package comparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestPerson {

    public static void main(String[] args) {
        Person person1 = new Person("adriana", "123", 20);
        Person person2 = new Person("veta", "234", 40);
        Person person3 = new Person("radu", "555", 16);

        List<Person> list = Arrays.asList(person1, person2, person3);

        Set<Person> personSet = new TreeSet<>(list);

        System.out.println(personSet);

       // System.out.println(list);

        Collections.sort(list);

        //System.out.println("After sort");
        //System.out.println(list);
    }
}
