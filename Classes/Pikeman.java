package Classes;

import Main.Hero;
import Main.Vector2;

public class Pikeman extends Hero {
    public Pikeman(String nameHero, Vector2 position) {
        super(
                100,
                100,
                5,
                new int[] { 20, 30 },
                nameHero,
                position.posX, position.posY, 3);
    }

    @Override
    public String toString() {
        return "Копейщик: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }
    
}
