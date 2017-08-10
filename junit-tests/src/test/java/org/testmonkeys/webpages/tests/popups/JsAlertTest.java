package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.popups.JsAlert;
import org.testmonkeys.koshmar.core.browser.popups.NoPopUpFoundException;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsAlertTest extends AbstractJsPopUpTest {

    @Test
    public void alertDisplayed_hasPopUp(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        page.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void alert_accept(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
        JsAlert alert=browser.getPopUps().getAlert();
        alert.accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
    }

    @Test
    public void alert_getText(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
        JsAlert alert=browser.getPopUps().getAlert();
        assertThat(alert.getText(),is("alert text"));
    }

    @Test
    public void alert_noAlert_get(){
        expectedException.expect(NoPopUpFoundException.class);
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        browser.getPopUps().getAlert();
    }
}
