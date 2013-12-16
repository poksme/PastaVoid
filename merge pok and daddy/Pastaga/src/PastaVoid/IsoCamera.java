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
    private LevelScene	scene;
    private float		offset;
    private float		stepPerMilliSec;

    public IsoCamera(LevelScene scene) {
        this.scene = scene;
        this.stepPerMilliSec = scene.getSpeed() * 4.f / 60.f / 1000.f;
//        System.out.println(introDelay);
        this.offset = 0;
    }

    public void update(long elapsedTime) {
    	this.setOffset(this.getOffset() + this.stepPerMilliSec * elapsedTime);
    }

    public void draw(Game parent) {

        float cameraZ = -100.0f;
        float zoom = 1.0f;

        parent.camera(parent.width/2.0f, parent.height/2.0f, (parent.height/2.0f) / parent.tan(parent.PI/6.0f),
                parent.width/2.0f, parent.height/2.0f, 0.0f,
                0.0f, 1.0f, 0.0f);
        float fov = parent.PI/3.0f;
        cameraZ = (parent.height/2.0f) / parent.tan(fov/2.0f);

        parent.translate(parent.width / 2, parent.height, 0.0f);
        
        parent.rotateX(0.9f);
        
        parent.scale(700.0f, 300.0f, 1.0f);

        parent.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        parent.translate(-this.scene.getWalls().getSizeX() / 2,  0.0f, 0.0f);
        
        parent.translate(0.0f, -this.getOffset(), 0.0f);
    }

//    public void draw(Game parent) {
//
//    	//camera setup
//        float cameraZ = -100.0f;
//        float zoom = 1.0f;
//        //parent.rotateX(parent.PI/6.0f);
////        parent.camera(parent.width/2.0f, parent.height/2.0f, (parent.height/2.0f) / parent.tan(parent.PI/6.0f),
////                parent.width/2.0f, parent.height/2.0f, 0.0f,
////                0.0f, 1.0f, 0.0f);
//        float fov = parent.PI/3.0f;
//        cameraZ = (parent.height/2.0f) / parent.tan(fov/2.0f);
////       parent.perspective(fov, (float)(parent.width)/(float)(parent.height), 
////                    0.0f, 100.0f);
//        
//        //parent.camera(0.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 1.0f);
//        parent.box(1);
//
//        //camera viewport setup
////        parent.translate(parent.width / 2, parent.height, 0.0f);
//        //change this value to change the angle of the walls
////        parent.rotateX(0.9f);
//        //change the x value to change the X scale
//        //change the y value to change the Y stretching
////        parent.scale(700.0f, 300.0f, 1.0f);
//        	//parent.scale(700.0f, 300.0f, 1.0f);
////      parent.scale(100.0f, 100.0f, 100.0f);
//        //parent.scale(100.0f, 100.0f);
//        //map setup
////        parent.rotate(180.0f, 1.0f, 0.0f, 0.0f);
////        parent.translate(-this.scene.getWalls().getSizeX() / 2,  0.0f, 0.0f);
//        
//        //scrolling translation
////        parent.translate(0.0f, -this.getOffset(), 0.0f);
//    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

	public float getOffset() {
		return offset;
	}

	public void setOffset(float offset) {
		this.offset = offset;
	}
}
