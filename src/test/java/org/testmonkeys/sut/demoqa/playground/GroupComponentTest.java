package org.testmonkeys.sut.demoqa.playground;

import org.junit.Test;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.DriverFactory;
import org.testmonkeys.maui.core.factory.PageFactory;
import org.testmonkeys.maui.core.factory.PageScanner;
import org.testmonkeys.maui.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.sut.demoqa.HomePage;

public class GroupComponentTest {

    //TODO: Figure out what this test was for
//    @Test
//    public void genericComponent() throws Exception {
//
//        Browser browser = new Browser(DriverFactory.initDriver("chrome"));
//        //browser.goTo("http://www.demoqa.com");
//        PageFactory pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.sut"), "http://demoqa.com");
//
//        HomePage home = pageFactory.createPage(HomePage.class);
//        home.open();
//
//        for (HtmlAttribute attr : home.getInteractions().get(4).getHtmlElement().getAttributes()) {
//            System.out.println(attr);
//        }
//        browser.quit();
//    }
}
