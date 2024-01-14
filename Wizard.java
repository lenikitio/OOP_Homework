public class Wizard extends Hero {
    public Wizard(String nameHero, Vector2 position) {
        super(
                50,
                50,
                1,
                new int[] { -10, -5 },
                nameHero,
                position.posX,
                position.posY);
    }

    @Override
    public String toString() {
        return "Колдун: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }
    
}
