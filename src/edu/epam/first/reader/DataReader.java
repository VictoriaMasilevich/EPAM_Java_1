package edu.epam.first.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static final Logger logger = LogManager.getLogger();

    public static List<String> readData(String filePath) throws RuntimeException {
        List<String> lines;
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            logger.fatal("File not found: " + filePath);
            throw new RuntimeException("File not found.");
        }
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal("Error file opening: " + filePath, e);
            throw new RuntimeException("Error file opening ", e);
        }
        return lines;
    }
}
