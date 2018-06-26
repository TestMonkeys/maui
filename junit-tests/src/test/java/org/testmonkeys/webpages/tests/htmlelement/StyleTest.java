package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.maui.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class StyleTest extends AbstractHtmlElementPageTest {


    @Test
    public void get_hasStyle() {
        Map<String, String> style = page.styledInput().getHtmlElement().getStyle();
        assertThat(style.getOrDefault("border-right-width", ""), is("2px"));
        assertThat(style.getOrDefault("border-right-color", ""), is("rgb(0, 0, 255)"));
    }

    @Test
    public void get_hasStyle_specific() {
        String style = page.styledInput().getHtmlElement().getStyle("border-right-width");
        assertThat(style, is("2px"));
    }

    @Test
    public void get_noAttributes() {
        List<HtmlAttribute> attrs = page.firstName2().getHtmlElement().getAttributes();
        assertThat("attributes size", attrs.size(), is(0));
    }

    @Test
    public void get_invalidKeyStyle_specific() {
        String style = page.styledInput().getHtmlElement().getStyle("bor1der-right-width");
        assertThat(style, is(nullValue()));
    }
}
