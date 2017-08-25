package org.testmonkeys.sut.demoqa.playground;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.testmonkeys.AbstractRegistrationPageTest;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;


public class RadioComponentTest extends AbstractRegistrationPageTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void default_index() {
        assertThat(registrationPage.getMaritalStatus().getSelectedIndex(), is(-1));
    }

    @Test
    public void select_by_index() {
        registrationPage.getMaritalStatus().selectByIndex(2);
        assertThat(registrationPage.getMaritalStatus().getSelectedIndex(), is(2));
        registrationPage.getMaritalStatus().selectByIndex(0);
        assertThat(registrationPage.getMaritalStatus().getSelectedIndex(), is(0));
    }

    @Test
    public void select_by_index_notFound() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Could not find radio button by index 3, radio button group size is 3");
        registrationPage.getMaritalStatus().selectByIndex(3);
    }

    @Test
    public void default_value() {
        assertThat(registrationPage.getMaritalStatus().getSelectedValue(), is(nullValue()));
    }

    @Test
    public void select_by_value() {
        registrationPage.getMaritalStatus().selectByValue("married");
        assertThat(registrationPage.getMaritalStatus().getSelectedValue(), is("married"));
        registrationPage.getMaritalStatus().selectByValue("single");
        assertThat(registrationPage.getMaritalStatus().getSelectedValue(), is("single"));
    }

    @Test
    public void select_by_value_notFound() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Could not find radio button by value notExisting123");
        registrationPage.getMaritalStatus().selectByValue("notExisting123");
    }

    @Test
    public void get_all_values() {
        Object[] items = registrationPage.getMaritalStatus().getValues().toArray();
        assertThat(items, hasItemInArray("single"));
        assertThat(items, hasItemInArray("married"));
        assertThat(items, hasItemInArray("divorced"));
    }
}
