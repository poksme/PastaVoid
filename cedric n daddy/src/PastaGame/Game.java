package PastaGame;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */

import Config.Config;
import GameEngine.SceneManager;
import GameEngine.StopWatch;
import ddf.minim.*;

public class Game {

    private SceneManager    sceneManager;
    private StopWatch       watch;
    private Config          config;
    Minim                   minim;
    AudioPlayer             player;

    void    start() {
        this.sceneManager = new SceneManager();
        this.getSceneManager().start();
        this.watch = new StopWatch();
        this.watch.start();
//        this.getSceneManager().addScene(new MenuScene());
        //create Gamescene
        //create GUiGameScene (Gamescene)

        config = new Config(Main.pApplet.loadJSONObject("config.json"));
        this.getSceneManager().addScene(new TestScene(config));

        minim = new Minim(Main.pApplet);
        player = minim.loadFile("music" + java.io.File.separator + config.getLevels().get(0).getMusicPath());
        //player.play();
        Main.pApplet.println(config);
    }

    public long getElapsedTime() {
        return this.watch.getElapsedTime();
    }


    void    update() {
        this.getSceneManager().update();
    }

    void    draw() {
        this.watch.start();
        this.getSceneManager().draw();
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
