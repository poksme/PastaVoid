package PastaVoid;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Step {
    public  float     x;
    public  float     y;
    public  float     holeSize;
    public boolean  isWall;

    public Step(float x, float y, float holeSize, boolean isWall) {
        this.x = x;
        this.y = y;
        this.holeSize = holeSize;
        this.isWall = isWall;
        //System.out.printf("%f;%f => %f\n", this.x,this.y,this.holeSize);
    }
}