package ru.easyjava.java;


import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ForEach on collections example.
 */
public class ForEach {
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

    private static final Map<Integer, String> MAP =
            Collections.unmodifiableMap(Stream.of(
                    new SimpleEntry<>(0, "zero"),
                    new SimpleEntry<>(1, "one"),
                    new SimpleEntry<>(2, "two"),
                    new SimpleEntry<>(3, "three"))
                    .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));

    public Collection<String> iterateOldSchool() {
        Collection<String> upper = new ArrayList<>();
        for (String s : LONG_WELCOME) {
            upper.add(s.toUpperCase(Locale.ROOT));
        }
        return upper;
    }

    public Collection<String> forEach() {
        Collection<String> upper = new ArrayList<>();
        LONG_WELCOME.forEach(s -> upper.add(s.toUpperCase(Locale.ROOT)));
        return upper;
    }

    public Map<Integer,String> iterateMapOldSchool() {
        Map<Integer, String> upper = new HashMap<>();
        for (Map.Entry<Integer, String> entry: MAP.entrySet()) {
            upper.put(entry.getKey(), entry.getValue().toUpperCase(Locale.ROOT));
        }
        return upper;
    }

    public Map<Integer, String> forEachMap() {
        Map<Integer, String> upper = new HashMap<>();
        MAP.forEach((k, v) -> upper.put(k, v.toUpperCase(Locale.ROOT)));
        return upper;
    }
}
