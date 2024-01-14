
public class Peasant extends Hero {
    public Peasant(String nameHero, Vector2 position) {
        super(
                100,
                100,
                0,
                new int[] { 0, 0 },
                nameHero,
                position.posX, position.posY);
    }

    @Override
    public String toString() {
        return "Крестьянин: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }

    
}