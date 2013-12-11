package PastaVoid;

import GameEngine.AScene;
import GameEngine.KeysManager;

public class MenuScene extends AScene {
	private enum ESong {
		DEFIANT_ORDER,
		SECOND_SONG,
		THIRD_SONG
	};
	private ESong curSong;
    public MenuScene(Game game) {
    	super(game, true, true); // UPDTABLE AND DRAWABLE
    	curSong = ESong.DEFIANT_ORDER;
    }
    
	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressed(KeysManager.EKeys.SPACE))
			System.out.println("Spacebar is being pressed LOL!!!");
		// TODO Auto-generated method stub
	}

	public void draw(Game parent) {
		parent.camera();
        parent.fill(0, 102, 153);
        parent.text("DEMO", 200, 200, 0);		
	}

}
