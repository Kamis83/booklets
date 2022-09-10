package pl.kamis83.booklet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class Booklet {
    String name;
    String format;
    int numberOfPages;
    float surfaceArea;
    Map<Integer, String> number = new TreeMap<>();


    public Booklet(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public int setNumberOfPages(String name) {
        number = setMapOfPages();
        for (int i = 1; i <= number.size(); i++) {
            String phrase = number.get(4 * i);
            if (hasBookletNameInfoAboutNmberOfPages(name, phrase)) {
                changeTypeToInteger(phrase);
            }
        }
        return this.numberOfPages;
    }

    public float setSurfaceArea(String format) {
        String length;
        String width;
        String[] helpValue;
        helpValue = format.toLowerCase()
                .replaceAll(" ", "")
                .replaceAll(",", ".")
                .split("x");
        length = helpValue[0];
        width = helpValue[1];
        surfaceArea = Float.parseFloat(length) * Float.parseFloat(width);
        return this.surfaceArea;
    }

    private boolean hasBookletNameInfoAboutNmberOfPages(String name, String phrase) {
        return name.replaceAll(" ", "").contains(phrase);
    }

    private void changeTypeToInteger(String phrase) {
        if (phrase.length() == 5) cutSequenceForTwoDigitNumber(phrase);
        else if (phrase.length() == 6) cutSequenceForThreeDigitNumber(phrase);
    }

    private void cutSequenceForThreeDigitNumber(String phrase) {
        numberOfPages = Integer.parseInt(phrase.substring(0, 3));
    }

    private void cutSequenceForTwoDigitNumber(String phrase) {
        numberOfPages = Integer.parseInt(phrase.substring(0, 2));
    }

    private Map<Integer, String> setMapOfPages() {
        for (int i = 1; i < 100; i++) {
            int key = i * 4;
            String value = i * 4 + "STR";
            number.put(key, value);
        }
        return number;
    }
}

