package org.testmonkeys.webpages.tests.elements;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.testmonkeys.maui.core.elements.Component;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class ElementFindingTest extends AbstractHtmlElementPageTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void element_inside_module() {
        Component c = pageFactory.getElement(page, "inside module");
        assertThat("element found", c, notNullValue());
        assertThat("parent", c.getParent(), is(page.getModule()));
    }

    @Test
    public void element_on_page() {
        Component c = pageFactory.getElement(page, "element3");
        assertThat("element found", c, notNullValue());
        assertThat("parent", c.getParent(), is(page));
    }

    @Test
    @Ignore //todo fix test
    public void element_not_found() {
        expectedException.expect(RuntimeException.class);
        Component c = pageFactory.getElement(page, "element3456");
    }
}
