Player player;

public void setup(){
  frameRate(30);
  registerMethod("keyEvent", this);  //keyboad handler
  size(800, 480);
  smooth();
  player = new Player();
}

public void keyEvent(KeyEvent e)
 {
  if (key == CODED) {
       switch(keyCode) {
          case UP:
          
             break;
          case LEFT:
          player.findMove(LEFT);
            break;
          case RIGHT:
          player.findMove(RIGHT);
           break;
      }
  }
  else {
        switch(e.getKeyCode()) {
          case ' ':    // spacebar
                 
                  break;                 

      }
  }
}   

void keyReleased() {
  if (player._effect == "ELASTIC") {
    player._targetX = width/2;
  }
}

public void draw() {
  background(255);
  player.draw();
  player.update();
}
