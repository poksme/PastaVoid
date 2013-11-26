import processing.core.PApplet;

public class PastaVoid extends PApplet {

    public static   PastaVoid   pApplet;
    Game            game;

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
