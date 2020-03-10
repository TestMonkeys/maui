package org.testmonkeys.webpages.tests.elements;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComponentTest extends AbstractHtmlElementPageTest {

    @Test
    public void isEnabled_false() {
        assertThat("first name enabled", page.firstName().isEnabled(), is(false));
    }

    @Test
    public void isEnabled_true() {
        assertThat("first name2 enabled", page.firstName2().isEnabled(), is(true));
    }

    @Test
    public void isDisplayed_false_noDisplay() {
        assertThat("element no display displayed", page.getNoDisplayInput().isDisplayed(), is(false));
    }

    @Test
    public void isDisplayed_false_hidden() {
        assertThat("hidden element displayed", page.getHiddenInput().isDisplayed(), is(false));
    }

    @Test
    public void isDisplayed_true() {
        assertThat("first name2 displayed", page.firstName2().isDisplayed(), is(true));
    }
}
