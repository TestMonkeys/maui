package org.testmonkeys.maui.driverfactory.builders.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testmonkeys.maui.driverfactory.ChromeOptionsConfig;
import org.testmonkeys.maui.driverfactory.DriverConfiguration;
import org.testmonkeys.maui.driverfactory.builders.WebDriverBuilder;

public class ChromeLocalBuilder implements WebDriverBuilder {

    public WebDriver getWebDriver(DriverConfiguration driverConfiguration) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptionsConfig chromeOptionsConfig=driverConfiguration.getChromeOptions();
        if (chromeOptionsConfig!=null)
        capabilities.setCapability("chromeOptions", getChromeOptions(chromeOptionsConfig));
        return new ChromeDriver(capabilities);
    }

    private ChromeOptions getChromeOptions(ChromeOptionsConfig chromeOptionsConfig) {
        ChromeOptions options = new ChromeOptions();
        if (chromeOptionsConfig.getArguments()!=null){
            options.addArguments(chromeOptionsConfig.getArguments());
        }
        if (chromeOptionsConfig.getBinary()!=null && !chromeOptionsConfig.getBinary().isEmpty())
            options.setBinary(chromeOptionsConfig.getBinary());
        if (chromeOptionsConfig.getEncodedExtensions()!=null){
            options.addEncodedExtensions(chromeOptionsConfig.getEncodedExtensions());
        }
        return options;
    }
}
