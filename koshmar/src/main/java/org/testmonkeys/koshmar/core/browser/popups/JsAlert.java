package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;

public class JsAlert {
    protected Alert alert;

    public JsAlert(Alert alert) {
        this.alert=alert;
    }

    public String getText(){
        return alert.getText();
    }

    public void accept(){
        alert.accept();
    }
}
