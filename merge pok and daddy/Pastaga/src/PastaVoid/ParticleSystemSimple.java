package PastaVoid;

import java.util.ArrayList;

import GameEngine.Color;
import processing.core.PVector;

public class ParticleSystemSimple {
	 ArrayList<Particle> particles;
	 PVector origin;
	 int	particleNb = 20;
	 
	  ParticleSystemSimple(PVector location, Game parent) {
	    particles = new ArrayList<Particle>(particleNb);
	  }
	  
	  void createParticleSystem(Game parent, float posX)
	  {
		  for (int i = 0; i < particleNb; i++)
		    addParticle(parent, new PVector(posX, 520));
	  }
	  
	  void addParticle(Game parent, PVector location) {
		if ((int)parent.random(2) == 1)
			particles.add(new Particle(location, parent, new Color(30, 73, 145)));
		else
			particles.add(new Particle(location, parent, new Color(48, 117, 232)));
			//particles.add(new Particle(location, parent, new Color(255,255,255)));
	  }
	  
	  void draw(Game parent){
		parent.camera();
		parent.pushMatrix();
		for (int i = particles.size()-1; i >= 0; i--) {
		      Particle p = particles.get(i);
		      p.display(parent);
		    }
		parent.popMatrix();
	  }
	  
	  void run() {
	    for (int i = particles.size()-1; i >= 0; i--) {
	      Particle p = particles.get(i);
	      p.update();
	      if (p.isDead()) {
	        particles.remove(i);
	      }
	    }
	  }
}
