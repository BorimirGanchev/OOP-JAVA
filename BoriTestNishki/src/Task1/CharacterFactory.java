package Task1;

import java.util.List;

class CharacterFactory {
    public static Character createCharacter(String type, String name, List<String> equipment) {
        return switch (type.toLowerCase()) {
            case "warrior" -> new Warrior(name, equipment);
            case "mage" -> new Mage(name, equipment);
            case "archer" -> new Archer(name, equipment);
            default -> throw new IllegalArgumentException("err type: " + type);
        };
    }
}