package PastaGame;

import processing.core.PApplet;
import processing.opengl.PShader;

public class Main extends PApplet {

    public static Main pApplet;
    Game game;
    public PShader      blur;

//    public static void main(String[] args) {
//    }

    public static void main(String args[]) {
        //PApplet.main(new String[] { "--present", "PastaGame.Main" });
        PApplet.main(new String[] { "PastaGame.Main" });
        }

    public void     setup(){
        pApplet = this;

        Main.pApplet.size(800, 600, Main.pApplet.P2D);

        //tmp
        this.blur = loadShader("./shaders/blur.glsl");


        this.game = new Game();
        this.game.start();
    }

    public void     draw() {
        this.game.update();
        this.game.draw();
    }
}
