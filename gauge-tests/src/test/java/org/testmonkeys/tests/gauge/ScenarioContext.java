package org.testmonkeys.tests.gauge;

import com.thoughtworks.gauge.ExecutionContext;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.koshmar.core.page.Page;

import java.io.File;
import java.net.URL;

public class ScenarioContext extends ExecutionContext {

    private static ScenarioContext instance = null;

    private Browser browser;
    private static String browserType;
    private PageFactory pageFactory;
    private PageScanner pageScanner;

    private String baseUrl;

    private Page currentPage;

    private ScenarioContext() {
        System.getenv().forEach(System::setProperty);
        browserType = System.getProperty("browser");
        URL url = this.getClass().getClassLoader().getResource("WebPages");
        if (url == null) {
            throw new RuntimeException("Static pages folder not found");
        }
        this.baseUrl = new File(url.getFile()).getAbsolutePath();
    }

    synchronized public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }

        return instance;
    }


    public void reset() {
        //TODO add to this method the logic of resetting the environment related resources: browser, storage.
    }

    public void initBrowser() {
        this.browser = new Browser(DriverFactory.initDriver(browserType));
        pageScanner = new PageScanner("org.testmonkeys.sut.demoqa");
        this.pageFactory = new PageFactory(this.browser, pageScanner, baseUrl);
    }

    public void quitBrowser() {
        this.browser.quit();
    }

    public Page getPage(String pageName) {
        return this.pageFactory.createPage(pageName);
    }

    public PageScanner getPageScanner() {
        return pageScanner;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public Page getCurrentPage() {

        return currentPage;
    }
}
