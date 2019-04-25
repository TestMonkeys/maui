package org.testmonkeys.maui.driverfactory;

import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;

public class DriverProvider {

    public WebDriver createNewDriver(String profilePath){
        Yaml yaml = new Yaml(new Constructor(DriverConfiguration.class));

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/testConfig.yaml");
        DriverConfiguration dc = yaml.load(inputStream);
        return createNewDriver(dc);
    }

    private WebDriver createNewDriver(DriverConfiguration dc) {
        switch (dc.getDriverLocation()){
            case LOCAL:
                return new LocalFactory().getWebDriver(dc);
            default: throw new Error("No Factory defined for driver location: "+dc.getDriverLocation());
        }
    }


}
