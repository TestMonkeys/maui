package org.testmonkeys.maui.driverfactory.test;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testmonkeys.maui.driverfactory.*;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import sun.rmi.runtime.NewThreadAction;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    @Test
    public void generateYaml() throws IOException {
        DriverConfiguration dc=new DriverConfiguration();
        dc.setBrowserName(BrowserName.CHROME);
        dc.setDriverLocation(DriverMode.LOCAL);
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("argument1","argument2");
        opt.addEncodedExtensions("extension1","extension2");
        opt.setBinary("path/to/chrome");
        opt.setExperimentalOption("expKey","expValue");
        opt.setExperimentalOption("expKey2","expValue2");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptionsConfig chromeOptions = new ChromeOptionsConfig();
        List<String> args = new ArrayList<String>();
        args.add("--arg1");
        args.add("--arg2");
        chromeOptions.setArguments(args);
        dc.setChromeOptions(chromeOptions);
        yaml.dump(dc, writer);
        String val=writer.toString();
        System.out.println(writer);
    }

    @Test
    public void parseYaml(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        Yaml yaml = new Yaml(new Constructor(DriverConfiguration.class));

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/testConfig.yaml");
        DriverConfiguration dc = yaml.load(inputStream);
        System.out.println(dc);
    }

    @Test
    public void parseYaml1(){
        //String value="browserName: CHROME\r\n driverMode: LOCAL";
        DriverProvider dp = new DriverProvider();
        dp.createNewDriver("yaml/testConfig.yaml");

    }

}
