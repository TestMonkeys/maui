package org.testmonkeys.webpages.tests;

import com.automation.remarks.junit.VideoRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testmonkeys.TestConfiguration;
import org.testmonkeys.maui.core.browser.Browser;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
abstract public class AbstractComponentTest {

    @Rule
    public VideoRule videoRule = new VideoRule();
    @Autowired
    protected Browser browser;

    @After
    public void cleanup() {
        browser.quit();
    }


}
