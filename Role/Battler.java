package Role;

import java.util.ArrayList;

import Interfes.Move;
import Main.Hero;
import Main.Vector2;

public abstract class Battler extends Hero implements Move{

    public Battler(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int move) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 3);
        this.move = move;

    }
    protected int move;

    @Override
    public String toString() {
        return super.toString() + " передвижение: " + move;
    }


    public void move(Hero enemy, ArrayList<Hero> team){
        int movement = move;
        Vector2 point = new Vector2(position.posX, position.posY);
        while (movement > 0) {
            if (enemy.position.posX - position.posX > 0) {
                point.posX++;
                movement--;                
            } else if (enemy.position.posX - position.posX < 0) {
                point.posX--;
                movement--;                
            } else if (enemy.position.posY - position.posY > 0) {
                point.posY++;
                movement--;
            } else if (enemy.position.posY - position.posY < 0) {
                point.posY--;
                movement--;
            } else {
                movement = 0;
            }
            for (Hero friend : team) {
                if (friend.position.posX == point.posX && friend.position.posY == point.posY) {
                    point.posX = position.posX;
                    point.posY = position.posY;
                } else {
                    position.posX = point.posX;
                    position.posY = point.posY;
                }
            }                
        }
    }


    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        Hero enemy = searchTarget(enemies);
        if (IsDead() == false && IsNear(enemy) == true) {
            DealDamage(enemy);
            System.out.println(nameHero + " находится " + position); 
        } else if (IsNear(enemy) == false && IsDead() == false) {
            move(enemy, Allies);
            System.out.println(nameHero + " находится " + position);           
        } 
    }
    
}
