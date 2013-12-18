package PastaVoid;

import processing.core.PImage;
import GameEngine.AScene;
import GameEngine.KeysManager;
import GameEngine.SceneManager;

public class PauseScene extends AScene {
	private int curElem;
	private LevelScene pausedLevel;
	private PImage pausePic;
	
	public PauseScene(Game game, boolean isUpdatable, boolean isDrawable, LevelScene pausedLevel) {
		super(game, isUpdatable, isDrawable);
		this.curElem = 0;
		this.pausedLevel = pausedLevel;
		this.pausePic = game.loadImage("pause.jpg");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.UP)) {
			curElem = ((curElem - 1) < 0) ? 2 : curElem - 1;
		} 
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.DOWN)) {
			curElem = (curElem + 1) % 3;
		}
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER) || KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.SPACE)) {
			if (curElem == 0) {
    		pausedLevel.setUpdatable(true);
    		pausedLevel.setDrawable(true);
    		pausedLevel.getGuiScene().setDrawable(true);
    		pausedLevel.getGuiScene().setUpdatable(true);
    		pausedLevel.setPaused(false);
    		SceneManager.getInstance().removeScene(this);
    		this.game.getCurrentSong().play();
			} else if (curElem == 1) {
				pausedLevel.reset();
	    		pausedLevel.setUpdatable(true);
	    		pausedLevel.setDrawable(true);
	    		pausedLevel.getGuiScene().setDrawable(true);
	    		pausedLevel.getGuiScene().setUpdatable(true);
	    		pausedLevel.setPaused(false);
	    		SceneManager.getInstance().removeScene(this);
	    		this.game.getCurrentSong().play();
			} else if (curElem == 2) {
				SceneManager.getInstance().removeScene(this);
				SceneManager.getInstance().removeScene(this.pausedLevel);
	    		SceneManager.getInstance().removeScene(this.pausedLevel.getGuiScene());
	    		SceneManager.getInstance().addScene(new MenuScene(this.game, this.game.getConfig()));
			}
		}
	}

	@Override
	public void draw(Game parent) {
		parent.camera();
		parent.textAlign(parent.CENTER);
		parent.image(pausePic, parent.width / 2 - 340, 60);
		parent.text("UP AND DOWN TO SELECT AND ENTER TO VALIDATE", parent.width / 2, parent.height + 500 , -1000);
		// TODO Auto-generated method stub
		
		parent.text("RESUME", parent.width / 2, parent.height / 2 + 40  - 80, 0);
		parent.text("RESTART", parent.width / 2, parent.height / 2 + 40, 0);
		parent.text("QUIT", parent.width / 2, parent.height / 2 + 40 + 80, 0);
		
		int trSize = 30;

	      int trY = parent.height / 2 - 80 + 80 * curElem;
	      int trX = 140;
	      parent.triangle(trX + 0, trY + 0, trX + 0, trY + trSize, trX + trSize / 2 , trY + trSize / 2);

	}

}
