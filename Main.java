import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private Main(){
        super("BrickBreaker");

        setTitle("BrickBreaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 600);
    }

    static class DrawPane extends JPanel{
        public void paintComponent(Graphics g){
            
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        main.frameInit();
    }

    private static void loop(JFrame frame, JPanel panel){
        while(true){

        }

    }
}
