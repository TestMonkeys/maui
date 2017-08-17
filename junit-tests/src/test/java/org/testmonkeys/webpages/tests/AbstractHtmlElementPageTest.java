package org.testmonkeys.webpages.tests;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.sut.demoqa.RegistrationPage;
import org.testmonkeys.webpages.pageObjects.HtmlElementsPageObject;

import java.io.IOException;

public class AbstractHtmlElementPageTest extends AbstractComponentTest {

    protected HtmlElementsPageObject page;
    protected PageFactory pageFactory;

    protected ClassPathResource htmlPage = new ClassPathResource("/WebPages/HtmlStyleElementsPage.html");

    @Before
    public void beforeScenario() throws IOException {
        pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.webpages"),
                "file:///" + htmlPage.getFile().getAbsolutePath());
        page = pageFactory.createPage(HtmlElementsPageObject.class);
        page.open();
    }
}
