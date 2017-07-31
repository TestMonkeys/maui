package org.testmonkeys.sut.demoqa.playground;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.sut.demoqa.HomePage;
import org.testmonkeys.sut.demoqa.RegistrationPage;

public class RadioComponentTest {

    @Test
    public void radioBtnComponent(){

        DriverFactory df = new DriverFactory();
        Browser browser= new Browser(df.initDriver("chrome"));
        //browser.goTo("http://www.demoqa.com");
        PageFactory pageFactory=new PageFactory(browser,new PageScanner("org.testmonkeys.sut"),"http://demoqa.com");

        RegistrationPage registrationPage=pageFactory.createPage(RegistrationPage.class);
        registrationPage.open();
        registrationPage.getMaritalStatus().selectByIndex(5);
        registrationPage.getMaritalStatus().selectByValue("married");
        for (String s:registrationPage.getMaritalStatus().getValues())
            System.out.println(s);
        System.out.println(":"+registrationPage.getMaritalStatus().getSelectedValue());
        registrationPage.getUrl();

    }
}
