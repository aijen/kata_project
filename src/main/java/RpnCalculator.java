import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RpnCalculator {

    public int rpnExpression(String input) {

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(input.split(" ")).forEach(c -> {
            if (Character.isDigit(c.charAt(0))) {
                numbers.add(Integer.parseInt(c));
            } else {
                Operation operation = findOperation(c);
                int calculate = operation.calculate(numbers);
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
            int calculate(ArrayDeque<Integer> numbers) {
                int firstNumber = numbers.removeLast();
                int secondNumber = numbers.removeLast();
                return secondNumber / firstNumber;
            }
        }, MULTIPLICATION {
            @Override
            int calculate(ArrayDeque<Integer> numbers) {
                int firstNumber = numbers.removeLast();
                int secondNumber = numbers.removeLast();
                return firstNumber * secondNumber;
            }
        }, SOUSTRACTION {
            @Override
            int calculate(ArrayDeque<Integer> numbers) {
                int firstNumber = numbers.removeLast();
                int secondNumber = numbers.removeLast();
                return secondNumber - firstNumber;
            }
        }, ADDITION {
            @Override
            int calculate(ArrayDeque<Integer> numbers) {
                int firstNumber = numbers.removeLast();
                int secondNumber = numbers.removeLast();
                return firstNumber + secondNumber;
            }
        },
        SQRT {
            @Override
            int calculate(ArrayDeque<Integer> numbers) {
                int firstNumber = numbers.removeLast();
                return (int) Math.sqrt(firstNumber);
            }
        },
        MAX {
            @Override
            int calculate(ArrayDeque<Integer> numbers) {
                int length = numbers.size();
                Integer[] list_number = new Integer[length];

                for (int i = 0; i < length; i++) {
                    list_number[i] = numbers.removeFirst();
                }return Collections.max(Arrays.asList(list_number));
            }
        };

        abstract int calculate(ArrayDeque<Integer> numbers);

    }
}

