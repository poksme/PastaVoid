package PastaVoid;

import GameEngine.Color;
import processing.core.PVector;

public class Particle {
	  private PVector location;
	  private PVector velocity;
	  private PVector acceleration;
	  private PVector prevLocation;
	  float lifespan;
	  Color	color;
	
	  Particle(PVector l, Game parent, Color particleColor) {
	    acceleration = new PVector(0,0.08f);
	    prevLocation = new PVector(0, 0);
	    velocity = new PVector(parent.random(-3,3),parent.random(-1,3));
	    location = l.get();
	    prevLocation.x = location.x;
	    prevLocation.y = location.y;
	    lifespan = 200.0f;
	    color = particleColor;
	  }
	
	  // Method to update location
	  public void update() {
		prevLocation.x = location.x;
		prevLocation.y = location.y;
	    velocity.add(acceleration);
	    location.add(velocity);
	    lifespan -= 1.0f;
	  }
	
	  // Method to display
	  public void display(Game parent) {
		 
		parent.stroke(color.red, color.green, color.blue, lifespan);
	    parent.fill(255,lifespan);
	    parent.strokeWeight(10);
	    
	    /*if (color.red == 255)
	    	parent.rect(location.x,location.y,5,5);
	    else*/
	    	parent.line(location.x, location.y, 0, prevLocation.x, prevLocation.y, 0);
	    
	    parent.smooth();
	  }
	  
	  // Is the particle still useful?
	  public boolean isDead() {
	    if (lifespan < 0.0) {
	      return true;
	    } else {
	      return false;
	    }
	  }
}
