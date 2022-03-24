package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TabIndexTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_tabIndex() {
        int res = page.header().getHtmlElement().getTabIndex();
        assertThat(res, is(-1));
    }

    @Test
    public void set_tabIndex() {
        int res = page.header().getHtmlElement().getTabIndex();
        assertThat(res, is(-1));
        page.header().getHtmlElement().setTabIndex(1);

        res = page.header().getHtmlElement().getTabIndex();
        assertThat(res, is(1));
    }


}
