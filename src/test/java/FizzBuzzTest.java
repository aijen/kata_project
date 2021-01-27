import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class FizzBuzzTest {

    @Test
    public void should_return_1_if_1_input() {

        // ARRANGE (A) - GIVEN
        int input = 1;

        // ACT (A) - WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // ASSERT (A) - THEN
        //assertEquals("1", result);
        assertThat(result).isEqualTo("1");

    }

    @Test
    public void should_return_2_if_2_input() {
        //public void shouldReturn2If2Input(){
        //public void return2If2Input(){

        // GIVEN
        int input = 2;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // THEN
        //assertEquals("2", result) ;
        assertThat(result ).isEqualTo("2");

    }

    @Test
    public void should_return_Fizz_if_3_input() {

        // GIVEN
        int input = 3;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // THEN
        //assertEquals("Fizz",result);
        assertThat(result ).isEqualTo("Fizz");

    }

    @Test
    public void should_return_4_if_4_input() {

        //  GIVEN
        int input = 4;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // THEN
        //assertEquals( "4",result);
        assertThat(result).isEqualTo("4");

    }

    @Test
    public void should_return_Buzz_if_5_input() {

        // GIVEN
        int input = 5;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // THEN
        //assertEquals("Buzz",result);
        assertThat(result).isEqualTo("Buzz");

    }

    @Test
    public void should_return_Fizz_if_6_input() {

        // GIVEN
        int input = 6;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // THEN
        //assertEquals("Fizz",result);
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void should_return_FizzBuzz_if_15_input() {

        // GIVEN
        int input = 15;

        // WHEN
        String result = FizzBuzz.fizzBuzz(input);

        // WHEN
        //assertEquals("FizzBuzz",result);
        assertThat(result).isEqualTo("FizzBuzz");
    }

}