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

public class DriverFactory {

    public WebDriver initDriver(String type) {
        DesiredCapabilities cap;
        switch (type.toLowerCase()) {
            case "chrome":
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
