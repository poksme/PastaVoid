package PastaVoid;

import processing.core.*;
import ddf.minim.*;
import Tools.StopWatch;

public class Game extends PApplet {

//    private SceneManager    sceneManager;
    private StopWatch       watch;
//    private Config          config;
    Minim                   minim;
    AudioPlayer             player;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "PastaVoid.Game" });
      }

    public void setup() {
        this.watch = new StopWatch();

        this.size(800, 600);

//        this.sceneManager = new SceneManager();
//        this.getSceneManager().start();
        
//        this.config = new Config(Main.pApplet.loadJSONObject("config.json"));
//        this.getSceneManager().addScene(new TestScene(config));

        this.minim = new Minim(this);
        this.player = minim.loadFile("music" + java.io.File.separator + "defiant_order.mp3");// config.getLevels().get(0).getMusicPath());
        this.player.play();
//        this.println(config);
    }
    
    public void draw() {
//        this.getSceneManager().update(this.watch.getElapsedTime());
        this.watch.start();
//        this.getSceneManager().draw();
    }		
}