package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickerTest {

    @Test
    void hasTheStickerGoodWeight() { //given

       Sticker sticker = new Sticker(219.4,70,80,"FSC mix Credit");

        //when
        double result = sticker.getWeight();

        //then
        assertEquals(0.0012286400000000002,result);
    }
}