package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



import Classes.Crossbowner;
import Classes.Monk;
import Classes.Peasant;
import Classes.Pikeman;
import Classes.Rogue;
import Classes.Sniper;
import Classes.Wizard;

public class Main {
    static ArrayList<Hero> heroesGood = new ArrayList<>();
    static ArrayList<Hero> heroesEvil = new ArrayList<>();
    static ArrayList<Hero> heroOrder = new ArrayList<>();

    static ArrayList<Hero> generateCommand(String side) {
        ArrayList<Hero> commandHeroes = new ArrayList<>();
        Random random = new Random();
        if (side.toLowerCase().contains("добро")) {
            for (int i = 1; i < 11; i++) {
                int rand = random.nextInt(1, 5);
                switch (rand) {
                    case 1:
                        commandHeroes.add(new Crossbowner(getName(), new Vector2(1, i)));
                        break;
                    case 2:
                        commandHeroes.add(new Monk(getName(), new Vector2(1, i)));
                        break;
                    case 3:
                        commandHeroes.add(new Pikeman(getName(), new Vector2(1, i)));
                        break;
                    case 4:
                        commandHeroes.add(new Peasant(getName(), new Vector2(1, i)));
                        break;
                }
            }
        } else if (side.toLowerCase().contains("зло")) {
            for (int i = 1; i < 11; i++) {
                int rand = random.nextInt(1, 5);
                switch (rand) {
                    case 1:
                        commandHeroes.add(new Rogue(getName(), new Vector2(10, i)));
                        break;
                    case 2:
                        commandHeroes.add(new Sniper(getName(), new Vector2(10, i)));
                        break;
                    case 3:
                        commandHeroes.add(new Wizard(getName(), new Vector2(10, i)));
                        break;
                    case 4:
                        commandHeroes.add(new Peasant(getName(), new Vector2(10, i)));
                        break;
                }
            }
        } else
            System.out.println("Такой стороны конфликта нет");
        return commandHeroes;
    }

    static String getName() {
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }

    public static boolean gameOverHoly() {
        for (Hero hero : heroesGood) {
            if (hero.IsDead() == false)
                return false;
        }
        return true;
    }


    public static boolean gameOverEvil() {
        for (Hero hero : heroesEvil) {
            if (hero.IsDead() == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        heroesGood = generateCommand("Добро");
        heroesEvil = generateCommand("зло");

        heroOrder.addAll(heroesGood);
        heroOrder.addAll(heroesEvil);
        heroOrder.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());

        // heroesGood.forEach(n -> System.out.println(n.toString()));
        // System.out.println("-----");
        // heroesEvil.forEach(n -> System.out.println(n.toString()));

        // System.out.println("-----");

        // for (int i = 0; i < 12; i++) {
        // for (Hero h : heroOrder) {
        // if (heroesEvil.contains(h)) {
        // h.step(heroesGood, heroesEvil);
        // System.out.println();
        // } else {
        // h.step(heroesEvil,heroesGood);
        // System.out.println();
        // }
        // }
        // System.out.println("-----");
        // }

        // heroesGood.forEach(n -> System.out.println(n.toString()));
        // System.out.println("-----");
        // heroesEvil.forEach(n -> System.out.println(n.toString()));

        Scanner sc = new Scanner(System.in);
        boolean flag;
        while (true) {
            View.view();
            if (gameOverEvil()) {
                flag = true;
                break;
            }
            if (gameOverHoly()) {
                flag = false;
                break;
            }
            for (Hero h : heroOrder) {
                if (heroesEvil.contains(h)) {
                    h.step(heroesGood, heroesEvil);
                } else {
                    h.step(heroesEvil, heroesGood);
                }
            }
            sc.nextLine();
        }
        if (flag) {
            System.out.println("Победило добро");
        } else {
            System.out.println("Победило зло");
        }
    }

}