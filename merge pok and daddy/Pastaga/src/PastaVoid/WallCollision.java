package PastaVoid;

import processing.core.PVector;

//last Step
//current Step
//is Hitting

public class WallCollision {

	private Step	step;
	private PVector	collisionPoint;
	
	public WallCollision(Step step, PVector collisionPoint) {
		this.setStep(step);
		this.setCollisionPoint(collisionPoint);
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public PVector getCollisionPoint() {
		return collisionPoint;
	}

	public void setCollisionPoint(PVector collisionPoint) {
		this.collisionPoint = collisionPoint;
	}	
}
