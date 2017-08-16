package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;

/**
 * JsAlert is the representation of a simple Alert box
 */
public class JsAlert {
    protected Alert alert;

    public JsAlert(Alert alert) {
        this.alert = alert;
    }

    /**
     * Gets the text displayed in the pop-up
     *
     * @return text displayed in pop-up
     */
    public String getText() {
        return alert.getText();
    }

    /**
     * Accepts the pop-up, usually would press OK button, but depending on web page
     * could be Confirm, Accept.
     */
    public void accept() {
        alert.accept();
    }
}
