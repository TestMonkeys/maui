package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DraggableTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_draggable() {
        boolean res = page.header().getHtmlElement().getDraggable();
        assertThat(res, is(false));
    }

    @Test
    public void set_draggable() {
        boolean res = page.header().getHtmlElement().getDraggable();
        assertThat(res, is(false));
        page.header().getHtmlElement().setDraggable(true);

        res = page.header().getHtmlElement().getDraggable();
        assertThat(res, is(true));
    }


}
