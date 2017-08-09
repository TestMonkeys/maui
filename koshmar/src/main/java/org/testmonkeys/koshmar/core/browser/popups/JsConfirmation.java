package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;

public class JsConfirmation extends JsAlert {


    public JsConfirmation(Alert alert) {
        super(alert);
    }

    public void dismiss(){
        alert.dismiss();
    }
}
