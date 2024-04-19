package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MyAssertTest {
    List<String> todos = List.of("AWS","Docker","Spring");
    @Test
    public void testAsserts(){
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("Dockers");
        assertTrue(test);
        assertFalse(test2);
        assertEquals(3,todos.size());
        assertEquals(true,todos.contains("Spring"));

    }
}
