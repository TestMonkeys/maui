package org.testmonkeys.webpages.tests.elements;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import java.time.Duration;
import java.time.Instant;

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

    @Test
    public void isDisplayed_elementNotPresent() {
        Instant start = Instant.now();
        assertThat("element not present is displayed", page.getNonExistingInput().isDisplayed(), is(false));
        Instant end = Instant.now();
        Duration executedDuration = Duration.between(start, end);
        System.out.println(executedDuration);
        assertThat("search was more or less instant", executedDuration.getSeconds(), Matchers.lessThan(2l));
    }
}
