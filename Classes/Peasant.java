package Classes;

import Main.Hero;
import Main.Vector2;

public class Peasant extends Hero {
    public Peasant(String nameHero, Vector2 position) {
        super(
                100,
                100,
                0,
                new int[] { 0, 0 },
                nameHero,
                position.posX, position.posY,
                0);
    }

    @Override
    public String toString() {
        return "Крестьянин: " + super.toString();
    }

    
}