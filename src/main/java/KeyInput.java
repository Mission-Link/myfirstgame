import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private ObjHandler objHandler;

    public KeyInput(ObjHandler objHandler) {
        this.objHandler = objHandler;
    }

    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        if(objHandler.isPlayerReceived()){
            Player player = objHandler.getLinkToPlayerObj();
            if(key == KeyEvent.VK_W){
                player.changeVelocity(0, (-2));
            }else if(key == KeyEvent.VK_A){
                player.changeVelocity((-2), 0);
            }else if(key == KeyEvent.VK_S){
                player.changeVelocity(0, (2));
            }else if(key == KeyEvent.VK_D){
                player.changeVelocity((2), 0);
            }
        }

    }

    public void keyReleased(KeyEvent event){

    }

}//end of class
