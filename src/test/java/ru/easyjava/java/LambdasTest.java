package ru.easyjava.java;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

public class LambdasTest {
    private static final String EXPECTED = "Hello, world";

    private Lambdas testedObject = new Lambdas();

    @Test
    public void testGreet() throws Exception {
        assertThat(testedObject.greet(), is(EXPECTED));
    }

    @Test
    public void testGreetLong() throws Exception {
        assertThat(testedObject.greetLong(), is(EXPECTED));
    }

    @Test
    public void testGreetNoReturn() throws Exception {
        assertThat(testedObject.greetNoReturn(), is(EXPECTED));
    }

    @Test
    public void testGreetVariable() throws Exception {
        assertThat(testedObject.greetVariable(s -> s.length() == 4), is("java"));
        assertThat(testedObject.greetVariable(s -> s.length() == 6), isEmptyString());
    }

    @Test
    public void testGreetPredicate() throws Exception {
        assertThat(testedObject.greetPredicate(s -> s.length() == 4), is("java"));
        assertThat(testedObject.greetPredicate(s -> s.length() == 6), isEmptyString());
    }

    @Test
    public void testGreetLocalVars() throws Exception {
        int l = 2;
        assertThat(testedObject.greetPredicate(s -> s.length() == l), is("to, of"));
    }

    @Test
    public void testClosures() throws Exception {
        assertThat(testedObject.greetPredicate(testedObject.filterPredicate(4)), is("java"));
        assertThat(testedObject.greetPredicate(testedObject.filterPredicate(6)), isEmptyString());
    }

    @Test
    public void testReferencedSort() {
        assertThat(testedObject.sort(), is(Arrays.asList("8",
                "and",
                "Hello",
                "java",
                "of",
                "the",
                "to",
                "welcome",
                "wonderful",
                "world")));
    }
}