import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {

    public boolean gameOver = false;

    private PlayerDot playerDot;
    private long lastUpdateTime;
    private int dx = -1;
    private int dy = -1;

    DrawPane() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lastUpdateTime = System.currentTimeMillis();
        playerDot = new PlayerDot(getWidth() / 2, getHeight() / 2);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - lastUpdateTime;
        lastUpdateTime = currentTime;

        updatePosition(timeDiff);
        if(checkForCollision()){
            g.fillRect(playerDot.getX(), playerDot.getY(), playerDot.width, playerDot.height);
        }else {
            g.drawString("GAME OVER!", getWidth() / 2, getHeight() / 2);
        }


    }

    private void updatePosition(long timeDiff) {
        playerDot.setX(playerDot.getX() + (int) (dx * (timeDiff / 4)));
        playerDot.setY(playerDot.getY() + (int) (dy * (timeDiff / 4)));
    }

    private boolean checkForCollision() {
        if (playerDot.getX() <= 0 || playerDot.getX() + playerDot.width >= getWidth()) {
            dx *= -1;
        }
        if (playerDot.getY() <= 0) {
            dy *= -1;
        }
        if(playerDot.getY() + playerDot.height >= getHeight()){
            gameOver = true;
            return false;
        }

        return true;
    }

}
