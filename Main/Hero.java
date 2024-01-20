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
        if (health <= 0) {
            return true;            
        }
        return false;
    }

    public void DealDamage(Hero enemy){
        Random rnd = new Random();
        enemy.health = enemy.health + enemy.armor - rnd.nextInt(damage[0], damage[1] + 1);
    }

    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        System.out.println("В разработке");
    }

    protected int initiative;

    public int getInitiative(){
        return initiative;
    }

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

    protected boolean IsNear(Hero enemy){
        if (Math.abs(enemy.position.posX) - Math.abs(position.posX) == 1 && Math.abs(enemy.position.posY) - Math.abs(position.posY) == 1) {
            return true;
        } else if (enemy.position.posX == position.posX && Math.abs(enemy.position.posY) - Math.abs(position.posY) == 1) {
            return true;
        } else if (Math.abs(enemy.position.posX) - Math.abs(position.posX) == 1 && enemy.position.posY == position.posY) {
            return true;            
        }
        return false;
    }

    @Override
    public String toString() {
        if (IsDead() == true) {
            return "Мёртв " + nameHero + " Здоровье: " + health + "/" + healthMax + " броня: " + armor;
        } else {
        return nameHero + " Здоровье: " + health + "/" + healthMax + " броня: " + armor;
        }
    }

    


}