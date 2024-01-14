public class Crossbowner extends Hero {

    public Crossbowner(String nameHero, Vector2 position) {
        super(
                75,
                75,
                2,
                new int[] { 10, 15 },
                nameHero, 
                position.posX, position.posY);
        rangeMaxDamage = 4;
    }

    protected int rangeMaxDamage;



    @Override
    public String toString() {
        return "Арбалетчик: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }

}
