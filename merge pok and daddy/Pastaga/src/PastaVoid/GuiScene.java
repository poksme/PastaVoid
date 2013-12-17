package PastaVoid;

import GameEngine.AScene;
import GameEngine.KeysManager;

public class GuiScene extends AScene{

	LevelScene		_levelScene;
	float			_life;
	float			_gaugeMaxHeight;
	float			_gaugeHeight;
	float			_steps;
	float			_doors;
	float			_hit;
	
	public GuiScene(Game game, LevelScene levelScene) {
		super(game, true, true);
		_levelScene = levelScene;
		_life = 0.5f;
		_gaugeHeight = 500.0f;
		_gaugeMaxHeight = 500;
		_steps = _levelScene.getConfigurationLevel().getBarNumber() * 16;
		_levelScene.setGuiScene(this);
		for (int i = 0; i < _steps; i++) {
            if (_levelScene.getConfigurationLevel().hasDoor(i)) 
            	_doors++; 
        }
		_hit = _gaugeMaxHeight / _doors;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		//if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			//if (_gaugeHeight > 0)
				//_gaugeHeight -= _hit;
		//}
	}

	@Override
	public void draw(Game parent) {
		parent.camera();
		parent.fill(42, 124, 214);
		parent.stroke(255);
		parent.strokeWeight(3);
		parent.rect(20, 20, 40, _gaugeMaxHeight);
		parent.fill(0);
		parent.strokeWeight(0);
		parent.rect(20, 20, 40, _gaugeHeight);
		// COMMENTED BECAUSE A PRINT AT EACH DRAW SLOW DOWN MY COMPUTER
		parent.println(_hit);
		parent.println(_doors);
		parent.println(_steps);
		// TODO Auto-generated method stub
	}
	
	public void playerTouched() {
		if (_gaugeHeight > 0)
			_gaugeHeight += _hit;
	}
	
	public void playerPass() {
		if (_gaugeHeight > 0)
			_gaugeHeight -= _hit;
	}
}
