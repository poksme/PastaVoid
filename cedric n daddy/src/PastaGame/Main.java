package PastaGame;

import processing.core.PApplet;

public class Main extends PApplet {

    public static Main pApplet;
    Game game;

    public void     setup(){
        pApplet = this;
        this.game = new Game();
        this.game.start();
    }

    public void     draw() {
        this.game.update();
        this.game.draw();
    }
}
