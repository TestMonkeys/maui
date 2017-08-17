package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.webpages.pageObjects.HtmlElementsPageObject;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;
import org.testmonkeys.webpages.tests.AbstractRegistrationPageTest;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AttributesTest extends AbstractHtmlElementPageTest {


    //    <input
    //      value=""
    //      id="name_3_firstname"
    //      name="first_name"
    //      class="input_fields  piereg_validate[required] input_fields"
    //      type="text"
    //      disabled>
    //    <input/>
    @Test
    public void get_hasAttributes() {
        List<HtmlAttribute> attrs = page.firstName().getHtmlElement().getAttributes();
        assertThat("value attr",attrs, hasItem(new HtmlAttribute("value", "")));
        assertThat("id attr",attrs, hasItem(new HtmlAttribute("id", "name_3_firstname")));
        assertThat("class attr",attrs, hasItem(new HtmlAttribute("class", "input_fields  piereg_validate[required] input_fields")));
        assertThat("type attr",attrs, hasItem(new HtmlAttribute("type", "text")));
        assertThat("disabled attr",attrs, hasItem(new HtmlAttribute("disabled", "")));
    }

    @Test
    public void get_noAttributes() {
        List<HtmlAttribute> attrs = page.firstName2().getHtmlElement().getAttributes();
        assertThat("attributes size", attrs.size(), is(0));
    }
}
