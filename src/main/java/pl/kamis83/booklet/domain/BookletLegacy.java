package pl.kamis83.booklet.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public record BookletLegacy(String name, String format, double grammage) {
    private final static Pattern STR_PATTERN = Pattern.compile("(\\d+)\\s?STR");
    private final static Pattern FORMAT_PATTERN = Pattern.compile("[\\d,\\.]+");

    public float countSurfaceArea() {
        Matcher matcher = FORMAT_PATTERN.matcher(this.format);
        return matchDimension(matcher) * matchDimension(matcher);
    }

    private float matchDimension(Matcher matcher) {
        if (matcher.find()) {
            return Float.parseFloat(matcher.group(0).replace(',', '.'));
        } else {
            throw new RuntimeException();
        }
    }

    public int getNumberOfPages() {
        Matcher matcher = STR_PATTERN.matcher(this.name);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return 0;
        }
    }
}
