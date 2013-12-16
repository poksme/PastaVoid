package PastaVoid;

import processing.core.PApplet;
import processing.core.PVector;
import Configuration.Door;
import Configuration.StepInfo;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

public class StepManager {

    private Step[]  walls;
    private float     sizeX = 1.0f;
    private float     sizeY;
    private LevelScene parent;

    public StepManager(LevelScene parent) {
        this.parent = parent;
    }

    public  void    generate() {
        this.sizeY = this.parent.getConfigurationLevel().getBarNumber() * 16; // bar number x step per bar
        this.setWalls(new Step[(int)sizeY]);

        for (int i = 0; i < sizeY; i++) {
            if (parent.getConfigurationLevel().hasDoor(i)) {
                Door tmpSI = parent.getConfigurationLevel().getStepInfo(i).getDoors().get(0); // getting only one door for now
                this.getWalls()[i] = new Step(tmpSI.getPosition(), i, tmpSI.getSize(), true);
            } else {
                this.getWalls()[i] = new Step(0, i, 0, false);
            }
        }
    }

    private void    _drawStep(Game parent, Step step, float posy) {
        if (!step.isWall) {
            return;
        }
        //for now draw a wall with only one hole
        parent.line(0, posy, step.x - step.holeSize / 2, posy);
        parent.line(step.x + step.holeSize / 2, posy, this.getSizeX(), posy);
    }

    public void     draw(Game parent) {
    	parent.pushMatrix();
        //parent.scale(1.0f, 1.0f, 1.0f);
        Step[] walls = this.walls;
        for (int i = 0; i < walls.length; ++i) {
            this._drawStep(parent, walls[i], walls[i].y);
        }
        float y = this.parent.getCamera().getOffset();
        parent.line( 0, y, 0, y + 32.0f);
        parent.line(this.getSizeX(), y, this.getSizeX(), y + 32.0f);
        parent.popMatrix();
    }

    //version POS,SIZE
//    public WallCollision	isColliding(PVector pos, PVector size) {
//    	int yPos = Math.round(pos.y);
//    	
//    	//size.y must be < 0.5f (tmp)
//    	if (yPos > this.getSizeY()) {
//        	return null;    		
//    	}
//    	Step step = this.walls[yPos];
//    	if (!step.isWall) {
//        	return null;    		
//    	}
//    	if ((pos.x) > step.x - step.holeSize / 2 && pos.x < (step.x + size.x) + step.holeSize / 2) {
//        	return null;
//    	}
//    	float posX = 0.0f;
//    	if ((pos.x) > step.x - step.holeSize / 2) {
//    		posX = pos.x;
//    	} else {
//    		posX = pos.x + size.x;
//    	}
//    	WallCollision coll = new WallCollision(step, new PVector(posX, yPos));
//		return coll;
//    }

    
    //version CENTER/SIZE
    public WallCollision	isColliding(PVector pos, PVector size) {
    	int yPos = Math.round(pos.y);
    	
    	if (yPos < 0.f) {
    		return null;
    	}
    	//size.y must be < 0.5f (tmp)
    	if (yPos > this.getSizeY()) {
        	return null;    		
    	}
    	Step step = this.walls[yPos];
    	if (!step.isWall) {
        	return null;    		
    	}
    	if ((pos.x - size.x / 2) > step.x - step.holeSize / 2 && (pos.x + size.x / 2) < step.x + step.holeSize / 2) {
        	return null;
    	}
    	float posX = 0.0f;
    	if ((pos.x - size.x / 2) < step.x - step.holeSize / 2) {
    		posX = pos.x - size.x / 2;
    	} else {
    		posX = pos.x + size.x / 2;
    	}
    	WallCollision coll = new WallCollision(step, new PVector(posX, yPos));
		return coll;
    }
    
    public Step[] getWalls() {
        return walls;
    }

    public void setWalls(Step[] walls) {
        this.walls = walls;
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }
}
