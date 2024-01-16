package Classes;
import Main.Vector2;
import Role.Shooter;

public class Crossbowner extends Shooter {

    public Crossbowner(String nameHero, Vector2 position) {
        super(
                75,
                75,
                2,
                new int[] { 10, 15 },
                nameHero, 
                position.posX, position.posY);
                this.maxArrows = arrows = 10;
    }

    @Override
    public String toString() {
        return "Арбалетчик: " + super.toString();
    }



    

}
