package org.testmonkeys.webpages.tests.htmlelement;

import org.junit.Test;
import org.testmonkeys.maui.pageobjects.elements.html.HtmlAttribute;
import org.testmonkeys.maui.pageobjects.elements.html.HtmlElement;
import org.testmonkeys.webpages.tests.AbstractHtmlElementPageTest;

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
        assertThat("value attr", attrs, hasItem(new HtmlAttribute("value", "")));
        assertThat("id attr", attrs, hasItem(new HtmlAttribute("id", "name_3_firstname")));
        assertThat("class attr", attrs, hasItem(new HtmlAttribute("class", "input_fields  piereg_validate[required] input_fields")));
        assertThat("type attr", attrs, hasItem(new HtmlAttribute("type", "text")));
        assertThat("disabled attr", attrs, hasItem(new HtmlAttribute("disabled", "")));
    }

    @Test
    public void get_singleAttributes() {
        HtmlElement htmlElement = page.firstName().getHtmlElement();
        assertThat("value attr", htmlElement.getAttribute("value"), is(""));
        assertThat("id attr", htmlElement.getAttribute("id"), is("name_3_firstname"));
        assertThat("class attr", htmlElement.getAttribute("class"), is("input_fields  piereg_validate[required] input_fields"));
        assertThat("type attr", htmlElement.getAttribute("type"), is("text"));
        assertThat("disabled attr", htmlElement.getAttribute("disabled"), is("true"));
    }

    @Test
    //@Ignore //todo fix
    public void get_noAttributes() {
        List<HtmlAttribute> attrs = page.firstName2().getHtmlElement().getAttributes();
        assertThat("attributes size", attrs.size(), is(0));
    }

    @Test
    public void testInputClear() {
        page.firstName2().type("test_here");
        page.firstName2().clear();
        assertThat(page.firstName2().getText(), is(""));
    }
}
