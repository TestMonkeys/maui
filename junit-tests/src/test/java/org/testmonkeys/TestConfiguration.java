package org.testmonkeys;

import org.json.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

@Configuration
@ComponentScan(basePackages = "org.testmonkeys")
//@PropertySource(
//        value = {"file:properties/driver.properties"},
//        ignoreResourceNotFound = true)
public class TestConfiguration {


    //TODO remove this ugly stuff when the defect on video library will be fixed
    @Bean
    public Properties loadTestProperties() throws IOException {
        FileInputStream inputStream = new FileInputStream("properties/test.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Object key : properties.keySet()) {
            System.setProperty((String) key, properties.getProperty((String) key));
        }
        System.setProperty("video.folder", System.getProperty("user.dir") + separator + "target" + separator + "video");
        return properties;
    }

    @Bean
    @Scope("prototype")
    public WebDriver webDriver(@Value("${selenium.profile}") String seleniumProfile,
                               @Value("${browser.profile}") String browserProfile ) throws Exception {
        switch (seleniumProfile){
            case "local":
                Properties properties = new Properties();
                properties.load(new FileInputStream("properties/driver.properties"));

//                DesiredCapabilities capabilities = new DesiredCapabilities(browser, "", Platform.ANY);
//                for (Object key : properties.keySet()) {
//                    capabilities.setCapability(String.valueOf(key), properties.getProperty(String.valueOf(key)));
//                }

                File file = new File(browserProfile);
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                fis.close();

                String str = new String(data, "UTF-8");

                JSONObject config = new JSONObject(str);
                return DriverFactory.initLocalDriver(config);
            case "browserStack":
                if (browserProfile==null || browserProfile.isEmpty())
                    throw new IllegalArgumentException("Browser Profile argument should be provided");
                file = new File(browserProfile);
                fis = new FileInputStream(file);
                data = new byte[(int) file.length()];
                fis.read(data);
                fis.close();

                str = new String(data, "UTF-8");

                config = new JSONObject(str);

                return DriverFactory.initDriver(config);
            default:
                throw new IllegalArgumentException("Selenium Profile argument should be provided");
        }





    }

    @Bean
    @Scope("prototype")
    public Browser browser(WebDriver webDriver,
                           @Value("${browser.timeout.unit}") TimeUnit unit,
                           @Value("${browser.element.timeout}") int elementTimeout,
                           @Value("${browser.page.timeout}") int pageTimeout) {
        return new Browser(webDriver, unit, elementTimeout, pageTimeout);
    }
}
