package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testmonkeys.koshmar.core.browser.Browser;

import java.util.concurrent.TimeUnit;

/**
 * This class contains logic of checking and retrieving pop-up boxes.
 */
public class BrowserPopUps {

    private Browser browser;

    public BrowserPopUps(Browser browser) {
        this.browser = browser;
    }

    private FluentWait<WebDriver> getFluentWait() {
        return browser.initWaitter(500, 100, TimeUnit.MILLISECONDS);
    }

    private boolean popUpPresent(WebDriver webDriver) {
        boolean hasPopup = false;
        try {
            Alert a = webDriver.switchTo().alert();
            if (a != null)
                hasPopup = true;
        } catch (Exception e) {

        }
        return hasPopup;
    }

    /**
     * Checks if on the current window a pop up box is displayed.
     *
     * @return boolean result
     */
    public boolean hasPopUp() {
        try {
            return getFluentWait().until(this::popUpPresent);
        } catch (TimeoutException e) {
            return false;
        }
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
