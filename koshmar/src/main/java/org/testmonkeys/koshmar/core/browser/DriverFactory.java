package org.testmonkeys.koshmar.core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public WebDriver initDriver(String type) {
        switch (type.toLowerCase()) {
            case "chrome":
                DesiredCapabilities cap=DesiredCapabilities.chrome();
                return new ChromeDriver(cap);

            default:
                throw new RuntimeException("Unsupported browser[" + type + "]");
        }
    }

    public WebDriver initDriver(String type,DesiredCapabilities caps) {
        switch (type.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(caps);

            default:
                throw new RuntimeException("Unsupported browser[" + type + "]");
        }
    }
}
