package org.testmonkeys.webpages.tests;

//import com.automation.remarks.junit.VideoRule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testmonkeys.DriverFactory;
import org.testmonkeys.TestConfiguration;
import org.testmonkeys.maui.core.browser.Browser;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
abstract public class AbstractComponentTest {

    //    @Rule
//    public VideoRule videoRule = new VideoRule();
    @Rule(order = 1)
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            WebDriver driver = browser.getDriver();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"" + description.toString() + "\"}}");
            browser.quit();
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            browser.quit();
        }
    };

    @Autowired
    protected Browser browser;

    @After
    public void cleanup() {


        //browser.quit();
    }

    @AfterClass
    public static void cleanupClass() {
        DriverFactory.stopLocals();
    }
}
