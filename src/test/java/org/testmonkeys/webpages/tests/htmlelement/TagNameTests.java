package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TagNameTests extends AbstractHtmlElementPageTest {

    @Test
    public void get_tagName() {
        String res = page.header().getHtmlElement().getTagName();
        assertThat(res, is("H1"));
    }


}
