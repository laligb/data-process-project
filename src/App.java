import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        // Inizialization of List
        List<Employee> listOfEmployees = new ArrayList<>();

        // Mock data of employes
        Employee david = new Employee("David", 45, "Engineering", 3400.0f);
        Employee laura = new Employee("Laura", 34, "Design", 2500.0f);
        Employee maria = new Employee("Maria", 21, "Engineering", 1500.0f);
        Employee leo = new Employee("Leo", 37, "Engineering", 4500.0f);
        Employee pablo = new Employee("Pablo", 38, "Design", 4700.0f);
        Employee indira = new Employee("Indiar", 46, "Engineering", 4300.0f);
        Employee alexander = new Employee("Alexander", 20, "Design", 2500.0f);
        Employee paul = new Employee("Paul", 39, "Engineering", 3600.0f);

        // Adding mock data to list of employees
        listOfEmployees.add(david);
        listOfEmployees.add(laura);
        listOfEmployees.add(maria);
        listOfEmployees.add(leo);
        listOfEmployees.add(pablo);
        listOfEmployees.add(indira);
        listOfEmployees.add(alexander);
        listOfEmployees.add(paul);

        // Prints the whole list of all employees
        System.out.println("List of employees: ");
        for (Employee item : listOfEmployees) {
          System.out.println(item); // prints each employee
        }

        // Function interface lambda expression that returns name and department of employee
        Function<Employee, String> nameAndDepartment = employee -> employee.getName() + ": " + employee.getDepartment();

        // List of names and departmens that are created using  stream and collections.
        // We take a list of employes and map names and departments using landa function,
        // finally we collect them to list.
        List<String> namesAndDepartments = listOfEmployees.stream()
          .map(nameAndDepartment) // takes only names and department together
          .collect(Collectors.toList()); // collects to list

        // Test to check our new list. We loop through all elements of namseAndDepartments
        System.out.println("\nNames and departments: ");
        for (String item : namesAndDepartments) {
          System.out.println(item); // prints each employee's name and department
        }

        // Calculates average salary of employees
        double average = listOfEmployees.stream()
          .mapToDouble(Employee::getSalary) // method reference to get salary and convert to double
          .average() // calculates average
          .orElse(0.0); // returns 0.0 if list is empty

        System.out.println("\nAverage salary: " + average); // prints average salary

        // Filter function that only includes employess whose age is above 30.
        List<Employee> filteredByAge = listOfEmployees.stream()
          .filter(employee -> employee.getAge() > 30)
          .collect(Collectors.toList());

        // Testing the function
        System.out.println("\nEmployees whose age are above 30: ");
        for (Employee item : filteredByAge) {
          System.out.println(item);
        }

        // Filter by Salary:
        List<Employee> filterBySalary = listOfEmployees.stream()
          .filter(employee -> employee.getSalary() >= 3000.0f) // filters salaries started from 3000
          .filter(employee -> employee.getSalary() <= 4000.0f) // filters salaries that are not above 4000
          .collect(Collectors.toList());

        // Testing the function
        System.out.println("\nEmployees whose salary is between 3000 and 4000: ");
        for (Employee item : filterBySalary) {
          System.out.println(item);
        }
    }
}

/**
 * Class Employee that has private instance variables name, department,
 * salary and age. Contains constructor and getters for each variable.
 */
class Employee {
  private String name, department;
  private float salary;
  private int age;

  /**
   * Constructor employee
   * @param name name of the employee in String
   * @param age age of an employee in integer
   * @param department department name in String
   * @param salary Salary of employee in float
   */
  Employee (String name, int age, String department, float salary) {
    this.name = name;
    this.age = age;
    this.department = department;
    this.salary = salary;
  }

  /**
   * Getter that returns the name
   * @return name of employee
   */
  public String getName(){
    return name;
  }

  /**
   * Getter that returns the age
   * @return age of employee
   */
  public int getAge() {
    return age;
  }

  /**
   * Getter that returns the name of the department
   * @return department in String
   */
  public String getDepartment() {
    return this.department;
  }

  /**
   * Getter that returns the salary of the employee
   * @return salary in float
   */
  public float getSalary() {
    return this.salary;
  }

  /**
   * Method that overrides the Object class and prints the
   * information about employee
   */
  @Override
  public String toString() {
    return "Name: "
    + this.name
    + ". Age: "
    + this.age
    + ". Department: "
    + this.department
    + ". Salary: "
    + this.salary;
  }
}
