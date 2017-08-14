package org.testmonkeys.webpages.tests.elements;

import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBox;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;
import org.testmonkeys.sut.demoqa.RegistrationPage;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckBoxComponentTest extends AbstractComponentTest {

    private RegistrationPage registrationPage;

    @Rule
    public VideoRule videoRule = new VideoRule();

    @Before
    public void beforeScenario() throws IOException {
        DriverFactory df = new DriverFactory();
        browser = new Browser(df.initDriver("chrome"));//, cap));
        PageFactory pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.sut"),
                "file:///"+htmlPage.getFile().getAbsolutePath());
        registrationPage = pageFactory.createPage(RegistrationPage.class);
        registrationPage.open();
    }

    @Test
    @Video
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
    @Video
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
    @Video
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
    @Video
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
