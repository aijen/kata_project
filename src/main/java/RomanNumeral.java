public class RomanNumeral {
    public String computeRomanNumeral(int input) {
        if(input>3000)
            return "The Romans themselves didn't tend to go any higher";
        switch (input){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "VIIII";
            case 10: return "X";
            default: return "";
        }
    }
}
