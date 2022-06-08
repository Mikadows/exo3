package fr.esgi.siwiorek.exo3.infrastructure.input;

import fr.esgi.siwiorek.exo3.core.calculator.models.numbers.Number;
import fr.esgi.siwiorek.exo3.core.calculator.models.numbers.Numbers;
import fr.esgi.siwiorek.exo3.core.calculator.ports.CalculatorReader;
import fr.esgi.siwiorek.exo3.core.calculator.services.exceptions.FailedToReadInputNumbers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader implements CalculatorReader {

    @Override
    public Numbers readNumbers(String path) throws FailedToReadInputNumbers {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            return new Numbers(lines.stream()
                    .map(Integer::valueOf)
                    .map(Number::new)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            throw new FailedToReadInputNumbers(e.getMessage());
        }
    }
}


