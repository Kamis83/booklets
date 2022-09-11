package pl.kamis83.booklet.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookletLegacyTest {

    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWithoutBlankSpace() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [12STR][12.09]Fsc Mix Credit", "0,210x0,297", 55);
        //when
        int result = booklet.getNumberOfPages();
        //then
        assertEquals(12, result);


    }
    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWithBlankSpace() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [ 12 STR][12.09]Fsc mix Credit", "0,210x0,297", 55);
        //when
        int result = booklet.getNumberOfPages();
        //then
        assertEquals(12, result);


    }
    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWith6CharLength() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [ 200 STR][12.09]Fsc mix Credit", "0,210x0,297", 55);
        //when
        int result = booklet.getNumberOfPages();
        //then
        assertEquals(200, result);


    }
    @Test
    void hasBookletRightAmountOfPagesWithoutInfoInName() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [12.09]Fsc mix Credit", "0,210x0,297", 55);
        //when
        int result = booklet.getNumberOfPages();
        //then
        assertEquals(0, result);


    }
    @Test
    void hasBookletRightSurfaceArea() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [12.09]Fsc mix Credit", "0.210x0.297", 55);
        //when
        float result = booklet.countSurfaceArea();
        //then
        assertEquals(0.062369994819164276, result);

    }
    @Test
    void hasBookletRightSurfaceAreaWithDifferentNotationOfNumber() {
        //given
        BookletLegacy booklet = new BookletLegacy("Aneboda [12.09]Fsc mix Credit", "0,210 x 0,297 x 0,420", 55);
        //when
        float result = booklet.countSurfaceArea();
        //then
        assertEquals(0.062369994819164276, result);

    }


}