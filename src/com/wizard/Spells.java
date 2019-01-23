package com.wizard;

import java.util.HashMap;
import java.util.Map;

public class Spells {
    private Map<String, Spell> spellMap = new HashMap<>();

    public Map<String, Spell> getSpellMap() {
        return spellMap;
    }

    public void setSpellMap(Map<String, Spell> spellMap) {
        this.spellMap = spellMap;
    }


    public Spells() {
        spellMap.put("Lucarnum Inflamarae", new Spell("Lucarnum Inflamarae", 25, 10,
                16, 70, 1));
        spellMap.put("Lumos Solem", new Spell("Lumos Solem", 45, 17,
                23, 65, 2));
        spellMap.put("Everte Statum", new Spell("Everte Statum", 45, 23,
                29, 60, 3));
        spellMap.put("Arania Exumai", new Spell("Arania Exumai", 50, 30,
                36, 55, 4));
        spellMap.put("Avada Kevadra", new Spell("Avada Kevadra", 100, 100,
                100, 10, 5));
        spellMap.put("Vulnera Sanentur", new Spell("Vulnera Sanentur", 25, 10,
                20, 70, 1));
    }

    public Spell getSpell(String spellName) {
        for (Map.Entry<String, Spell> someSpellName : spellMap.entrySet()) {
            if (someSpellName.getKey().equalsIgnoreCase(spellName)) {
                return spellMap.get(spellName);
            }
        }
        System.out.println("This spell doesn't exist");
        return null;

    }

}
