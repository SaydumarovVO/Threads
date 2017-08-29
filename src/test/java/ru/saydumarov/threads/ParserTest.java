package ru.saydumarov.threads;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ParserTest {

    @Test
    void test_1() throws Exception {
        String testString = "nine thousand nine hundred ninety nine";
        int test = Parser.toNum(testString);
        assertEquals(9999, test);
    }

    @Test
    void test_2() throws Exception {
        try {
            String testString = "nine nine hundred ninety nine";
            int test = Parser.toNum(testString);
            fail();
        } catch (Exception e){
            assertThat(e.getMessage(), is("Invalid expression. Try again"));
        }

    }

    @Test
    void test_3() throws Exception {
        String testString = "nine hundred ninety nine";
        int test = Parser.toNum(testString);
        assertEquals(999, test);
    }

    @Test
    void test_4() throws Exception {
        String testString = "ninety nine";
        int test = Parser.toNum(testString);
        assertEquals(99, test);
    }

    @Test
    void test_5() throws Exception {
        try {
            String testString = "nine thousand nine ninety nine";
            int test = Parser.toNum(testString);
            fail();
        } catch (Exception e){
            assertThat(e.getMessage(), is("Invalid expression. Try again"));
        }
    }

    @Test
    void test_6() throws Exception {
        String testString = "nine";
        int test = Parser.toNum(testString);
        assertEquals(9, test);
    }

    @Test
    void test_7() throws Exception {
        try {
            String testString = "nine nine";
            int test = Parser.toNum(testString);
            fail();
        } catch (Exception e){
            assertThat(e.getMessage(), is("Invalid expression. Try again"));
        }
    }

    @Test
    void test_8() throws Exception {
        String testString = "nine thousand";
        int test = Parser.toNum(testString);
        assertEquals(9000, test);
    }

    @Test
    void test_9() throws Exception {
        String testString = "nine hundred";
        int test = Parser.toNum(testString);
        assertEquals(900, test);
    }

    @Test
    void test_10() throws Exception {

        try {
            String testString = "naine thousand nine hundred ninety nine";
            int test = Parser.toNum(testString);
            fail();
        } catch (Exception e){
            assertThat(e.getMessage(), is("Invalid expression. Try again"));
        }
    }
}