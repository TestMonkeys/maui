package org.testmonkeys.maui.driverfactory;

import java.util.HashMap;

public class DriverConfiguration {

    private DriverMode driverLocation;
    private BrowserName browserName;
    private ChromeOptionsConfig chromeOptions;
    private HashMap<String,Object> capabilities;
    private BrowserStackConfig browserStack;

    public DriverMode getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(DriverMode driverLocation) {
        this.driverLocation = driverLocation;
    }

    public BrowserName getBrowserName() {
        return browserName;
    }

    public void setBrowserName(BrowserName browserName) {
        this.browserName = browserName;
    }

    public ChromeOptionsConfig getChromeOptions() {
        return chromeOptions;
    }

    public void setChromeOptions(ChromeOptionsConfig chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    public HashMap<String, Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(HashMap<String, Object> capabilities) {
        this.capabilities = capabilities;
    }

    public BrowserStackConfig getBrowserStack() {
        return browserStack;
    }

    public void setBrowserStack(BrowserStackConfig browserStack) {
        this.browserStack = browserStack;
    }
}
