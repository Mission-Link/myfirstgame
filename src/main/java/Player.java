import java.awt.*;

public class Player extends GameObject {

    //constructor

    public Player() {
        super(new ObjCoordinates(100, 100), ID.Player);
        velX = 0;
        velY = 0;
    }

    public Player(ObjCoordinates coordinates) {
        super(coordinates, ID.Player);
        velX = 1;
        velY = 1;
    }

    //methods


//    @Override
    public void keepInBoundaries2d() {
        int deltaX = (getX() - (screenWidth - 48));
        int deltaY = (getY() - (screenHeight - 62));
        System.out.println("deltaX:"+deltaX+", deltaY:"+deltaY);
        if ((getX() > screenWidth - 48) || (getX() < 0)) {
            if(getX() > screenWidth/2){//right side
                changePosition(((screenWidth - 48) - deltaX), getY());
            }
            else {//left side

            }
            changeVelocity(getVelX() * (-1), getVelY());
        } else if ((getY() > screenHeight - 62) || (getY() < 0)) {
            changePosition(deltaX, ((screenHeight - 62) - deltaY));
            changeVelocity(getVelX(), getVelY() * (-1));
        }
    }

    public void moveObject() {
        coordinates.setX(coordinates.getX() + velX);
        coordinates.setY(coordinates.getY() + velY);
    }

    public void tick() {
        changePosition(getX() + velX, getY() + velY);
        keepInBoundaries2();
//        keepInBoundaries2(Launcher.fWIDTH, Launcher.fHEIGHT);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(getX(), getY(), 30, 30);
    }

    //getters

}//end of class
