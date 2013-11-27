package GameEngine;

import GameEngine.IScene;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class SceneManager {

    private ArrayList<IScene>   scenes;
    private ArrayList<IScene>   toAdd;
    private ArrayList<IScene>   toDelete;
    //

    public SceneManager() {
        this.scenes = new ArrayList<IScene>();
        this.toAdd = new ArrayList<IScene>();
        this.toDelete = new ArrayList<IScene>();
    }

    public void        addScene(IScene scene) {
        this.toAdd.add(scene);
    }

    public void        removeScene(IScene scene) {
        this.toDelete.add(scene);
    }

    public void        start() {

    }

    public void        update() {

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
            if (this.scenes.get(i).isUpdated()) {
                this.scenes.get(i).update();
            }
        }
    }

    public void        draw() {

        //draw all scenes
        for (int i = 0; i < this.scenes.size(); ++i) {
            if (this.scenes.get(i).isDrawn()) {
                this.scenes.get(i).draw();
            }
        }
    }
}
