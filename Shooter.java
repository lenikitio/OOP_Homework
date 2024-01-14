// Методы взаимодействия для героев с дальними атаками

import java.util.ArrayList;

public class Shooter {
    Vector2 position;

    public Hero searchTarget(ArrayList<Hero> enemy){
        float minDistance = 13;
        Hero target = enemy.get(0);
        for (Hero hero : enemy) {
            if (minDistance > position.rangeEnemy(hero.position)) {
                minDistance = position.rangeEnemy(hero.position);
                target = hero;
            }
        }
        return target;
    }
}