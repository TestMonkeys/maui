package org.testmonkeys.maui.driverfactory;

//import com.browserstack.local.Local;
//import org.json.JSONObject;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DriverFactory {

//    private static Local local;
//
//    public static WebDriver initDriver(JSONObject config) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//
//        JSONObject commonCapabilities = (JSONObject) config.get("capabilities");
//        Iterator it  = commonCapabilities.keySet().iterator();
//        while (it.hasNext()) {
//            String key=(String)it.next();
//            capabilities.setCapability(key, commonCapabilities.get(key));
//        }
//
//        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//        JSONObject browserStackCapabilities = (JSONObject) config.get("browserstack");
//        it  = browserStackCapabilities.keySet().iterator();
//        while (it.hasNext()) {
//            String key = it.next().toString();
//            browserstackOptions.put(key,browserStackCapabilities.get(key));
//        }
//
//        capabilities.setCapability("bstack:options", browserstackOptions);
//
//        String username = System.getenv("BROWSERSTACK_USERNAME");
//        if(username == null) {
//            username = (String) config.get("user");
//        }
//
//        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//        if(accessKey == null) {
//            accessKey = (String) config.get("key");
//        }
//
//        if(capabilities.getCapability("browserstack.local") != null &&
//                capabilities.getCapability("browserstack.local").toString() == "true"){
//            if (local==null || !local.isRunning()) {
//                local = new Local();
//                Map<String, String> options = new HashMap<String, String>();
//                options.put("key", accessKey);
//                try {
//                    local.start(options);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//        return new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
//    }
//
//    public static WebDriver initLocalDriver(JSONObject config) throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        String webDriverName = (String) config.get("webDriver");
//
//        switch (webDriverName){
//            case "ChromeDriver":
//                return new ChromeDriver(capabilities);
//            case "PhantomJSDriver":
//                return new PhantomJSDriver(capabilities);
//            default:
//                throw new IllegalArgumentException("WebDriver "+webDriverName+" is not yet supported");
//        }
//
//    }
//
//    public static void stopLocals()  {
//        if (local!=null) {
//            try {
//                local.stop();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
