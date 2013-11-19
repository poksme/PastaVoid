import processing.core.PVector;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class WallViewer {

    private     Walls   mwalls;
    private int     nViewedWalls;
    private int     offset;
    private PVector position;
    private float   speed;
    private int     sizeX;
    private int     sizeY;

    public WallViewer(Walls walls, int sizeX, int sizeY) {
        this.mwalls = walls;
        this.nViewedWalls = 4;
        this.setPosition(new PVector(0,0));
        this.offset = 0;
        this.speed = 10.0f;
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
    }


    public int getNViewedWalls() {
        return nViewedWalls;
    }

    public void setNViewedWalls(int nViewedWalls) {
        this.nViewedWalls = nViewedWalls;
    }

    public void     update() {

    }

    public void     draw() {

    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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
}
