package GameEngine;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IScene {

    public void     start();
    public void     update(long elapsedTime);
    public void     draw(PApplet parent);

    public boolean  isDrawn();
    public boolean  isUpdated();
    public void     setDrawn(boolean drawn);
    public void     setUpdated(boolean drawn);
}
