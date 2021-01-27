import java.util.Arrays;

public class StringCalculator {


    public int add(String input) {

        throwExceptionIfinputNotValid(input);

        if (input.isEmpty() || input == null) {
            return 0;
        }

        return calculatSum(input);

    }

    private String[] extractNumbersAsStrings(String input) {
        if (isContainerDelimter(input)) {
            return extractInputByDelemiter(input);
        }
        return input.split(",|\n");
    }

    private void throwExceptionIfinputNotValid(String input) {
        if (!isContainerDelimter(input) && validateInput(input)) {
            if (containNegatifValues(input)) {
                exceptExceptionIfNegatifInput(input);
            }
            if (twoLastCarater(input).equals("\n")) {
                throw new BadInputException("Syntax Error");
            }
        }
    }

    private boolean containNegatifValues(String input) {
        return Arrays.stream(input.split(",|\n")).
                map(Integer::parseInt).
                filter(s -> s < 0).
                count() > 0;
    }

    private void exceptExceptionIfNegatifInput(String input) {
        String negatifValues = Arrays.stream(
                input.split(",")).
                map(Integer::parseInt).
                filter(s -> s < 0).
                map(String::valueOf).
                reduce("", (a, b) -> a = a + "," + b);
        throw new NegativeAllowException(
                negatifValues
        );
    }

    private boolean isContainerDelimter(String input) {
        return input.length() > 2 && isBeginBySlach(input);
    }

    private boolean validateInput(String input) {
        return input.length() > 1;
    }

    private Integer calculatSum(String array) {
        return Arrays.stream(extractNumbersAsStrings(array))
                .map(Integer::parseInt)
                .reduce(0, (a, b) -> a + b);
    }

    private String[] extractInputByDelemiter(String input) {
        return input.substring(4, input.length()).split(input.substring(2, 3));
    }

    private boolean isBeginBySlach(String input) {
        return input.substring(0, 2).equals("//");
    }

    protected String twoLastCarater(String input) {
        return input.substring(input.length() - 1, input.length());
    }


}
