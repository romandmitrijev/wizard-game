import com.wizard.*;

import java.util.Random;
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

        // Spell shopping operation
        WizardShop wizardShop = new WizardShop();
        while (player.getMoney()>0) {
            System.out.println("Enter spell name to buy or Done if you are finished.");
            System.out.println("Coins left: "+player.getMoney());
            wizardShop.printSpellList();
            String spellToBuy = scanner.nextLine();
            if (spellToBuy.equalsIgnoreCase("done")) {
                break;
            } else {
                wizardShop.buySpell(spellToBuy, player);
            }
        }
        System.out.println("You have bought " + player.getKnowledgeList());

        // Duel operation
        Opponent opponent = new Opponent();
        Spells spells = new Spells();
        SpellUtilities spellUtilities = new SpellUtilities();
        Random random = new Random();

        while (player.isAlive() && opponent.isAlive()) {
            System.out.println("-----------------------");
            System.out.println("Your Health: " + player.getHealth() + " || Opponent: " + opponent.getHealth());
            System.out.println("Select spell to cast..." + player.getKnowledgeList());
            String playerSpell = scanner.nextLine();
            String opponentSpell = opponent.decideSpellName(player, opponent);
            System.out.println("Opponent selected: "+opponentSpell);
            if (player.getKnowledgeList().contains(playerSpell)) {
                int playerSpellSpeed = spells.getSpell(playerSpell).getSpeedRate();
                int opponentSpellSpeed = spells.getSpell(opponentSpell).getSpeedRate();

                // 1st speed check
                if (playerSpellSpeed == opponentSpellSpeed) {
                    int randomNumber = random.nextInt(100);
                    if (randomNumber > 50) {
                        // random > 50 - player turn
                        if (playerSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(playerSpell);
                            int newPlayerHealth = player.getHealth() + healing;
                            System.out.println("You healed " + healing);
                            player.setHealth(newPlayerHealth);
                            player.healthRounder();
                        } else if (opponent.isAlive()) {
                            int damage = spellUtilities.castDamage(playerSpell);
                            int newOpponentHealth = opponent.getHealth() - damage;
                            System.out.println("You did " + damage + " damage");
                            opponent.setHealth(newOpponentHealth);
                        } else {
                            System.out.println("You Won!");
                            break;
                        }
                        // opponent turn
                        if (opponentSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(opponentSpell);
                            int newOpponentHealth = opponent.getHealth() + healing;
                            System.out.println("Opponent healed " + healing);
                            opponent.setHealth(newOpponentHealth);
                            opponent.healthRounder();
                        } else if (player.isAlive()) {
                            int damage = spellUtilities.castDamage(opponentSpell);
                            int newPlayerHealth = player.getHealth() - damage;
                            System.out.println("Opponent did " + damage);
                            player.setHealth(newPlayerHealth);
                        } else {
                            System.out.println("Opponent Won!");
                            break;
                        }
                        //random < 50 - opponent turn
                    } else {
                        if (opponentSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(opponentSpell);
                            int newOpponentHealth = opponent.getHealth() + healing;
                            System.out.println("Opponent healed " + healing);
                            opponent.setHealth(newOpponentHealth);
                            opponent.healthRounder();
                        } else if (player.isAlive()) {
                            int damage = spellUtilities.castDamage(playerSpell);
                            int newPlayerHealth = player.getHealth() - damage;
                            System.out.println("Opponent did " + damage);
                            player.setHealth(newPlayerHealth);
                        } else {
                            System.out.println("Opponent Won!");
                            break;
                        }
                        // player turn
                        if (playerSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(playerSpell);
                            int newPlayerHealth = player.getHealth() + healing;
                            System.out.println("You healed " + healing);
                            player.setHealth(newPlayerHealth);
                            player.healthRounder();
                        } else if (opponent.isAlive()) {
                            int damage = spellUtilities.castDamage(playerSpell);
                            int newOpponentHealth = opponent.getHealth() - damage;
                            System.out.println("You did " + damage + " damage");
                            opponent.setHealth(newOpponentHealth);
                        } else {
                            System.out.println("You Won!");
                            break;
                        }
                    }
                }
                // 2nd speed check - opponent turn
                if (opponentSpellSpeed < playerSpellSpeed) {
                    if (opponentSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(opponentSpell);
                        int newOpponentHealth = opponent.getHealth() + healing;
                        System.out.println("Opponent healed " + healing);
                        opponent.setHealth(newOpponentHealth);
                        opponent.healthRounder();
                    } else if (player.isAlive()) {
                        int damage = spellUtilities.castDamage(opponentSpell);
                        int newPlayerHealth = player.getHealth() - damage;
                        System.out.println("Opponent did " + damage);
                        player.setHealth(newPlayerHealth);
                    } else {
                        System.out.println("Opponent Won!");
                        break;
                    }
                    // player turn
                    if (playerSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(playerSpell);
                        int newPlayerHealth = player.getHealth() + healing;
                        System.out.println("You healed " + healing);
                        player.setHealth(newPlayerHealth);
                        player.healthRounder();
                    } else if (opponent.isAlive()) {
                        int damage = spellUtilities.castDamage(playerSpell);
                        int newOpponentHealth = opponent.getHealth() - damage;
                        System.out.println("You did " + damage);
                        opponent.setHealth(newOpponentHealth);
                    } else {
                        System.out.println("You Won!");
                        break;
                    }
                }
                // 3rd speed check - player turn
                if (opponentSpellSpeed > playerSpellSpeed) {
                    if (playerSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(playerSpell);
                        int newPlayerHealth = player.getHealth() + healing;
                        System.out.println("You healed " + healing);
                        player.setHealth(newPlayerHealth);
                        player.healthRounder();
                    } else if (opponent.isAlive()) {
                        int damage = spellUtilities.castDamage(playerSpell);
                        int newOpponentHealth = opponent.getHealth() - damage;
                        System.out.println("You did " + damage);
                        opponent.setHealth(newOpponentHealth);
                    } else {
                        System.out.println("You Won!");
                        break;
                    }
                    // opponent turn
                    if (opponentSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(opponentSpell);
                        int newOpponentHealth = opponent.getHealth() + healing;
                        System.out.println("Opponent healed " + healing);
                        opponent.setHealth(newOpponentHealth);
                        opponent.healthRounder();
                    } else if (player.isAlive()) {
                        int damage = spellUtilities.castDamage(opponentSpell);
                        int newPlayerHealth = player.getHealth() - damage;
                        System.out.println("Opponent did " + damage);
                        player.setHealth(newPlayerHealth);
                    } else {
                        System.out.println("Opponent Won!");
                        break;
                    }
                }
            } else {
                System.out.println("You don't have this spell");
            }
        }if (player.getHealth()<0){
            System.out.println("-----------------------");
            System.out.println("Your Health: " + player.getHealth() + " || Opponent: " + opponent.getHealth());
            System.out.println("Opponent have won!");
        }else{
            System.out.println("-----------------------");
            System.out.println("Your Health: " + player.getHealth() + " || Opponent: " + opponent.getHealth());
            System.out.println("You have won!");
        }
    }
}