//single-respository //
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
}

class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Welcome email sent to: " + user.getEmail());
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("John", "john@example.com");
        EmailService emailService = new EmailService();
        emailService.sendWelcomeEmail(user);
    }
}

//open-closed principles//
abstract class Payment {
    public abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}

class PayPalPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        Payment credit = new CreditCardPayment();
        Payment paypal = new PayPalPayment();

        processor.processPayment(credit, 100);
        processor.processPayment(paypal, 200);
    }
}
//liskov substitution//
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich {
    public void walk() {
        System.out.println("Ostrich is walking");
    }
}

public class Main {
    public static void main(String[] args) {
        Flyable bird = new Sparrow();
        bird.fly();

        Ostrich ostrich = new Ostrich();
        ostrich.walk();
    }
}
//interface segregation//
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() { System.out.println("Printing..."); }
    public void scan() { System.out.println("Scanning..."); }
    public void fax() { System.out.println("Faxing..."); }
}

class SimplePrinter implements Printer {
    public void print() { System.out.println("Simple printing only."); }
}

public class Main {
    public static void main(String[] args) {
        Printer multi = new MultiFunctionPrinter();
        multi.print();

        Printer simple = new SimplePrinter();
        simple.print();
    }
}
//dependency inversion//
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to PostgreSQL");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
        System.out.println("App is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Database mysql = new MySQLDatabase();
        Application app1 = new Application(mysql);
        app1.start();

        Database postgres = new PostgreSQLDatabase();
        Application app2 = new Application(postgres);
        app2.start();
    }
}