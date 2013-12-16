package PastaVoid;

import ddf.minim.AudioPlayer;
import Configuration.Config;
import GameEngine.AScene;
import GameEngine.KeysManager;
import GameEngine.SceneManager;
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
    private Configuration.Level      level;
    private IsoCamera   camera;
    private int			delayTime;
    private boolean		delayDone;
    private	Player		player;
    private boolean		isPaused;
    //should be in GUIScene
    private PauseMenuScene	pauseMenu;
    private AudioPlayer playingSong;
    
    public LevelScene(Game game, Configuration.Level level, AudioPlayer playingSong) {
    	super(game, true, true); // VISIBLE UPDTABLE
    	this.playingSong = playingSong;
        this.level = level;
        this.speed = level.getBpm();
        this.delayTime = level.getIntroDelay();
        this.delayDone = false;
        this.player = new Player(this);
        this.isPaused = false;
        this.pauseMenu = null;
    }

    public void start() {
        this.setWalls(new StepManager(this));
        this.getWalls().generate();
        this.setCamera(new IsoCamera(this));
        this.player.start();
    }
    
    public void togglePause() {
		if (!this.isPaused) {
			this.isPaused = true;
			this.game.getCurrentSong().pause();
			this.pauseMenu = new PauseMenuScene(this.game, this);
			SceneManager.getInstance().addScene(this.pauseMenu);
		} else {
			this.isPaused = false;
			this.game.getCurrentSong().play();
			SceneManager.getInstance().removeScene(this.pauseMenu);;
			this.pauseMenu = null;
		}    	
    }

    public void update(long timeElapsed) {
    	if (!delayDone) {
    		delayTime -= timeElapsed;
    		if (delayTime < 0) {
    			delayDone = true;
    	    	this.getCamera().update(delayTime * -1);		
    		} else {
    			System.out.println(delayTime);
    		}
    	} else {
    		if (!this.isPaused) {
        		this.getCamera().update(timeElapsed);
                this.player.update(timeElapsed);
                WallCollision wc = this.walls.isColliding(this.player.getPosition(), this.player.getBoundingBox());
            	this.player.computeCollision(wc);    			
    		}
    	}
    	if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER) || KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.SPACE)) {
    		this.togglePause();
    	}
    	if (!this.playingSong.isPlaying()) {
    		// PRINT AND OF GAME SCREEN AND GO BACK TO MAIN MENU
    		SceneManager.getInstance().removeScene(this);
    	}
    }

    public void draw(Game parent) {

    	// THIS MAY BE NEED FOR BETTER BLUR ?
        parent.smooth();
        parent.background(0);
        this.getCamera().draw(parent);


//        parent.stroke(108, 91, 242);
        parent.stroke(48, 117, 232);
        parent.strokeWeight(0.15f);
        this.walls.draw(parent);
        this.player.draw(parent);
        parent.blur();
        
//        parent.stroke(68, 51, 202);
        parent.stroke(30, 73, 145);
        parent.strokeWeight(0.05f);
        this.walls.draw(parent);
        this.player.draw(parent);
     }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Configuration.Level getConfigurationLevel() {
        return level;
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
