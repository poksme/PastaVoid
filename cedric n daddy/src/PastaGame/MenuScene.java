package PastaGame;

import GameEngine.IScene;
import PastaGame.GameScene;
import PastaGame.Main;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/18/13
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuScene implements IScene {

    private boolean     updated = true;
    private boolean     drawn = true;

    @Override
    public void start() {

    }

    @Override
    public void update() {
        if (Main.pApplet.keyPressed && Main.pApplet.key == 'a') {
            GameScene.loadGameScene();
            Main.pApplet.game.getSceneManager().removeScene(this);
        }
    }

    @Override
    public void draw() {
        Main.pApplet.background(255);
        Main.pApplet.line(0, 0, 500, 500);
    }

    @Override
    public boolean isDrawn() {
        return this.updated;
    }

    @Override
    public boolean isUpdated() {
        return this.drawn;
    }

    @Override
    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    @Override
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
