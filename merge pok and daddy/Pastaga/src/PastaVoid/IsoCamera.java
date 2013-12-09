package PastaVoid;

import processing.core.PVector;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 12/2/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsoCamera {

    private PVector     position;
    private float       zoom;

    public IsoCamera() {
        this.zoom = 1.0f;
    }

    public void update() {

    }

    public void draw(Game parent) {

        float cameraZ = -100.0f;
        parent.pushMatrix();
        parent.rotateX(parent.PI/6.0f);
        parent.camera(parent.width/2.0f, parent.height/2.0f, (parent.height/2.0f) / parent.tan(parent.PI/6.0f),
                parent.width/2.0f, parent.height/2.0f, 0.0f,
                0.0f, 1.0f, 0.0f);
        parent.popMatrix();


        parent.translate(parent.width / 2, parent.height, 0.0f);
        //change this value to change the angle of the walls
        parent.rotateX(0.9f);
        //change the x value to change the X scale
        //change the y value to change the Y stretching
        parent.scale(9.0f, 150.0f, 0.005f);
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }
}
