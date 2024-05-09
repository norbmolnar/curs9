import java.util.*;

class Basket {
    private List<String> fruits;

    public Basket() {
        fruits = new ArrayList<>();
    }

    public boolean find(String fruit) {
        return fruits.contains(fruit);
    }

    public boolean remove(String fruit) {
        return fruits.remove(fruit);
    }

    public int position(String fruit) {
        return fruits.indexOf(fruit);
    }

    public Collection<String> distinct() {
        return new HashSet<>(fruits);
    }

    public void add(String fruit) {
        fruits.add(fruit);
    }

    public int count() {
        return fruits.size();
    }

    public int customCount() {
        int count = 0;
        for (String fruit : fruits) {
            count++;
        }
        return count;
    }
}

class Bouquet {
    private Set<String> flowers;

    public Bouquet() {
        flowers = new HashSet<>();
    }

    public Collection<String> getAll() {
        return flowers;
    }

    public void add(String flower) {
        flowers.add(flower);
    }

    public boolean remove(String flower) {
        return flowers.remove(flower);
    }
}

class Person {
    private String name;
    private int age;
    private String position;

    public Person(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}

class Company {
    private List<Person> persons;

    public Company() {
        persons = new ArrayList<>();
    }

    public Person getManager() {
        for (Person person : persons) {
            if (person.getPosition().equals("manager")) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getPersons(String profession) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getPosition().equalsIgnoreCase(profession)) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsOlder(int age) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPerson(String filterName) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(filterName)) {
                result.add(person);
            }
        }
        return result;
    }

    public void employ(Person person) {
        persons.add(person);
    }
}

public class Main {
    public static void main(String[] args) {
        // Test Basket
        Basket basket = new Basket();
        basket.add("Apple");
        basket.add("Banana");
        System.out.println("Position of Banana: " + basket.position("Banana"));
        System.out.println("Is Orange in basket? " + basket.find("Orange"));
        System.out.println("Distinct Fruits: " + basket.distinct());
        System.out.println("Fruit Count: " + basket.count());
        System.out.println("Custom Fruit Count: " + basket.customCount());

        // Test Bouquet
        Bouquet bouquet = new Bouquet();
        bouquet.add("Rose");
        bouquet.add("Tulip");
        bouquet.add("Rose");
        bouquet.add("Sunflower");
        System.out.println("All Flowers: " + bouquet.getAll());
        bouquet.remove("Tulip");
        System.out.println("After removing Tulip: " + bouquet.getAll());

        // Test Company
        Company company = new Company();
        company.employ(new Person("Alice", 35, "manager"));
        company.employ(new Person("Bob", 30, "welder"));
        company.employ(new Person("Charlie", 40, "carpenter"));
        company.employ(new Person("David", 45, "plumber"));

        System.out.println("Manager: " + company.getManager().getName());
        System.out.println("Carpenters: " + company.getPersons("carpenter"));
        System.out.println("Persons older than 35: " + company.getPersonsOlder(35));
        System.out.println("Persons containing 'a' in name: " + company.getPerson("a"));
    }
}
