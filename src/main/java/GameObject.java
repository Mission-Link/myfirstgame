import java.awt.*;

public abstract class GameObject {

    protected ObjCoordinates coordinates;
    protected ID id;

    protected int velX;
    protected int velY;

    protected static int screenWidth;
    protected static int screenHeight;


    public static void assignStaticVars(int[] sizes){
        screenWidth = sizes[0];
        screenHeight = sizes[1];
    }

    //constructor

    public GameObject(ObjCoordinates coordinates, ID id) {
        this.coordinates = coordinates;
        this.id = id;
    }

    //methods

    public abstract void tick();

    public abstract void render(Graphics g);

    public void changeVelocity(int newVelX,int newVelY){
        velX = newVelX;
        velY = newVelY;
    }

    public void changePosition(int newX, int newY) {
        coordinates.setX(newX);
        coordinates.setY(newY);
    }

    public void keepInBoundaries() {
        if ((getX() > screenWidth) || (getX() < 0)) {
            velX *= -1;
        } else if ((getY() > screenHeight) || (getY() < 0)) {
            velY *= -1;
        }
    }

    //with wide frames
    public void keepInBoundaries2() {
        if ((getX() > screenWidth - 48) || (getX() < 0)) {
            velX *= -1;
        } else if ((getY() > screenHeight - 62) || (getY() < 0)) {
            velY *= -1;
        }
    }

    //getters & setters

    public ObjCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ObjCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    /*
    get X and Y coordinates
     */
    public int getX(){
        return coordinates.getX();
    }
    public int getY(){
        return coordinates.getY();
    }

}//end of class
