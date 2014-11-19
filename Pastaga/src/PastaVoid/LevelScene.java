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
    private StepManager walls;
    private float       speed;
    private Configuration.Level      level;
    private IsoCamera   camera;
    private int			delayTime;
    private boolean		delayDone;
    private	Player		player;
    private boolean		isPaused;
    //should be in GUIScene
    private PauseScene	pauseMenu;
    private AudioPlayer playingSong;
    private GuiScene	guiScene;
    private	ParticleSystemSimple particleSystemSimple;
//    private	ParticleSystemSmallBean	particleSystemSmallBean;
    
    public LevelScene(Game game, Configuration.Level level, AudioPlayer playingSong) {
    	super(game, true, true); // VISIBLE UPDTABLE
    	this.playingSong = playingSong;
        this.level = level;
        this.speed = level.getBpm();
        this.delayTime = level.getIntroDelay();
        this.delayDone = false;
        this.player = new Player(this, level.getPlayerSpeed());
        this.isPaused = false;
        this.pauseMenu = null;
        this.guiScene = null;
//        this.particleSystemSmallBean = new ParticleSystemSmallBean(this.game, this.game.width, this.game.height);
        this.particleSystemSimple = new ParticleSystemSimple(new PVector(400,520), this.game);
    }
        
    public void setPaused(boolean flag) {
    	isPaused = flag;
    }

    public void start() {
        this.setWalls(new StepManager(this));
        this.getWalls().generate();
        this.setCamera(new IsoCamera(this));
        this.player.start();
    }
    
    public void reset() {
    	delayTime = level.getIntroDelay();
    	this.playingSong.rewind();
    	this.delayDone = false;
    	this.player = new Player(this, level.getPlayerSpeed());
        this.setWalls(new StepManager(this));
        this.getWalls().generate();
        this.setCamera(new IsoCamera(this));
        this.player.start();
        guiScene = new GuiScene(game, this);
        SceneManager.getInstance().addScene(guiScene);
        }
    
    public void update(long timeElapsed) {
    	if (!delayDone) {
    		delayTime -= timeElapsed;
    		if (delayTime < 0) {
    			delayDone = true;
    	    	this.getCamera().update(delayTime * -1);		
    		} else {
//    			System.out.println(delayTime);
    		}
    	} else {
    		if (!this.isPaused) {
        		this.getCamera().update(timeElapsed);
                this.player.update(timeElapsed);
                this.walls.computeCollision(this.player);
                this.particleSystemSimple.run();
//                WallCollision wc = this.walls.isColliding(this.player.getPosition(), this.player.getBoundingBox());
//            	this.player.computeCollision(wc);    			
    		}
    	}
    	if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER) || KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.SPACE)) {
    		this.game.getCurrentSong().pause();
    		this.setUpdatable(false);
    		this.setDrawable(false);
    		guiScene.setDrawable(false);
    		guiScene.setUpdatable(false);
    		this.setPaused(true);
    		SceneManager.getInstance().addScene(new PauseScene(this.game, true, true, this));
    	}
    	if ((!this.playingSong.isPlaying() && !this.isPaused) || this.guiScene.barIsEmpty()) {
    		// PRINT AND OF GAME SCREEN AND GO BACK TO MAIN MENU
    		this.playingSong.pause();
    		SceneManager.getInstance().removeScene(this);
    		SceneManager.getInstance().removeScene(guiScene);
    		SceneManager.getInstance().addScene(new GameOverScene(guiScene.getPlayerScore(), this.game, true, true));
    	}
    }

    public boolean maxChain() {
    	return particleSystemSimple.maximumParticle();
    }
    
    public void draw(Game parent) {
		parent.colorMode(parent.RGB);
    	// THIS MAY BE NEED FOR BETTER BLUR ?
        parent.smooth();
        parent.background(0);


//        parent.stroke(108, 91, 242);
        parent.stroke(48, 117, 232);
        parent.strokeWeight(0.15f);
        this.getCamera().draw(parent);
        this.walls.draw(parent);
        this.player.draw(parent);
        this.particleSystemSimple.draw(parent);
        parent.blur();
        
//        parent.stroke(68, 51, 202);
        parent.stroke(30, 73, 145);
        parent.strokeWeight(0.05f);
        this.getCamera().draw(parent);
        this.walls.draw(parent);
        this.player.draw(parent);
        this.particleSystemSimple.draw(parent);
        
        //particleSystemSmallBean.draw(this.game, player._posX, true);
     }

    public void drawParticleSystem(){
    	//particleSystemSmallBean.draw(this.game, player._posX, true);
    	particleSystemSimple.createParticleSystem(this.game, player._posX * game.width - ((player._posX - 0.5f) * game.width/5));
    }
    
    public void resetParticleSystem(){
    	particleSystemSimple.resetParticleSystem();
    }
    
    public	void setGuiScene(GuiScene scene) {
    	guiScene = scene;
    }
    
    public	GuiScene getGuiScene() {
    	return guiScene;
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
