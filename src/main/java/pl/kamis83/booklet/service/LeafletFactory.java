package pl.kamis83.booklet.service;

import org.springframework.stereotype.Component;
import pl.kamis83.booklet.domain.Leaflet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LeafletFactory {
    public Leaflet createLeaflet(String name, String format, int grammage) {

        Pattern formatPattern = Pattern.compile("[\\d,\\.]+");
        Pattern fscPattern = Pattern.compile("FSC\\s?\\D+\\s?\\D+");
        Matcher matcher = formatPattern.matcher(format);
        String certificate = getCertificate(name, fscPattern);
        double xDimension = getDimension(matcher);
        double yDimension = getDimension(matcher);

        return new Leaflet(xDimension, yDimension, grammage,certificate);
    }

    private static String getCertificate(String name, Pattern fscPattern) {

        String certificate;
        Matcher matcher = fscPattern.matcher(name.toUpperCase());
        if (matcher.find()) {
            certificate = matcher.group(0);
        } else {
            certificate = null;
            System.out.println(" There is no certyfikate");
        }
        return certificate;
    }


    private static double getDimension(Matcher matcher) {
        double xDimension;
        if (matcher.find()) {
            xDimension = Double.parseDouble(matcher.group(0).replace(',', '.'));
        } else {
            throw new RuntimeException();
        }
        return xDimension;
    }
}
