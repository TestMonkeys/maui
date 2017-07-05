package playground.atf.tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.springframework.test.context.ContextConfiguration;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
//import playground.yats.configuration.*;

/**
 * Created by cpascal on 3/27/2017.
 */

public class TestClass {

    Scenario scenario;

    @Before
    public void before(Scenario scenario) throws InterruptedException {
       this.scenario=scenario;
       Thread.sleep(500);
        logger.info("executing before");
        scenario.write("test");
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Given("this is the first step")
    public void firstStep(){
        logger.info("first Step executed");
        scenario.write("test");
    }

    @After
    public void after(Scenario scenario){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scenario.write("test");
        logger.info("after Step executed");
    }
}
