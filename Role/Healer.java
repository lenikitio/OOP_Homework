package Role;

import java.util.ArrayList;
import java.util.Random;

import Interfes.Heal;
import Main.Hero;

public abstract class Healer extends Hero implements Heal {

    public Healer(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY,
            int initiative, int mana, int maxMana, int[] cure) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, initiative);
        this.mana = mana;
        this.maxMana = maxMana;
        this.cure = cure;
    }

    public int mana;
    public int maxMana;
    public int[] cure;

    @Override
    public String toString() {
        return super.toString() + " мана: " + mana + "/" + maxMana;
    }

    public Hero findPatient(ArrayList<Hero> Allies) {
        Hero patient = Allies.get(0);
        for (Hero hero : Allies) {
            if (hero.health < hero.healthMax && hero.health < patient.health) {
                patient = hero;
            }
        }
        return patient;
    }

    @Override
    public void heal(ArrayList<Hero> Allies) {
        Hero patient = findPatient(Allies);
        Random rnd = new Random();
        int healing = rnd.nextInt(cure[0], cure[1] + 1);
        patient.health += healing;
        if (patient.health > patient.healthMax) {
            patient.health = patient.healthMax;
        }
        mana -= 10;
        // System.out.println(nameHero + " исцелил " + patient.nameHero + " на " + healing);
    }

    private void curse(ArrayList<Hero> enemies) {
        Hero enemy = searchTarget(enemies);
        DealDamage(enemy);
        mana -= 10;
        // System.out.println(nameHero + " проклял " + enemy.nameHero);
    }

    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> Allies) {
        Random rnd = new Random();
        int choice = rnd.nextInt(0, 3);
        if (choice == 0 && mana >= 10 && IsDead() == false) {
            heal(Allies);
        } else if (choice == 1 && mana >= 10 && IsDead() == false) {
            curse(enemies);
        } else if (mana <= 10 && IsDead() == false) {
            mana = 0;
            mana += 10;
            // System.out.println(nameHero + " Отдыхает");           
        } else if (choice == 2 && mana == maxMana && IsDead() == false) {
            Hero patient = Allies.get(0);
            for (Hero hero : Allies) {
                if (hero.IsDead() == true) {
                    patient = hero;
                }
            }
            if (patient.IsDead() == true) {
                patient.health = patient.healthMax;
                mana = 0;
            }
        } else if (choice == 2 && IsDead() == false) {
            mana = maxMana; 
        }
    }

}
