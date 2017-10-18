package org.testmonkeys.koshmar.pageobjects.elements;

/**
 * Interface to define elements that can have their value read
 *
 * @param <T> type of data they hold
 */
public interface ReadableComponent<T> {

    /**
     * Reads the data from the component
     *
     * @return T data
     */
    T read();
}
