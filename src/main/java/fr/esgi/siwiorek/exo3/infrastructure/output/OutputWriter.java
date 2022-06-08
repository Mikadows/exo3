package fr.esgi.siwiorek.exo3.infrastructure.output;

import fr.esgi.siwiorek.exo3.core.calculator.ports.CalculatorWriter;

public class OutputWriter implements CalculatorWriter {
    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void log(String message) {
        System.out.printf("[%s:%s][log] %s%n", "", "", message);
    }
}
