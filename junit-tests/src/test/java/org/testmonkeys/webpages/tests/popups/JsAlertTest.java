package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.maui.core.browser.popups.JsAlert;
import org.testmonkeys.maui.core.browser.popups.NoPopUpFoundException;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;
import org.testmonkeys.webpages.tests.AbstractPopUpPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsAlertTest extends AbstractPopUpPageTest {

    @Test
    public void alertDisplayed_hasPopUp(){
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        popUpPage.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void alert_accept(){
        popUpPage.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
        JsAlert alert=browser.getPopUps().getAlert();
        alert.accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
    }

    @Test
    public void alert_getText(){
        popUpPage.alertBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
        JsAlert alert=browser.getPopUps().getAlert();
        assertThat(alert.getText(),is("alert text"));
    }

    @Test
    public void alert_noAlert_get(){
        expectedException.expect(NoPopUpFoundException.class);
        popUpPage.open();
        browser.getPopUps().getAlert();
    }
}
