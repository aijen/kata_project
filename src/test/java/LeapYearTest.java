
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LeapYearTest {

    @Test
    public void should_return_false_if_2001_input(){
        //GIVEN
        int input =2001;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        // THEN
        assertThat(compute).isFalse();

    }

    @Test
    public void should_return_true_if_1996_input(){
        //GIVEN
        int input = 1996;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        // THEN
        assertThat(compute).isTrue();
    }

    @Test
    public void should_return_true_if_1992_input(){
        //GIVEN
        int input =1992;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        // THEN
        assertThat(compute).isTrue();

    }

    @Test
    public void should_return_false_if_1900_input(){
        //GIVEN
        int input = 1900;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        //THEN
        assertThat(compute ).isFalse();
    }

    @Test
    public void should_return_true_if_2000_input(){
        //GIVEN
        int input = 2000;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        //THEN
        assertThat(compute).isTrue();

    }

    @Test
    public void should_return_false_if_1800_input(){
        //GIVEN
        int input = 1800;

        //WHEN
        boolean compute = new LeapYear().compute(input);

        //THEN
        assertThat(compute);
    }
}