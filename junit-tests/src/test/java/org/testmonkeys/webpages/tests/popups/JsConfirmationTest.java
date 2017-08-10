package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.popups.NoPopUpFoundException;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsConfirmationTest extends AbstractJsPopUpTest {

    @Test
    public void confirmationDisplayed_hasPopUp(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        page.confirmationBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void confirmation_getText(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.confirmationBtn().click();

        assertThat(browser.getPopUps().getConfirmation().getText(),is("Press a button!"));
    }

    @Test
    public void confirmation_accept(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.confirmationBtn().click();

        browser.getPopUps().getConfirmation().accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.confirmationTxt().getText(),is("You pressed OK!"));
    }

    @Test
    public void confirmation_dismiss(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.confirmationBtn().click();

        browser.getPopUps().getConfirmation().dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.confirmationTxt().getText(),is("You pressed Cancel!"));
    }

    @Test
    public void confirmation_noConfirmation_get(){
        expectedException.expect(NoPopUpFoundException.class);
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        browser.getPopUps().getConfirmation();
    }
}
