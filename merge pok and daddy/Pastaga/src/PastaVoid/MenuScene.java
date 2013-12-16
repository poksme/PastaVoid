package PastaVoid;

import java.util.ArrayList;

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
	
	public MenuScene(Game game, Config config) {
    	super(game, true, true); // UPDTABLE AND DRAWABLE
    	curSong = 0;
    	totalElapsedTime = 0;
    	posZ = 0;
    	songLibrary = new ArrayList<SongEntry>();
    	for (int i = 0; i < config.getLevels().size(); i++) {
    		songLibrary.add(new SongEntry(config.getLevels().get(i).getArtist() + "\n" + config.getLevels().get(i).getName()));
    		game.getSongPlayer().add(game.getMinim().loadFile("music" + java.io.File.separator + config.getLevels().get(i).getMusicPath()));
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
			game.getSongPlayer().get(curSong).play();
			game.setCurrentSong(game.getSongPlayer().get(curSong));
			//game.getSongPlayer().get(curSong).mute();
			this.setDrawable(false);
			this.setUpdatable(false);
	        LevelScene levelScene = new LevelScene(game, game.getConfig().getLevels().get(curSong));
	        SceneManager.getInstance().addScene(levelScene);
//	        SceneManager.getInstance().addScene(new Player(game, game.WIDTH, tmpLevelScene));
		}
	}

	public void draw(Game parent) {
		parent.camera();
		parent.fill(255);
//        parent.fill(0, 102, 153);
        parent.textAlign(parent.CENTER);
        parent.text(songLibrary.get(curSong).getTitle(), parent.width / 2, parent.height / 2 - 48, posZ);		
	}
}
