/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Step {
    public  int     x;
    public  int     y;
    public  int     holeSize;
    public boolean  isWall;

    public Step(int x, int y, int holeSize, boolean isWall) {
        this.x = x;
        this.y = y;
        this.holeSize = holeSize;
        this.isWall = isWall;
    }
}