package Classes;
import Main.Vector2;
import Role.Shooter;

public class Sniper extends Shooter {

    public Sniper(String nameHero, Vector2 position) {
        super(
                75,
                75,
                2,
                new int[] { 10, 15 },
                nameHero,
                position.posX, 
                position.posY);
                arrows = maxArrows = 10;
    }


    @Override
    public String toString() {
        return "Снайпер: " + super.toString();
    }

   
    
}
