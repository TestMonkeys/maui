package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;

public class JsPrompt extends JsConfirmation {

    public JsPrompt(Alert alert) {
        super(alert);
    }

    public void sendKeys(String text){
        alert.sendKeys(text);
    }
}
