package com.wizard;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpellUtilities {

    public int getRandomNumberInRange(int min, int max){
        Random random = new Random();
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }

    public int castDamage(String nameOfSpell){
        Spells spells = new Spells();
        Random random = new Random();
        int successChance = random.nextInt(100);
        if (successChance < spells.getSpellMap().get(nameOfSpell).getSuccessRate()){
            System.out.println(nameOfSpell+" cast successful!");
         return getRandomNumberInRange(spells.getSpellMap().get(nameOfSpell).getMinSpellPower(),
                 spells.getSpellMap().get(nameOfSpell).getMaxSpellPower() );
        }else{
            System.out.println(nameOfSpell+" cast failed!");
            return 0;
        }

    }

}
