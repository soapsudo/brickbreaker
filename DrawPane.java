import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {

    public boolean gameOver = false;

    private final PlayerDot playerDot;
    private final Player player;

    private long lastUpdateTime;
    private int dx = -1;
    private int dy = -1;

    DrawPane(Player player) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lastUpdateTime = System.currentTimeMillis();

        this.playerDot = new PlayerDot(getWidth() / 2, getHeight() / 2);
        this.player = player;

        this.player.setX(getWidth() / 2 - this.player.width);
        this.player.setY(getHeight() - getHeight() / 3);

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
            g.fillRect(player.getX(), player.getY(), player.width, player.height);
        }else {
            g.drawString("GAME OVER!", getWidth() / 2, getHeight() / 2);
        }


    }

    private void updatePosition(long timeDiff) {
        playerDot.setX(playerDot.getX() + (int) (dx * (timeDiff / 3)));
        playerDot.setY(playerDot.getY() + (int) (dy * (timeDiff / 3)));
    }

    private boolean checkForCollision() {
        if (playerDot.getCollisionX() < 0 || playerDot.getCollisionX() > getWidth()) {
            dx *= -1;
        }
        if (playerDot.getCollisionY() < 0) {
            dy *= -1;
        }
        if(playerDot.getCollisionY() >= getHeight()){
            gameOver = true;
            return false;
        }

        return true;
    }

}
