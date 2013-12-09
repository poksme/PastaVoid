package PastaVoid;

import Configuration.Config;
import GameEngine.AScene;
import processing.core.PVector;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/21/13
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */

public class TestScene extends AScene {

    private boolean     updated = true;
    private boolean     drawn = true;
    private StepManager walls;
    private WallViewer  viewer;
    private float       speed;
    private Config      config;
    private IsoCamera   camera;

    public TestScene(Config config) {
    	super(true, true); // VISIBLE UPDTABLE
        this.config = config;
        this.speed = config.getLevels().get(0).getBpm();
    }

    public void start() {
        this.walls = new StepManager(this);
        this.walls.generate();
        this.viewer = new WallViewer(this, this.walls, 500, 500);
        this.viewer.setScreenPosition(new PVector(100, 0));
        this.viewer.setSizeX(600);
        this.viewer.setSizeY(600);
        this.camera = new IsoCamera();
    }

    public void update(long timeElapsed) {
        this.viewer.update(timeElapsed);
    }

    public void draw(Game parent) {

    	// THIS MAY BE NEED FOR BETTER BLUR ?
//        parent.smooth();
        parent.background(0);
        this.camera.draw(parent);


        parent.stroke(255, 255, 255);
        parent.strokeWeight(1);
        this.viewer.draw(parent);
//        parent.blur();
        
        parent.stroke(100, 127, 255, 210);
        parent.strokeWeight(6);
        this.viewer.draw(parent);
        parent.blur();
       


    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Config getConfig() {
        return config;
    }
}
