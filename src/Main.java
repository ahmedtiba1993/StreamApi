import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initializes a List of Person objects containing sample data.
        List<Person> people = StreamApi.initializationList();

        //Displays the details of each Person
        System.out.println("****************************************************");
        System.out.println("Displays the details of each Person");
        StreamApi.displayPeople(people);

        //Displays the count of people by gender (Male and Female).
        System.out.println("****************************************************");
        System.out.println("Displays the count of people by gender (Male and Female");
        StreamApi.displayCountByGender(people);

        //Counts the number of people by gender (Male and Female).
        System.out.println("****************************************************");
        System.out.println("Counts the number of people by gender (Male and Female)");
        System.out.println(StreamApi.countPersonnesParGenre(people));

        //Retrieves all Person objects from the provided List where the gender matches the specified genre
        System.out.println("****************************************************");
        System.out.println("Retrieves all Person objects from the provided List where the gender matches the specified genre");
        StreamApi.getAllByGenre(people,"Male");

        //sort By Age increasing
        System.out.println("****************************************************");
        System.out.println("sort By Age increasing");
        StreamApi.sortByAgeIncreasing(people);

        //sort By Age decreasing
        System.out.println("****************************************************");
        System.out.println("sort By Age decreasing");
        StreamApi.sortByAgeDecreasing(people);

        //unique Names
        System.out.println("****************************************************");
        System.out.println("unique Names");
        StreamApi.uniqueNames(people);

        //Filter people by age >= x
        System.out.println("****************************************************");
        System.out.println("Filter people by age >= x");
        StreamApi.findAllMoreThanAge(people,40);

        //Filter people whose name starts with "ah"
        System.out.println("****************************************************");
        System.out.println("Filter people whose name starts with 'ah'");
        StreamApi.startNameWith(people, "ah");

        //display the top 3 age
        System.out.println("****************************************************");
        System.out.println("display the top 3 age");
        StreamApi.top3Age(people);

        // Find the person with the highest (Max age)
        System.out.println("***************************************************");
        System.out.println("Max Age");
        StreamApi.maxAge(people);

        // Min age
        System.out.println("***************************************************");
        System.out.println("Min Age");
        StreamApi.minAge(people);

        //display Total Salaries
        System.out.println("***************************************************");
        System.out.println("display Total Salaries");
        StreamApi.displayTotalSalaries(people);

        //create List People Names
        System.out.println("***************************************************");
        System.out.println("create List People Names");
        StreamApi.createListPeopleNames(people);

        // Check if at least one person has an age greater than 30
        System.out.println("***************************************************");
        System.out.println("Check if at least one person has an age greater than 30");
        StreamApi.checkIfExist(people);

        // Group people by city
        System.out.println("***************************************************");
        System.out.println("Group people by city");
        StreamApi.peopleByCity(people);
    }
}