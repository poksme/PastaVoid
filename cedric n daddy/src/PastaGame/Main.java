package PastaGame;

import processing.core.PApplet;

public class Main extends PApplet {

    public static Main pApplet;
    Game game;

//    public static void main(String[] args) {
//    }

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "PastaGame.Main" });
    }

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
