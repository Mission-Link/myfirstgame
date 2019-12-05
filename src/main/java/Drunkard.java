import java.awt.*;

public class Drunkard extends GameObject{

    public Drunkard(ObjCoordinates coordinates) {
        super(coordinates, ID.Drunkard);
        velX = 1;
        velY = 1;
    }


    public void tick() {
        changePosition(getX() + velX, getY() + velY);
//        keepInBoundaries2(Launcher.sWIDTH, Launcher.sHEIGHT);
        keepInBoundaries2();
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), 25, 25);
    }

}
