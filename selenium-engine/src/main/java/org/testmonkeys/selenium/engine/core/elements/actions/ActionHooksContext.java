package org.testmonkeys.selenium.engine.core.elements.actions;

import org.testmonkeys.selenium.engine.core.elements.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by cpascal on 3/29/2017.
 */
public class ActionHooksContext {

    private static ActionHooksContext instance;

    private List<Consumer<Component>> beforeHooks;
    private List<Consumer<Component>> afterHooks;

    private ActionHooksContext() {
        beforeHooks = new ArrayList<>();
        afterHooks = new ArrayList<>();
    }

    public static synchronized ActionHooksContext getContext() {
        if (instance == null)
            instance = new ActionHooksContext();
        return instance;
    }

    public void registerBeforeHook(Consumer<Component> predicate) {
        beforeHooks.add(predicate);
    }

    public void removeBeforeHook(Consumer<Component> predicate) {
        beforeHooks.remove(predicate);
    }

    public void registerAfterHook(Consumer<Component> predicate) {
        afterHooks.add(predicate);
    }

    public void removeAfterHook(Consumer<Component> predicate) {
        afterHooks.remove(predicate);
    }

    List<Consumer<Component>> getBeforeHooks() {
        return beforeHooks;
    }

    List<Consumer<Component>> getAfterHooks() {
        return afterHooks;
    }

}
