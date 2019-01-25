import com.wizard.*;

import java.util.Scanner;

public class WizardWars {

    public static void main(String[] args) {
        CharacterCreation characterCreation = new CharacterCreation();
        System.out.println("Welcome to Wizard Wars Game");
        Wizard player = new Wizard();
        Scanner scanner = new Scanner(System.in);

        while (player.getName() == null || player.getName().isEmpty()) {
            System.out.println("Please enter your Name:");
            String incomingFirstName = scanner.nextLine();
            if (characterCreation.validateName(incomingFirstName)) {
                player.setName(incomingFirstName);
            }
        }
        while (player.getSurname() == null || player.getSurname().isEmpty()) {
            System.out.println("Please enter your Surname:");
            String incomingSurname = scanner.nextLine();
            if (characterCreation.validateName(incomingSurname)) {
                player.setSurname(incomingSurname);
            }
        }
        System.out.println("So " + player.getName() + " " + player.getSurname() + ". Are you ready to play?");

//--------------------------Testing area---------------------------------------
        WizardShop wizardShop = new WizardShop();
        Wizard wizard = new Wizard();
        wizardShop.printSpellList();

        wizardShop.buySpell("Lucarnum Inflamarae", player);
        System.out.println("You know these spells:");
        System.out.println(player.getKnowledgeList());
        System.out.println("Your balance: " +player.getMoney()+" coins");

        SpellUtilities spellUtilities = new SpellUtilities();
        Spells spells = new Spells();
        int randomNumber = spellUtilities.getRandomNumberInRange(spells.getSpell("Lucarnum Inflamarae").getMinSpellPower(),
                spells.getSpell("Lucarnum Inflamarae").getMaxSpellPower());
        System.out.println(randomNumber);

        int afterDamage = wizard.getHealth() - spellUtilities.castHealing("Lucarnum Inflamarae");
        System.out.println(afterDamage);


    }
}