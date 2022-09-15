package pl.kamis83.booklet.service;

import org.springframework.stereotype.Component;
import pl.kamis83.booklet.domain.ComplexBooklet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ComplexBookletFactory {

    static final Pattern grammagePattern = Pattern.compile("[\\d+]+[^\\sg/m2,]");
    int pageMiddleUnitCount = 40;
    int pageCoverCount = 4;
    double xDimension = 297;
    double yDimension = 420;
    String certificate = "FSC MIX CREDIT";


    public ComplexBooklet createComplexBookletFactory(String name, String format, String rawMaterials) {

        Matcher matcher = ComplexBookletFactory.grammagePattern.matcher(rawMaterials);
        List<Integer> grammages = lookForGrammagesInRawMaterials(matcher);
        int coverGrammage = grammages.get(0);
        int unitGrammage = grammages.get(1);


        return new ComplexBooklet(pageMiddleUnitCount, pageCoverCount, xDimension, yDimension,
                unitGrammage, coverGrammage, certificate);
    }

    public List<Integer> lookForGrammagesInRawMaterials(Matcher matcher) {
        return getIntegers(getSingleGrammageFromRawMaterials(matcher), getSingleGrammageFromRawMaterials(matcher));
    }

    public int getSingleGrammageFromRawMaterials(Matcher matcher) {
        int grammage = 0;
        if (matcher.find()) {
            grammage = Integer.parseInt(matcher.group(0));
        }
        return grammage;
    }

    private static List<Integer> getIntegers(int firstGrammage, int secondGrammage) {
        List<Integer> grammages = new ArrayList<>();
        if (firstGrammage == 0 || secondGrammage != 0 && firstGrammage > secondGrammage) {
            grammages.add(0, firstGrammage);
            grammages.add(1, secondGrammage);
        } else if ((secondGrammage == 0 || firstGrammage < secondGrammage)) {
            grammages.add(0, secondGrammage);
            grammages.add(1, firstGrammage);
        }
        return grammages;
    }
}
