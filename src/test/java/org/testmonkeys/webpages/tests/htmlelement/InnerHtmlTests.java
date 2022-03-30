package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InnerHtmlTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_innerHtml() {
        String res = page.header().getHtmlElement().getInnerHtml();
        assertThat(res, is("Html Element "));
    }

    @Test
    public void set_innerHtml() {
        String res = page.header().getHtmlElement().getInnerHtml();
        assertThat(res, is("Html Element "));
        page.header().getHtmlElement().setInnerHtml("injected");
        res = page.header().getHtmlElement().getInnerHtml();
        assertThat(res, is("injected"));
    }


}
