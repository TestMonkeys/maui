package org.testmonkeys.webpages.tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.springframework.core.io.ClassPathResource;
import org.testmonkeys.maui.core.factory.PageFactory;
import org.testmonkeys.maui.core.factory.PageScanner;
import org.testmonkeys.sut.demoqa.RegistrationPage;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;

import java.io.IOException;

public class AbstractPopUpPageTest extends AbstractComponentTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    protected JsPopUpPage popUpPage;
    protected PageFactory pageFactory;
    protected ClassPathResource htmlPage = new ClassPathResource("/WebPages/JSPopUpPage.html");

    @Before
    public void beforeScenario() throws IOException {
        pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.webpages"),
                "http://localhost:8080/JSPopUpPage.html");
//                "file:///" + htmlPage.getFile().getAbsolutePath());
        popUpPage = pageFactory.createPage(JsPopUpPage.class);
        popUpPage.open();
    }
}
