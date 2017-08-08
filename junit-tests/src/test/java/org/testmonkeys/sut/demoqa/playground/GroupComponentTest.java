package org.testmonkeys.sut.demoqa.playground;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.sut.demoqa.HomePage;

import javax.swing.text.html.HTML;

public class GroupComponentTest {

    @Test
    public void genericComponent(){

        DriverFactory df = new DriverFactory();
        Browser browser= new Browser(df.initDriver("chrome"));
        //browser.goTo("http://www.demoqa.com");
        PageFactory pageFactory=new PageFactory(browser,new PageScanner("org.testmonkeys.sut"),"http://demoqa.com");

        HomePage home=pageFactory.createPage(HomePage.class);
        home.open();
        for(HtmlAttribute attr : home.getInteractions().get(4).getHtmlElement().getAttributes())
        System.out.println(attr);
        home.getUrl();

    }
}