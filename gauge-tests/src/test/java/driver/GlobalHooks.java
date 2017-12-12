package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.testmonkeys.tests.gauge.ScenarioContext;

public class GlobalHooks {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @BeforeScenario
    public void initializeDriver() {
        scenarioContext.reset();
        scenarioContext.initBrowser();
    }

    @AfterScenario
    public void closeDriver() {
        scenarioContext.quitBrowser();
    }

}
