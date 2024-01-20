package Classes;


import Main.Vector2;
import Role.Battler;

public class Pikeman extends Battler {
    public Pikeman(String nameHero, Vector2 position) {
        super(
                100,
                100,
                8,
                new int[] { 20, 30 },
                nameHero,
                position.posX, 
                position.posY,
                1);
    }

    @Override
    public String toString() {
        return "Копейщик: " + super.toString();
    }
    
}
