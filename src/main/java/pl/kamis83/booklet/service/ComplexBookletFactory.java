package pl.kamis83.booklet.service;

import org.springframework.stereotype.Component;
import pl.kamis83.booklet.domain.ComplexBooklet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ComplexBookletFactory {

    static final Pattern grammagePattern = Pattern.compile("[\\d+]+");
    int pageMiddleUnitCount = 40;
    int pageCoverCount = 4;
    double xDimension = 297;
    double yDimension = 420;
    String certificate = "FSC MIX CREDIT";




    public ComplexBooklet complexBookletFactory(String name, String format, String rawMaterials) {

        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        int unitGrammage = getGrammages(matcher);
        int coverGrammage = getGrammages(matcher);
        if (unitGrammage > coverGrammage) {
            int temporaryCoverGrammage = unitGrammage;
            unitGrammage = coverGrammage;
            coverGrammage = temporaryCoverGrammage;
        }

        return new ComplexBooklet (pageMiddleUnitCount, pageCoverCount, xDimension, yDimension,
                unitGrammage, coverGrammage, certificate);
    }

    public  int getGrammages(Matcher matcher) {
        int grammage = 0;
        if (matcher.find()) {
            grammage = Integer.parseInt(matcher.group(0));


        }return grammage;
    }
}
