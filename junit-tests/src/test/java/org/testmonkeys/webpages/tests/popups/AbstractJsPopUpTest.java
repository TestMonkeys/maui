package org.testmonkeys.webpages.tests.popups;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.browser.popups.JsAlert;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.File;

public abstract class AbstractJsPopUpTest {

    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    protected Browser browser;
    protected PageFactory pageFactory;
    @Before
    public void init(){
        DriverFactory df = new DriverFactory();

        browser= new Browser(df.initDriver("chrome"));
        File file = new File("src/test/resources/WebPages/JSPopUpPage.html");
        String absolutePath = file.getAbsolutePath();
        pageFactory=new PageFactory(browser,new PageScanner("org.testmonkeys.webpages"),"file:///"+absolutePath);
    }

    @After
    public void cleanup(){
        browser.quit();
    }








}
