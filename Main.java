import java.util.ArrayList;
import java.util.Random;

/**
 * Main
 */
public class Main {
    static ArrayList<Hero> herosWhite = new ArrayList<>();
    static ArrayList<Hero> herosBlack = new ArrayList<>();

    

    static ArrayList<Hero> generateCommand(int n) {
        ArrayList<Hero> commandHeroes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(1, 5) + n;
            switch (rand) {
                case 1:
                    commandHeroes.add(new Crossbowner(getName()));
                    break;
                case 2:
                    commandHeroes.add(new Monk(getName()));
                    break;
                case 3:
                    commandHeroes.add(new Pikeman(getName()));
                    break;
                case 4:
                    commandHeroes.add(new Peasant(getName()));
                    break;
                case 5:
                    commandHeroes.add(new Rogue(getName()));
                    break;
                case 6:
                    commandHeroes.add(new Sniper(getName()));
                    break;
                case 7:
                    commandHeroes.add(new Wizard(getName()));
                    break;             
            }

        }
        return commandHeroes;
    }

    static String getName(){
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }

    public static void main(String[] args) {
        herosWhite = generateCommand(0);
        herosBlack = generateCommand(3);



        herosWhite.forEach(n -> System.out.println(n.toString()));
        System.out.println("-----");
        herosBlack.forEach(n -> System.out.println(n.toString()));

    }

}