package demo;

import streams.StreamOperations;

import java.util.List;
import java.util.function.Supplier;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        show("average [1, 2, 3, 4]",
                () -> StreamOperations.average(List.of(1, 2, 3, 4)));
        show("average []",
                () -> StreamOperations.average(List.of()));

        show("toUpperCaseWithPrefix [hello, World]",
                () -> StreamOperations.toUpperCaseWithPrefix(List.of("hello", "World")));

        show("squaresOfUniqueElements [1, 2, 2, 3, 4, 4, 5]",
                () -> StreamOperations.squaresOfUniqueElements(List.of(1, 2, 2, 3, 4, 4, 5)));

        show("lastElement [10, 20, 30]",
                () -> StreamOperations.lastElement(List.of(10, 20, 30)));
        show("lastElement []",
                () -> StreamOperations.lastElement(List.of()));

        show("sumOfEven [1, 2, 3, 4, 5, 6]",
                () -> StreamOperations.sumOfEven(new int[]{1, 2, 3, 4, 5, 6}));
        show("sumOfEven [1, 3, 5]",
                () -> StreamOperations.sumOfEven(new int[]{1, 3, 5}));

        show("splitFirstCharacter [apple, banana, cherry]",
                () -> StreamOperations.splitFirstCharacter(List.of("apple", "banana", "cherry")));
        show("splitFirstCharacter [apple, avocado]",
                () -> StreamOperations.splitFirstCharacter(List.of("apple", "avocado")));
        show("splitFirstCharacter [apple, \"\"]",
                () -> StreamOperations.splitFirstCharacter(List.of("apple", "")));
    }

    private static void show(String title, Supplier<?> action) {
        try {
            System.out.println(title + " -> " + action.get());
        } catch (RuntimeException e) {
            System.out.println(title + " -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}