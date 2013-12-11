package PastaVoid;

import GameEngine.AScene;

public class MenuScene extends AScene {
	
    public MenuScene() {
    	super(true, true); // UPDTABLE AND DRAWABLE
    }
    
	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void update(long elapsedTime) {
		// TODO Auto-generated method stub		
	}

	public void draw(Game parent) {
        parent.fill(0, 102, 153);
        parent.text("DEMO", -5, -12, 0);		
	}

}
