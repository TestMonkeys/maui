package playground.atf.tests.uiTests;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.junit.Assertions;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitOptions;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.junit.Assertions;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitOptions;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomCucumberRunner extends ParentRunner<FeatureRunner> {

    private final Logger logger = LoggerFactory.getLogger(CustomCucumberRunner.class);
    private final JUnitReporter jUnitReporter;
    private final List<FeatureRunner> children = new ArrayList();
    private final Runtime runtime;

    public CustomCucumberRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        Assertions.assertNoCucumberAnnotatedMethods(clazz);
        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
        RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();
        ResourceLoader resourceLoader = new MultiLoader(classLoader);
        this.runtime = this.createRuntime(resourceLoader, classLoader, runtimeOptions);
        JUnitOptions junitOptions = new JUnitOptions(runtimeOptions.getJunitOptions());
        List<CucumberFeature> cucumberFeatures = runtimeOptions.cucumberFeatures(resourceLoader);
        this.jUnitReporter = new JUnitReporter(runtimeOptions.reporter(classLoader), runtimeOptions.formatter(classLoader), runtimeOptions.isStrict(), junitOptions);
        this.addChildren(cucumberFeatures);
    }

    protected Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions) throws InitializationError, IOException {
        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
        return new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
    }

    public List<FeatureRunner> getChildren() {
        return this.children;
    }

    protected Description describeChild(FeatureRunner child) {
        return child.getDescription();
    }

    protected void runChild(FeatureRunner child, RunNotifier notifier) {
        child.run(notifier);
    }

    public void run(RunNotifier notifier) {
        String runNumber=System.getProperty("runNumber");
        notifier.addListener(new RunListener(){

            @Override
            public void testRunStarted(Description description) throws Exception {
                //logger.info("Run Started: "+runNumber+" "+description);
            }

            @Override
            public void testRunFinished(Result result) throws Exception {
                //logger.info("Run finished: "+result);
            }

            @Override
            public void testStarted(Description description) throws Exception {
                logger.info("Test Started: "+runNumber+" "+description);
            }

            @Override
            public void testFinished(Description description) throws Exception {
                logger.info("Test Finished: "+description);
            }

            @Override
            public void testFailure(Failure failure) throws Exception {
                logger.info("Test Failure "+failure);
            }

            @Override
            public void testAssumptionFailure(Failure failure) {
            }

            @Override
            public void testIgnored(Description description) throws Exception {
            }

        });
        super.run(notifier);
        this.jUnitReporter.done();
        this.jUnitReporter.close();
        this.runtime.printSummary();
    }

    private void addChildren(List<CucumberFeature> cucumberFeatures) throws InitializationError {
        Iterator var2 = cucumberFeatures.iterator();

        while(var2.hasNext()) {
            CucumberFeature cucumberFeature = (CucumberFeature)var2.next();
            this.children.add(new FeatureRunner(cucumberFeature, this.runtime, this.jUnitReporter));
        }

    }
}
