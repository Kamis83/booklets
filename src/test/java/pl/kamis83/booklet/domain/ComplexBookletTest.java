package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexBookletTest {

    @Test
    void getWeight() {
        //given
        ComplexBooklet complexBooklet = new ComplexBooklet(48,388,246.0,
                170,90,"FSC mix Credit");

        //when
        double result = complexBooklet.getWeight();

        //then
        assertEquals(0.0480249,result);

    }
}