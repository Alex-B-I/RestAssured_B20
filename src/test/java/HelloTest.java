import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloTest {

    //Junit5 Annotation
    // @BeforeAll @AfterAll @BeforeEach @AfterEach

    @BeforeAll
    public static void setUp(){
        System.out.println("@BeforeAll is running");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll is running");
    }
    @BeforeEach
    public void setUpTest(){
        System.out.println("@BeforeEach is running");
    }

    @AfterEach
    public void tearDownTest(){
        System.out.println("@AfterEach is running");
    }


    @Test
    public void test(){
        Assertions.assertEquals(4,3+1);
        System.out.println("Test1 is running");
    }

    @Test
    public void test2(){
        //assert  4 time 3 is 12
        assertEquals(12, 4*3);
        System.out.println("Test2 is running");
    }
}
