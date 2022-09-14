package pl.kamis83.booklet.service;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class ComplexBookletFactoryTest {

    @Test
    void getGrammage() {
        //given
      ComplexBookletFactory complexBookletFactory = new ComplexBookletFactory();
        String rawMaterials = "kreda mat 80g/m";
        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        //when
        int result = complexBookletFactory.getGrammages(matcher);
        //Then

        assertEquals(80,result);

    }
    @Test
    void getGrammages() {
        //given
        ComplexBookletFactory complexBookletFactory = new ComplexBookletFactory();
        String rawMaterials = "kreda mat 80g/m, kreda 90 g/m";
        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        //when
        int firstGrammage = complexBookletFactory.getGrammages(matcher);
        int secondGrammage = complexBookletFactory.getGrammages(matcher);
        //Then

        assertEquals(80,firstGrammage);
        assertEquals(90,secondGrammage);

    }
}