public class Crossbowner extends Hero {

    public Crossbowner(String nameHero) {
        super(
                75,
                75,
                2,
                new int[] { 10, 15 },
                nameHero);
        rangeMaxDamage = 4;
    }

    int rangeMaxDamage;

    @Override
    public String toString() {
        return "Арбалетчик: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }

}
