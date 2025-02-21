import javax.swing.*;
import java.awt.*;


public class Main extends JFrame  {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }

    private Main(){
        super("BrickBreaker");


        ImageIcon icon = new ImageIcon("brickbreakerlogo.png");

        setTitle("BrickBreaker");
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setVisible(true);

        Player player = new Player();
        player.setX(getWidth() / 2 - player.width);
        player.setY(getHeight() - getHeight() / 4);

        DrawPane dp = new DrawPane(player);

        addKeyListener(new KeyboardInput(player, this));

        Thread loop = new Thread(new MainLoop(this, dp));
        Thread brickLoop = new Thread(new BrickLoop(this, dp));

        brickLoop.start();
        loop.start();

        this.add(dp);
    }

}
