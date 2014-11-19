package PastaVoid;

import processing.core.PVector;
import GameEngine.Color;
import GameEngine.KeysManager;

public class Player {
	
	public enum PlayerState {
		NORMAL,
		COLLIDING,
		IMMUNE
	}

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
	private int			_immuneSteps;
	private int			_immuneStepNumber;
	private int			_alphabyStep;
	private int			_startAlpha;
	private boolean		_immuneCollision;
	private PlayerState	_state;

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
	    _boundingBox = new PVector(0.1f, 0.8f);
	    _color = new Color(255, 255, 255);
	    setIsPlayerColliding(false);
	    this._alphabyStep = 50;
	    this._immuneStepNumber = 7;
	    this._immuneSteps = 0;
	    this._startAlpha = 50;
	    this._alphabyStep = (255 - 50) / this._immuneStepNumber;
	    this._immuneCollision = false;
	    this._state = PlayerState.NORMAL;
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
		if (this._state == PlayerState.IMMUNE) {
			this._immuneSteps--;			
			if (this._immuneSteps == 0) {
				this._state = PlayerState.NORMAL;
			}
		}
//		_color.alpha += this._alphabyStep;
//		if (this._immuneSteps == 0) {
//			this._color.red = 255;
//			this._color.green = 255;
//			this._color.blue = 255;
//			_color.alpha = 255;
//		}
	}
	
	public void	onPassedWall() {
//		System.out.println("Successfully passed a step!");
		_levelScene.getGuiScene().playerPass();
		_levelScene.drawParticleSystem();
	}
	
	public void	onStartCollision() {
		this._playerColliding = true;
		if (this._state == PlayerState.NORMAL) {
			this._state = PlayerState.COLLIDING;			
			_levelScene.getGuiScene().playerTouched();
			_levelScene.resetParticleSystem();
		}
//		this._playerColliding = true;
//		if (this._immuneSteps > 0) {
//			_levelScene.resetParticleSystem();
//			return;
//		}
//		_color.red = 255;
//		_color.green = 0;
//		_color.blue = 0;
//		_color.alpha = 255;
//		_levelScene.getGuiScene().playerTouched();
//		_levelScene.resetParticleSystem();
//		//becomes immune
//		this._immuneSteps = this._immuneStepNumber;
//		this._immuneCollision = true;
	}
	
	public void	onColliding() {
		
	}
	
	public void	onEndCollision() {
		this._playerColliding = false;
		if (this._state == PlayerState.COLLIDING) {
			this._state = PlayerState.IMMUNE;
			this._immuneSteps = this._immuneStepNumber;
		}
//		_color.red = 255;
//		_color.green = 255;
//		_color.blue = 255;	
//		_color.alpha = 255;
//		if (this._immuneCollision) {
//			_color.red = 255;
//			_color.green = 255;
//			_color.blue = 255;
//			_color.alpha = 50;
//			this._immuneCollision = false;
//		}
//		if (this._immuneSteps == this._immuneStepNumber) {
//			_color.red = 255;
//			_color.green = 255;
//			_color.blue = 255;		
//			_color.alpha = 50;
//		}
	}

	public void draw(Game parent) {
		//parent.ellipse(_posX, _levelScene.getCamera().getOffset() + 0.5f, _sizeX * _scale, _sizeY * _scale);
		parent.pushMatrix();
		parent.translate(_posX, _levelScene.getCamera().getOffset() + 0.5f, 0.f);
		
		float rotateSpeed = 2.0f;
		parent.rotateX(parent.radians(67.f));
		parent.rotateY(parent.radians(_yDeg) * rotateSpeed);
		
		if (this._state == PlayerState.NORMAL) {
			parent.stroke(255, 255, 255, 255);
		} else if (this._state == PlayerState.COLLIDING) {			
			parent.stroke(255, 0, 0, 255);
		} else if (this._state == PlayerState.IMMUNE) {
			parent.stroke(255, 255, 255, 255 - ((255 - this._startAlpha) / this._immuneStepNumber) * this._immuneSteps);
		}
		parent.strokeWeight(0.05f);
		parent.noFill();
		parent.color(_color.red, _color.green, _color.blue, _color.alpha);
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
