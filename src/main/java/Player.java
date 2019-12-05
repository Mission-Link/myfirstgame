import java.awt.*;

public class Player extends GameObject {

    //constructor

    public Player() {
        super(new ObjCoordinates(100, 100), ID.Player);
        velX = 3;
        velY = 3;
    }

    public Player(ObjCoordinates coordinates) {
        super(coordinates, ID.Player);
        velX = 1;
        velY = 1;
    }

    //methods

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
