package ru.easyjava.java;

/**
 * Example of functional interface.
 */
@FunctionalInterface
public interface WordFilterInterface {
    /**
     * Predicate-like method.
     * @param s String to filter.
     * @return Filtering result.
     */
    boolean filter(String s);
}
