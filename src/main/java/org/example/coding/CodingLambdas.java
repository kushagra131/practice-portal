package org.example.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class CodingLambdas {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Kushagra", "Sharma", 30),
                new Person("Navi Singh", "Thakur", 30),
                new Person("Shreya Singh", "Thakur", 24),
                new Person("John", "McNeil", 55),
                new Person("Brain", "Canham", 55)
        );

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
            }
        });

        // performConditionally(people, p -> p.getFirstName().startsWith("K"), p -> System.out.println(p));
        performConditionally(people, p -> p.getAge() > 50, p -> System.out.println(p));


        Stream<Person> stream = people.stream()
                .filter(p -> p.getAge() < 50);

        stream.forEach(p -> System.out.println(p));
    }


    static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p))
                consumer.accept(p);
        }
    }
}
