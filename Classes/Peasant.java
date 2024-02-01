package Classes;

import java.util.ArrayList;

import Interfes.Recharge;
import Main.Hero;
import Main.Vector2;
import Role.Battler;
import Role.Shooter;

public class Peasant extends Battler implements Recharge{
    public Peasant(String nameHero, Vector2 position) {
        super(
                100,
                100,
                0,
                new int[] { 0, 0 },
                nameHero,
                position.posX, position.posY,
                2);
    }

    @Override
    public String toString() {
        return "Крестьянин: " + super.toString();
    }


    @Override
    public String getInfo() {
        return "Крестьянин";
    }

    @Override
    public void recharge(ArrayList<Hero> Allies) {
        ArrayList<Shooter> shooters = new ArrayList<>();
        for (Hero hero : Allies) {
            if (hero.IsDead() == false && hero.getClass() == Crossbowner.class || hero.getClass() == Sniper.class) {
                Shooter sr = (Shooter) hero;
                shooters.add(sr);
            }
        }
        if (shooters.isEmpty() == false) {
            Shooter needing = shooters.get(0);
            for (Shooter shooter : shooters) {
                if (shooter.arrows < needing.arrows) {
                    needing = shooter;                    
                }
            }
            move(needing, Allies);
            needing.arrows = needing.maxArrows;      
        }        
    }



    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        Hero enemy = searchTarget(enemies);
        Hero helper = searchTarget(Allies);
        if (IsDead() == false && IsNear(enemy) == true) {
            move(helper, Allies);
        } else if (IsDead() == false && IsNear(enemy) == false) {
            recharge(Allies);
        }
    }




    
}