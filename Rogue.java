public class Rogue extends Hero {

    public Rogue(String nameHero, Vector2 position) {
        super(
                100,
                100,
                5,
                new int[] { 20, 30 },
                nameHero, 
                position.posX, position.posY);
    }

    @Override
    public String toString() {
        return "Разбойник: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }
}
