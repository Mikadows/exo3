package fr.esgi.siwiorek.exo3;

import fr.esgi.siwiorek.exo3.core.calculator.services.CalculatorService;
import fr.esgi.siwiorek.exo3.infrastructure.input.FileReader;
import fr.esgi.siwiorek.exo3.infrastructure.output.OutputWriter;

public class Main {

    public static void main(String[] args) {
        var inputFile = args[0];
        var operation = args[1];

        var fileReader = new FileReader();
        var fileWriter = new OutputWriter();
        var calculatorService = new CalculatorService(fileReader, fileWriter);

        calculatorService.calculate(inputFile, operation);
    }
}
