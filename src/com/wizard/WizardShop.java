package com.wizard;


import java.util.Map;

public class WizardShop {
    Spells spells = new Spells();

    public void printSpellList (){
        System.out.println("--------------");
        for (Map.Entry<String, Spell> someNumber: spells.getSpellMap().entrySet()){
            System.out.println();
        }
        System.out.println("--------------");
    }
}
