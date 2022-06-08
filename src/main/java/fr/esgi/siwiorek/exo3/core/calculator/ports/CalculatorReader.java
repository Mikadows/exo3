package fr.esgi.siwiorek.exo3.core.calculator.ports;

import fr.esgi.siwiorek.exo3.core.calculator.models.numbers.Numbers;
import fr.esgi.siwiorek.exo3.core.calculator.services.exceptions.FailedToReadInputNumbers;

public interface CalculatorReader {
    Numbers readNumbers(String path) throws FailedToReadInputNumbers;
}
