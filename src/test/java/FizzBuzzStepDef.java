import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzStepDef {

    private int number;
    private String result;

    @Given("the number {int}")
    public void the_number(int number) {
        this.number = number;
    }

    @When("we compute FizzBuzz")
    public void we_compute_fizz_buzz() {
        result = FizzBuzz.fizzBuzz(number);
    }

    @Then("the result is {string}")
    public void the_result_is(String expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }

}
