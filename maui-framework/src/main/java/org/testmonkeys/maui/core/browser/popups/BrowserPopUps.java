package org.testmonkeys.maui.core.browser.popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testmonkeys.maui.core.browser.Browser;

/**
 * This class contains logic of checking and retrieving pop-up boxes.
 */
public class BrowserPopUps {

    private Browser browser;

    public BrowserPopUps(Browser browser) {
        this.browser = browser;
    }

    /**
     * Checks if on the current window a pop up box is displayed.
     *
     * @return boolean result
     */
    public boolean hasPopUp() {
        boolean hasPopup = false;
        try {
            Alert a = browser.getDriver().switchTo().alert();
            if (a != null)
                hasPopup = true;
        } catch (Exception e) {

        }
        return hasPopup;
    }

    /**
     * Gets the JsAlert box displayed on page
     *
     * @return instance of JsAlert class
     * @throws NoPopUpFoundException if no alert is displayed
     */
    public JsAlert getAlert() {
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsAlert(a);
        } catch (NoAlertPresentException e) {
            throw new NoPopUpFoundException(e);
        }
    }

    /**
     * Gets the JsConfirmation box displayed on page
     *
     * @return instance of JsConfirmation class
     * @throws NoPopUpFoundException if no alert is displayed
     */
    public JsConfirmation getConfirmation() {
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsConfirmation(a);
        } catch (NoAlertPresentException e) {
            throw new NoPopUpFoundException(e);
        }
    }

    /**
     * Gets the JsPrompt box displayed on page
     *
     * @return instance of JsPrompt class
     * @throws NoPopUpFoundException if no alert is displayed
     */
    public JsPrompt getPrompt() {
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsPrompt(a);
        } catch (NoAlertPresentException e) {
            throw new NoPopUpFoundException(e);
        }
    }
}
