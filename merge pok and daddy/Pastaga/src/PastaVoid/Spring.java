package PastaVoid;

public class Spring {
	  private float Xpos;
	  private float Ypos;
	  private float Xvel;
	  private float Yvel;
	  private float Pxpos;
	  private float Pypos;
	  private float colorness;

	  Spring(float tempXpos, float tempYpos, int colortemp) {
	   Xpos = tempXpos;
	   System.out.println(tempXpos);
	   Ypos = tempYpos;
	   colorness = colortemp;
	  }
	  
	  void render(Game parent, float playerPosX, float playerPosY, boolean trigger) {
	    Xpos += Xvel;
	    Ypos += Yvel;
	    if (parent.mousePressed == true) {
	    	
	    //if (trigger == true) {
	      Xvel += (4000.f / parent.dist(playerPosX, playerPosY, Xpos, Ypos) * ((0.009 * (playerPosX - Xpos))) / 50.f);
	      Yvel += (4000.f / parent.dist(playerPosX, playerPosY, Xpos, Ypos) * ((0.009 * (playerPosX - Ypos))) / 50.f);
	    } else {
	    Xvel = Xvel / 1.04f;
	    Yvel = Yvel / 1.04f;
	    }
	    
	    colorness = parent.dist(Xpos, Ypos, Pxpos, Pypos) * 10;
	    
	    parent.colorMode(parent.HSB);
	    parent.strokeWeight(0.01f);
	    parent.fill(colorness, 255, 255);
	    parent.stroke(colorness, 255, 255, 20);
	    parent.line(Xpos, Ypos, 0, Pxpos, Pypos, 0);
	    
	    Pxpos = Xpos;
	    Pypos = Ypos;
	  }
}
