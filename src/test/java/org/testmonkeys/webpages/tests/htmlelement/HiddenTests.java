package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HiddenTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_Hidden() {
        boolean res = page.header().getHtmlElement().getHidden();
        assertThat(res, is(false));
    }

    @Test
    public void set_Hidden() {
        boolean res = page.header().getHtmlElement().getHidden();
        assertThat(res, is(false));
        page.header().getHtmlElement().setHidden(true);

        res = page.header().getHtmlElement().getHidden();
        assertThat(res, is(true));
    }


}
