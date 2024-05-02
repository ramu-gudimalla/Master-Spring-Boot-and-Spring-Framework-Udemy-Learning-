package programming;

import java.util.List;

public class FP01FunctionalExercise {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 33, 557, 65, 34, 233, 12, 123, 4);
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        printAllCoursesIndividually(courses);
        printOddNumbersInList(numbers);
        findWordInCourses(courses,"Spring");
        coursesWithMoreThanLength(courses,4);
        printCubeOfOddNumbers(numbers);
        printNumberOfCharactersInEachCourse(courses);
    }

    private static void printNumberOfCharactersInEachCourse(List<String> courses) {
        courses.stream().map(String::length).forEach(System.out::println);
    }

    private static void printCubeOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num%2 != 0)
                .map(num -> num * num * num)
                .forEach(System.out::println);
    }

    private static void coursesWithMoreThanLength(List<String> courses, int i) {
        courses.stream().filter(str -> str.length()>4).forEach(System.out::println);
    }

    private static void findWordInCourses(List<String> courses,String word) {
        courses.stream().filter(str -> str.contains(word)).forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private static void printOddNumbersInList(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num%2!=0) //Lambda expression
                .forEach(System.out::println);
    }
}
