package comparators;

public class Person implements Comparable<Person> {

    //break into firstName and lastName
    private String name;
    private String cnp;
    private int age;

    public Person(String name, String cnp, int age) {
        this.name = name;
        this.cnp = cnp;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", age=" + age +
                '}';
    }

    //change implementation of compareTo - for age
    /*
    -1
    0
    1
     */
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}
