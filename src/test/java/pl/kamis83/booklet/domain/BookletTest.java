package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookletTest {
    @Test
    void hasBookletGoodWeight() {

        //given
        Booklet booklet = new Booklet(28,210.0,297.0,55,"FSC mix Credit");

        //when
        double result = booklet.getWeight();

        //then
        assertEquals(0.0480249,result);

    }
}