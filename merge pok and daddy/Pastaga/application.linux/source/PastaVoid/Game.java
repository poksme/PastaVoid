package PastaVoid;

import processing.core.*;
import ddf.minim.*;
import GameEngine.StopWatch;
import Configuration.Config;
import GameEngine.SceneManager;

public class Game extends PApplet {

    private SceneManager    sceneManager;
    private StopWatch	watch;
    private Minim		minim;
    private AudioPlayer	player;
    private Config      config;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "PastaVoid.Game" });
      }
    
    public void setup() {
        size(800, 600);
        background(255);
        

        // CONF
        this.config = new Config(this);
        this.println(config);

        this.sceneManager = new SceneManager();
        this.sceneManager.addScene(new TestScene(config));

      
      	// MUSIC PLAYER
      	this.minim = new Minim(this);
        this.player = minim.loadFile("music" + java.io.File.separator + "defiant_order.mp3");// config.getLevels().get(0).getMusicPath());

        this.watch = new StopWatch();
        this.player.play();

        this.sceneManager.start();
    }
    
    public void draw() {
        sceneManager.update(this.watch.getElapsedTime());
        this.watch.start();
        sceneManager.draw(this);
    }		
}