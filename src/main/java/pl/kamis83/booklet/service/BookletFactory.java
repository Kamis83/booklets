package pl.kamis83.booklet.service;

import org.springframework.stereotype.Component;
import pl.kamis83.booklet.domain.Booklet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookletFactory {

    private static final Pattern STR_PATTERN = Pattern.compile("(\\d+)\\s?STR");
    private static final Pattern FORMAT_PATTERN = Pattern.compile("[\\d,\\.]+");
    private static final Pattern FSC_PATTERN = Pattern.compile("FSC\\s?\\D+\\s?\\D+");

    public Booklet createBooklet(String name, String format, int grammage) {

        String certificate = getCertificate(name);
        int pageCount = getPageCount(name);
        Matcher matcher = FORMAT_PATTERN.matcher(format);
        double xDimension = getDimension(matcher);
        double yDimension = getDimension(matcher);
        return new Booklet(pageCount, xDimension, yDimension, grammage, certificate);
    }

    private static String getCertificate(String name) {

        String certificate;
        Matcher matcher = BookletFactory.FSC_PATTERN.matcher(name.toUpperCase());
        if (matcher.find()) {
            certificate = matcher.group(0);
        } else {
            certificate = null;
            System.out.println(" There is no certificate");
        }
        return certificate;
    }


    private static double getDimension(Matcher matcher) {
        double dimension;
        if (matcher.find()) {
            dimension = Double.parseDouble(matcher.group(0).replace(',', '.'));
        } else {
            throw new RuntimeException();
        }
        return dimension;
    }

    private static int getPageCount(String name) {
        int pageCount;
        Matcher matcher = BookletFactory.STR_PATTERN.matcher(name.toUpperCase());
        if (matcher.find()) {
            pageCount = Integer.parseInt(matcher.group(1));
        } else {
            pageCount = 0;

        }
        return pageCount;
    }
}
