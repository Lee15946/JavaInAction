package chapter5;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStream {
    public static void main(String[] args) {
        // Nullable stream
        final var homeValueStream = Stream.ofNullable(System.getProperty("home"));
        System.out.println(homeValueStream);
        final var values = Stream.of("config", "home", "user").flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        System.out.println(values);

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // Add predicate for iterate
        IntStream.iterate(0, n -> n < 100, n -> n + 4).forEach(System.out::println);
        IntStream.iterate(0, n -> n + 4).takeWhile(n -> n < 100).forEach(System.out::println);

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        // When the data has sequence
        final var integers = List.of(120, 300, 350, 400, 530);
        integers.stream().takeWhile(value -> value < 320).forEach(System.out::println);
        integers.stream().dropWhile(value -> value < 320).forEach(System.out::println);
    }
}
