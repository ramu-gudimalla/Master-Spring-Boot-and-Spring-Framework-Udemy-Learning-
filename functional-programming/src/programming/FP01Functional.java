package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 33, 557, 65, 34, 233, 12, 123, 4);
        printEvenNumbersInList(numbers);
        printSquareNumbersInList(numbers);
    }

//    private static void print(int number){
//        System.out.println(number);
//    }
    private static boolean isEven(int number){
        return number%2==0;
    }
    private static void printAllNumbersInList(List<Integer> numbers) {
        //What to do?
//        numbers.stream().forEach(FP01Functional::print); //Method reference
        numbers.stream().forEach(System.out::println);
    }
    private static void printEvenNumbersInList(List<Integer> numbers) {
        //What to do?
//        numbers.stream().forEach(FP01Functional::print); //Method reference
        numbers.stream()
                .filter(num -> num%2==0) //Lambda expression
                .forEach(System.out::println);
    }
    private static void printSquareNumbersInList(List<Integer> numbers) {
        //What to do?
//        numbers.stream().forEach(FP01Functional::print); //Method reference
        numbers.stream()
                .filter(num -> num%2==0) //Lambda expression
                .map(num -> num * num)
                .forEach(System.out::println);
    }
}
