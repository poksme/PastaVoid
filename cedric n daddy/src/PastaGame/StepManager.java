package PastaGame; /**
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
    private int     sizeY = 1000;

    public StepManager() {
    }

    public  void    generate() {
        this.setWalls(new Step[sizeY]);
        // GENERATE POOM CHAK
        for (int i = 0; i < sizeY; i++) {
            int relativeStep = i % 16;
            int holeSize = 10;
            if (relativeStep == 0 || relativeStep == 8) { // KICK
                this.getWalls()[i] = new Step(15, i, holeSize, true);
            } else if (relativeStep == 4 || relativeStep == 12) { // SNARE
                this.getWalls()[i] = new Step(35, i, holeSize, true);
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
