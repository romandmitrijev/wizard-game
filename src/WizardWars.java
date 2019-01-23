import com.wizard.CharacterCreation;

import com.wizard.Wizard;
import java.util.Scanner;

public class WizardWars {

    public static void main(String[] args) {
        CharacterCreation characterCreation = new CharacterCreation();
        System.out.println("Welcome to Wizard Wars Game");
        Wizard player = new Wizard();
        Scanner scaner = new Scanner(System.in);

        while (player.getName() == null || player.getName().isEmpty()) {
            System.out.println("Please enter your Name:");
            String incomingFirstName = scaner.nextLine();
            if (characterCreation.validateName(incomingFirstName)) {
                player.setName(incomingFirstName);
            }
        }
        while (player.getSurname() == null || player.getSurname().isEmpty()) {
            System.out.println("Please enter your Surname:");
            String incomingSurname = scaner.nextLine();
            if (characterCreation.validateName(incomingSurname)) {
                player.setSurname(incomingSurname);
            }
        }
        System.out.println("So " + player.getName() + " " + player.getSurname() + ". Are you ready to play?");




    }
}