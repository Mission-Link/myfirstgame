import java.awt.*;
import java.util.ArrayList;

public class Handler {
    private ArrayList<GameObject> gameObjects;

    //constructor
    public Handler() {
        gameObjects = new ArrayList<GameObject>();
    }

    //methods
    public void tick(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = gameObjects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        gameObjects.add(object);
    }

    public void removeObject(GameObject object){
        gameObjects.remove(object);
    }

}//end of class
