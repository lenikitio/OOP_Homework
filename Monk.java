public class Monk extends Hero {

    public Monk(String nameHero) {
        super(
                50,
                50,
                1,
                new int[] { -35, -30 },
                nameHero);
    }

    @Override
    public String toString() {
        return "Монах: " + nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }
    
}
