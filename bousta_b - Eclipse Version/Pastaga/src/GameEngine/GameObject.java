package GameEngine; /**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */

import processing.core.PVector;

public class GameObject {

    private String   name;
    private PVector   position;

    public void draw() {

    }

    public void update() {

    }

    public boolean hasCollider() {
        return false;
    }

    public void onCollision(GameObject other) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }
}
