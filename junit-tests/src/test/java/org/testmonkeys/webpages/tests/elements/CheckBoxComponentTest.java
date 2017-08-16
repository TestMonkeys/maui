package org.testmonkeys.webpages.tests.elements;

import org.junit.Test;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBox;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;
import org.testmonkeys.webpages.tests.AbstractRegistrationPageTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckBoxComponentTest extends AbstractRegistrationPageTest {

    @Test
    public void check() {
        GroupComponent<CheckBox> checkBoxGroupComponent = registrationPage.hobbyCheckBoxes();
        List<CheckBox> hobbies = checkBoxGroupComponent.getAll();
        checkBoxGroupComponent.get(0);
        assertThat(hobbies).hasSize(3);
        hobbies.forEach(h -> assertThat(h.isChecked()).isFalse());
        hobbies.forEach(CheckBox::check);
        hobbies.forEach(h -> assertThat(h.isChecked()).isTrue());
    }

    @Test
    public void checkAlreadyChecked() {
        GroupComponent<CheckBox> checkBoxGroupComponent = registrationPage.hobbyCheckBoxes();
        List<CheckBox> hobbies = checkBoxGroupComponent.getAll();
        assertThat(hobbies).hasSize(3);
        hobbies.forEach(h -> assertThat(h.isChecked()).isFalse());
        hobbies.forEach(CheckBox::check);
        hobbies.forEach(h -> assertThat(h.isChecked()).isTrue());
        hobbies.forEach(CheckBox::check);
        hobbies.forEach(h -> assertThat(h.isChecked()).isTrue());
    }

    @Test
    public void uncheck() {
        GroupComponent<CheckBox> checkBoxGroupComponent = registrationPage.hobbyCheckBoxes();
        List<CheckBox> hobbies = checkBoxGroupComponent.getAll();
        assertThat(hobbies).hasSize(3);
        hobbies.forEach(CheckBox::check);
        hobbies.forEach(h -> assertThat(h.isChecked()).isTrue());
        hobbies.forEach(CheckBox::uncheck);
        hobbies.forEach(h -> assertThat(h.isChecked()).isFalse());
    }

    @Test
    public void uncheckAlreadyUnchecked() {
        GroupComponent<CheckBox> checkBoxGroupComponent = registrationPage.hobbyCheckBoxes();
        List<CheckBox> hobbies = checkBoxGroupComponent.getAll();
        assertThat(hobbies).hasSize(3);
        hobbies.forEach(CheckBox::check);
        hobbies.forEach(h -> assertThat(h.isChecked()).isTrue());
        hobbies.forEach(CheckBox::uncheck);
        hobbies.forEach(h -> assertThat(h.isChecked()).isFalse());
        hobbies.forEach(CheckBox::uncheck);
        hobbies.forEach(h -> assertThat(h.isChecked()).isFalse());
    }
}
