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

                short numberSize = (short) numbers.size();

                short numberOfOperands = operation.getNumbersOfOperands(numberSize);
                Integer[] operands = new Integer[numberOfOperands];

                for (int i = 0; i < numberOfOperands; i++) {
                    Integer operand = numbers.removeFirst();
                    operands[i] = operand;
                }
                int operationResult = operation.calculate(operands);

                numbers.add(operationResult);
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
            int calculate(Integer ... numbers) {
                int firstNumber = numbers[0].intValue();
                int secondNumber = numbers[1].intValue();
                return firstNumber / secondNumber;
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return 2;
            }
        }, MULTIPLICATION {
            @Override
            int calculate(Integer ... numbers) {
                return numbers[1] * numbers[0];
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return 2;
            }
        }, SOUSTRACTION {
            @Override
            int calculate(Integer ... numbers) {

                return numbers[0] - numbers[1];
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return 2;
            }
        }, ADDITION {
            @Override
            int calculate(Integer ... numbers) {

                return numbers[0] + numbers[1];
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return 2;
            }
        },
        SQRT {
            @Override
            int calculate(Integer ... numbers) {
                return (int) Math.sqrt(numbers[0]);
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return 1;
            }
        },
        MAX {
            @Override
            int calculate(Integer ... numbers) {
               /*/*int length = numbers.length();
                Integer[] list_number = new Integer[length];

                for (int i = 0; i < length; i++) {
                    list_number[i] = numbers.removeFirst();
                }*/
                return Collections.max(Arrays.asList(numbers));
            }

            @Override
            public short getNumbersOfOperands(short length) {
                return length;
            }
        };

        abstract int calculate(Integer... numbers);

        public abstract short getNumbersOfOperands(short length);
    }
}

