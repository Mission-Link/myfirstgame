import java.awt.*;
import java.util.ArrayList;

public class ObjHandler {
    private ArrayList<GameObject> gameObjects;
    private Player linkToPlayerObj;

    private boolean playerReceived;

    //constructor
    public ObjHandler() {
        gameObjects = new ArrayList<GameObject>();
        linkToPlayerObj = null;
        playerReceived = false;
    }

    //methods
    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        System.out.println("object class name:"+object.getClass().toString());
        if (object.getClass().toString().equalsIgnoreCase("class Player")) {
            System.out.println("Obj Handler: Player object received!");
            linkToPlayerObj = (Player) object;
            playerReceived = true;
        }
        gameObjects.add(object);

    }

    public boolean isPlayerReceived() {
        return playerReceived;
    }

    public Player getLinkToPlayerObj() {
        return linkToPlayerObj;
    }

    public void removeObject(GameObject object) {
        gameObjects.remove(object);
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }


}//end of class
