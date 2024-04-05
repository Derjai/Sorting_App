package com.example.sortingapp.test;

import static org.junit.Assert.assertEquals;


import com.example.sortingapp.SortingApp;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

/**
 * Unit test for simple App.
 */

@RunWith(Parameterized.class)
public class SortingAppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String[] input;
    private final String expectedOutput;

    public SortingAppTest(String[] input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> data() {
        String ls = System.lineSeparator(); // Line separator for the current platform
        return Arrays.asList(new Object[][]{
                {new String[]{}, "Ordered numbers:" + ls + ls}, // zero arguments
                {new String[]{"5"}, "Ordered numbers:" + ls + "5 " + ls}, // one argument
                {new String[]{"5", "3", "9", "1", "6", "8", "2", "4", "7", "0"}, "Ordered numbers:" + ls + "0 1 2 3 4 5 6 7 8 9 " + ls}, // ten arguments
                {new String[]{"5", "3", "9", "1", "6", "8", "2", "4", "7", "0", "11"}, "Error: Too many arguments" + ls} // more than ten arguments
        });
    }

    @org.junit.Test
    public void testMain() {
        System.setOut(new PrintStream(outContent));
        SortingApp.main(input);
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(originalOut);
    }
}
