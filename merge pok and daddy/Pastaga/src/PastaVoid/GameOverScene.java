package PastaVoid;

import processing.core.PImage;
import GameEngine.AScene;
import GameEngine.KeysManager;
import GameEngine.SceneManager;

public class GameOverScene extends AScene {

	private int score;
	private PImage gameOver;
	private float posZ;
	private float totalElapsedTime;
	
	public GameOverScene(int score, Game game, boolean isUpdatable, boolean isDrawable) {
		super(game, isUpdatable, isDrawable);
		this.score = score;
		this.gameOver = game.loadImage("gameover.jpg");
		this.posZ = 0;
		this.totalElapsedTime = 0;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		totalElapsedTime += elapsedTime;
		posZ = game.cos(totalElapsedTime / 1000) * 10.f;
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER) || KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.SPACE)) {
			SceneManager.getInstance().removeScene(this);
			SceneManager.getInstance().addScene(new MenuScene(this.game, this.game.getConfig()));
		}
	}

	@Override
	public void draw(Game parent) {
		// TODO Auto-generated method stub
		parent.camera();
      parent.textAlign(parent.CENTER);
		parent.image(gameOver, parent.width / 2 - 326, 65);
      parent.fill(255);
      parent.text("SCORE\n" + score, parent.width / 2, parent.height / 2 , posZ);
		parent.text("PRESS START OR SPACE TO CONTINUE", parent.width / 2, parent.height + 500 , -1000);
	}

}
