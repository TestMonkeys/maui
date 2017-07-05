package org.testmonkeys.selenium.engine.core.page;

import org.testmonkeys.selenium.engine.core.browser.Browser;
import org.testmonkeys.selenium.engine.core.elements.location.LocatesElements;

public interface Page extends LocatesElements {

    void open();

    String getUrl();

    void setUrl(String url);

    String name();

    void setName(String name);

    void setBrowser(Browser browser);

    String title();

    boolean isCurrentPage();
}
