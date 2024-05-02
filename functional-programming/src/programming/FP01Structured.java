package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 33, 557, 65, 34, 233, 12, 123, 4);
        printEvenNumbersInList(numbers);
//        printAllNumbersInList(numbers);
    }

    private static void printAllNumbersInList(List<Integer> numbers) {
        //How to loop the numbers?
        for(int number : numbers){
            System.out.println(number);
        }
    }
    private static void printEvenNumbersInList(List<Integer> numbers) {
        //How to loop the numbers?
        for(int number : numbers){
            if(number%2==0)
                System.out.println(number);
        }
    }
}
