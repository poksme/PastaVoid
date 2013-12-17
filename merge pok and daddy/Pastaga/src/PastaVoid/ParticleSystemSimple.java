package PastaVoid;

import java.util.ArrayList;

import processing.core.PVector;

public class ParticleSystemSimple {
	 ArrayList<Particle> particles;
	 PVector origin;

	  ParticleSystemSimple(PVector location, Game parent) {
	    particles = new ArrayList<Particle>(25);
	  }
	  
	  void createParticleSystem(Game parent, float posX)
	  {
		  for (int i = 0; i < 25; i++)
		    addParticle(parent, new PVector(posX, 520));
	  }
	  
	  void addParticle(Game parent, PVector location) {
	    particles.add(new Particle(location, parent));
	  }
	  
	  void draw(Game parent){
		parent.camera();
		for (int i = particles.size()-1; i >= 0; i--) {
		      Particle p = particles.get(i);
		      p.display(parent);
		    }
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
