
/**
 * Heroes
 */
public abstract class Hero {

    protected int health, healthMax, armor;
    protected int[] damage;
    protected String nameHero;

    public Hero(int health, int healthMax, int armor, int[] damage, String nameHero){
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
    }
    

}