package org.testmonkeys.koshmar.core.browser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverFactory {

    public static WebDriver initDriver(String browser) {
        DesiredCapabilities cap;
        switch (browser.toLowerCase()) {
            case CHROME:
                cap = DesiredCapabilities.chrome();
                return new ChromeDriver(cap);
            case "phantomjs":
                cap = DesiredCapabilities.phantomjs();
                return new PhantomJSDriver(cap);
            case "htmlunit":
                cap = DesiredCapabilities.htmlUnit();
                HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.EDGE, true);
                htmlUnitDriver.setJavascriptEnabled(true);
                return htmlUnitDriver;
            case "firefox":
                cap = DesiredCapabilities.firefox();
                cap.setCapability("binary", "/usr/bin/firefox");
                cap.setCapability("marionette", false);

                return new FirefoxDriver(cap);
            default:
                throw new RuntimeException("Unsupported browser[" + browser + "]");
        }
    }

    public static WebDriver initDriver(String browser, String mode, DesiredCapabilities caps) {
        switch (browser.toLowerCase()) {
            case CHROME:
                return initChromeDriver(mode, caps);
            default:
                throw new RuntimeException("Unsupported browser[" + browser + "]");
        }
    }

    public static WebDriver initChromeDriver(String mode, DesiredCapabilities capabilities) {
        if (mode != null && mode.equals("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        return new ChromeDriver(capabilities);
    }
}
