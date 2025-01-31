public class Brick {
    int x;
    int y;

    public boolean hit;

    public boolean accessed;

    final int width = 150;
    final int height = 40;

    public int getCollisionX(){
        return x + 15;
    }

    public int getCollisionY(){
        return y + 15;
    }

    public void setHit(boolean hit){
        this.hit = hit;
    }
}
