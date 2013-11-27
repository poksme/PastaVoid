package PastaGame;

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

    public TestScene(float speed) {
        this.speed = speed;
    }

    @Override
    public void start() {
        this.walls = new StepManager();
        this.walls.generate();
        this.viewer = new WallViewer(this, this.walls, 500, 500);
        this.viewer.setScreenPosition(new PVector(100, 0));
        this.viewer.setSizeX(600);
        this.viewer.setSizeY(600);
    }

    @Override
    public void update() {
        this.viewer.update();
    }

    @Override
    public void draw() {
        Main.pApplet.background(255);
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
}
