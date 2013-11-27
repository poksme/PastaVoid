package Config;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class Door {
    int position;
    int size;

    public Door(int position, int size) {
        this.position = position;
        this.size = size;
    }

    public String toString() {
        String ret = "[Door]";
        ret += " Position: " + position + ", Size: " + size;
        return ret;
    }

    public int getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }
}
