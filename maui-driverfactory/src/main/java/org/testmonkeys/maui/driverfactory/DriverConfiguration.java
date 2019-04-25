package org.testmonkeys.maui.driverfactory;

public class DriverConfiguration {

    private DriverMode driverLocation;
    private BrowserName browserName;
    private ChromeOptionsConfig chromeOptions;

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
}
