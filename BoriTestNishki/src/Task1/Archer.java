package Task1;

import java.util.List;

class Archer extends Character {
    public Archer(String name, List<String> equipment) {
        super(name, 120, 40, 15, equipment);
    }

    @Override
    public void display() {
        System.out.println("strelec: " + name + " jivot: " + health + " ataka: " + attack + " zashtia: " + defense + " ekipirovka: " + equipment);
    }
}
