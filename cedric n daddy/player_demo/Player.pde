class Player {
  float  _posX;
  float  _speed;
  float  _scale;
  float  _sizeX;
  float  _sizeY;
  String  _effect; //(enum)
  String  _effectList[] = {"NONE", "REVERSE", "ELASTIC"};
  float   _easing = 0.2;
  float   _targetX;
  float   _dx;
  
  Player() {
    
    _posX = width/2;
    _speed = 10.0f;
    _scale = 1;
    _sizeX = 50;
    _sizeY = 50;
    _effect = "ELASTIC";
     _targetX = width/2;
  }
  
  void update() {
    //_posX = mouseX;
    //_speed += 10.f;
    _dx = _targetX - _posX;
    if(abs(_dx) > 1) {
      _posX += _dx * _easing;
    }
  }
  
  void findMove(int direction) {
      if (canMove(direction) == false)
        return;
        //tableaau[_effect] ==>Appel bonne fonction move  }
        if (_effect == "NONE")
          movePlayer(direction);
         else if (_effect == "ELASTIC") {
          moveElastic(direction);
        }
        else if (_effect == "REVERSE") {
          moveReverse(direction);
        }
  }
  
  boolean  canMove(int direction) {
    if (_effect != "REVERSE" && direction == LEFT && (_targetX - (_sizeX * _scale / 2)) >= 0
      ||_effect != "REVERSE" && direction == RIGHT && (_targetX + (_sizeX * _scale / 2)) <= width
      || _effect == "REVERSE" && direction == RIGHT && (_targetX - (_sizeX * _scale / 2)) >= 0
      ||_effect == "REVERSE" && direction == LEFT && (_targetX + (_sizeX * _scale / 2)) <= width)
     return true;
    else
     return false;

  }
  
  void setEffect(String effect)
  {
     _effect = effect;
  }
  
  void moveElastic(int direction) {
    float    speed = 50.0f;
      if (direction == LEFT){
        _posX -= speed;
      }
      else if (direction == RIGHT) {
        _posX += speed;
      }   
  }
  void movePlayer(int direction) {
    float    speed = 10.0f;
    if (direction == LEFT){
        _targetX -= speed;
      }
      else if (direction == RIGHT) {
        _targetX += speed;
      }   
  }
  
  void moveReverse(int direction) {
    float    speed = 10.0f;
    if (direction == LEFT){
        _targetX += speed;
      }
      else if (direction == RIGHT) {
        _targetX -= speed;
      }   
  }
  
  void draw() {
     ellipse(_posX, 400, _sizeX * _scale, _sizeY * _scale);
  }
}
