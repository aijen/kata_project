import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class RpnCalculator {

    public int rpnExpression(String input) {

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(input.split(" ")).forEach(c -> {
            if (Character.isDigit(c.charAt(0))) {
                numbers.add(Integer.parseInt(c));
            } else {
                Operation operation = findOperation(c);
                int firstNumber = 0;
                if (!operation.equals(Operation.SQRT))
                    firstNumber = numbers.removeLast();
                int secondNumber = numbers.removeLast();
                int calculate = operation.calculate(secondNumber, firstNumber);
                numbers.add(calculate);
            }
        });
        return numbers.getLast();
    }

    private Operation findOperation(String operator) {
        if (operator.equals("+")) {
            return Operation.ADDITION;
        }
        if (operator.equals("*")) {
            return Operation.MULTIPLICATION;
        }
        if (operator.equals("-")) {
            return Operation.SOUSTRACTION;
        }
        if (operator.equals("SQRT")) {
            return Operation.SQRT;
        }
        if (operator.equals("MAX"))
            return Operation.MAX;
        return Operation.DIVISTION;
    }

    enum Operation {
        DIVISTION {
            @Override
            int calculate(Integer... numbers) {
                return numbers[0] / numbers[1];
            }
        }, MULTIPLICATION {
            @Override
            int calculate(Integer... numbers) {
                return numbers[0] * numbers[1];
            }
        }, SOUSTRACTION {
            @Override
            int calculate(Integer... numbers) {
                return numbers[0] - numbers[1];
            }
        }, ADDITION {
            @Override
            int calculate(Integer... numbers) {
                return numbers[0] + numbers[1];
            }
        },
        SQRT {
            @Override
            int calculate(Integer... numbers) {
                return (int) Math.sqrt(numbers[0]);
            }
        },
        MAX {
            @Override
            int calculate(Integer... numbers) {
                return Arrays.stream(numbers)
                        .max(Integer::compare)
                        .get();
            }
        };

        abstract int calculate(Integer... numbers);

    }
}

