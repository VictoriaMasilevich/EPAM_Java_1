package util.epam.first.filter;

import util.epam.first.parser.DataParser;
import util.epam.first.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataFilter {
    private static final Logger logger = LogManager.getLogger();

    public List<String> filterData(List<String> inputData) {
        DataParser parser = new DataParser();
        List<String> validData = new ArrayList<>();
        for (String line : inputData) {
            List<String> currentLine = parser.parseToStringArray(line);
            if (DataValidator.isValidPointsCount(currentLine)) {
                if (DataValidator.isValidDoubleData(currentLine)) {
                    validData.add(line);
                } else {
                    logger.error("Line " + line + " include incorrect values");
                }
            } else {
                logger.error("Arguments count is invalid in line: " + line);
            }
        }
        return validData;
    }

}
