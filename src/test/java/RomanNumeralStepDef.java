import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralStepDef {


    private int input;
    private String result;

    @Given("the input {int}")
    public void the_input(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        this.input = int1;
    }

    @When("we compute Roman Numeral")
    public void we_compute_roman_numeral() {
        // Write code here that turns the phrase above into concrete actions
        this.result = new RomanNumeral().computeRomanNumeral(this.input);
    }

    @Then("the roman numeral result is {string}")
    public void the_roman_numeral_result_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(this.result).isEqualTo(string);
    }


}
