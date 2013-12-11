package PastaVoid;

import GameEngine.KeysManager;
import GameEngine.AScene;

public class PlayerScene extends AScene {

	float  _posX;
	float  _scale = 1.f;
	float  _sizeX = 10.f;
	float  _sizeY = 0.5f;
	float  _speed = 1.f;
	int	   _widthScreen;
	LevelScene	_levelScene;
	  
	public PlayerScene(Game game, int widthScreen, LevelScene levelScene) {
		super(game, true, true);
		// TODO Auto-generated constructor stub
		_widthScreen = widthScreen;
	    _posX = 50;
	    _levelScene = levelScene;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			if (_posX > _sizeX/2 + 1.f)
				_posX -= _speed;
		}
		else if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.RIGHT) == true) {
			if (_posX < 100 - _sizeX/2  - 1.f)
			_posX += _speed;
		}
			
		
	}

	@Override
	public void draw(Game parent) {
		parent.ellipse(_posX, _levelScene.getCamera().getOffset() + 0.5f, _sizeX * _scale, _sizeY * _scale);
	}

}
