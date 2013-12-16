package PastaVoid;

import processing.core.PVector;
import GameEngine.KeysManager;
import GameEngine.AScene;

public class Player {

	float  _posX;
	float  _scale = 1.f;
	float  _sizeX = 0.075f;
	float  _speed = 0.007f;
	//int	   _widthScreen;
	float  _yDeg = 45.f;
	LevelScene	_levelScene;
	private PVector		_boundingBox;
	  
//	public Player(Game game, int widthScreen, LevelScene levelScene) {
//		super(game, true, true);
//		// TODO Auto-generated constructor stub
//		//_widthScreen = widthScreen;
//	    _posX = 0.5f;
//	    _levelScene = levelScene;
//	}
	public Player(LevelScene levelScene) {
		// TODO Auto-generated constructor stub
		//_widthScreen = widthScreen;
	    _posX = 0.5f;
	    _levelScene = levelScene;
	    this._boundingBox = new PVector(_sizeX, _sizeX * 4f);
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void update(long elapsedTime) {
		_yDeg+=2.f;
		if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.LEFT) == true) {
			if (_posX > _sizeX/2)
				_posX -= _speed;
		}
		else if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.RIGHT) == true) {
			if (_posX < 1.f - _sizeX/2)
			_posX += _speed;
		}
	}

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

	public PVector		getPosition() {
		return new PVector(_posX, _levelScene.getCamera().getOffset() + 0.5f);
	}

	public PVector getBoundingBox() {
		return _boundingBox;
	}
}
