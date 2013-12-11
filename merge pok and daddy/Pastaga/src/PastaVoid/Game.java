package PastaVoid;

import java.util.ArrayList;

import processing.core.*;
import ddf.minim.*;
import GameEngine.KeysManager;
import GameEngine.StopWatch;
import Configuration.Config;
import GameEngine.SceneManager;
import processing.opengl.PShader;
import processing.core.*;
import processing.opengl.*;
import processing.event.KeyEvent;

public class Game extends PApplet {
    private SceneManager    sceneManager;
    private StopWatch		watch;
    private Minim			minim;
    private ArrayList<AudioPlayer>		songPlayer;
    private Config      	config;
    private PFont			font;
    public 	PShader      	blur;

    public static void main(String args[]) {
//        PApplet.main(new String[] { "--present", "PastaVoid.Game" });
    	PApplet.main(new String[] { "PastaVoid.Game" });
      }
    
    public ArrayList<AudioPlayer> getSongPlayer() {
    	return songPlayer;
    }
    
    public Minim getMinim() {
    	return minim;
    }
    
    public void setup() {
        size(800, 600, P3D);
        background(0);
        
        // FONT
        this.font = this.loadFont("fonts" + java.io.File.separator + "Orbitron-Light-48.vlw");
        this.textFont(this.font, 48);

      	// MUSIC PLAYER
      	this.minim = new Minim(this);
      	this.songPlayer = new ArrayList<AudioPlayer>();
//        this.player = minim.loadFile("music" + java.io.File.separator + "defiant_order.mp3");// config.getLevels().get(0).getMusicPath());

        
        // CONF
        this.config = new Config(this);
        this.println(config);

        this.sceneManager = SceneManager.getInstance();
        
        LevelScene tmpLevelScene = new LevelScene(this, config);
        this.sceneManager.addScene(tmpLevelScene);
        this.sceneManager.addScene(new PlayerScene(this, Game.WIDTH, tmpLevelScene));
        this.sceneManager.addScene(new MenuScene(this, config));

        // SHADER
        this.blur = loadShader("shaders/sepBlur.glsl");
        

        this.watch = new StopWatch();
        
        // START WATCH IN THE SETUP
//        this.watch.start();
        
<<<<<<< HEAD
=======
        
//        this.player.play();
>>>>>>> e0e29e7a279ed2118e1995a9d4b83decdc055802

        this.sceneManager.start();
    }
    
    public void blur() {
    	this.blur.set("blurSize", 6);
        this.blur.set("sigma", 6.0f);
        this.blur.set("horizontalPass", 1);
        this.filter(this.blur);       
        this.blur.set("horizontalPass", 0);
        this.filter(this.blur);
    }
    
    public void keyPressed(KeyEvent event) {
    	KeysManager.getInstance().setPressed(event.getKeyCode());
    }
    
    public void keyReleased(KeyEvent event) {
    	KeysManager.getInstance().setReleased(event.getKeyCode());
    }
    
    public void draw() {
    	fill(255, 255, 255);
    	KeysManager.getInstance().update();
        sceneManager.update(this.watch.getElapsedTime());
        this.watch.start();
        sceneManager.draw(this);
    }		
}