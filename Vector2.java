public class Vector2 {

    int posX, posY;

    public Vector2(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString() {
        return posX + "/" + posY;
    }

    public float rangeEnemy(Vector2 enemy){
        return (float) Math.sqrt(Math.pow(enemy.posX - posX, 2) + Math.pow(enemy.posY - posY, 2));
    }

}
