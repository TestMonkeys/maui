package org.testmonkeys.sut.demoqa.playground;

import org.junit.After;
import org.springframework.core.io.ClassPathResource;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;

abstract public class AbstractComponentTest {

    protected DriverFactory df = new DriverFactory();
    protected Browser browser = new Browser(df.initDriver("chrome"));

    protected ClassPathResource htmlPage = new ClassPathResource("/WebPages/HtmlElementsPage.html");

    @After
    public void cleanup() {
        browser.getDriver().quit();
    }
}
