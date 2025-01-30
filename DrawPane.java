import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {

    DrawPane() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - Main.startTime;

        g.fillRect((int) (timeDiff / 10), 10, 10, 10);
    }
}
