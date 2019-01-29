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
        System.out.println("You have 100 coins, what spells do you want to buy?");
        WizardShop wizardShop = new WizardShop();
        while (true) {
            System.out.println("Enter spell name to buy or Done if you are finished");
            wizardShop.printSpellList();
            String spellToBuy = scanner.nextLine();
            if (spellToBuy.equalsIgnoreCase("done")) {
                System.out.println("You have bought " + player.getKnowledgeList());
                break;
            } else {
                wizardShop.buySpell(spellToBuy, player);
            }
        }

        // Duel operation
        Opponent opponent = new Opponent();
        Spells spells = new Spells();
        SpellUtilities spellUtilities = new SpellUtilities();
        Random random = new Random();


        while (player.isAlive() && opponent.isAlive()) {
            System.out.println("-----------------------");
            System.out.println("Your Health: " + player.getHealth() + " || Opponent: " + opponent.getHealth());
            System.out.println("Select spell to cast..."+player.getKnowledgeList());
            String playerSpell = scanner.nextLine();
            if (player.getKnowledgeList().contains(playerSpell)) {
                String opponentSpell = opponent.decideSpellName(player, opponent);
                int playerSpellSpeed = spells.getSpell(playerSpell).getSpeedRate();
                int opponentSpellSpeed = spells.getSpell(opponentSpell).getSpeedRate();


                if (playerSpellSpeed == opponentSpellSpeed) {
                    int randomNumber = random.nextInt(100);
                    if (randomNumber > 50) {
                        if (playerSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(playerSpell);
                            int newPlayerHealth = player.getHealth() + healing;
                            System.out.println("You healed " + healing);
                            player.setHealth(newPlayerHealth);
                        } else if (opponent.isAlive()) {
                            int damage = spellUtilities.castDamage(playerSpell);
                            int newOpponentHealth = opponent.getHealth() - damage;
                            System.out.println("You did " + damage +" damage");
                            opponent.setHealth(newOpponentHealth);
                        }
                        if (opponentSpell.equals("Vulnera Sanentur")) {
                            int healing = spellUtilities.castHealing(playerSpell);
                            int newOpponentHealth = opponent.getHealth() + healing;
                            System.out.println("Opponent healed " + healing);
                            opponent.setHealth(newOpponentHealth);
                        } else if (player.isAlive()) {
                            int damage = spellUtilities.castDamage(opponentSpell);
                            int newPlayerHealth = player.getHealth() - damage;
                            System.out.println("Opponent did " + damage);
                            player.setHealth(newPlayerHealth);
                        }
                    } else if (opponentSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(playerSpell);
                        int newOpponentHealth = opponent.getHealth() + healing;
                        System.out.println("Opponent healed " + healing);
                        opponent.setHealth(newOpponentHealth);
                    } else if (player.isAlive()) {
                        int damage = spellUtilities.castDamage(playerSpell);
                        int newPlayerHealth = player.getHealth() - damage;
                        System.out.println("Opponent did " + damage);
                        player.setHealth(newPlayerHealth);
                    }

                } else if (opponentSpellSpeed > playerSpellSpeed) {
                    if (opponentSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(playerSpell);
                        int newOpponentHealth = opponent.getHealth() + healing;
                        System.out.println("Opponent healed " + healing);
                        opponent.setHealth(newOpponentHealth);
                    } else if (player.isAlive()) {
                        int damage = spellUtilities.castDamage(playerSpell);
                        int newOpponentHealth = opponent.getHealth() - damage;
                        System.out.println("Opponent did " + damage);
                        opponent.setHealth(newOpponentHealth);
                    }
                    if (playerSpell.equals("Vulnera Sanentur")) {
                        int healing = spellUtilities.castHealing(playerSpell);
                        int newPlayerHealth = player.getHealth() + healing;
                        System.out.println("You healed " + healing);
                        player.setHealth(newPlayerHealth);
                    } else if (opponent.isAlive()) {
                        int damage = spellUtilities.castDamage(playerSpell);
                        int newOpponentHealth = opponent.getHealth() - damage;
                        System.out.println("You did " + damage);
                        opponent.setHealth(newOpponentHealth);
                    }

                } else if (playerSpell.equals("Vulnera Sanentur")) {
                    int healing = spellUtilities.castHealing(playerSpell);
                    int newPlayerHealth = player.getHealth() + healing;
                    System.out.println("You healed " + healing);
                    player.setHealth(newPlayerHealth);
                } else if (opponent.isAlive()) {
                    int damage = spellUtilities.castDamage(playerSpell);
                    int newOpponentHealth = opponent.getHealth() - damage;
                    System.out.println("You did " + damage);
                    opponent.setHealth(newOpponentHealth);
                } else if (opponentSpell.equals("Vulnera Sanentur")) {
                    int healing = spellUtilities.castHealing(playerSpell);
                    int newOpponentHealth = opponent.getHealth() + healing;
                    System.out.println("Opponent healed " + healing);
                    opponent.setHealth(newOpponentHealth);
                } else if (player.isAlive()) {
                    int damage = spellUtilities.castDamage(playerSpell);
                    int newPlayerHealth = player.getHealth() - damage;
                    System.out.println("Opponent did " + damage);
                    player.setHealth(newPlayerHealth);
                }

            } else {
                System.out.println("You don't have this spell");
            }
        }
    }
}