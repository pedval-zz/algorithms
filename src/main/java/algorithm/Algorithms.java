package algorithm;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by valenciap on 15/08/2015.
 */
public class Algorithms {

    private static final String SEPARATOR = "\\s";

    public static void main(String[] args) {
        Algorithms algorithms = new Algorithms();
        algorithms.runExercises();
    }

    public void runExercises() {
        //exercise1();
        //exercise2();
        //exercise3();
        //exercise4();
        //exercise5();
        //exercise6();
        //exercise7();
        //exercise8();
        //exercise9();
        //exercise10();
        //exercise11();
        //exercise12();
    }

    private void exercise1() {

        List<Integer> numbers = Arrays.asList(3, 5, 2, 7, 12, 1, 9, 6, 4);
        Integer maxNumber = Integer.MIN_VALUE;
        for(Integer number: numbers) {
            if(number % 2 != 0) {
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }

        System.out.println("Max odd number: " + maxNumber);
    }

    private void exercise2() {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        String words = in.nextLine();
        String[] splited = words.split(SEPARATOR);
        Long result = 0L;
        for(int i = 0; i < length; i++) {
            result += Long.parseLong(splited[i]);
        }
        System.out.println(result);

    }

    private void exercise3() {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        int sum_diagonal1 = 0;
        int sum_diagonal2 = 0;
        for(int i = 0; i < length; i++) {
            String line= in.nextLine();
            String[] numbers_in_line = line.split(SEPARATOR);
            sum_diagonal1 += Integer.parseInt(numbers_in_line[i]);
            sum_diagonal2 += Integer.parseInt(numbers_in_line[length-1-i]);
        }
        System.out.println(Math.abs(sum_diagonal1 - sum_diagonal2));
    }

    private void exercise4() {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        int num_positives = 0;
        int num_negatives = 0;
        int num_zeroes = 0;
        String line= in.nextLine();
        String[] numbers_in_line = line.split(SEPARATOR);

        for(int i = 0; i < length; i++) {
            if(Integer.parseInt(numbers_in_line[i]) == 0) {
                num_zeroes++;
            } else if (Integer.parseInt(numbers_in_line[i]) > 0) {
                num_positives++;
            } else {
                num_negatives++;
            }
        }
        System.out.println(new Double(num_positives)/length);
        System.out.println(new Double (num_negatives)/length);
        System.out.println(new Double(num_zeroes)/length);
    }

    private void exercise5() {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        for(int i = 0; i < height;i++) {
            for(int j = 0; j < height; j++) {
                if(j >= height-1 - i) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }


    }

    private void exercise6() {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 4, 7, 6, 7, 2);
        HashMap<Integer, Boolean> number_repeated = new HashMap<>();
        for(Integer number: numbers) {
            if(number_repeated.containsKey(number)) {
                number_repeated.put(number, true);
            } else {
                number_repeated.put(number,false);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Boolean> entry: number_repeated.entrySet()) {
            if(!entry.getValue() && max < entry.getKey()) {
                max = entry.getKey();
            }
        }

        System.out.println("Max not repeated: "+ max);
    }

    private void exercise7() {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] time_parts = line.split(":");
        String hours = time_parts[0];
        String minutes = time_parts[1];
        String seconds = time_parts[time_parts.length-1].replaceAll("[^\\d.]", "");
        String rangeOfDay = time_parts[time_parts.length-1].subSequence(seconds.length(), time_parts[time_parts.length-1].length()).toString();
        if("PM".equals(rangeOfDay)) {
            if(!"12".equals(hours)) {
                hours = String.valueOf(Integer.parseInt(hours) + 12);
            }
            //seconds = seconds.replace("PM","");
        } else if("AM".equals(rangeOfDay)) {
            if("12".equals(hours)) {
                hours = "00";
            }
        }
        System.out.println(hours+":"+minutes+":"+seconds);

    }

    private void exercise8() {
        Scanner in = new Scanner(System.in);
        String actual_date = in.nextLine();
        String[] actual_date_el = actual_date.split(SEPARATOR);
        String expected_date = in.nextLine();
        String[] expected_date_el = expected_date.split(SEPARATOR);
        int toPay = 0;
        int actualYear = Integer.parseInt(actual_date_el[2]);
        int expectedYear = Integer.parseInt(expected_date_el[2]);
        int actualMonth = Integer.parseInt(actual_date_el[1]);
        int expectedMonth = Integer.parseInt(expected_date_el[1]);
        int actualDay = Integer.parseInt(actual_date_el[0]);
        int expectedDay = Integer.parseInt(expected_date_el[0]);
        if(actualYear > expectedYear) {
            toPay = 10000*(actualYear - expectedYear);
        } else if((actualYear == expectedYear) && (actualMonth > expectedMonth)) {
            toPay = 500*(actualMonth-expectedMonth);
        } else if((actualYear == expectedYear) &&
                (actualMonth == expectedMonth) &&
                actualDay > expectedDay) {
            toPay = 15*(actualDay - expectedDay);
        }
        System.out.println(toPay);
    }

    private void exercise9() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        BigInteger result = BigInteger.ONE;
        for(int i = number; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

    private void exercise10() {
        String input = "from";
        String target = "form";

        char[] target_array = target.toCharArray();
        char[] input_array = input.toCharArray();

        String result = "IMPOSSIBLE";
        if(input.equals(target)) {
            result = "NOTHING";
        } else if(target.length() - input.length() == 1) {
            result = insert(input_array, target_array, true);
        } else if(input.length() - target.length() == 1) {
           result = insert(target_array, input_array, false);
        } else if(target.length() == input.length()) {
            result = swap(input_array, target_array);
        }

        System.out.println(result);


    }

    private String swap(char[] input_array, char[]  target_array) {

        boolean equals = true;
        boolean needSwap = true;
        char first_char = '\0';
        char second_char = '\0';
        for(int i=0; i < target_array.length; i++) {
            if(equals && input_array[i] == target_array[i+1] && input_array[i+1] == target_array[i]) {
                equals = false;
                first_char = input_array[i];
                second_char = input_array[i+1];
                i++;
            } else if(!equals && input_array[i] != target_array[i]) {
                needSwap = false;
            }
        }

        if(needSwap) {
            return "SWAP "+first_char+" "+second_char;
        }

        return "IMPOSSIBLE";
    }

    private String insert(char[] input_array, char[]  target_array, boolean isInsert) {

        boolean equals = true;
        boolean needInsert = true;
        char toInsertOrDelete = '\0';

        for(int i=0; i < target_array.length; i++) {
            if(equals && input_array[i] != target_array[i]) {
                equals = false;
                toInsertOrDelete = target_array[i];
            } else if(!equals && input_array[i-1] != target_array[i]) {
                needInsert = false;
            }
        }
        if(needInsert) {
           if(isInsert) {
               return "INSERT "+toInsertOrDelete;
           } else {
               return "DELETE "+toInsertOrDelete;
           }
        } else {
            return "IMPOSSIBLE";
        }


    }


    private void exercise11() {
        int A = 0;
        int B = 20;

        int howManyWholeSquares = 0;
        for(int i = A; i <= B; i++) {
            if(isPerfectSquare(Math.abs(i))) {
                howManyWholeSquares++;;
            }
        }
        System.out.println(howManyWholeSquares);
    }


    public final boolean isPerfectSquare(int input)
    {
        if (input < 0) {
            return false;
        }
        switch(input & 0xF) {

            case 0:
            case 1:
            case 4:
            case 9:
            long root = (long) Math.sqrt(input);
            return (root*root == input);

            default:
                return false;
        }
    }

    private void exercise12() {
        System.out.println(binomial(40,20));
    }

    private int binomial(int N, int K) {


        if(N < 0 || N-K <= 0) {
            return -1;
        }

        int dividend = N;
        int divisor_first = K;
        int divisor_second = N-K;

        BigInteger dividend_factorial = BigInteger.valueOf(0);
        BigInteger divisor_first_factorial = BigInteger.valueOf(0);
        BigInteger divisor_second_factorial = BigInteger.valueOf(0);

        BigInteger result = BigInteger.valueOf(1);

        for(int i = 1; i <= dividend; i++) {

            result = result.multiply(BigInteger.valueOf(i));
            if(i == dividend) {
                dividend_factorial = result;
            }
            if(i == divisor_first) {
                divisor_first_factorial  = result;
            }
            if(i == divisor_second) {
                divisor_second_factorial = result;
            }
        }


        BigInteger binomial = dividend_factorial.divide(divisor_first_factorial.multiply(divisor_second_factorial));
        if(binomial.compareTo(BigInteger.valueOf(1000000)) > 0) {
            return -1;
        }
        return binomial.intValue();


    }
}
