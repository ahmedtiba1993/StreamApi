import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public static List<Person> initializationList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ben Ali", "Mohamed", 45, "Tunis", "Male", 500.0));
        people.add(new Person("Trabelsi", "Faten", 38, "Sfax", "Female", 600.0));
        people.add(new Person("Bouazizi", "Ali", 30, "Sousse", "Male", 450.0));
        people.add(new Person("Miled", "Leila", 27, "Monastir", "Female", 550.0));
        people.add(new Person("Jaziri", "Nidhal", 50, "Gabès", "Male", 700.0));
        people.add(new Person("Hammami", "Salma", 25, "Nabeul", "Female", 480.0));
        people.add(new Person("Khemiri", "Ahmed", 32, "Sousse", "Male", 520.0));
        people.add(new Person("Khlifi", "Noura", 29, "Kairouan", "Female", 510.0));
        people.add(new Person("Saidi", "Omar", 40, "Sousse", "Male", 590.0));
        people.add(new Person("Dridi", "Sarra", 34, "Mahdia", "Female", 570.0));

        return people;
    }

    public static void displayPeople(List<Person> people) {
        people.stream().forEach(System.out::println);
    }

    public static void displayCountByGender(List<Person> people) {
        long nombreMasculin = people.stream().filter(person -> "Masculin".equalsIgnoreCase(person.getGender())).count();

        long nombreFeminin = people.stream().filter(person -> "Féminin".equalsIgnoreCase(person.getGender())).count();

        System.out.println("Nombre de personnes masculines : " + nombreMasculin);
        System.out.println("Nombre de personnes féminines : " + nombreFeminin);
    }

    public static Map<String, Long> countPersonnesParGenre(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
    }

    public static void getAllByGenre(List<Person> people, String genre) {
        people.stream().filter(person -> person.getGender().equals(genre)).forEach(System.out::println);
    }

    public static void sortByAgeIncreasing(List<Person> people) {
        people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

    public static void sortByAgeDecreasing(List<Person> people) {
        people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);
    }

    public static void uniqueNames(List<Person> people) {
        people.stream().map(Person::getFirstName).distinct().forEach(System.out::println);
    }

    public static void findAllMoreThanAge(List<Person> people, int age) {
        people.stream()
                .filter(person -> person.getAge() >= age)
                .forEach(System.out::println);
    }

    public static void startNameWith(List<Person> people, String start){
        people.stream()
                .filter(person -> person.getFirstName().toLowerCase().startsWith(start.toLowerCase()))
                .forEach(System.out::println);
    }

    public static void top3Age(List<Person> people) {
        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void maxAge(List<Person> people) {
        people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(System.out::println);
    }

    public static void minAge(List<Person> people) {
        people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .ifPresent(System.out::println);
    }

    public static void displayTotalSalaries(List<Person> people) {
        Double totalSalary = people.stream()
                .map(Person::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Total Salary: " + totalSalary);
    }

    public static void createListPeopleNames(List<Person> people) {

        List<String> names = people.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }

    public static void checkIfExist(List<Person> people) {
        boolean anyAbove30 = people.stream()
                .anyMatch(person -> person.getAge() > 30);
        if(anyAbove30){
            System.out.println("Above 30");
        }else{
            System.out.println("Not Above 30");
        }
    }

    public static void peopleByCity(List<Person> people) {
        Map<String, List<Person>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        System.out.println(peopleByCity);
    }
}
