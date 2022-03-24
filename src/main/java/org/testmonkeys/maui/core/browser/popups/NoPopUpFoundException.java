package org.testmonkeys.maui.core.browser.popups;

public class NoPopUpFoundException extends RuntimeException {
    public NoPopUpFoundException(Exception e) {
        super("No Pop Up is present", e);
    }

}
