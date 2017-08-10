package org.testmonkeys.koshmar.core.browser.popups;

import javax.management.RuntimeErrorException;

public class NoPopUpFoundException extends RuntimeException {
    public NoPopUpFoundException(Exception e) {
        super("No Pop Up is present", e);
    }

}
