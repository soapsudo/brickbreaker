import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    private final Player player;
    private final Main main;

    KeyboardInput(Player player, Main main){
        this.player = player;
        this.main = main;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && player.getX() + player.width < main.getWidth()){
            player.setX(this.player.getX() + 25);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT && player.getX() > 0){
            player.setX(this.player.getX() - 25);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
