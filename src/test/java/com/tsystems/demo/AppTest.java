package com.tsystems.demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSayHi() {
        String result = new App().sayHi("World");
        assertEquals(result, "Hello World");
    }
}
