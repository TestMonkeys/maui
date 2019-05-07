package org.testmonkeys.maui.driverfactory.builders.browserstack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testmonkeys.maui.driverfactory.BrowserStackAuth;
import org.testmonkeys.maui.driverfactory.BrowserStackConfig;
import org.testmonkeys.maui.driverfactory.DriverConfiguration;
import org.testmonkeys.maui.driverfactory.builders.WebDriverBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class BrowserstackBuilder implements WebDriverBuilder {

    public WebDriver getWebDriver(DriverConfiguration driverConfiguration) {
        BrowserStackConfig bsConfig = driverConfiguration.getBrowserStack();
        if (bsConfig==null)
            throw new IllegalArgumentException("BrowserStack configuration missing");

        DesiredCapabilities capabilities = getCapabilities(driverConfiguration);
        URL gridUrl = getGridUrl(bsConfig.getAuth());

        return new RemoteWebDriver(gridUrl,capabilities);
    }

    private URL getGridUrl(BrowserStackAuth auth) {
        if (auth.getServer()==null || auth.getServer().isEmpty())
            throw new IllegalArgumentException("BrowserStack server is not set");
        String username = null;
        if (auth.getUserEnvVar()!=null)
            username = System.getenv(auth.getUserEnvVar());
        if(username == null) {
            username = auth.getUser();
        }
        String accessKey =null;
        if (auth.getKeyEnvVar()!=null)
            accessKey = System.getenv(auth.getKeyEnvVar());
        if(accessKey == null) {
            accessKey = auth.getKey();
        }
        URL url;
        try{
            url=new URL("http://"+username+":"+accessKey+"@"+auth.getServer()+"/wd/hub");
        } catch(MalformedURLException e) {
            throw new IllegalArgumentException("Could not build BrowserStack url");
        }
        return url;
    }

    private DesiredCapabilities getCapabilities(DriverConfiguration configuration) {
       DesiredCapabilities capabilities = new DesiredCapabilities();
       if (configuration.getCapabilities()!=null){
           Iterator iterator=configuration.getCapabilities().keySet().iterator();
           while (iterator.hasNext()){
               String key=iterator.next().toString();
               capabilities.setCapability(key, configuration.getCapabilities().get(key));
           }
        }
        capabilities.setCapability("browserstack.use_w3c",true);

        capabilities.setBrowserName(configuration.getBrowserName().toString());
        HashMap<String,Object> browserstackOptions = new HashMap<>();
        addOptionIfSet(browserstackOptions,"seleniumVersion","3.4.0");
        addOptionIfSet(browserstackOptions,"local", String.valueOf(configuration.getBrowserStack().isLocal()));
        addOptionIfSet(browserstackOptions,"os",configuration.getBrowserStack().getOs());
        addOptionIfSet(browserstackOptions,"seleniumVersion",configuration.getBrowserStack().getSeleniumVersion());
//        capabilities.setCapability("browserstack.seleniumVersion","3.4.0");
//        capabilities.setCapability("browserstack.local", String.valueOf(configuration.getBrowserStack().isLocal()));
//        capabilities.setCapability("browserstack.os",configuration.getBrowserStack().getOs());
//       // capabilities.setCapability("browserstack.seleniumVersion",configuration.getBrowserStack().getSeleniumVersion());
        String localIdentifier="";
        if (configuration.getBrowserStack().getLocalIdentifierVar()!=null && !configuration.getBrowserStack().getLocalIdentifierVar().isEmpty())
            localIdentifier= System.getenv(configuration.getBrowserStack().getLocalIdentifierVar());
        if (!localIdentifier.isEmpty()) {
            System.out.println("identifier is"+localIdentifier);
            addOptionIfSet(browserstackOptions,"browserstack.localIdentifier", localIdentifier);
        }
        capabilities.setCapability("bstack:options", browserstackOptions);
       return capabilities;
    }

    private void addOptionIfSet(HashMap<String, Object> browserstackOptions, String key, String value) {
        if (value!=null && !value.isEmpty())
            browserstackOptions.put(key,value);
    }
}
