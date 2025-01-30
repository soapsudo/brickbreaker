import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {

    public boolean gameOver = false;

    private final PlayerDot playerDot;
    private final Player player;

    private final Font f = new Font("Calibri", Font.PLAIN, 40);

    private long lastUpdateTime;
    private int dx = -1;
    private int dy = -1;

    DrawPane(Player player) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lastUpdateTime = System.currentTimeMillis();

        this.playerDot = new PlayerDot(getWidth() / 2, getHeight() / 2);
        this.player = player;

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
        }else{
            g.setFont(f);
            g.drawString("GAME OVER!", (int) (getWidth() / 2.5 - 40), getHeight() / 2);
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

        if ((playerDot.getCollisionX() < player.getX() + player.width && playerDot.getCollisionX() > player.getX())
                && (playerDot.getCollisionY() > player.getY() && playerDot.getCollisionY() < player.getY() + player.height)) {
            dy *= -1;
        }

        if(playerDot.getCollisionY() >= getHeight()){
            gameOver = true;
            return false;
        }

        return true;
    }

}
