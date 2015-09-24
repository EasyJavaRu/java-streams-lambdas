package ru.easyjava.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ForEachTest {
    private ForEach testedObject = new ForEach();

    @Test
    public void testIterateOldSchool() {
        assertThat(testedObject.iterateOldSchool(), is(Arrays.asList("HELLO",
                "AND",
                "WELCOME",
                "TO",
                "THE",
                "WONDERFUL",
                "WORLD",
                "OF",
                "JAVA",
                "8")));
    }

    @Test
    public void testIterate() {
        assertThat(testedObject.forEach(), is(Arrays.asList("HELLO",
                "AND",
                "WELCOME",
                "TO",
                "THE",
                "WONDERFUL",
                "WORLD",
                "OF",
                "JAVA",
                "8")));
    }

    @Test
    public void testIterateMapOldSchool() {
        assertThat(new ArrayList<>(testedObject.iterateMapOldSchool().values()), is(Arrays.asList("ZERO",
                "ONE",
                "TWO",
                "THREE")));
    }

    @Test
    public void testIterateMap() {
        assertThat(new ArrayList<>(testedObject.forEachMap().values()), is(Arrays.asList("ZERO",
                "ONE",
                "TWO",
                "THREE")));
    }
}