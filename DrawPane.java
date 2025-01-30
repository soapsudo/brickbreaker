import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {

    DrawPane(){
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(10, 10, 20, 20);
    }
}
