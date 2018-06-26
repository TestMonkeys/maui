package org.testmonkeys.maui.core.page;

import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.elements.location.LocatesElements;

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
