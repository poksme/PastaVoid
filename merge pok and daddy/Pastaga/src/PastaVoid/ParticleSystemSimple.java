package PastaVoid;

import java.util.ArrayList;
import java.util.Arrays;

import GameEngine.Color;
import processing.core.PVector;

public class ParticleSystemSimple {
	 ArrayList<Particle> particles;
	 PVector origin;
	 float	particleNb = 0f;
	 int	maxParticleNb = 25;
	 
	  ParticleSystemSimple(PVector location, Game parent) {
	    particles = new ArrayList<Particle>(maxParticleNb);
	  }
	  
	  void createParticleSystem(Game parent, float posX)
	  {
		  if (particleNb < maxParticleNb)
			  particleNb+=0.5f;
		  //for (int i = 0; i < (int)particleNb; i++)
		    addParticles(parent, new PVector(posX, 520));
	  }
	  
	  void addParticles(Game parent, PVector location) {
		  float cur = particleNb;
		  int whiteParticleNb = (int)(cur * (cur/maxParticleNb));

		  parent.println(cur);
		  for (int i = 0; i < (int)particleNb; i++)
		  {
			  if (i < whiteParticleNb)
				  particles.add(new Particle(location, parent, new Color(255, 255, 255)));
			  else {
				  if (i%2 == 0)
						particles.add(new Particle(location, parent, new Color(30, 73, 145)));
					else
						particles.add(new Particle(location, parent, new Color(48, 117, 232)));
			  }
		  }
	  }
	  
	  public boolean maximumParticle() {
		  return ((int)particleNb >= maxParticleNb);
	  }
	  
	  void resetParticleSystem(){
		  particleNb = 0f;
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
