package PastaGame;

import Config.Config;
import GameEngine.IScene;
import processing.core.PVector;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/21/13
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */

public class TestScene implements IScene {

    private boolean     updated = true;
    private boolean     drawn = true;
    private StepManager walls;
    private WallViewer  viewer;
    private float       speed;
    private Config      config;
    private IsoCamera   camera;

    public TestScene(Config config) {
        this.config = config;
        this.speed = config.getLevels().get(0).getBpm();
    }

    @Override
    public void start() {
        this.walls = new StepManager(this);
        this.walls.generate();
        this.viewer = new WallViewer(this, this.walls, 500, 500);
        this.viewer.setScreenPosition(new PVector(100, 0));
        this.viewer.setSizeX(600);
        this.viewer.setSizeY(600);
        this.camera = new IsoCamera();
    }

    @Override
    public void update() {
        this.viewer.update();
    }

    @Override
    public void draw() {

        Main.pApplet.smooth();
        Main.pApplet.background(0);
        this.camera.draw();
//        Main.pApplet.stroke(29, 27, 130);
//        Main.pApplet.resetMatrix();
        Main.pApplet.stroke(29, 27, 130);
        Main.pApplet.strokeWeight(15);
        this.viewer.draw();
        Main.pApplet.blur();

        Main.pApplet.stroke(100, 100, 250);
        Main.pApplet.strokeWeight(3);
        this.viewer.draw();
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Config getConfig() {
        return config;
    }
}
