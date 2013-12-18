package PastaVoid;

import java.util.ArrayList;

import processing.core.PImage;
import Configuration.Config;
import GameEngine.AScene;
import GameEngine.KeysManager;
import GameEngine.KeysManager.EKeys;
import GameEngine.SceneManager;

public class MenuScene extends AScene {
	
	private int curSong;
    private ArrayList<SongEntry> songLibrary;
    private float totalElapsedTime;
    private float posZ;
    private PImage logo;
	
	public MenuScene(Game game, Config config) {
    	super(game, true, true); // UPDTABLE AND DRAWABLE
    	curSong = 0;
    	totalElapsedTime = 0;
    	posZ = 0;
    	logo = game.loadImage("TitleLogo.jpg");
    	songLibrary = new ArrayList<SongEntry>();
    	for (int i = 0; i < config.getLevels().size(); i++) {
    		songLibrary.add(new SongEntry(config.getLevels().get(i).getArtist() + "\n" + config.getLevels().get(i).getName()));
    		game.getSongPlayer().add(game.getMinim().loadFile("music/" + config.getLevels().get(i).getMusicPath()));
    	}
    }
    
	public void start() {
		// TODO Auto-generated method stub		
	}

	
	public void update(long elapsedTime) {
		totalElapsedTime += elapsedTime;
		posZ = game.cos(totalElapsedTime / 1000) * 10.f;
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.RIGHT)) {
			curSong = (curSong + 1) % songLibrary.size();
		} 
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.LEFT)) {
			curSong = ((curSong - 1) < 0) ? songLibrary.size() - 1 : curSong - 1;
		}
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.ENTER)) {
//			game.getSongPlayer().get(curSong).play();
//			game.setCurrentSong(game.getSongPlayer().get(curSong));
			//game.getSongPlayer().get(curSong).mute();
			this.setDrawable(false);
			this.setUpdatable(false);
			game.getSongPlayer().get(curSong).rewind();
	        LevelScene levelScene = new LevelScene(game, game.getConfig().getLevels().get(curSong), game.getSongPlayer().get(curSong));
	        SceneManager.getInstance().addScene(levelScene);
	        GuiScene guiScene = new GuiScene(game, levelScene);
	        SceneManager.getInstance().addScene(guiScene);
			game.setCurrentSong(game.getSongPlayer().get(curSong));
			// NEED TO PLAY AS THE LEAST ACTION
			game.getSongPlayer().get(curSong).play();
//	        SceneManager.getInstance().addScene(new Player(game, game.WIDTH, tmpLevelScene));
		}
	}

	public void draw(Game parent) {
		parent.camera();
	      parent.textAlign(parent.CENTER);

//	      parent.fill(48, 117, 232);
////	      parent.fill(30, 73, 145, 100);
//	      parent.strokeWeight(0.5f);
//	      parent.text("PASTAVOID", parent.width / 2, parent.height / 2 - 100, 200);      
//      parent.blur();
//
////      parent.fill(30, 73, 145, 100);
//      parent.fill(48, 117, 232);
//      parent.strokeWeight(0.05f);
//      parent.text("PASTAVOID", parent.width / 2, parent.height / 2 - 100, 200);
//      parent.blur();

	  parent.image(logo, parent.width / 2 - 340, 60);
      parent.fill(255);
      parent.text(songLibrary.get(curSong).getTitle(), parent.width / 2, parent.height / 2 , posZ);
      int trSize = 30;

      int trY = parent.height / 2;
      int trX = 140;
      parent.triangle(trX + 0, trY + trSize / 2, trX + trSize / 2, trY + 0, trX + trSize / 2 , trY + trSize);

      trX = parent.width - 140 - trSize / 2;
      parent.triangle(trX + 0, trY + 0, trX + 0, trY + trSize, trX + trSize / 2 , trY + trSize / 2);
      
      
      parent.text("PASTAGAME SOFTWARE PRESENTS - FALL 2013 KMU GAME PROJECT", parent.width / 2, parent.height + 500 , -1000);
	}
}
