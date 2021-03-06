
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {

    @Test
    public void should_return_0_if_empty_input(){
        //GIVEN
        String input ="";

        //WHEN
        int result =new StringCalculator().add(input);

        //THEN
        assertThat(result).isEqualTo(0);

    }

    @Test

    public void should_return_1_if_1_input(){
        //GIVEN
        String intput = "1";

        //WHEN
        int result = new StringCalculator().add(intput);

        //THEN
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_3_if_1_2_input(){
        //GIVEN
        String input ="1,2";

        //WHEN
        int result = new StringCalculator().add(input);

        //THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_21_if_1_2_3_4_5_6_input(){
        //GIVEN
        String input="1,2,3,4,5,6";

        //WHEN
        int result = new StringCalculator().add(input);

        //THEN
        assertThat(result).isEqualTo(21);
    }

    @Test

    public void should_return_6_if_1_n2_3_input(){
        //GIVEN
        String input ="1\n2,3";

        //WHEN
        int result = new StringCalculator().add(input);

        //THEN
        assertThat(result).isEqualTo(6);
    }

    @Test

    public void should_throw_exception_if_1_n_input(){
        //GIVEN
        String input ="1,\n";

        //WHEN AND THEN
        assertThatThrownBy(() -> new StringCalculator().add(input))
                .isInstanceOf(BadInputException.class);

    }

    @Test

    public void should_return_3_if__n1_2_input(){
        //GIVEN
        String input ="//;\n1;2";

        //WHEN
        int result = new StringCalculator().add(input);

        //ASSERT
        assertThat(result).isEqualTo(3);
    }

    @Test

    public void should_return_negative_not_allowd_if__1_2_input(){
        //GIVEN
        String input ="-1,2";


        //ASSERT
        assertThatThrownBy(()->new StringCalculator().add(input))
                .isInstanceOf(NegativeAllowException.class);
    }

}