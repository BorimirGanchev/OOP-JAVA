package Task1;

import java.util.List;

class Mage extends Character {
    public Mage(String name, List<String> equipment) {
        super(name, 100, 50, 10, equipment);
    }

    @Override
    public void display() {
        System.out.println("mag: " + name + " jivot: " + health + " ataka: " + attack + " zashtia: " + defense + " ekipirovka: " + equipment);
    }
}