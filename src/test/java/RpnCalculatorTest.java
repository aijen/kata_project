import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@Disabled
class RpnCalculatorTest {

    @Test
    public void should_return_1_if_1_input(){
        //GIVEN
        String input = "1";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //THEN
        assertThat(result).isEqualTo(1);

    }

    @Test
    public void should_return_3_if_1_2_plus_input(){
        //GIVEN
        String input = "1 2 +";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_4_if_1_3_plus_input(){
        //GIVEN
        String input = "1 3 +";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void should_return_4_if_20_5_divid_input(){
        //GIVEN
        String input = "20 5 /";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void should_throw_arithemtique_exception_if_20_0_divid_input(){
        //GIVEN
        String input = "20 0 /";

        //WHEN and ASSERT
        assertThatThrownBy(() -> new RpnCalculator().rpnExpression(input))
                .isInstanceOf(ArithmeticException.class);

    }

    @Test
    public void should_return_3_if_4_2_plus_3_minus_input(){
        //GIVEN
        String input = "4 2 + 3 -";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_36_if_10_4_multipe_4_minus_input(){
        //GIVEN
        String input = "10 4 * 4 -";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(36);
    }

    @Test
    public void should_return_141_if_3_5_8_multiple_7_plus_multiple_input(){
        //GIVEN
        String input = "3 5 8 * 7 + *";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(141);

    }

    @Test
    public void should_return_30_if_2_5_9_plus_multiple_3_1_minus_plus_input(){
        //GIVEN
        String input = "2 5 9 + * 3 1 - +";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void should_return_input_exception_if_multiple_input(){
        //GIVEN
        String input = "*";

        //WHEN and ASSERT
        assertThatThrownBy(()->new RpnCalculator().rpnExpression(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void should_throw_exception_2_if_2_divid_input(){
        //GIVEN
        String input ="2 /";

        //WHEN and ASSERT
        assertThatThrownBy(()->new RpnCalculator().rpnExpression(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void should_throw_exception_3_if_3_plus_input(){
        //GIVEN
        String input ="3 +";

        //WHEN and ASSERT
        assertThatThrownBy(()->new RpnCalculator().rpnExpression(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void should_return_2_if_4_sqrt_input(){
        //GIVEN
        String input ="4 SQRT";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_12_if_12_5_7_plus_sqrt_input(){
        //GIVEN
        String input ="12 5 7 + * SQRT";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void should_return_8_if_5_8_1_4_2_MAX_input(){
        //GIVEN
        String input ="5 8 1 4 2 MAX";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void should_return_5_if_5_MAX_input(){
        //GIVEN
        String input ="5 MAX";

        //WHEN
        int result = new RpnCalculator().rpnExpression(input);

        //ASSERT
        assertThat(result).isEqualTo(5);
    }



}