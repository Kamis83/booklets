package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafletTest {

    @Test
    void hasTheStickerGoodWeight() { //given

       Leaflet leaflet = new Leaflet(219.4,70,80,"FSC mix Credit");

        //when
        double result = leaflet.getWeight();

        //then
        assertEquals(0.0012286400000000002,result);
    }
}