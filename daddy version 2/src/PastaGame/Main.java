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

    public static void blur() {
        Main.pApplet.blur.set("blurSize", 9);
        Main.pApplet.blur.set("sigma", 6.0f);
        Main.pApplet.blur.set("horizontalPass", 0);
        Main.pApplet.filter(Main.pApplet.blur);
        Main.pApplet.blur.set("horizontalPass", 1);
        Main.pApplet.filter(Main.pApplet.blur);
    }

    public void     setup(){
        pApplet = this;

        Main.pApplet.size(800, 600, Main.pApplet.P3D);

        this.blur = loadShader("shaders/sepBlur.glsl");

        this.game = new Game();
        this.game.start();
    }

    public void     draw() {
        this.game.update();
        this.game.draw();
    }
}
