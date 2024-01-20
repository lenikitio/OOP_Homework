package Role;

import java.util.ArrayList;

import Interfes.Move;
import Main.Hero;

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


    public void move(Hero enemy, Hero friend){
        int movement = move;
        while (movement > 0) {
            if (IsNear(enemy) == true) {
                movement = 0; 
            } else if (enemy.position.posX - position.posX > 0 && friend.position.posX != position.posX++) {
                position.posX++;
                movement--;                
            } else if (enemy.position.posX - position.posX < 0 && friend.position.posX != position.posX--) {
                position.posX--;
                movement--;                
            } else if (enemy.position.posY - position.posY > 0 && friend.position.posY != position.posY++) {
                position.posY++;
                movement--;
            } else if (enemy.position.posY - position.posY < 0 && friend.position.posY != position.posY--) {
                position.posY--;
                movement--;
            } else {
                movement = 0;
            }                
         
        }
    }


    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        Hero enemy = searchTarget(enemies);
        Hero friend = searchTarget(Allies);
        if (health > 0 && IsNear(enemy) == true) {
            DealDamage(enemy);
        } else if (IsNear(enemy) == false) {
            move(enemy, friend);          
        }
        System.out.println(nameHero + " находится " + position);  
    }
    
}
