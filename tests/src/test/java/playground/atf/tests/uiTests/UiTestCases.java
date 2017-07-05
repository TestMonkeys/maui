package playground.atf.tests.uiTests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testmonkeys.selenium.engine.core.browser.Browser;
import org.testmonkeys.selenium.engine.core.browser.DriverFactory;
import org.testmonkeys.selenium.engine.core.elements.Component;
import org.testmonkeys.selenium.engine.core.elements.actions.ActionHooksContext;
import org.testmonkeys.selenium.engine.core.factory.PageFactory;
import org.testmonkeys.selenium.engine.core.factory.PageScanner;
import playground.atf.tests.pageObjects.EmagPage;
import playground.atf.tests.pageObjects.ItemModule;
import playground.atf.tests.pageObjects.Practicepage;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by cpascal on 3/29/2017.
 */
public class UiTestCases {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void uiTest() throws ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\Playground\\ATF\\drivers\\chromedriver.exe");
        DriverFactory driverFactory = new DriverFactory();
        Browser browser=new Browser(driverFactory.initDriver("chrome"));
        PageScanner pageScanner = new PageScanner("playground.atf.tests.pageObjects");
        PageFactory pageFactory = new PageFactory(browser,pageScanner,"http://www.emag.ro");
        EmagPage page=(EmagPage) pageFactory.createPage("emagPage");
        page.open();
        logger.info("new price" +
               page.getPhoneBox().get(1).getPriceModule().getNewPrice().getText());
        ActionHooksContext.getContext().registerBeforeHook(new Consumer<Component>() {
            @Override
            public void accept(Component component) {
                logger.info("hook");
            }
        });
        logger.info("old price "+
                page.getPhoneBox().get(1).getPriceModule().getOldPrice().getText());
        page.getPhoneBox().get(1).getPriceModule().getOldPrice().click();

        List<ItemModule> items=page.getPhoneBox().getAll();
        items.forEach(item->logger.info("position "+
                item.getPosition()+" price "+item.getPriceModule().getNewPrice().getText()));

        browser.goTo("http://www.google.com");
        browser.goBack();
        items.forEach(item->logger.info("position "+
                item.getPosition()+" price "+item.getPriceModule().getNewPrice().getText()));
    }

    @Test
    public void uiTest2() throws ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\Playground\\ATF\\drivers\\chromedriver.exe");
        DriverFactory driverFactory = new DriverFactory();
        Browser browser=new Browser(driverFactory.initDriver("chrome"));
        PageScanner pageScanner = new PageScanner("playground.atf.tests.pageObjects");
        PageFactory pageFactory = new PageFactory(browser,pageScanner,"http://www.seleniumframework.com");
        Practicepage page=(Practicepage) pageFactory.createPage(Practicepage.class);
        page.open();
        page.getSelect().selectByValue("Option 2");

    }
}
