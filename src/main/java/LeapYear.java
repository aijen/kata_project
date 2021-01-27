public class LeapYear {

    public boolean compute(int input) {

        return  isDivisibleBy4(input) && !isDivisibleBy100(input) || isDivisibleBy400(input);
    }

    private boolean isDivisibleBy400(int input) {
        return input%400==0;
    }

    private boolean isDivisibleBy100(int input) {
        return input%100==0;
    }

    public boolean isDivisibleBy4(int input){
        return input%4==0;
    }




}
