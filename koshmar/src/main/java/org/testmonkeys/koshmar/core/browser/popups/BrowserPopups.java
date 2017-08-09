package org.testmonkeys.koshmar.core.browser.popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testmonkeys.koshmar.core.browser.Browser;

public class BrowserPopups {

    private Browser browser;

    public BrowserPopups(Browser browser){
        this.browser=browser;
    }

    public boolean hasPopUp(){
        boolean hasPopup=false;
        try {
            Alert a = browser.getDriver().switchTo().alert();
            if (a != null)
                hasPopup = true;
        }catch (Exception e){

        }
        return hasPopup;
    }

    public JsAlert getAlert(){
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsAlert(a);
        }catch (NoAlertPresentException e){
            throw new RuntimeException(e);
        }
    }

    public JsConfirmation getConfirmation(){
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsConfirmation(a);
        }catch (NoAlertPresentException e){
            throw new RuntimeException(e);
        }
    }

    public JsPrompt getPrompt(){
        try {
            Alert a = browser.getDriver().switchTo().alert();
            return new JsPrompt(a);
        }catch (NoAlertPresentException e){
            throw new RuntimeException(e);
        }
    }
}
