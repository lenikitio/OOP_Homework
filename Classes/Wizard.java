package Classes;

import Main.Vector2;
import Role.Healer;

public class Wizard extends Healer {
    public Wizard(String nameHero, Vector2 position) {
        super(
                50,
                50,
                1,
                new int[] { 10, 25 },
                nameHero,
                position.posX,
                position.posY, 
                1,
                100,
                100,
                new int[] {5, 10});
    }

    @Override
    public String toString() {
        return "Колдун " + super.toString();
    }

    @Override
    public String getInfo() {
        return "Колдун";
    }

    
}
