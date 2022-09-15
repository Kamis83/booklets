package pl.kamis83.booklet.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class ComplexBookletFactoryTest {

    @Test
    void getOneGrammage() {
        //given
      ComplexBookletFactory complexBookletFactory = new ComplexBookletFactory();
        String rawMaterials = "kreda mat 80g/m";
        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        //when
        int result = complexBookletFactory.getSingleGrammageFromRawMaterials(matcher);
        //Then

        assertEquals(80,result);

    }
    @Test
    void getTwoGrammages() {
        //given
        ComplexBookletFactory complexBookletFactory = new ComplexBookletFactory();
        String rawMaterials = "Kreda mat 170 g/m2, Kreda mat 90 g/m2";
        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        //when
        int firstGrammage = complexBookletFactory.getSingleGrammageFromRawMaterials(matcher);
        int secondGrammage = complexBookletFactory.getSingleGrammageFromRawMaterials(matcher);
        //Then

        assertEquals(170,firstGrammage);
        assertEquals(90,secondGrammage);

    }

    @Test
    void findGrammage() {

        //given
        ComplexBookletFactory complexBookletFactory = new ComplexBookletFactory();
        String rawMaterials = "Kreda mat g/m2, Kreda mat 80 g/m2";
        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);

        //when
        List<Integer> grammages = complexBookletFactory.lookForGrammagesInRawMaterials(matcher);
        int coverGrammage = grammages.get(0);
        int unitGrammage = grammages.get(1);


        //then
        assertEquals(0,coverGrammage);
        assertEquals(80,unitGrammage);





    }
}