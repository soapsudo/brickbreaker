public class MainLoop implements Runnable{

    private final Main main;

    MainLoop(Main main){
        this.main = main;
    }

    @Override
    public void run() {
        while(true){
            main.repaint();
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
            }
        }
    }
}
