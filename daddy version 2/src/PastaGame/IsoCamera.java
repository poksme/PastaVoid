package PastaGame;

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

    public void draw() {

        float cameraZ = -100.0f;
        Main.pApplet.pushMatrix();
        Main.pApplet.rotateX(Main.pApplet.PI/6.0f);
        Main.pApplet.camera(Main.pApplet.width/2.0f, Main.pApplet.height/2.0f, (Main.pApplet.height/2.0f) / Main.pApplet.tan(Main.pApplet.PI/6.0f),
                Main.pApplet.width/2.0f, Main.pApplet.height/2.0f, 0.0f,
                0.0f, 1.0f, 0.0f);
        Main.pApplet.popMatrix();


        Main.pApplet.translate(Main.pApplet.width / 2, Main.pApplet.height, 0.0f);
        //change this value to change the angle of the walls
        Main.pApplet.rotateX(0.9f);
        //change the x value to change the X scale
        //change the y value to change the Y stretching
        Main.pApplet.scale(9.0f, 150.0f, 0.0f);

        //3d axis (DEBUG)
        Main.pApplet.strokeWeight(10);
        Main.pApplet.stroke(255, 0, 0);
        Main.pApplet.line(0.0f, 0.0f, 0.0f, 1000.0f, 0.0f, 0.0f);
        Main.pApplet.stroke(0, 255, 0);
        Main.pApplet.line(0.0f, 0.0f, 0.0f, 0.0f, 1000.0f, 0.0f);
        Main.pApplet.stroke(0, 200, 255);
        Main.pApplet.line(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f);
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }
}
