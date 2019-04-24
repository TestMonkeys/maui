package org.testmonkeys.maui.driverfactory;

public class DriverConfiguration {

    private DriverMode driverLocation;
    private BrowserName browserName;


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
}
