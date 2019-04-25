package org.testmonkeys.maui.driverfactory.builders;

import org.openqa.selenium.WebDriver;
import org.testmonkeys.maui.driverfactory.DriverConfiguration;

public interface WebDriverBuilder {

    WebDriver getWebDriver(DriverConfiguration driverConfiguration);
}
