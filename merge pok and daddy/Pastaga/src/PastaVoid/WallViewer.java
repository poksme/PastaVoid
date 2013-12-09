package PastaVoid;

import processing.core.PVector;
import processing.core.PApplet;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */

//TODO: add a method to properly render lines that ends outside the bounds
public class WallViewer {

    private StepManager mwalls;
    private float       viewHeight;
    private float       viewWidth;
    private float       offset;
    private PVector     screenPosition;
    private int         sizeX;
    private int         sizeY;
    float               farPlane = 0.5f;
    float               nearPlane = 1.0f;
    float               isoPlanX;
    private TestScene   parent;
    private float stepPerMilliSec;

    public WallViewer(TestScene parent, StepManager walls, int sizeX, int sizeY) {
        this.parent = parent;
        this.mwalls = walls;
        this.viewHeight = 16.5f;
        this.viewWidth = this.mwalls.getSizeX();
        setScreenPosition(new PVector(0,0));
        this.offset = 0.0f;
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
        this.isoPlanX = this.viewWidth / 2;
        this.stepPerMilliSec = (parent.getSpeed() / 60.f) / 1000.f * 4.f;
        this.stepPerMilliSec = parent.getSpeed() * 4.f / 60.f / 1000.f;
    }


    public float getNViewedSteps() {
        return viewHeight;
    }

    public void setNViewedSteps(float nViewedWalls) {
        this.viewHeight = nViewedWalls;
    }

    public void     update(long elapsedTime) {
        this.offset += this.stepPerMilliSec * elapsedTime;
    }

    public PVector  worldPointToScreenPoint(PVector wpoint) {
        PVector   spoint = new PVector(wpoint.x, this.viewHeight - wpoint.y);
        return spoint;
    }

    private void    _drawLine(PApplet parent, float startX, float startY, float endX, float endY) {
        parent.line(startX - this.mwalls.getSizeX() / 2, -startY, 0.0f, endX - this.mwalls.getSizeX() / 2, -endY, 0.0f);
    }

    public void     drawLineInScreenPoint(PApplet parent, float x, float y, float x1, float y1) {
        PVector start = this.worldPointToScreenPoint(new PVector(x, y));
        PVector end = this.worldPointToScreenPoint(new PVector(x1, y1));
        this._drawLine(parent, start.x, start.y, end.x, end.y);
    }

    private void    _drawStep(PApplet parent, Step step, float posy) {
        if (!step.isWall) {
            return;
        }
        //for now draw a wall with only one hole
        this.drawLineInScreenPoint(parent, 0, posy, step.x - step.holeSize / 2, posy);
        this.drawLineInScreenPoint(parent, step.x + step.holeSize / 2, posy, this.mwalls.getSizeX(), posy);
    }

    public void     draw(PApplet parent) {
        Step[] walls = this.mwalls.getWalls();
        for (int i = 0; i < walls.length; ++i) {
            float posy = walls[i].y - this.offset;
            if (posy < this.viewHeight && posy > 0) {
                this._drawStep(parent, walls[i], this.viewHeight - posy);
            }
        }
        this.drawLineInScreenPoint(parent, 0, 0, 0, this.viewHeight);
        this.drawLineInScreenPoint(parent, this.mwalls.getSizeX(), 0, this.mwalls.getSizeX(), this.viewHeight);
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public PVector getScreenPosition() {
        return screenPosition;
    }

    public void setScreenPosition(PVector screenPosition) {
        this.screenPosition = screenPosition;
    }
}
