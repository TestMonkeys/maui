package org.testmonkeys.webpages.tests.htmlelement;

import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.sut.demoqa.HomePage;
import org.testmonkeys.webpages.pageObjects.HtmlElementsPageObject;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class HtmlElementsTest {

    protected Browser browser;
    protected PageFactory pageFactory;
    @Before
    public void init(){
        DriverFactory df = new DriverFactory();
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        cap.setCapability(ChromeOptions.CAPABILITY,options);

        browser= new Browser(df.initDriver("chrome",cap));
        File file = new File("src/test/resources/WebPages/HtmlElementsPage.html");
        String absolutePath = file.getAbsolutePath();
        pageFactory=new PageFactory(browser,new PageScanner("org.testmonkeys.webpages"),"file:///"+absolutePath);
    }

    @After
    public void cleanup(){
        browser.quit();
    }


}
