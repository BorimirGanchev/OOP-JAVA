package Task1;

import java.util.List;

class Warrior extends Character {
    public Warrior(String name, List<String> equipment) {
        super(name, 150, 30, 20, equipment);
    }

    @Override
    public void display() {
        System.out.println("voin: " + name + " jivot: " + health + " ataka: " + attack + " zashtia: " + defense + " ekipirovka: " + equipment);
    }
}
