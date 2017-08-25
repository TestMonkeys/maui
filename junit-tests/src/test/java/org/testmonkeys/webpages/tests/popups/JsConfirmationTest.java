package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.AbstractPopUpPageTest;
import org.testmonkeys.koshmar.core.browser.popups.NoPopUpFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsConfirmationTest extends AbstractPopUpPageTest {

    @Test
    public void confirmationDisplayed_hasPopUp(){
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        popUpPage.confirmationBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void confirmation_getText(){
        popUpPage.confirmationBtn().click();
        assertThat(browser.getPopUps().getConfirmation().getText(),is("Press a button!"));
    }

    @Test
    public void confirmation_accept(){
        popUpPage.confirmationBtn().click();

        browser.getPopUps().getConfirmation().accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.confirmationTxt().getText(), is("You pressed OK!"));
    }

    @Test
    public void confirmation_dismiss(){
        popUpPage.confirmationBtn().click();

        browser.getPopUps().getConfirmation().dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.confirmationTxt().getText(), is("You pressed Cancel!"));
    }

    @Test
    public void confirmation_noConfirmation_get(){
        expectedException.expect(NoPopUpFoundException.class);
        browser.getPopUps().getConfirmation();
    }
}
