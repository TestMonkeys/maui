package org.testmonkeys;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

@Configuration
@ComponentScan(basePackages = "org.testmonkeys")
@PropertySource(
        value = {"file:properties/driver.properties"},
        ignoreResourceNotFound = true)
public class TestConfiguration {

    //TODO remove this ugly stuff when the defect on video library will be fixed
    @Bean
    public Properties loadTestProperties() throws IOException {
        FileInputStream inputStream = new FileInputStream("properties/test.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Object key : properties.keySet()) {
            System.setProperty((String) key, properties.getProperty((String) key));
        }
        System.setProperty("video.folder", System.getProperty("user.dir") + separator + "target" + separator + "video");
        return properties;
    }

    @Bean
    @Scope("prototype")
    public WebDriver webDriver(@Value("${browser}") String browser,
                               @Value("${browser.mode}") String mode) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("properties/driver.properties"));

        DesiredCapabilities capabilities = new DesiredCapabilities(browser, "", Platform.ANY);
        for (Object key : properties.keySet()) {
            capabilities.setCapability(String.valueOf(key), properties.getProperty(String.valueOf(key)));
        }

        return DriverFactory.initDriver(browser, mode, capabilities);
    }

    @Bean
    @Scope("prototype")
    public Browser browser(WebDriver webDriver,
                           @Value("${browser.timeout.unit}") TimeUnit unit,
                           @Value("${browser.element.timeout}") int elementTimeout,
                           @Value("${browser.page.timeout}") int pageTimeout) {
        return new Browser(webDriver, unit, elementTimeout, pageTimeout);
    }
}
