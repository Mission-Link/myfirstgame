import java.awt.*;

public abstract class GameObject {

    protected static int screenWidth;
    protected static int screenHeight;

    protected static int rightSide;
    protected static int leftSide = 0;
    protected static int topSide = 0;
    protected static int bottomSide;


    public static void assignStaticVars(int[] sizes){
        screenWidth = sizes[0];
        screenHeight = sizes[1];

        rightSide = screenWidth - 40;
        bottomSide = screenHeight - 62;
    }

    protected ObjCoordinates coordinates;
    protected ID id;

    protected int velX;
    protected int velY;

    //constructor

    public GameObject(ObjCoordinates coordinates, ID id) {
        this.coordinates = coordinates;
        this.id = id;
    }

    //methods

    public abstract void tick();

    public abstract void render(Graphics g);

    public void changeVelocity(int newVelX, int newVelY){
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
        if ((getX() > rightSide) || (getX() < leftSide)) {
            velX *= -1;
        } else if ((getY() > bottomSide) || (getY() < topSide)) {
            velY *= -1;
        }
        else if((getX() > rightSide) && (getY() > bottomSide)){
            velX *= -1;
            velY *= -1;
        }
        else if((getX() < leftSide) && (getY() < topSide)){
            velX *= -1;
            velY *= -1;
        }
    }//end of keepInBoundaries2 method

//    public void keepInBoundaries2() {
//        if ((getX() > screenWidth - 48) || (getX() < 0)) {
//            velX *= -1;
//        } else if ((getY() > screenHeight - 62) || (getY() < 0)) {
//            velY *= -1;
//        }
//    }

    //getters & setters

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public ObjCoordinates getCoordinates() {
        return coordinates;
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
