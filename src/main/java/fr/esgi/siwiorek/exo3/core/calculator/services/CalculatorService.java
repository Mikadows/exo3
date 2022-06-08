package fr.esgi.siwiorek.exo3.core.calculator.services;

import fr.esgi.siwiorek.exo3.core.calculator.models.Calculator;
import fr.esgi.siwiorek.exo3.core.calculator.models.Operator;
import fr.esgi.siwiorek.exo3.core.calculator.ports.CalculatorReader;
import fr.esgi.siwiorek.exo3.core.calculator.ports.CalculatorWriter;
import fr.esgi.siwiorek.exo3.core.calculator.services.exceptions.FailedToReadInputNumbers;

public class CalculatorService {
    private final CalculatorReader reader;
    private final CalculatorWriter writer;

    public CalculatorService(CalculatorReader reader, CalculatorWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void calculate(String inputFile, String operation) {
        try {
            var numbers = reader.readNumbers(inputFile);
            var operator = getOperator(operation);
            var calculator = new Calculator(operator, numbers);

            writer.write(calculator.compute().toString());
        } catch (FailedToReadInputNumbers e) {
            writer.log(e.getMessage());
        }
    }

    private Operator getOperator(String operation) {
        switch (operation) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
    }
}
