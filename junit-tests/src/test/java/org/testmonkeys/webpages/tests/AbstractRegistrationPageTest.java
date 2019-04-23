package org.testmonkeys.webpages.tests;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.testmonkeys.maui.core.factory.PageFactory;
import org.testmonkeys.maui.core.factory.PageScanner;
import org.testmonkeys.sut.demoqa.RegistrationPage;

import java.io.IOException;

public class AbstractRegistrationPageTest extends AbstractComponentTest {

    protected RegistrationPage registrationPage;
    protected PageFactory pageFactory;

    protected ClassPathResource webPagesPath = new ClassPathResource("WebPages");

    @Before
    public void beforeScenario() throws IOException {
        pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.sut"),
                "http://localhost:8080");
        registrationPage = pageFactory.createPage(RegistrationPage.class);
        registrationPage.open();
    }
}
