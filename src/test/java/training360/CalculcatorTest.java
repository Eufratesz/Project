package training360;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculcatorTest {

    @Test
    void add() {

        assertEquals(10, new Calculcator().add(7,3));
    }

    @Test
    void multiply(){
        assertEquals(21, new Calculcator().multiply(7,3));
    }


}