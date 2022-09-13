package pl.kamis83.booklet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kamis83.booklet.domain.Booklet;

import static org.junit.jupiter.api.Assertions.*;

class BookletFactoryTest {

    @Autowired


    @Test
    void isBookletCorrectCreated() {
        //given
        BookletFactory booklet = new BookletFactory();

        //when
        Booklet result = booklet.createBooklet("SomeProduct AA-987231-12[28 str][09.22] Fsc Mix Credit",
                "210x297x2,22", 55);
        //then

        assertEquals("Booklet[pageCount=28, xDimension=210.0, yDimension=297.0, grammage=55, certificate=FSC MIX CREDIT]", result.toString());
    }
    @Test
    void isBookletCorrectCreatedWithDifferentNameAndFormat() {
        //given
        BookletFactory booklet = new BookletFactory();

        //when
        Booklet result = booklet.createBooklet("SomeProduct AA-987231-12[28 str][09.22] Fsc Recycled Credit",
                "210 x 297.0 x 2,22", 55);
        //then

        assertEquals("Booklet[pageCount=28, xDimension=210.0, yDimension=297.0, " +
                "grammage=55, certificate=FSC RECYCLED CREDIT]", result.toString());


    }
}