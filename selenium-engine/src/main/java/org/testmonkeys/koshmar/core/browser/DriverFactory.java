package org.testmonkeys.koshmar.core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public WebDriver initDriver(String type) {
        switch (type.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(DesiredCapabilities.chrome());

            default:
                throw new RuntimeException("Unsupported browser[" + type + "]");
        }
    }
}
