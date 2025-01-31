import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPane extends JPanel {

    public boolean gameOver = false;

    private final PlayerDot playerDot;
    private final Player player;

    private final Font f = new Font("Calibri", Font.PLAIN, 40);
    private final Color c = new Color(238, 238, 238);

    private long lastUpdateTime;
    private int dx = -1;
    private int dy = -1;

    private ArrayList<ArrayList<Brick>> bricks;

    DrawPane(Player player) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lastUpdateTime = System.currentTimeMillis();

        this.playerDot = new PlayerDot(450, 450);
        this.player = player;

        bricks = initializeBricks();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - lastUpdateTime;
        lastUpdateTime = currentTime;

        updatePosition(timeDiff);

        if (checkForCollision()) {
            g2d.fillRect(playerDot.getX(), playerDot.getY(), playerDot.width, playerDot.height);
            g2d.fillRect(player.getX(), player.getY(), player.width, player.height);
            drawBricks(g2d);
        } else {
            g2d.setFont(f);
            g2d.drawString("GAME OVER!", (int) (getWidth() / 2.5 - 40), getHeight() / 2);
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

        if (playerDot.getCollisionY() >= getHeight()) {
            gameOver = true;
            return false;
        }

        return true;
    }

    private ArrayList<ArrayList<Brick>> initializeBricks() {

        int rows = 5;
        int columns = 5;

        ArrayList<ArrayList<Brick>> brickGrid = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Brick> brickRow = new ArrayList<>();

            for (int j = 0; j < columns; j++) {
                Brick brick = new Brick();
                brick.x = j * brick.width + 15;
                brick.y = i * brick.height + 15;
                brickRow.add(brick);
            }
            brickGrid.add(brickRow);
        }

        return brickGrid;
    }

    public void drawBricks(Graphics2D g2d) {

        for (int i = 0; i < bricks.size(); i++) {
            ArrayList<Brick> printBricks = bricks.get(i);
            for (int j = 0; j < printBricks.size(); j++) {
                Brick brick = printBricks.get(j);

                if(brick.accessed){
                    try{
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    brick.accessed = true;
                    if(!brick.hit){
                        g2d.setStroke(new BasicStroke(10));
                        g2d.setColor(c);
                        g2d.drawRect(brick.x, brick.y, brick.width, brick.height);

                        g2d.setColor(Color.BLACK);
                        g2d.fillRect(brick.x, brick.y, brick.width, brick.height);

                    }else {
                        g2d.setStroke(new BasicStroke(10));
                        g2d.setColor(c);
                        g2d.drawRect(brick.x, brick.y, brick.width, brick.height);

                        g2d.setColor(c);
                        g2d.fillRect(brick.x, brick.y, brick.width, brick.height);
                    }
                    brick.accessed = false;
                }
            }
        }
    }

    public void checkBrickCollision(){
        for (int i = 0; i < bricks.size(); i++) {
            ArrayList<Brick> brickRow = bricks.get(i);
            for (int j = 0; j < brickRow.size(); j++) {
                Brick brick = brickRow.get(j);

                if(brick.accessed){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    brick.accessed = true;
                    if (!brick.hit) {
                        if ((playerDot.getCollisionX() < brick.getCollisionX() + brick.width && playerDot.getCollisionX() > brick.getCollisionX())
                                && (playerDot.getCollisionY() > brick.getCollisionY() && playerDot.getCollisionY() < brick.getCollisionY() + brick.height)) {
                            brick.setHit(true);
                            dy *= -1;
                        }
                    }
                    brick.accessed = false;
                }
            }
        }
    }
}
