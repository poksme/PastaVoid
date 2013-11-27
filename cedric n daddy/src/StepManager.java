/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

public class StepManager {

    private Step[]  walls;
    private float   holeMinSize = 5;
    private float   holeMaxSize = 15;
    private int     sizeX = 50;
    private int     sizeY = 200;

    public StepManager() {
    }

    public  void    generate() {
        this.setWalls(new Step[sizeY]);
        for (int i = 0; i < this.getWalls().length; ++i) {
            if (PastaVoid.pApplet.random(0.0f, 3.0f) > 2.0f) {
                int holeSize = (int)PastaVoid.pApplet.random(this.holeMinSize, this.holeMaxSize);
                this.getWalls()[i] = new Step((int)PastaVoid.pApplet.random(holeSize, sizeX - holeSize), i, holeSize, true);
            } else {
                this.getWalls()[i] = new Step(0, i, 0, false);
            }
        }
    }

    public float getHoleMinSize() {
        return holeMinSize;
    }

    public void setHoleMinSize(float holeMinSize) {
        this.holeMinSize = holeMinSize;
    }

    public float getHoleMaxSize() {
        return holeMaxSize;
    }

    public void setHoleMaxSize(float holeMaxSize) {
        this.holeMaxSize = holeMaxSize;
    }

    public Step[] getWalls() {
        return walls;
    }

    public void setWalls(Step[] walls) {
        this.walls = walls;
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
