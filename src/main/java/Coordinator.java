import java.awt.*;
import java.util.Random;

public class Coordinator {

    private ObjCoordinates coordinates;

    private static int screenWidth;
    private static int screenHeight;

    private static int rightSide;
    private static int leftSide = 0;
    private static int topSide = 0;
    private static int bottomSide;

    private boolean outOfTopSide; //greater than topSide
    private boolean outOfBottomSide; //less than bottomSide
    private boolean outOfLeftSide; //less than bottomSide
    private boolean outOfRightSide; //less than bottomSide
    private boolean inHeightArea; //in the middle of height
    private boolean inWidthArea; //in the middle of width

    private boolean inBounds;

    public static void assignStaticVars() { //int[] sizes
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int WIDTH = (int) screenSize.getWidth();
        int HEIGHT = (int) screenSize.getHeight();

        screenWidth = WIDTH;
        screenHeight = HEIGHT;

//        screenWidth = sizes[0];
//        screenHeight = sizes[1];

        rightSide = screenWidth - 40;
        bottomSide = screenHeight - 62;
    }

    public Coordinator(ObjCoordinates coordinates) {
        this.coordinates = coordinates;

        outOfTopSide = coordinates.getY() < topSide;
        outOfBottomSide = coordinates.getY() > bottomSide;
        outOfLeftSide = coordinates.getX() < leftSide;
        outOfRightSide = coordinates.getX() > rightSide;

        inHeightArea = ((coordinates.getY() < bottomSide) && (coordinates.getY() > topSide));
        inWidthArea = ((coordinates.getX() > leftSide) && (coordinates.getX() < rightSide));

        inBounds = (!outOfLeftSide && !outOfTopSide && !outOfRightSide && !outOfBottomSide);
    }

    public void locateObject() {
        if (inBounds) {
            System.out.println("normal");
        } else if (outOfLeftSide && inHeightArea) {
            System.out.println("left side/middle");
        } else if (outOfTopSide && inWidthArea) {
            System.out.println("top side/middle");
        } else if (outOfRightSide && inHeightArea) {
            System.out.println("right side/middle");
        } else if (outOfBottomSide && inWidthArea) {
            System.out.println("bottom side/middle");
        } else {
            System.out.println("object out of bounds");
        }

    }

    public ObjCoordinates calculateNewCoordinates() {
        if (!inBounds) {
            switch ((new Random().nextInt(2))) {
                case 0:
                    return new ObjCoordinates(10, 10);
                case 1:
                    return new ObjCoordinates(rightSide - 20, bottomSide - 20);
                default:
                    return new ObjCoordinates(10, 10);
            }
        }
        else{
            System.out.println("Object in bounds");
            return coordinates;
        }

    }


    public static void main(String[] args) {
        assignStaticVars();
        //left side
//        new Coordinator(new ObjCoordinates(leftSide + 5, screenHeight / 2)).locateObject(); //normal
//        new Coordinator(new ObjCoordinates(leftSide - 5, screenHeight / 2)).locateObject(); //exceeds left
//        //top side
//        new Coordinator(new ObjCoordinates(screenWidth / 2, topSide + 5)).locateObject();//normal
//        new Coordinator(new ObjCoordinates(screenWidth / 2, topSide - 5)).locateObject(); //exceeds top
//        //right side
//        new Coordinator(new ObjCoordinates(rightSide - 5, screenHeight / 2)).locateObject();//normal
//        new Coordinator(new ObjCoordinates(rightSide + 5, screenHeight / 2)).locateObject(); //exceeds right
//        //bottom side
//        new Coordinator(new ObjCoordinates(screenWidth / 2, bottomSide - 5)).locateObject();//normal
//        new Coordinator(new ObjCoordinates(screenWidth / 2, bottomSide + 5)).locateObject(); //exceeds right
//        new Coordinator(new ObjCoordinates(rightSide + 100, bottomSide + 100)).locateObject(); //out of bounds

        for(int i = 0; i < 10; i++) {
            Coordinator coordinator = new Coordinator(new ObjCoordinates(rightSide + 100, bottomSide + 100));
            ObjCoordinates coordinates = coordinator.calculateNewCoordinates();
            System.out.println("X: " + coordinates.getX() + ", Y:" + coordinates.getY());
            new Coordinator(coordinates).locateObject();
        }


    }

}
