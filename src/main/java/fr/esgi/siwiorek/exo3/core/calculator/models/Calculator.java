package fr.esgi.siwiorek.exo3.core.calculator.models;

import fr.esgi.siwiorek.exo3.core.calculator.models.numbers.Number;
import fr.esgi.siwiorek.exo3.core.calculator.models.numbers.Numbers;

public record Calculator(Operator operator, Numbers numbers) {

    public Integer compute() {
        var integerStream = numbers.numbers().stream()
                .map(Number::number);
        return switch (operator) {
            case ADD -> integerStream
                    .reduce(0, Integer::sum);
            case SUBTRACT -> integerStream
                    .reduce(0, (a, b) -> a - b);
            case MULTIPLY ->
                    integerStream.reduce(1, (a, b) -> a * b);
        };
    }

}
