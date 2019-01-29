package com.wizard;

import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private String name;
    private String surname;
    private int health = 100;
    private int money = 100;
    private List<String> knowledgeList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(ArrayList<String> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void healthRounder(){
        if (health>100){
            this.health=100;
        }
    }

}