package org.testmonkeys.maui.core.browser.popups;

import org.openqa.selenium.Alert;

/**
 * JsPrompt is the representation of a prompt pop-up. It differs from a Confirmation by having an input
 * field.
 */
public class JsPrompt extends JsConfirmation {

    public JsPrompt(Alert alert) {
        super(alert);
    }

    /**
     * Sets a value in the prompt
     *
     * @param text to be provided to the prompt
     */
    public void sendKeys(String text) {
        alert.sendKeys(text);
    }
}
