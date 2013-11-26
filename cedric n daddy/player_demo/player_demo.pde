Player player;

public void setup(){
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
          player.move(LEFT);
            break;
          case RIGHT:
           player._posX += player._speed;
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

public void draw() {
  background(255);
  player.draw();
  player.update();
}
