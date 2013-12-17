package PastaVoid;

public class ParticleSystemSmallBean {
	
	private int longness = 5000;
	private Spring[] springs = new Spring[longness];
	
	ParticleSystemSmallBean(Game game, int screenWidth,int screenHeight) {
		  for (int i = 0; i < longness; i++) {
		      springs[i] = new Spring(game.random(screenWidth), game.random(screenHeight), i);
		    }
	}
	
	void draw(Game parent, float playerPosX, float playerPosY, boolean trigger){
		parent.camera();

	parent.pushMatrix();
	  parent.translate(playerPosX, playerPosY, 0.f);
//	  parent.println(playerPosY);
		playerPosY = 200.f;
		playerPosX = 300.f;
	  for (int i = 0; i < longness ; i++) {
	    springs[i].render(parent, playerPosX, playerPosY, trigger);
	  }
	  
	  parent.popMatrix();	  
	}
}