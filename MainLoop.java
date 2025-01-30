public class MainLoop implements Runnable{

    private final Main main;
    private DrawPane drawPane;

    MainLoop(Main main, DrawPane drawPane){
        this.main = main;
        this.drawPane = drawPane;
    }

    @Override
    public void run() {
        while(!this.drawPane.gameOver){
            main.repaint();
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){

            }
        }
    }
}
