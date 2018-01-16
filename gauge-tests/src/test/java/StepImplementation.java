import com.thoughtworks.gauge.Step;
import org.hamcrest.Matchers;
import org.testmonkeys.koshmar.core.page.Page;
import org.testmonkeys.tests.gauge.ScenarioContext;

import static org.junit.Assert.assertThat;

public class StepImplementation {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Step("Open the page <pageName>")
    public void openUrl(String pageName) {
        Page page = scenarioContext.getPage(pageName);
        page.open();
        scenarioContext.setCurrentPage(page);
    }

    @Step("Check that the page title is <Your Store>")
    public void checkPageTitle(String title) {
        Page currentPage = scenarioContext.getCurrentPage();
        assertThat(currentPage.title(), Matchers.is(title));
    }
}
