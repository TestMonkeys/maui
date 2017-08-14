package org.testmonkeys.webpages.tests.elements;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testmonkeys.TestConfiguration;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
abstract public class AbstractComponentTest {

    protected DriverFactory df;//= new DriverFactory();
    protected Browser browser;//= new Browser(df.initDriver("chrome"));

    protected ClassPathResource htmlPage = new ClassPathResource("/WebPages/HtmlElementsPage.html");

    @After
    public void cleanup() {
        browser.getDriver().quit();
    }
}
