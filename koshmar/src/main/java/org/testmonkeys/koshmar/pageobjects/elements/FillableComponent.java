package org.testmonkeys.koshmar.pageobjects.elements;

/**
 * Interface to define components that can be filled with data, such as
 * inputs, selects, checkboxes etc.
 */
public interface FillableComponent<T> {

    /**
     * Fills the component with data.
     *
     * @param data - data to fill in
     */
    void fill(T data);
}
