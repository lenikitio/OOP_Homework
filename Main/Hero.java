package Main;

import java.util.ArrayList;
import java.util.Random;


import Interfes.Step;

/**
 * Heroes
 */
public abstract class Hero implements Step{

    public int health, healthMax, armor;
    public int[] damage;
    public String nameHero;
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
        int harm = rnd.nextInt(damage[0], damage[1] + 1);
        enemy.health = enemy.health + enemy.armor - harm;
        System.out.println(nameHero + " Нанёс " + harm + " единиц урона по " + enemy.nameHero);
        if (enemy.health < 1) {
            health = 0;
            System.out.println(enemy.nameHero + ": Погиб");
        } else {        
            System.out.println(" Осталось жизни у противника: " + enemy.health + "/" + enemy.healthMax);
        }
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
        for (int i = position.posX - 1; i < position.posX + 2; i++) {
            for (int j = position.posY - 1; j < position.posY + 2; j++) {
                if (i == enemy.position.posX && j == enemy.position.posY) {
                    return true;
                }             
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (IsDead() == true) {
            return nameHero + " Мёртв ";
        }
        return nameHero + " Здоровье: " + health + "/" + healthMax + " броня: " + armor;
    }

    


}