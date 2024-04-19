package test;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MyBeforeAfterTest {
    @BeforeClass
    public static void beforeALl(){
        System.out.println("Before ALl");
    }
    @Before
    public void beforeEach(){
        System.out.println("Before Each");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
    }
    @After
    public void afterEach(){
        System.out.println("After Each");
    }
    @AfterClass
    public static void afterALl(){
        System.out.println("After ALl");
    }
}
