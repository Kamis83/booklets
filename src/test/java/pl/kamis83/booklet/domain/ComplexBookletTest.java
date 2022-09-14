package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexBookletTest {

    @Test
    void getWeightBookletWithCoverAndMiddleUnit() {
        //given
        ComplexBooklet complexBooklet = new ComplexBooklet(48,4,194,246.0,
                170,90,"FSC mix Credit");

        //when
        double result = complexBooklet.getWeight();

        //then
        assertEquals(0.11931,result);

    } @Test
    void getWeightBookletWithCoverWithoutMiddleUnit() {
        //given
        ComplexBooklet complexBooklet = new ComplexBooklet(28,0,210,297,
                0,55,"FSC mix Credit");

        //when
        double result = complexBooklet.getWeight();

        //then
        assertEquals(0.048024899999999995,result);

    }
}