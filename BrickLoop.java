import java.awt.*;

public class BrickLoop implements Runnable{

    private final Main main;
    private final DrawPane drawPane;

    BrickLoop(Main main, DrawPane drawPane){
        this.main = main;
        this.drawPane = drawPane;
    }

    @Override
    public void run() {
        while(!this.drawPane.gameOver){
            drawPane.checkBrickCollision();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
