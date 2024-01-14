public class Sniper extends Hero {
    public Sniper(String nameHero, Vector2 position) {
        super(
                75,
                75,
                2,
                new int[] { 10, 15 },
                nameHero,
                position.posX, 
                position.posY);
    }

    @Override
    public String toString() {
        return "Снайпер: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }
    
}
