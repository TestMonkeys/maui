package org.testmonkeys.maui.driverfactory.test;

import org.junit.Test;
import org.testmonkeys.maui.driverfactory.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;

public class TestClass {

    //@Test
    public void generateYaml() throws IOException {
        DriverConfiguration dc=new DriverConfiguration();
        dc.setBrowserName(BrowserName.CHROME);
        dc.setDriverLocation(DriverMode.LOCAL);
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        dc.setCapabilities(new HashMap<>());
        dc.getCapabilities().put("key","value");
        yaml.dump(dc, writer);
        String val=writer.toString();
        System.out.println(writer);
    }

    //@Test
    public void generateBSYaml() throws IOException {
        DriverConfiguration dc=new DriverConfiguration();
        dc.setBrowserName(BrowserName.CHROME);
        dc.setDriverLocation(DriverMode.LOCAL);
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        dc.setCapabilities(new HashMap<>());
        dc.getCapabilities().put("key","value");
        BrowserStackAuth auth=new BrowserStackAuth();
        auth.setServer("www.server.com");
        auth.setKeyEnvVar("keyenvvar");
        auth.setUserEnvVar("usrkeyvar");
        BrowserStackConfig bsConfig=new BrowserStackConfig();
        bsConfig.setLocal(true);
        bsConfig.setOs("Windows");
        bsConfig.setSeleniumVersion("3.4.7");
        bsConfig.setAuth(auth);
        dc.setBrowserStack(bsConfig);
        yaml.dump(dc, writer);
        String val=writer.toString();
        System.out.println(writer);
    }

    //@Test
    public void parseYaml(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        Yaml yaml = new Yaml(new Constructor(DriverConfiguration.class));

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/testConfig.yaml");
        DriverConfiguration dc = yaml.load(inputStream);
        System.out.println(dc);
    }

    //@Test
    public void parseBSYaml(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        Yaml yaml = new Yaml(new Constructor(DriverConfiguration.class));

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/bs-chrome-latest.yaml");
        DriverConfiguration dc = yaml.load(inputStream);
        System.out.println(dc);
    }

   // @Test
    public void parseYaml1(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        DriverProvider dp = new DriverProvider();
        dp.createNewDriver("yaml/testConfig.yaml");

    }

}
