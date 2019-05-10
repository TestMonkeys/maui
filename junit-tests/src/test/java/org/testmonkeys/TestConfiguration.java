package org.testmonkeys;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.driverfactory.DriverProvider;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

@Configuration
@ComponentScan(basePackages = "org.testmonkeys")
public class TestConfiguration {


    //TODO remove this ugly stuff when the defect on video library will be fixed
//    @Bean
//    public Properties loadTestProperties() throws IOException {
//        FileInputStream inputStream = new FileInputStream("properties/test.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);
//        for (Object key : properties.keySet()) {
//            System.setProperty((String) key, properties.getProperty((String) key));
//        }
//        System.setProperty("video.folder", System.getProperty("user.dir") + separator + "target" + separator + "video");
//        return properties;
//    }

    @Bean
    @Scope("prototype")
    public Browser browser(//@Value("${selenium.profile}") String seleniumProfile,
                           @Value("${browser.profile}") String browserProfile ) throws Exception {
//        if (seleniumProfile==null || seleniumProfile.isEmpty()){
//            throw new IllegalArgumentException("Selenium profile should be provided by -Dselenium.profile parameter");
//        }
        if (browserProfile==null || browserProfile.isEmpty()){
            throw new IllegalArgumentException("Browser profile should be provided by -Dbrowser.profile parameter");
        }
//        JSONObject config = readProfile(browserProfile);
//        WebDriver driver;
//
//        switch (seleniumProfile){
//            case "local":
//                driver= DriverFactory.initLocalDriver(config);
//                break;
//            case "browserStack":
//                driver= DriverFactory.initDriver(config);
//                break;
//            default:
//                throw new IllegalArgumentException("Selenium Profile argument should be provided");
//        }
//        MauiConfigProperties mauiConfig=readMauiConfigProps(config);
        readProfile(browserProfile);
        DriverProvider provider=new DriverProvider();
        WebDriver driver= provider.createNewDriver(browserProfile);

        return new Browser(driver, TimeUnit.SECONDS, 10, 10);
                //mauiConfig.timeoutTimeUnit, mauiConfig.elementTimeout, mauiConfig.pageTimeout);
    }

    private void readProfile(String profile) throws IOException {
        try {
            File file = new File(profile);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String str = new String(data, "UTF-8");
            System.out.println(str);
           // return new JSONObject(str);
        } catch (IOException e){
            throw new IOException("Could not read profile: "+profile,e);
        }
    }

    private MauiConfigProperties readMauiConfigProps(JSONObject config) throws IOException {
        MauiConfigProperties props=new MauiConfigProperties();
        JSONObject mauiConfig = (JSONObject) config.get("mauiProperties");
        props.elementTimeout= (int) mauiConfig.get("elementTimeout");
        props.pageTimeout = (int) mauiConfig.get("pageTimeout");
        props.timeoutTimeUnit = TimeUnit.valueOf((String) mauiConfig.get("timeoutTimeUnit"));
        return props;
    }

    private class MauiConfigProperties{
        public TimeUnit timeoutTimeUnit;
        public int elementTimeout;
        public int pageTimeout;
    }
}
