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

public class LevelScene extends AScene {

    private boolean     updated = true;
    private boolean     drawn = true;
    private StepManager walls;
    private float       speed;
    private Config      config;
    private IsoCamera   camera;

    
    public LevelScene(Game game, Config config) {
    	super(game, true, true); // VISIBLE UPDTABLE
        this.config = config;
        this.speed = config.getLevels().get(0).getBpm();
    }

    public void start() {
        this.setWalls(new StepManager(this));
        this.getWalls().generate();
        this.setCamera(new IsoCamera(this));
    }

    public void update(long timeElapsed) {
    	this.getCamera().update(timeElapsed);
    	
    }

    public void draw(Game parent) {

    	// THIS MAY BE NEED FOR BETTER BLUR ?
//        parent.smooth();
        parent.background(0);
        this.getCamera().draw(parent);


        parent.stroke(108, 91, 242);
        parent.strokeWeight(6);
        this.walls.draw(parent);
        parent.blur();
        
        parent.stroke(68, 51, 202);
        parent.strokeWeight(2);
        this.walls.draw(parent);
//        parent.blur();
       


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

	public StepManager getWalls() {
		return walls;
	}

	public void setWalls(StepManager walls) {
		this.walls = walls;
	}

	public IsoCamera getCamera() {
		return camera;
	}

	public void setCamera(IsoCamera camera) {
		this.camera = camera;
	}
}
