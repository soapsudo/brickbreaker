import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    private final Player player;

    KeyboardInput(Player player){
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.player.setX(this.player.getX() + 15);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.player.setY(this.player.getX() - 15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
