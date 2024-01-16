package Main;

import java.util.ArrayList;
import java.util.Random;

import Interfes.Step;

/**
 * Heroes
 */
public abstract class Hero implements Step{

    protected int health, healthMax, armor;
    protected int[] damage;
    protected String nameHero;
    public Vector2 position;

    public Hero(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int initiative){
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
        this.position = new Vector2(posX, posY);
        this.initiative = initiative;
    }

    public void printEnemyDistance(ArrayList<Hero> enemy){
        enemy.forEach(n -> System.out.print(position.rangeEnemy(n.position) + ", "));
        System.out.println();        
    }

    public boolean IsDead(){
        if (health == 0) {
            return true;            
        }
        return false;
    }

    public void DealDamage(Hero enemy){
        Random rnd = new Random();
        enemy.health = enemy.health + enemy.armor - rnd.nextInt(damage[0], damage[1] + 1);
    }

    @Override
    public void step(ArrayList<Hero> enemies) {
        System.out.println("В разработке");
    }

    protected int initiative;

    public int getInitiative(){
        return initiative;
    }


}