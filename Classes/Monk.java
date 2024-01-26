package Classes;

import java.util.ArrayList;

import Main.Hero;
import Main.Vector2;
import Role.Healer;

public class Monk extends Healer {

    public Monk(String nameHero, Vector2 position) {
        super(
                50,
                50,
                1,
                new int[] { 5, 15 },
                nameHero,
                position.posX, 
                position.posY, 
                1,
                100,
                100,
                new int[] {5, 15});
    }

    @Override
    public String toString() {
        return "Монах: " + super.toString();
    }

    @Override
    public String getInfo() {
        return "Монах";
    }

    
}
