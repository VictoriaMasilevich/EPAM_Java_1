package edu.epam.first.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DataValidator {
    private static final Logger logger = LogManager.getLogger();

    private static final String REGEX_DIGIT = "\\d";
    private static final String REGEX_EXP = "[eE][+-]?" + REGEX_DIGIT;
    private static final String REGEX_DOUBLE = "[-+]?" + REGEX_DIGIT + "*\\.?" + REGEX_DIGIT +
            "+(" + REGEX_EXP + "+)?[fFdD]?";
    private static final int QUADRANGLE_POINTS_COUNT = 8;

    private static boolean isValidDouble(String value) {
        return value.matches(REGEX_DOUBLE);
    }

    public static boolean isValidPointsCount(List<String> values) {
        return (values.size() == QUADRANGLE_POINTS_COUNT);
    }

    public static boolean isValidDoubleData(List<String> values) {
        boolean isValid = true;
        for (String value : values) {
            if (!isValidDouble(value)) {
                isValid = false;
                logger.error("Incorrect value: " + value);
            }
        }
        return isValid;
    }
}
