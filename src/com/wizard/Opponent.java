package com.wizard;

import java.util.Random;

public class Opponent extends Wizard {
    private Random random = new Random();
    private SpellUtilities spellUtilities = new SpellUtilities();
    private Spells spells = new Spells();

    public String decideSpellName(Wizard player, Wizard opponent) {
        int decision = random.nextInt(100);
        if (opponent.getHealth() < 45) {
            if (decision < 50) {
                return "Vulnera Sanentur";
            } else {
                int playerHealth = player.getHealth();
                if (playerHealth < 11) {
                    return "Lucarnum Inflamarae";
                } else if (player.getHealth() < 17) {
                    return "Lumos Solem";
                } else if (playerHealth < 23) {
                    return "Everte Statum";
                } else if (playerHealth < 30) {
                    return "Arania Exumai";
                } else if (playerHealth < 65) {
                    return "Avada Kedavra";
                } else {
                    return "Vulnera Sanentur";
                }
            }
        } else if (opponent.getHealth() >= player.getHealth()) {
            if (decision < 25) {
                return "Lumos Solem";
            } else if (decision < 50) {
                return "Arania Exumai";
            }else if (decision<75){
                return "Everte Statum";
            }else{
                return "Lucarnum Inflamarae";
            }

        }else{
            if (decision < 20) {
                return "Lumos Solem";
            } else if (decision < 35) {
                return "Arania Exumai";
            }else if (decision<55){
                return "Everte Statum";
            }else if (decision<80){
                return "Lucarnum Inflamarae";
            }else{
                return "Vulnera Sanentur";
            }
        }
    }
}