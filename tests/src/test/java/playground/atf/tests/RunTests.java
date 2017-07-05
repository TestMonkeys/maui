package playground.atf.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import playground.atf.tests.uiTests.CustomCucumberRunner;

/**
 * Created by cpascal on 3/27/2017.
 */
//@RunWith(CustomCucumberRunner.class)
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"playground"},
        features ={"src/test/resources/"},
        plugin = {"pretty","html:target/cucumber/"}//"playground.atf.tests.ELKFormatter"}
)//
//@ContextConfiguration("classpath:cucumber.xml")
public class RunTests {
}
