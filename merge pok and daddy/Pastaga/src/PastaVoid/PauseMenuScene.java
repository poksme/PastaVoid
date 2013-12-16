package PastaVoid;

import GameEngine.AScene;
import GameEngine.KeysManager;

public class PauseMenuScene extends AScene {

	private LevelScene		levelScene;
	private int				_currOption;
	private String[]		options;
	
	public PauseMenuScene(Game game, LevelScene levelScene) {
		super(game, true, true);
		this.levelScene = levelScene;
		this.options = new String[3];
		this.options[0] = "Resume";
		this.options[1] = "Restart";
		this.options[2] = "Exit";
	}

	@Override
	public void start() {
		
	}

	@Override
	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.DOWN)) {
			this._currOption++;
			if (_currOption >= this.options.length) {
				this._currOption = 0;
			}
		}
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.UP)) {
			this._currOption--;
			if (_currOption <= -1) {
				this._currOption = this.options.length - 1;
			}
		}
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER)
				|| KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.RIGHT)) {
			//ACTIVAAAATION
		}
	}
	
	private void	onResume() {
		
	}
	
	private void	onRestart() {
		
	}

	private void	onExitToMainMenu() {
		
	}
	
	private void		renderText(Game parent) {
		parent.strokeWeight(2);
		parent.textAlign(parent.CENTER);
				
		for (int i = 0; i < this.options.length; ++i) {
			if (i == this._currOption) {
				parent.fill(0, 255, 0);
			} else {
				parent.fill(255, 255, 255);
			}
//			parent.text(this.options[i]);
		}
	}
	
	@Override
	public void draw(Game parent) {
		parent.camera();
		
		this.renderText(parent);		
	}

}
