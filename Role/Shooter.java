package Role;
// Методы взаимодействия для героев с дальними атаками

import java.util.ArrayList;

import Interfes.Shot;
import Main.Hero;

public abstract class Shooter extends Hero implements Shot{

    public Shooter(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 4);
        this.arrows = arrows;
        this.maxArrows = maxArrows;
    }

    protected int maxArrows;
    protected int arrows;



    public Hero searchTarget(ArrayList<Hero> enemies){
        float minDistance = 13;
        Hero target = enemies.get(0);
        for (Hero hero : enemies) {
            if (minDistance > position.rangeEnemy(hero.position) && hero.IsDead() == false) {
                minDistance = position.rangeEnemy(hero.position);
                target = hero;
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return nameHero + " " + "Здоровье: " + health + "/" + healthMax + " броня: " + armor + " стрелы: " + arrows + "/" + maxArrows;
    }

    @Override
    public void shot(Hero enemy) {
        DealDamage(enemy);
        arrows --;
    }


    @Override
    public void step(ArrayList<Hero> enemies) {
        if (health > 0 && arrows > 0) {
            Hero enemy  = searchTarget(enemies);
            shot(enemy);
        }
    }
}