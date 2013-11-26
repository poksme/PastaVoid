class Player {
  float  _posX;
  float  _speed;
  float  _scale;
  float  _sizeX;
  float  _sizeY;
  String  _effect; //(enum)
  String  _effectList[] = {"NONE", "REVERSE"};
  
  Player() {
    _posX = width/2;
    _speed = 1;
    _scale = 1;
    _sizeX = 50;
    _sizeY = 50;
    _effect = "NONE";
  }
  
  void update() {
    _posX = mouseX;
  }
  
  void move(int direction) {
        //tableaau[_effect] ==>Appel bonne fonction move  } 
        if (_effect == "NONE") {
          
        }
        else if (_effect == "REVERSE") {
          
        }
  }
  
  void setEffect(String effect)
  {
     _effect = effect;
  }
  
  void moveReverse(int direction) {
      if (direction == LEFT){
        //Verifie collision
      }
      else if (direction == RIGHT) {
        //Verifie collision
      }   
  }
  
  void draw() {
    ellipse(_posX, 400, _sizeX * _scale, _sizeY * _scale);
  }
}
