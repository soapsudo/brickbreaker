public class PlayerDot {
    int x;
    int y;

    public final int width = 10;
    public final int height = 10;

    PlayerDot(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCollisionX(){
        return x + width / 2;
    }

    public int getCollisionY(){
        return y + height / 2;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
