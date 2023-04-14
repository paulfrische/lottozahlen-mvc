package xyz.paulfrische.lottozahlen.util;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {
    public static List<Short> parseNumbers(String arg) {
        List<Short> numbers = new ArrayList<>();
        String[] badNumbersString =  arg.split(",");
        for (String num : badNumbersString) {
            numbers.add(Short.parseShort(num));
        }
        return numbers;
    }
}
