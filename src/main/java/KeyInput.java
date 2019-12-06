import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private ObjHandler objHandler;
    private int speed;

    private boolean uPressed; //up key pressed
    private boolean dPressed; //down key pressed
    private boolean lPressed; //left key pressed
    private boolean rPressed; //right key pressed

    public KeyInput(ObjHandler objHandler) {
        this.objHandler = objHandler;
        speed = 3;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (objHandler.isPlayerReceived()) {
            Player player = objHandler.getLinkToPlayerObj();
            if (key == KeyEvent.VK_W) { //up
                uPressed = true;
                player.changeVelocity(0, (-speed));
            } else if (key == KeyEvent.VK_A) { //left
                lPressed = true;
                player.changeVelocity((-speed), 0);
            } else if (key == KeyEvent.VK_S) { //down
                dPressed = true;
                player.changeVelocity(0, (speed));
            } else if (key == KeyEvent.VK_D) { //right
                rPressed = true;
                player.changeVelocity((speed), 0);
            }
        }
    }//end of method keyPressed()

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if (objHandler.isPlayerReceived()) {
            Player player = objHandler.getLinkToPlayerObj();
            if (key == KeyEvent.VK_W) {//UP released
                uPressed = false;
                if (dPressed) {
                    dPressed = false;
                    player.changeVelocity(0, (-speed));
                } else if (rPressed) { //if r still pressed
                    rPressed = false;
                    player.changeVelocity((-speed), 0);
                } else if (lPressed) {
                    lPressed = false;
                    player.changeVelocity((-speed), 0);
                } else {
                    player.changeVelocity(0, 0);
                }
            } else if (key == KeyEvent.VK_A) {//LEFT released
                lPressed = false;
                if (rPressed) {
                    rPressed= false;
                    player.changeVelocity((-speed), 0);
                } else if (uPressed) {
                    uPressed = false;
                    player.changeVelocity(0, (-speed));
                } else if (dPressed) {
                    dPressed = false;
                    player.changeVelocity(0, (-speed));
                } else {
                    player.changeVelocity(0, 0);
                }
            } else if (key == KeyEvent.VK_S) {//DOWN released
                dPressed = false;
                if (uPressed) {
                    uPressed = false;
                    player.changeVelocity(0, (-speed));
                } else if (rPressed) { //if r still pressed
                    rPressed = false;
                    player.changeVelocity((-speed), 0);
                } else if (lPressed) {
                    lPressed = false;
                    player.changeVelocity((-speed), 0);
                } else {
                    player.changeVelocity(0, 0);
                }
            } else if (key == KeyEvent.VK_D) {//RIGHT released
                rPressed = false;
                if (lPressed) {
                    lPressed = false;
                    player.changeVelocity((-speed), 0);
                } else if (dPressed) {
                    dPressed = false;
                    player.changeVelocity(0, (-speed));
                } else if (uPressed) {
                    uPressed = false;
                    player.changeVelocity(0, (-speed));
                } else {
                    player.changeVelocity(0, 0);
                }
            }
        }
    }//end of key release method

//    public void keyReleased(KeyEvent event) {
//        int key = event.getKeyCode();
//        if (objHandler.isPlayerReceived()) {
//            Player player = objHandler.getLinkToPlayerObj();
//            if (key == KeyEvent.VK_W) {//up released
//                uPressed = false;
//                if (dPressed) {
//                    player.changeVelocity(0, (-speed));
//                } else {
//                    player.changeVelocity(0, 0);
//                }
//            } else if (key == KeyEvent.VK_A) {//left released
//                lPressed = false;
//                if (rPressed) { //if r still pressed
//                    player.changeVelocity((-speed), 0);
//                } else {
//                    player.changeVelocity(0, 0);
//                }
//            } else if (key == KeyEvent.VK_S) {//down released
//                dPressed = false;
//                if (uPressed) {
//                    player.changeVelocity(0, (-speed));
//                } else {
//                    player.changeVelocity(0, 0);
//                }
//            } else if (key == KeyEvent.VK_D) {//right released
//                rPressed = false;
//                if (lPressed) {
//                    player.changeVelocity((-speed), 0);
//                } else {
//                    player.changeVelocity(0, 0);
//                }
//            }
//        }
//    }//end of key release method

}//end of class
