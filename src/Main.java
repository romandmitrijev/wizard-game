import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Harry Potter Game");
        Scanner scanner = new Scanner(System.in);
        Wizard wizard = new Wizard();

        while (true) {
            System.out.println("Please enter your Name:");
            String name = scanner.next();
            if (name.matches("[a-zA-Z0-9]*")) {
                wizard.setName(name);
                break;
            } else {
                System.out.println("Name contains illegal characters, please use only letters and numbers.");
            }
        }
        while (true) {
            System.out.println("Please enter your Surname:");
            String surname = scanner.next();
            if (surname.matches("[a-zA-Z0-9]*")) {
                wizard.setSurname(surname);
                break;
            } else {
                System.out.println("Surname contains illegal characters, please use only letters and numbers.");
            }
        }

        System.out.println("Wizard ["+wizard.getName()+" "+wizard.getSurname()+"] created");
    }
}