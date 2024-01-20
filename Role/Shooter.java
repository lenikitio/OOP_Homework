package Role;
// Методы взаимодействия для героев с дальними атаками

import java.util.ArrayList;

import Interfes.Shot;
import Main.Hero;

public abstract class Shooter extends Hero implements Shot{

    public Shooter(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int arrows, int maxArrows) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 4);
        this.arrows = arrows;
        this.maxArrows = maxArrows;
    }

    protected int maxArrows;
    protected int arrows;



    

    @Override
    public String toString() {
        return super.toString() + " стрелы: " + arrows + "/" + maxArrows;
    }

    @Override
    public void shot(Hero enemy) {
        DealDamage(enemy);
        arrows --;
    }


    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        Hero friend = searchTarget(Allies);
        if (IsNear(friend) == true) {
            damage[1] += 2;
            System.out.println("Повышенный урон");
        }
        if (health > 0 && arrows > 0) {
            Hero enemy  = searchTarget(enemies);
            shot(enemy);
        }
    }
}