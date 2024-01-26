package Classes;


import Main.Vector2;
import Role.Battler;

public class Rogue extends Battler {

    public Rogue(String nameHero, Vector2 position) {
        super(
                100,
                100,
                4,
                new int[] { 20, 30 },
                nameHero, 
                position.posX, 
                position.posY, 
                3);
    }

    @Override
    public String toString() {
        return "Разбойник: " + super.toString();
    }

    @Override
    public String getInfo() {
        return "Разбойник";
    }
}

