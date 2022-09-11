package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookletTest {
    @Test
    void getWeight() {

        //given
        Booklet booklet = new Booklet(28,0.297,0.420,55);

        //when
        double result = booklet.getWeight();

        //then
        assertEquals(0.0480249,result);

    }
}