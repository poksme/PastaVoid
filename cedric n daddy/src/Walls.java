/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

public class Walls {

    private int     nWalls;
    private Wall[] walls;
    private float   holeMinSize = 5;
    private float   holeMaxSize = 15;
    private int     sizeX = 50;
    private int     sizeY = 200;

    public Walls(int nWalls) {
        this.nWalls = nWalls;
    }

    public  void    generate() {
        this.walls = new Wall[this.nWalls];
        for (int i = 0; i < this.walls.length; ++i) {
            int holeSize = (int)PastaVoid.pApplet.random(this.holeMinSize, this.holeMaxSize);
            this.walls[i] = new Wall((int)PastaVoid.pApplet.random(holeSize * 2, sizeX - holeSize * 2), (int)PastaVoid.pApplet.random(0, sizeY), holeSize);
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
}
