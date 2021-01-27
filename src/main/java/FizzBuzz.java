public class FizzBuzz {

    public static void main(String ...args){

    }

    public static String fizzBuzz(int entier){
        if(isDivisibleBy3(entier) &&isDivisibleBy5(entier)){
            return  "FizzBuzz";
        }
        if(isDivisibleBy5(entier))
            return "Buzz";

        if(isDivisibleBy3(entier))
            return "Fizz";

         return String.valueOf(entier);
    }

    private static boolean isDivisibleBy3(int entier) {
        return entier%3==0;
    }
    private static boolean isDivisibleBy5(int entier){
        return entier%5==0;
    }
}
