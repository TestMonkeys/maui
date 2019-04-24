package org.testmonkeys.maui.driverfactory.test;

import org.junit.Test;
import org.testmonkeys.maui.driverfactory.BrowserName;
import org.testmonkeys.maui.driverfactory.DriverConfiguration;
import org.testmonkeys.maui.driverfactory.DriverMode;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.io.StringWriter;

public class TestClass {

    @Test
    public void generateYaml(){
        DriverConfiguration dc=new DriverConfiguration();
        dc.setBrowserName(BrowserName.CHROME);
        dc.setDriverLocation(DriverMode.LOCAL);
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(dc, writer);
        String val=writer.toString();
        System.out.println(writer);
    }

    @Test
    public void parseYaml(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/testConfig.yaml");
        DriverConfiguration dc = yaml.load(inputStream);
        System.out.println(dc);
    }

}
