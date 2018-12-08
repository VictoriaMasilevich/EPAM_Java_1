package util.epam.first.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {

    private static final String DATA_DELIMITER = "\\s+";

    public List<Double> parseToDoubleArray(String line) {
        List<String> lineStringValues = parseToStringArray(line);
        List<Double> lineDoubleValues = new ArrayList<>();
        for (String element : lineStringValues) {
            lineDoubleValues.add(Double.parseDouble(element));
        }
        return lineDoubleValues;
    }

    public List<String> parseToStringArray(String line) {
        List<String> lineStringsValues = Arrays.asList(line.trim().split(DATA_DELIMITER));
        return lineStringsValues;
    }
}
