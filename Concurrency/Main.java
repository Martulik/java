package Concurrency;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1, 2, 3, 3, 7, 8, 8, 4, 5, 9, 10);
        System.out.println("task 1 " + averageValue(listInt));

        List<String> listStr = Arrays.asList("first", "SEcoND", "THIrd");
        System.out.println("task 2 \n" + "old: " + listStr + "\n" + upperCase(listStr));

        System.out.println("task 3\n" + squaresOfNumbers(listInt));

        Collection<String> collection = Arrays.asList("aa", "cb", "cd", "cc", "abc");
        sortedCollection(collection, "b");
        System.out.println("task 4\n" + sortedCollection(collection, "c"));

        System.out.println("task 5");
        try {
            Collection<Integer> emptyCollection = new ArrayList<>();
            System.out.println(getLastElement(listInt));
            System.out.println(getLastElement(emptyCollection));
        } catch (NoSuchElementException e) {
            System.out.println("empty collection");
        }

        int[] arrayWithEvenNumbers = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        };
        int[] arrayWithoutEvenNumbers = new int[]{
                1, 3, 5, 7, 9
        };
        System.out.println("task 6\n" + sumOfEvenNumbers(arrayWithEvenNumbers));
        System.out.println(sumOfEvenNumbers(arrayWithoutEvenNumbers));


        System.out.println("task 7\n" + convertToMap(listStr));
    }

    // TASK 1
    // метод, возвращающий среднее значение списка целых чисел;
    public static double averageValue(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
        //return (double) list.stream().reduce(Integer::sum).orElse(0) / list.size();
        //return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    // TASK 2
    // метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»;
    public static List<String> upperCase(List<String> list) {
        return list
                .stream()
                .map(string -> ("_new_ " + string.toUpperCase()))
                .collect(Collectors.toList());
    }

    // TASK 3
    // метод, возвращающий список квадратов всех встречающихся только один раз элементов списка;
    public static List<Integer> squaresOfNumbers(List<Integer> list) {
        return list
                .stream()
                .filter(e -> Collections.frequency(list, e) == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // TASK 4
    // метод, принимающий на вход коллекцию строк и возвращающий все строки, начинающиеся с заданной буквы,
    // отсортированные по алфавиту;
    public static Collection<String> sortedCollection(Collection<String> collection, String n) {
        return collection
                .stream()
                .filter(s -> s.startsWith(n))
                .sorted()
                .toList();
    }

    // TASK 5
    // метод, принимающий на вход коллекцию и возвращающий её последний элемент или кидающий исключение,
    // если коллекция пуста;
    public static Integer getLastElement(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            throw new NoSuchElementException();
        }
        return collection
                .stream()
                .skip(collection.size() - 1)
                .findAny()
                .get();
    }

    // TASK 6
    // метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет;
    public static Integer sumOfEvenNumbers(int[] array) {
        return Arrays
                .stream(array)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    // TASK 7
    // метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение
    public static Map<String, String> convertToMap(List<String> list) {
        return list
                .stream()
                .collect(Collectors
                        .toMap(str -> str.substring(0, 1), str -> str.substring(1)));
    }

}
