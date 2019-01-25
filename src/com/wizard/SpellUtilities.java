package com.wizard;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpellUtilities {
    private Random random = new Random();
    private Spells spells = new Spells();

    public int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public int castDamage(String nameOfSpell) {
        int successChance = random.nextInt(100);
        if (successChance < spells.getSpellMap().get(nameOfSpell).getSuccessRate()) {
            System.out.println(nameOfSpell + " cast successful!");
            return getRandomNumberInRange(spells.getSpellMap().get(nameOfSpell).getMinSpellPower(),
                    spells.getSpellMap().get(nameOfSpell).getMaxSpellPower());
        } else {
            System.out.println(nameOfSpell + " cast failed!");
            return 0;
        }

    }

    public int castHealing(String nameOfSpell) {
        int successChance = random.nextInt(100);
        if (successChance < spells.getSpellMap().get(nameOfSpell).getSuccessRate()) {
            System.out.println(nameOfSpell + " cast successful!");
            int totalHealingAmount = getRandomNumberInRange(spells.getSpellMap().get(nameOfSpell).getMinSpellPower(),
                    spells.getSpellMap().get(nameOfSpell).getMaxSpellPower());
            System.out.println("Healing " + totalHealingAmount);
            int currentSuccessRate = spells.getSpellMap().get(nameOfSpell).getSuccessRate();
            while (currentSuccessRate > 0) {
                int newSuccessChance = random.nextInt(100);
                currentSuccessRate = currentSuccessRate - getRandomNumberInRange(5, 10);
                if (newSuccessChance < currentSuccessRate) {
                    int healingAmount = getRandomNumberInRange(spells.getSpellMap().get(nameOfSpell).getMinSpellPower(),
                            spells.getSpellMap().get(nameOfSpell).getMaxSpellPower());
                    System.out.println("Healing " + healingAmount);
                    totalHealingAmount = totalHealingAmount + healingAmount;
                }else{
                    break;
                }

            }
            return totalHealingAmount;
        } else {
            System.out.println(nameOfSpell + " cast failed!");
            return 0;
        }
    }

}
