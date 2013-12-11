package Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class Door {
    float position;
    float size;

    public Door(float position, float size) {
        this.position = position;
        this.size = size;
    }

    public String toString() {
        String ret = "[Door]";
        ret += " Position: " + position + ", Size: " + size;
        return ret;
    }

    public float getPosition() {
        return position;
    }

    public float getSize() {
        return size;
    }
}
