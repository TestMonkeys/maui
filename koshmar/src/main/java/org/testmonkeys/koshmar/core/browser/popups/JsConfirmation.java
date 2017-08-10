package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;

/**
 * JsConfirmation is the representation of a confirmation box. This differs from an Alert
 * by providing you a choice to accept or refuse the pop-up
 */
public class JsConfirmation extends JsAlert {

    public JsConfirmation(Alert alert) {
        super(alert);
    }

    /**
     * Dismisses the pop-up by pressing Cancel
     */
    public void dismiss(){
        alert.dismiss();
    }
}
