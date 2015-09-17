package ru.easyjava.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Streams demonstration.
 */
public class Lambdas {
    /**
     * Source data to process.
     */
    private static final List<String> LONG_WELCOME = Arrays.asList(
            "Hello",
            "and",
            "welcome",
            "to",
            "the",
            "wonderful",
            "world",
            "of",
            "java",
            "8");

    /**
     * We will select words of that length.
     */
    private static final Integer WORD_LENGTH = 5;

    /**
     * Hello world in a modern way.
     * @return "Hello, world"
     */
    public final String greet() {
        return LONG_WELCOME
                .stream()
                .filter(s -> s.length() == WORD_LENGTH)
                .collect(Collectors.joining(", "));
    }

    /**
     * Example of full lambda syntax.
     * @return "Hello, world".
     */
    public final String greetLong() {
        return LONG_WELCOME
                .stream()
                .filter((final String s) -> {
                    System.out.println(s);
                    return s.length() == WORD_LENGTH; }
                )
                .collect(Collectors.joining(", "));
    }

    /**
     * Example of no braces lambda syntax.
     * @return "Hello, world".
     */
    public final String greetNoReturn() {
        return LONG_WELCOME
                .stream()
                .filter((final String s) -> s.length() == WORD_LENGTH)
                .collect(Collectors.joining(", "));
    }

    /**
     * Example of functional interfaces.
     * @param filter filtering function
     * @return "Hello, world".
     */
    public final String greetVariable(final WordFilterInterface filter) {
        StringBuilder result = new StringBuilder();
        for (String s : LONG_WELCOME) {
            if (filter.filter(s)) {
                result.append(s);
            }
        }

        return result.toString();
    }

    /**
     * Example of standard functional interfaces.
     * @param filter filtering function
     * @return "Hello, world".
     */
    public final String greetPredicate(final Predicate<String> filter) {
        return LONG_WELCOME
                .stream()
                .filter(filter)
                .collect(Collectors.joining(", "));
    }

    /**
     * Example of closures.
     * @param length required length of words.
     * @return Lambda that will check if word of required length or not.
     */
    public final Predicate<String> filterPredicate(final Integer length) {
        return s -> s.length() == length;
    }

    /**
     * Example of method references.
     * @return Sorted LONG_WELCOME array
     */
    public final Collection<String> sort() {
        List<String> sorted = new ArrayList<>(LONG_WELCOME);
        sorted.sort(String::compareToIgnoreCase);
        return sorted;
    }
}
