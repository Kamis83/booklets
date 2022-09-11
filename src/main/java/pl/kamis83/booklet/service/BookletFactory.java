package pl.kamis83.booklet.service;
import org.springframework.stereotype.Component;
import pl.kamis83.booklet.domain.Booklet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookletFactory {

    public Booklet createBooklet(String name, String format, int grammage) {
        Pattern strPattern = Pattern.compile("(\\d+)\\s?STR");
        Pattern formatPattern = Pattern.compile("[\\d,\\.]+");
        Matcher matcher = formatPattern.matcher(format);
        int pageCount = getPageCount(name, strPattern);
        double xDimension = getDimension(matcher);
        double yDimension = getDimension(matcher);
        return new Booklet(pageCount, xDimension, yDimension, grammage);
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

    private static int getPageCount(String name, Pattern strPattern) {
        int pageCount;
        Matcher matcher = strPattern.matcher(name.toUpperCase());
        if (matcher.find()) {
            pageCount = Integer.parseInt(matcher.group(1));
        } else {
            pageCount = 0;

        }
        return pageCount;
    }
}
