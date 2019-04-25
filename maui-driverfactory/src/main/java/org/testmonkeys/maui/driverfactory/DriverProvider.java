package org.testmonkeys.maui.driverfactory;

import org.openqa.selenium.WebDriver;
import org.testmonkeys.maui.driverfactory.builders.browserstack.BrowserstackBuilder;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.sql.Driver;

public class DriverProvider {

    public WebDriver createNewDriver(String profilePath){
        Yaml yaml = new Yaml(new Constructor(DriverConfiguration.class));
        FileInputStream inputStream;

        try {
            inputStream = new FileInputStream(profilePath);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("could not read profile: "+profilePath);
        }

        DriverConfiguration dc = yaml.load(inputStream);
        return createNewDriver(dc);
    }

    private WebDriver createNewDriver(DriverConfiguration dc) {
        switch (dc.getDriverLocation()){
            case LOCAL:
                return new LocalFactory().getWebDriver(dc);
            case BROWSERSTACK:
                return new BrowserstackBuilder().getWebDriver(dc);
            default: throw new Error("No Factory defined for driver location: "+dc.getDriverLocation());
        }
    }


}
