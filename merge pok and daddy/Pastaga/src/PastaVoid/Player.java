package PastaVoid;

import processing.core.PVector;
import GameEngine.Color;
import GameEngine.KeysManager;

public class Player {

	float  _posX;
	float  _scale = 1.f;
	float  _sizeX = 0.075f;
	float  _speed;// = 0.07f / 100f;//0.010f;
	//int	   _widthScreen;
	float  _yDeg = 45.f;
	LevelScene	_levelScene;
	PVector		_boundingBox;
	Color		_color;
	private boolean		_playerColliding;
	  
//	public Player(Game game, int widthScreen, LevelScene levelScene) {
//		super(game, true, true);
//		// TODO Auto-generated constructor stub
//		//_widthScreen = widthScreen;
//	    _posX = 0.5f;
//	    _levelScene = levelScene;
//	}
	public Player(LevelScene levelScene, float playerSpeed) {
		// TODO Auto-generated constructor stub
		//_widthScreen = widthScreen;
		_speed = playerSpeed;
	    _posX = 0.5f;
	    _levelScene = levelScene;
	    float bboxScale = 0.7f;
	    _boundingBox = new PVector(_sizeX * bboxScale, _sizeX * 4f * bboxScale);
	    _color = new Color(255, 255, 255);
	    setIsPlayerColliding(false);
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	// DON'T FORGET  TO USE ELAPSEDTIME ON UPDATES
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

	public void	onPassedStep() {
//		System.out.println("Successfully passed a step!");
		_levelScene.getGuiScene().playerPass();
		/*_color.red = 0;
		_color.green = 255;
		_color.blue = 0;*/
		_levelScene.drawParticleSystem();
	}
	
	public void	onStartCollision() {
		this._playerColliding = true;
		_color.red = 255;
		_color.green = 0;
		_color.blue = 0;
		_levelScene.getGuiScene().playerTouched();
	}
	
	public void	onColliding() {
		
	}
	
	public void	onEndCollision() {
		this._playerColliding = false;
		_color.red = 255;
		_color.green = 255;
		_color.blue = 255;		
	}
	
//	public void	computeCollision(WallCollision wc) {
//		boolean n_playerColliding = (wc != null);
//		if (n_playerColliding && is_playerColliding() == false) {
//			onStartCollision();
//		} else if (!n_playerColliding && is_playerColliding() == true) {
//			onEndCollision();
//		} else if (n_playerColliding && is_playerColliding() == true) {
//			onColliding();
//		} else {
//			//nothing lol
//		}
//		set_playerColliding(n_playerColliding);
//	}

	public void draw(Game parent) {
		//parent.ellipse(_posX, _levelScene.getCamera().getOffset() + 0.5f, _sizeX * _scale, _sizeY * _scale);
		parent.pushMatrix();
		parent.translate(_posX, _levelScene.getCamera().getOffset() + 0.5f, 0.f);
		
		float rotateSpeed = 2.0f;
		parent.rotateX(parent.radians(67.f));
		parent.rotateY(parent.radians(_yDeg) * rotateSpeed);
		
		parent.stroke(_color.red, _color.green, _color.blue);
		parent.strokeWeight(0.05f);
		parent.noFill();
		parent.color(_color.red, _color.green, _color.blue);
		parent.box(_sizeX, _sizeX * 4f, _sizeX);
		parent.popMatrix();
	}

	public PVector		getPosition() {
		return new PVector(_posX, _levelScene.getCamera().getOffset() + 0.5f);
	}

	public PVector getBoundingBox() {
		return _boundingBox;
	}

	public boolean isPlayerColliding() {
		return _playerColliding;
	}

	public void setIsPlayerColliding(boolean _playerColliding) {
		this._playerColliding = _playerColliding;
	}
}
