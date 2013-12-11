package PastaVoid;

import processing.core.PApplet;
import processing.core.PVector;

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

    public WallViewer(float bpm, StepManager walls, int sizeX, int sizeY) {
        this.parent = parent;
        this.mwalls = walls;
        this.viewHeight = 16.5f;
        this.viewWidth = this.mwalls.getSizeX();
        setScreenPosition(new PVector(0,0));
        this.offset = -1.f;
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
        this.isoPlanX = this.viewWidth / 2;
        this.stepPerMilliSec = bpm * 4.f / 60.f / 1000.f;

    }


    public float getNViewedSteps() {
        return viewHeight;
    }

    public void setNViewedSteps(float nViewedWalls) {
        this.viewHeight = nViewedWalls;
    }

    public void     update(long elapsedTime) {
        //Main.pApplet.println(this.stepPerMilliSec * Main.pApplet.game.getElapsedTime());
        this.offset += this.stepPerMilliSec * elapsedTime;
        //this.offset += speed* frameCount;
    }

    public PVector  worldPointToScreenPoint(PVector wpoint) {
        PVector   spoint = new PVector(wpoint.x, this.viewHeight - wpoint.y);

        //apply isometric method
        float range = 1.0f - this.farPlane;
        float dist = spoint.y / this.viewHeight;
        range = farPlane + (dist * (this.nearPlane - this.farPlane));
        spoint.x = this.isoPlanX - (this.isoPlanX - spoint.x) * (range);

//        //move it to the iso bounds
        //here switch size and some value
        float   xCoeff = this.sizeX / this.viewWidth;
        float   yCoeff = this.sizeY / this.viewHeight;
        spoint.x *= xCoeff;
        spoint.y *= yCoeff;
        spoint.x += this.screenPosition.x;
        spoint.y += this.screenPosition.y;
        return spoint;
    }

    public void     drawLineInScreenPoint(PApplet parent, float x, float y, float x1, float y1) {
//        System.out.printf("%f %f %f %f\n", x, y, x1, y1);
        PVector start = this.worldPointToScreenPoint(new PVector(x, y));
        PVector end = this.worldPointToScreenPoint(new PVector(x1, y1));
        parent.line(start.x, start.y, end.x, end.y);
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
        parent.rect( this.screenPosition.x, this.screenPosition.y,
                this.sizeX, this.sizeY);
        Step[] walls = this.mwalls.getWalls();
        for (int i = 0; i < walls.length; ++i) {
            float posy = walls[i].y - this.offset;
            if (posy < this.viewHeight && posy > 0) {
                this._drawStep(parent, walls[i], posy);
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