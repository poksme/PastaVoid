package PastaVoid;

import GameEngine.KeysManager;
import GameEngine.AScene;

public class PlayerScene extends AScene {

	float  _posX;
	float  _scale = 1.f;
	float  _sizeX = 0.075f;
	float  _speed = 0.007f / 20f;
	int	   _widthScreen;
	float  _yDeg = 45.f;
	LevelScene	_levelScene;
	  
	public PlayerScene(Game game, int widthScreen, LevelScene levelScene) {
		super(game, true, true);
		// TODO Auto-generated constructor stub
		_widthScreen = widthScreen;
	    _posX = 0.5f;
	    _levelScene = levelScene;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	// DON'T FORGET  TO USE ELAPSEDTIME ON UPDATES
	@Override
	public void update(long elapsedTime) {
		_yDeg+= (2.f / 20f) * elapsedTime;
		if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			if (_posX > _sizeX / 2)
				_posX -= _speed * elapsedTime;
		}
		else if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.RIGHT) == true) {
			if (_posX < 1.f - _sizeX / 2)
			_posX += _speed * elapsedTime;
		}
	}

	@Override
	public void draw(Game parent) {
		//parent.ellipse(_posX, _levelScene.getCamera().getOffset() + 0.5f, _sizeX * _scale, _sizeY * _scale);
		parent.pushMatrix();
		parent.stroke(255);
		parent.noFill();
		parent.translate(_posX, _levelScene.getCamera().getOffset() + 0.5f, 0.f);
		
		
		parent.rotateX(parent.radians(67.f));
		parent.rotateY(parent.radians(_yDeg));
		
		parent.box(_sizeX, _sizeX * 4f, _sizeX);
		parent.popMatrix();
	}

}
