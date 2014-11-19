package PastaVoid;

import processing.core.PImage;
import GameEngine.AScene;
import GameEngine.SceneManager;
import Configuration.Config;

public class SecretScene extends AScene {

	private	float		duration;
	private float		_currentTime;
	private	Config		_config;
	private boolean		_done;
	private PImage		_logo;
	
	
	public SecretScene(Game game, Config config) {
		super(game, true, true);
		this.duration = 3.0f;
		this._currentTime = 0.0f;
		this._config = config;
		this._done = false;
		this._logo = game.loadImage("PastagaMeLogo.png");
	}

	@Override
	public void start() {
		
	}

	@Override
	public void update(long elapsedTime) {
		this._currentTime += elapsedTime;
		if (this._currentTime >= this.duration * 1000 && !this._done) {
			SceneManager.getInstance().addScene(new MenuScene(this.game, this._config));
			SceneManager.getInstance().removeScene(this);
			this._done = true;
		}
	}

	@Override
	public void draw(Game parent) {
		if (!this._done) {
			parent.background(255);
			parent.camera();
			parent.image(this._logo, parent.width / 2 - 547 / 2, parent.height / 2 - 547 / 2);
		}
	}

}
