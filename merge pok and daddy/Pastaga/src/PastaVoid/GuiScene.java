package PastaVoid;

import processing.core.PImage;
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
	int				_scoring;
	int				_playerScore;
	private PImage 	_healthBar;
	
	public GuiScene(Game game, LevelScene levelScene) {
		super(game, true, true);
		_levelScene = levelScene;
		_life = 0.5f;
		_gaugeHeight = 400.0f;
		_gaugeMaxHeight = 500.f;
		_scoring = 100;
		_playerScore = 0;
		_steps = _levelScene.getConfigurationLevel().getBarNumber() * 16;
		_levelScene.setGuiScene(this);
		_healthBar = game.loadImage("HealthBar.png");
		for (int i = 0; i < _steps; i++) {
            if (_levelScene.getConfigurationLevel().hasDoor(i)) 
            	_doors++; 
        }
		_hit = (_gaugeMaxHeight / _doors) * 3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long elapsedTime) {

	}

	@Override
	public void draw(Game parent) {
		parent.camera();
		parent.image(_healthBar, 
					20, 20 + _gaugeHeight, 	50, _gaugeMaxHeight - _gaugeHeight,
					0, (int)(_gaugeHeight), 50, (int)(_gaugeMaxHeight));
	}
	
	public void playerTouched() {
		if (_gaugeHeight <= _gaugeMaxHeight)
			_gaugeHeight += _hit * 10;
	}
	
	public void playerPass() {
		if (_gaugeHeight >= 0)
			_gaugeHeight -= _hit;
		_playerScore += _scoring;
	}
	
	public	int	getPlayerScore() {
		return _playerScore;
	}
	
	public boolean barIsEmpty() {
		return (_gaugeHeight >= _gaugeMaxHeight);
	}
}
