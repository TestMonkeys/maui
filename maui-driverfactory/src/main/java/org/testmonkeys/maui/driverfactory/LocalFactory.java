package org.testmonkeys.maui.driverfactory;

import org.openqa.selenium.WebDriver;
import org.testmonkeys.maui.driverfactory.builders.local.ChromeLocalBuilder;


public class LocalFactory {

    public WebDriver getWebDriver(DriverConfiguration configuration){
        switch (configuration.getBrowserName()){
            case CHROME: return new ChromeLocalBuilder().getWebDriver(configuration);
            default: throw new Error("No builder defined for "+configuration.getBrowserName());
        }
    }
}
