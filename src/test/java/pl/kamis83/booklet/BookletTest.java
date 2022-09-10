package pl.kamis83.booklet;

import org.apache.maven.plugin.version.PluginVersionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookletTest {

    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWithoutBlankSpace() {
        //given
        Booklet booklet = new Booklet("Aneboda [12STR][12.09]Fsc mix Credit", "0,210x0,297");
        //when
        int result = booklet.setNumberOfPages(booklet.name);
        //then
        assertEquals(12, result);


    }
    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWithBlankSpace() {
        //given
        Booklet booklet = new Booklet("Aneboda [ 12 STR][12.09]Fsc mix Credit", "0,210x0,297");
        //when
        int result = booklet.setNumberOfPages(booklet.name);
        //then
        assertEquals(12, result);


    }
    @Test
    void hasBookletNameRightAmountOfPagesForSequenceWith6CharLength() {
        //given
        Booklet booklet = new Booklet("Aneboda [ 200 STR][12.09]Fsc mix Credit", "0,210x0,297");
        //when
        int result = booklet.setNumberOfPages(booklet.name);
        //then
        assertEquals(200, result);


    }
    @Test
    void hasBookletRightAmountOfPagesWithoutInfoInName() {
        //given
        Booklet booklet = new Booklet("Aneboda [12.09]Fsc mix Credit", "0,210x0,297");
        //when
        int result = booklet.setNumberOfPages(booklet.name);
        //then
        assertEquals(0, result);


    }
    @Test
    void hasBookletRightSurfaceArea() {
        //given
        Booklet booklet = new Booklet("Aneboda [12.09]Fsc mix Credit", "0.210x0.297");
        //when
        float result = booklet.setSurfaceArea(booklet.format);
        //then
        assertEquals(0.062369994819164276, result);

    }
    @Test
    void hasBookletRightSurfaceAreaWithDifferentNotationOfNumber() {
        //given
        Booklet booklet = new Booklet("Aneboda [12.09]Fsc mix Credit", "0,210 x 0,297 x 0,420");
        //when
        float result = booklet.setSurfaceArea(booklet.format);
        //then
        assertEquals(0.062369994819164276, result);

    }


}