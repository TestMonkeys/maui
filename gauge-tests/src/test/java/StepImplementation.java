import com.thoughtworks.gauge.Step;
import org.testmonkeys.koshmar.core.page.Page;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBox;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;
import org.testmonkeys.tests.gauge.ScenarioContext;

import java.util.function.Consumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepImplementation {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();


    @Step("Open the <pageName>")
    public void openPageByName(String pageName) {
        Page page = scenarioContext.getPage(pageName);
        page.open();
        scenarioContext.setCurrentPage(page);
    }

    @Step("Check all <groupName> checkboxes")
    public void checkCheckBoxes(String groupName) {
        GroupComponent<CheckBox> checkBox = scenarioContext.getPageScanner()
                .findPageElementByName(scenarioContext.getCurrentPage(), groupName);
        checkBox.getAll().forEach(CheckBox::check);
    }

    @Step("All <groupName> checkboxes are checked")
    public void verifyAllCheckBoxesAreChecked(String groupName) {
        verifyCheckBoxes(groupName, c ->
                assertTrue("Checkbox " + c.getValue() + " in group '" + groupName + "' are checked", c.isChecked()));
    }

    @Step("All <hobby> checkboxes are not checked")
    public void verifyAllCheckBoxesAreNotChecked(String groupName) {
        verifyCheckBoxes(groupName, c ->
                assertFalse("Checkbox " + c.getValue() + " in group '" + groupName + "' are not checked", c.isChecked()));
    }

    private void verifyCheckBoxes(String groupName, Consumer<CheckBox> checkBoxConsumer) {
        GroupComponent<CheckBox> checkBox = scenarioContext.getPageScanner()
                .findPageElementByName(scenarioContext.getCurrentPage(), groupName);
        checkBox.getAll().forEach(checkBoxConsumer);
    }

}
