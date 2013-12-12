package GameEngine;

import java.util.ArrayList;

import PastaVoid.Game;
import processing.core.PVector;


public class ParticleSystem {
	
	public PVector		position;
	
	ArrayList<Particle> particles;
	
	//particle datas
	public	int		emission = 10;
	public	float	lifeSpan = 1.0f;
	public	float	size = 2.0f;
	

	public	ParticleSystem() {
	    particles = new ArrayList<Particle>();
	}

	public	void	start() {
		
	}
	
	public	void	update(long timeElapsed) {
		for (int i = particles.size()-1; i >= 0; i--) {
		      Particle p = particles.get(i);
		      p.update();
		      if (p.isDead()) {
		        particles.remove(i);
		      }
		    }
		  }		
	}
	
	public	void	draw(Game parent) {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y, this.position.z);
		for (int i = particles.size()-1; i >= 0; i--) {
		      Particle p = particles.get(i);
		      p.draw();
		  }
		parent.popMatrix();
	}
}
