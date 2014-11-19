package PastaVoid;

public class ParticleSystemSmallBean {
	
	private int longness = 2000;
	private Spring[] springs = new Spring[longness];
	
	ParticleSystemSmallBean(Game game, int screenWidth,int screenHeight) {
		  for (int i = 0; i < longness; i++) {
		      springs[i] = new Spring(game.random(screenWidth), game.random(screenHeight), i);
		    }
	}
	
	void draw(Game parent, float playerPosX, boolean trigger){
		parent.camera();
		parent.pushMatrix();
		playerPosX = parent.width * playerPosX;
	  for (int i = 0; i < longness ; i++) {
	    springs[i].render(parent, playerPosX, 520, trigger);
	  }
	  parent.popMatrix();
	}
}