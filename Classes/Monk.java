package Classes;

import Main.Hero;
import Main.Vector2;

public class Monk extends Hero {

    public Monk(String nameHero, Vector2 position) {
        super(
                50,
                50,
                1,
                new int[] { -35, -30 },
                nameHero,
                position.posX, 
                position.posY, 
                1);
    }

    @Override
    public String toString() {
        return "Монах: " + super.toString();
    }
    
}
