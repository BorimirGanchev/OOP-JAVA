package Task1;

import java.util.List;

abstract class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected List<String> equipment;

    public Character(String name, int health, int attack, int defense, List<String> equipment) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.equipment = equipment;
    }

    public abstract void display();
}



