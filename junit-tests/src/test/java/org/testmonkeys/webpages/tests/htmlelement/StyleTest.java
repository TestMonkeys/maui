package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.webpages.pageObjects.HtmlElementsPageObject;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class StyleTest extends HtmlElementsTest {


    @Test
    public void get_hasStyle() {
        HtmlElementsPageObject page = pageFactory.createPage(HtmlElementsPageObject.class);
        page.open();
        String style = page.styledInput().getHtmlElement().getStyle();
    }

    @Test
    public void get_noAttributes() {
        HtmlElementsPageObject page = pageFactory.createPage(HtmlElementsPageObject.class);
        page.open();
        List<HtmlAttribute> attrs = page.firstName2().getHtmlElement().getAttributes();
        assertThat("attributes size", attrs.size(), is(0));
    }
}
