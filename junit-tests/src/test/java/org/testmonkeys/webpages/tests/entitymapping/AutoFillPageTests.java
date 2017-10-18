package org.testmonkeys.webpages.tests.entitymapping;

import com.sun.jna.platform.win32.Netapi32Util;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.io.ClassPathResource;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.webpages.pageObjects.AutoFillPageObject;
import org.testmonkeys.webpages.pageObjects.JsPopUpPage;
import org.testmonkeys.webpages.tests.AbstractComponentTest;

import java.io.IOException;

public class AutoFillPageTests extends AbstractComponentTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    protected AutoFillPageObject page;
    protected PageFactory pageFactory;
    protected ClassPathResource htmlPage = new ClassPathResource("/WebPages/AutoFillPage.html");

    @Before
    public void beforeScenario() throws IOException {
        pageFactory = new PageFactory(browser, new PageScanner("org.testmonkeys.webpages"),
                "file:///" + htmlPage.getFile().getAbsolutePath());
        page = pageFactory.createPage(AutoFillPageObject.class);
        page.open();
    }

    @Test
    public void fillTest() {
        UserEntity ue = new UserEntity();
        ue.setPhone("89760");
        ue.setUsername("user1");
        ue.setReadingHobby(true);

        page.fillEntity(ue);
        System.out.println(page.phone().getText());
        UserEntity readUsr = page.readEntity(UserEntity.class);
        System.out.println(readUsr);

    }

}
