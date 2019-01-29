package com.wizard;


import java.util.HashMap;
import java.util.Map;

public class WizardShop {
    private Map<String, Integer> spellMenu = new HashMap<>();

    public Map<String, Integer> getSpellMenu() {
        return spellMenu;
    }

    public void setSpellMenu(Map<String, Integer> spellMenu) {
        this.spellMenu = spellMenu;
    }

    public WizardShop() {
        spellMenu.put("Lucarnum Inflamarae", 25);
        spellMenu.put("Lumos Solem", 45);
        spellMenu.put("Everte Statum", 45);
        spellMenu.put("Arania Exumai", 50);
        spellMenu.put("Avada Kevadra", 100);
        spellMenu.put("Vulnera Sanentur", 25);
    }

    public void printSpellList() {
        System.out.println("-------------------------");
        for (Map.Entry<String, Integer> someNumber : spellMenu.entrySet()) {
            System.out.println(someNumber.getKey() + " => " + someNumber.getValue());
        }
        System.out.println("-------------------------");
    }


    public void buySpell(String requestedSpell, Wizard wizard) {
        if (spellMenu.containsKey(requestedSpell)) {
            if (wizard.getKnowledgeList().contains(requestedSpell)) {
                System.out.println("You have already bought this spell");
            } else {
                if (wizard.getMoney() < spellMenu.get(requestedSpell)) {
                    System.out.println("You don't have enough of money");
                } else {
                    wizard.getKnowledgeList().add(requestedSpell);
                    int currentBalance = wizard.getMoney() - spellMenu.get(requestedSpell);
                    wizard.setMoney(currentBalance);
                }
            }
        } else {
            System.out.println("This spell doesn't exist in the shop");
        }
    }
}