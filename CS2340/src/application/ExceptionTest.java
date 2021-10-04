package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void testNoException() {
        try {
            main();
        }
        catch (Exception e){
            fail("No exception should have bneen thrown");
        }

    }

}