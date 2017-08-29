package ru.saydumarov.threads;

class Parser {
    private static final String[] DIGITS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] MAGNITUDES = {"hundred", "thousand"};


    static int toNum(String inline) throws Exception {
        inline = inline.toLowerCase().trim();
        return onThousandSplit(inline);
    }

    private static int onThousandSplit(String inline) throws Exception {
        int result = 0;

        if (inline.contains(MAGNITUDES[1])){
            String[] input = inline.split(MAGNITUDES[1]);
            if (input.length == 2 || input.length == 1){
                if (input[0].trim().split(" ").length == 1){
                    String temp = input[0].trim();
                    for(int k = 0; k < DIGITS.length; k++){
                        if (temp.equals(DIGITS[k])){
                            result += (k+1)*1000;
                        }
                    }
                    if (result < 1000) throw new Exception("Invalid expression. Try again");
                    if (input.length == 2){
                        result += onHundredSplit(input[1]);
                    }

                }
                else throw new Exception("Invalid expression. Try again");
            }
            else throw new Exception("Invalid expression. Try again");
        }

        else {
            result += onHundredSplit(inline);
        }

        return result;
    }

    private static int onHundredSplit(String inline) throws Exception {
        int result = 0;
//        input = input[0].split(MAGNITUDES[0]);

        if (inline.contains(MAGNITUDES[0])){
            String[] input = inline.split(MAGNITUDES[0]);
            if (input.length == 2 || input.length == 1){
                if (input[0].trim().split(" ").length == 1){
                    String temp = input[0].trim();
                    for(int k = 0; k < DIGITS.length; k++){
                        if (temp.equals(DIGITS[k])){
                            result += (k+1)*100;
                        }
                    }
                    if (result < 100) throw new Exception("Invalid expression. Try again");
                    if (input.length == 2){
                        result += onDozensSplit(input[1].trim().split(" "));
                    }
                }
                else throw new Exception("Invalid expression. Try again");
            }
            else throw new Exception("Invalid expression. Try again");
        }

        else{
            result += onDozensSplit(inline.trim().split(" "));
        }
        return result;
    }

    private static int onDozensSplit(String[] input) throws Exception{
        int result = 0;
        if (input.length == 1){
            for(int k = 0; k < DIGITS.length; k++){
                if (input[0].equals(DIGITS[k])){
                    result += k+1;
                }
                if (input[0].equals(TENS[k])){
                    result += (k+1)*10;
                }
                if (input[0].equals(TEENS[k])){
                    result += k+10;
                }
            }
        }
        if (input.length == 2){
            for(int k = 0; k < DIGITS.length; k++){
                if (input[0].equals(TENS[k])){
                    result += (k+1)*10;
                }
                if (input[1].equals(DIGITS[k])){
                    result += k+1;
                }
            }
            if (result < 10 || result%10 == 0) throw new Exception("Invalid expression. Try again");

        }
        if (input.length > 2) throw new Exception("Invalid expression. Try again");
        return result;
    }

}
