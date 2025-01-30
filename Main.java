import javax.swing.*;
import java.awt.*;


public class Main extends JFrame  {


    public static long startTime = System.currentTimeMillis();

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

        DrawPane dp = new DrawPane();

        Thread loop = new Thread(new MainLoop(this, dp));
        loop.start();

        this.add(dp);
    }

}
