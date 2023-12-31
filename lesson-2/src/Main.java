import shape.Ball;
import shape.ColourPyramid;
import shape.Cylinder;
import shape.Pyramid;
import shape.Shape;

public class Main {

  public static void main(String[] args) {
    Car car = new Car.Bulder(40, 20)
        .setColor("Cyan")
        .setModel("Lada Granta")
        .setFuel(20)
        .setMileage(10300)
        .build();

    car.startEngine();
    car.drive();
    car.stopEngine();
    car.info();
    car.refuel(60);
    car.startEngine();
    car.drive();
    car.info();

    Contact contactGomer = new Contact("Gomer", "gomer@yandex.ru");
    System.out.println(contactGomer.email());
    contactGomer.sayHello();
    System.out.println();

    Contact contactAndrew = new Contact("Andrew");
    System.out.println(contactAndrew.email());
    contactAndrew.sayHello();
    System.out.println();

    Contact contactKonstantin = new Contact("Konstantin", "k.starikov@gmail.com");
    System.out.println(contactKonstantin.email());
    contactKonstantin.sayHello();
    System.out.println();

    Shape[] shapes = new Shape[5];
    shapes[0] = new Shape(15);
    shapes[1] = new Ball(3);
    shapes[2] = new Cylinder(10, 5);
    shapes[3] = new Pyramid(8, 24);
    shapes[4] = new ColourPyramid(10, 32, "Red");
    for (Shape shape : shapes) {
      shape.print();
    }
  }

  static boolean equals(String s, String t) {
    // проверить, что строки совпадают без учета регистра
    String s1 = s.toLowerCase();
    String s2 = t.toLowerCase();
    return s1.equals(s2);
  }

  static String replace(String str, String oldStr, String newStr) {
    // в строке str все вхождения oldStr заменить на newStr
    return str.replace(oldStr, newStr);
  }

  static String format(String surname, int mark, String subject) {
    // вернуть строку, используя форматирование: Студент [Фамилия] получил [оценка] по [предмету]
    return String.format("Студент %s получил %d по %s", surname, mark, subject);
  }

  static boolean isPalindrome(String str) {
    // проверить, является ли строка палиндромом
    StringBuilder reversedStr = new StringBuilder();
    reversedStr.append(str);
    reversedStr.reverse();

    return reversedStr.toString().equals(str);
  }
}
