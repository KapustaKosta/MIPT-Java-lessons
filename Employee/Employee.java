package Employee;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

  private String name;
  private String surname;
  private String city;
  private int age;
  private int salary;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Employee(String name, String surname, String city, int age, int salary) {
    this.name = name;
    this.surname = surname;
    this.city = city;
    this.age = age;
    this.salary = salary;
  }

  public static final Comparator<Employee> AGE_SALARY_COMPARATOR = (Employee empl1, Employee empl2) ->
  {
    int ageCompResult = Integer.compare(empl1.age, empl2.age);
    if (ageCompResult != 0) {
      return ageCompResult;
    }

    return Integer.compare(empl1.salary, empl2.salary);
  };

  public static final Comparator<Employee> PASSPORT_COMPARATOR = (Employee empl1, Employee empl2) ->
  {
    int nameCompResult = empl1.name.compareToIgnoreCase(empl2.name);
    if (nameCompResult != 0) {
      return nameCompResult;
    }

    int surnameCompResult = empl1.surname.compareToIgnoreCase(empl2.surname);
    if (surnameCompResult != 0) {
      return surnameCompResult;
    }

    return empl1.city.compareTo(empl2.city);
  };

  public static final Comparator<Employee> FULL_COMPARATOR = (Employee empl1, Employee empl2) ->
  {
    int nameCompResult = empl1.name.compareToIgnoreCase(empl2.name);
    if (nameCompResult != 0) {
      return nameCompResult;
    }

    int surnameCompResult = empl1.surname.compareToIgnoreCase(empl2.surname);
    if (surnameCompResult != 0) {
      return surnameCompResult;
    }

    int cityCompResult = empl1.city.compareTo(empl2.city);
    if (cityCompResult != 0) {
      return cityCompResult;
    }

    int ageCompResult = Integer.compare(empl1.age, empl2.age);
    if (ageCompResult != 0) {
      return ageCompResult;
    }

    return Integer.compare(empl1.salary, empl2.salary);
  };

  @Override
  public int compareTo(Employee o) {
    int nameComparison = this.name.compareToIgnoreCase(o.getName());
    if (nameComparison != 0) {
      return nameComparison;
    } else {
      return Integer.compare(this.age, o.getAge());
    }
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}