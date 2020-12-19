package day09;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5_ParametrizedTest {
    
    
    @ParameterizedTest
    @ValueSource(ints = { 5,6,7,8,9})
    public void test1(int myNumber){
    
        //assert 5,6,7,8,9 all less than 10
        System.out.println("myNumber = " + myNumber);
        
    }
    
}
