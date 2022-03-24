package org.testmonkeys.maui.pageobjects.elements.html;

public class JSInteractionException extends RuntimeException {

    public JSInteractionException(String message) {
        super(message);
    }

    public JSInteractionException(String message, Throwable cause) {
        super(message, cause);
    }
}
