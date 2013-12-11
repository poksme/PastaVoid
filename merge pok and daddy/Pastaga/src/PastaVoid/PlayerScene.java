package PastaVoid;

import GameEngine.KeysManager;
import GameEngine.AScene;

public class PlayerScene extends AScene {

	float  _posX;
	float  _scale;
	float  _sizeX = 50;
	float  _sizeY = 50;
	float  _speed = 10.0f;
	int	_widthScreen;
	  
	public PlayerScene(Game game, int widthScreen) {
		super(game, true, true);
		// TODO Auto-generated constructor stub
		
		_widthScreen = widthScreen;
	    _posX = _widthScreen/2;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			_posX += _speed;
		}
		else if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			_posX -= _speed;
		}
			
		
	}

	@Override
	public void draw(Game parent) {
		parent.ellipse(_posX, 400, _sizeX * _scale, _sizeY * _scale);
	}

}
