package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.popups.JsPrompt;
import org.testmonkeys.koshmar.core.browser.popups.NoPopUpFoundException;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;
import org.testmonkeys.webpages.tests.AbstractPopUpPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsPromptTest extends AbstractPopUpPageTest {

    @Test
    public void promptDisplayed_hasPopUp(){
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        popUpPage.promptBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void prompt_getText(){
        popUpPage.promptBtn().click();

        assertThat(browser.getPopUps().getPrompt().getText(),is("Please enter your name"));
    }

    @Test
    public void prompt_accept(){
        popUpPage.promptBtn().click();

        browser.getPopUps().getPrompt().accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.promptTxt().getText(), is("Hello Harry Potter! How are you today?"));
    }

    @Test
    public void prompt_enterValue_accept(){
        popUpPage.promptBtn().click();

        JsPrompt prompt=browser.getPopUps().getPrompt();
        prompt.sendKeys("Johnny B.");
        prompt.accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.promptTxt().getText(), is("Hello Johnny B.! How are you today?"));
    }

    @Test
    public void prompt_dismiss(){
        popUpPage.promptBtn().click();

        browser.getPopUps().getPrompt().dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.promptTxt().getText(), is("User cancelled the prompt."));
    }

    @Test
    public void prompt_enterValue_dismiss(){
        popUpPage.promptBtn().click();

        JsPrompt prompt=browser.getPopUps().getPrompt();
        prompt.sendKeys("Johnny B.");
        prompt.dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(popUpPage.promptTxt().getText(), is("User cancelled the prompt."));
    }

    @Test
    public void prompt_noPrompt_get(){
        expectedException.expect(NoPopUpFoundException.class);
        browser.getPopUps().getPrompt();
    }
}
