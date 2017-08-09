package org.testmonkeys.webpages.tests.popups;

import org.junit.Test;
import org.testmonkeys.koshmar.core.browser.popups.JsPrompt;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsPromptTest extends AbstractJsPopUpTest {

    @Test
    public void promptDisplayed_hasPopUp(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        page.promptBtn().click();
        assertThat(browser.getPopUps().hasPopUp(),is(true));
    }

    @Test
    public void prompt_getText(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.promptBtn().click();

        assertThat(browser.getPopUps().getPrompt().getText(),is("Please enter your name"));
    }

    @Test
    public void prompt_accept(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.promptBtn().click();

        browser.getPopUps().getPrompt().accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.promptTxt().getText(),is("Hello Harry Potter! How are you today?"));
    }

    @Test
    public void prompt_enterValue_accept(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.promptBtn().click();

        JsPrompt prompt=browser.getPopUps().getPrompt();
        prompt.sendKeys("Johnny B.");
        prompt.accept();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.promptTxt().getText(),is("Hello Johnny B.! How are you today?"));
    }

    @Test
    public void prompt_dismiss(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.promptBtn().click();

        browser.getPopUps().getPrompt().dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.promptTxt().getText(),is("User cancelled the prompt."));
    }

    @Test
    public void prompt_enterValue_dismiss(){
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        page.promptBtn().click();

        JsPrompt prompt=browser.getPopUps().getPrompt();
        prompt.sendKeys("Johnny B.");
        prompt.dismiss();
        assertThat(browser.getPopUps().hasPopUp(),is(false));
        assertThat(page.promptTxt().getText(),is("User cancelled the prompt."));
    }

    @Test
    public void prompt_noPrompt_get(){
        expectedException.expect(RuntimeException.class);
        JsPopUpPage page = pageFactory.createPage(JsPopUpPage.class);
        page.open();
        browser.getPopUps().getPrompt();
    }
}
