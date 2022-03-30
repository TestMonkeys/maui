package org.testmonkeys.maui.core.factory;

import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.page.Page;
import org.testmonkeys.maui.core.utils.ReflectionUtils;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

import java.util.HashMap;
import java.util.Map;


public class PageFactory {

    private Browser browser;
    private PageScanner scanner;
    private Map<Class<? extends Page>, Page> cache;
    private String baseUrl;
    private PageInitializer pageInitializer;
    private ReflectionUtils reflectionUtils;

    public PageFactory(Browser browser, PageScanner scanner, String baseUrl) {
        this.browser = browser;
        this.scanner = scanner;
        this.baseUrl = baseUrl;
        this.cache = new HashMap<>();
        pageInitializer = new PageInitializer();
        reflectionUtils = new ReflectionUtils();
    }

    public Page createPage(String name) {
        Class<? extends Page> page = scanner.getPageByName(name);
        return createPage(page);
    }

    /**
     * Finds instance of element by accessor name from a parent page. The search is recursive
     * and will try to find the element in sub-modules as well. In case there are more than one elements
     * with the same declared name - the first one found will be returned
     *
     * @param page        Parent page instance to search the element in
     * @param elementName declared element accessor name
     * @param <T>
     * @return Instance of found element
     */
    public <T extends AbstractComponent> T getElement(Page page, String elementName) {
        return scanner.findPageElementByName(page, elementName);
    }

    public <T extends Page> T createPage(Class<T> type) {

        Page cachedPage = cache.get(type);
        if (cachedPage != null) return type.cast(cachedPage);

        PageAccessor pageAccessor = getPageAccessor(type);
        String url = baseUrl + pageAccessor.url();

        T page = reflectionUtils.instantiate(type);
        page.setBrowser(browser);
        page.setName(pageAccessor.name());
        page.setUrl(url);

        pageInitializer.createPageContent(browser, page);

        cache.put(page.getClass(), page);
        return page;

    }

    private <T extends Page> PageAccessor getPageAccessor(Class<T> type) {
        PageAccessor[] pageAccessors = type.getAnnotationsByType(PageAccessor.class);
        if (pageAccessors.length != 1)
            throw new RuntimeException("Page of type [" + type + "] has wrong number of PageAccessor annotations.");

        return pageAccessors[0];
    }


}
