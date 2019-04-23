package org.testmonkeys;

import com.browserstack.local.Local;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.PHANTOMJS;

public class DriverFactory {

    private static Local local;

    public static Local getLocal(){
        return local;
    }

    public static WebDriver initDriver(String browser) throws Exception {
        DesiredCapabilities cap;
        switch (browser.toLowerCase()) {
            case CHROME:
                cap = DesiredCapabilities.chrome();
                return new ChromeDriver(cap);
            case PHANTOMJS:
                cap = DesiredCapabilities.phantomjs();
                cap.setCapability("phantomjs.page.settings.userAgent", "chrome");
                cap.setCapability("phantomjs.page.settings.resourceTimeout", 5000);
                PhantomJSDriver driver = new PhantomJSDriver(cap);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                return driver;
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


    public static WebDriver initDriver(JSONObject config) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        JSONObject commonCapabilities = (JSONObject) config.get("capabilities");
        Iterator it  = commonCapabilities.keySet().iterator();
        while (it.hasNext()) {
            String key=(String)it.next();
            capabilities.setCapability(key, commonCapabilities.get(key));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        JSONObject browserStackCapabilities = (JSONObject) config.get("browserstack");
        it  = browserStackCapabilities.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            browserstackOptions.put(key,browserStackCapabilities.get(key));
        }

        capabilities.setCapability("bstack:options", browserstackOptions);

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("key");
        }

        if(capabilities.getCapability("browserstack.local") != null &&
                capabilities.getCapability("browserstack.local").toString() == "true"){
            if (local==null || !local.isRunning()) {
                local = new Local();
                Map<String, String> options = new HashMap<String, String>();
                options.put("key", accessKey);
                try {
                    local.start(options);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
    }

    public static WebDriver initLocalDriver(JSONObject config) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String webDriverName = (String) config.get("webDriver");

        switch (webDriverName){
            case "ChromeDriver":
                return new ChromeDriver(capabilities);
            case "PhantomJSDriver":
                return new PhantomJSDriver(capabilities);
            default:
                throw new IllegalArgumentException("WebDriver "+webDriverName+" is not yet supported");
        }

    }

    public static WebDriver initDriver(String browser, String mode, DesiredCapabilities caps) {
        switch (browser.toLowerCase()) {
            case CHROME:
                return initChromeDriver(mode, caps);
            case PHANTOMJS:
                caps = DesiredCapabilities.phantomjs();
                return new PhantomJSDriver(caps);

            default:
                throw new RuntimeException("Unsupported browser[" + browser + "]");
        }
    }

    public static WebDriver initChromeDriver(String mode, DesiredCapabilities capabilities) {
        if (mode != null && mode.equals("headless")) {
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        return new ChromeDriver(capabilities);
    }

    public static void stopLocals()  {
        if (local!=null) {
            try {
                local.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
