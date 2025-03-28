package Task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> warriorEquipment = Arrays.asList("Sword", "Shield");
        List<String> mageEquipment = Arrays.asList("Staff", "Spellbook");
        List<String> archerEquipment = Arrays.asList("Bow", "Quiver");

        Character warrior = CharacterFactory.createCharacter("Warrior", "Thorin", warriorEquipment);
        Character mage = CharacterFactory.createCharacter("Mage", "Gandalf", mageEquipment);
        Character archer = CharacterFactory.createCharacter("Archer", "Legolas", archerEquipment);

        warrior.display();
        mage.display();
        archer.display();
    }
}
