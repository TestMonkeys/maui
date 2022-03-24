package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TitleTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_title() {
        String res = page.header().getHtmlElement().getTitle();
        assertThat(res, is(""));
    }

    @Test
    public void set_title() {
        String res = page.header().getHtmlElement().getTitle();
        assertThat(res, is(""));
        page.header().getHtmlElement().setTitle("injected title");
        res = page.header().getHtmlElement().getTitle();
        assertThat(res, is("injected title"));
    }


}
