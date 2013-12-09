package GameEngine;

import GameEngine.AScene;
import PastaVoid.Game;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class SceneManager {

    private ArrayList<AScene>   scenes;
    private ArrayList<AScene>   toAdd;
    private ArrayList<AScene>   toDelete;
    //

    // SINGLETON CONSTRUCTOR
    private SceneManager() {
        this.scenes = new ArrayList<AScene>();
        this.toAdd = new ArrayList<AScene>();
        this.toDelete = new ArrayList<AScene>();
    }
    
    private static SceneManager INSTANCE = new SceneManager();
    
    public static SceneManager getInstance() {
    	return INSTANCE;
    }
    
    public void        addScene(AScene scene) {
        this.toAdd.add(scene);
    }

    public void        removeScene(AScene scene) {
        this.toDelete.add(scene);
    }

    public void        start() {

    }

    public void        update(long elapsedTime) {

        //adding the scene that should be added
        for (int i = 0; i < this.toAdd.size(); ++i) {
            this.scenes.add(this.toAdd.get(i));
            this.toAdd.get(i).start();
        }
        this.toAdd.clear();

        //deleting the scene that should be deleted
        for (int i = 0; i < this.toDelete.size(); ++i) {
            this.scenes.remove(this.toDelete.get(i));
        }
        this.toDelete.clear();

        //update all scenes
        for (int i = 0; i < this.scenes.size(); ++i) {
            if (this.scenes.get(i).isUpdatable()) {
                this.scenes.get(i).update(elapsedTime);
            }
        }
    }

    public void        draw(Game parent) {

        //draw all scenes
        for (int i = 0; i < this.scenes.size(); ++i) {
            if (this.scenes.get(i).isDrawable()) {
                this.scenes.get(i).draw(parent);
            }
        }
    }
}
