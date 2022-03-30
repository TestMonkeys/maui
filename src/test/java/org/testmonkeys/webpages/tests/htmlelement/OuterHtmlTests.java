package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OuterHtmlTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_outerHtml() {
        String res = page.header().getHtmlElement().getOuterHtml();
        assertThat(res, is("<h1 class=\"entry-title\">Html Element </h1>"));
    }

    @Test
    public void set_outerHtml() {
        String res = page.header().getHtmlElement().getOuterHtml();
        assertThat(res, is("<h1 class=\"entry-title\">Html Element </h1>"));
        page.header().getHtmlElement().setOuterHtml("<h1 class=\"entry-title1\">injected</h1>");
        res = page.header().getHtmlElement().getOuterHtml();
        assertThat(res, is("<h1 class=\"entry-title1\">injected</h1>"));
    }


}
