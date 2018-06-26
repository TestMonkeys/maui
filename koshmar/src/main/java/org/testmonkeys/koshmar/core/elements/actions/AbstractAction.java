package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

import java.util.concurrent.TimeUnit;

/**
 * Created by cpascal on 3/29/2017.
 */
public abstract class AbstractAction<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    protected AbstractComponent component;
    private FluentWait<AbstractComponent> retryMech;

    public AbstractAction(AbstractComponent component) {
        retryMech=new FluentWait<AbstractComponent>(component)
                .ignoring(WebDriverException.class)
                .pollingEvery(1, TimeUnit.SECONDS).withTimeout(10,TimeUnit.SECONDS);
        this.component = component;
    }

    public T execute() {
        ActionHooksContext.getContext().getBeforeHooks().forEach(hook -> hook.accept(component));
        logger.trace("Executing action upon " + component);
        logger.info(describeAction());
        T actionResult = executeAction(component.find());
        if (actionResult != null)
            logger.info("Action result is '" + actionResult + "'");
        logger.trace("Action result is = " + actionResult);
        ActionHooksContext.getContext().getAfterHooks().forEach(hook -> hook.accept(component));
        return actionResult;
    }

    protected abstract T executeAction(WebElement webElement);

    protected String describeAction() {
        return "Executing action upon " + component;
    }
}
