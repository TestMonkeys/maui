package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.sut.demoqa.HomePage;
import org.testmonkeys.webpages.pageObjects.HtmlElementsPageObject;

import java.io.File;
import java.util.List;

public class HtmlElementsTest {

    protected Browser browser;
    protected PageFactory pageFactory;
    @Before
    public void init(){
        DriverFactory df = new DriverFactory();
        browser= new Browser(df.initDriver("chrome"));
        File file = new File("src/test/resources/WebPages/HtmlElementsPage.html");
        String absolutePath = file.getAbsolutePath();
        pageFactory=new PageFactory(browser,new PageScanner("org.testmonkeys.webpages"),absolutePath);
    }

    @After
    public void cleanup(){
        browser.quit();
    }


}
