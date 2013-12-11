package PastaVoid;

import java.util.HashMap;
import java.util.Map;

import GameEngine.AScene;
import GameEngine.KeysManager;
import GameEngine.KeysManager.EKeys;

public class MenuScene extends AScene {
	
	private enum ESong {
		NONE(-1),
		DEFIANT_ORDER(0),
		SECOND_SONG(1),
		THIRD_SONG(2);
	
	    private final int id;
	    ESong(int id) { this.id = id; }
	    public int getValue() { return id; }
	};

	private ESong curSong;
	private ESong[] songList;
    private Map<ESong, SongEntry> songLibrary;
	
	public MenuScene(Game game) {
//    	super(game, true, true); // UPDTABLE AND DRAWABLE
		super(game, false, false);
    	curSong = ESong.DEFIANT_ORDER;
    	songList = ESong.values();
    	songLibrary = new HashMap<ESong, SongEntry>();
    	songLibrary.put(ESong.DEFIANT_ORDER, new SongEntry("Defiant Order"));
    	songLibrary.put(ESong.SECOND_SONG, new SongEntry("Second Song"));
    	songLibrary.put(ESong.THIRD_SONG, new SongEntry("Third Song"));
    }
    
	public void start() {
		// TODO Auto-generated method stub
		
	}

	private ESong intToESong(int song) {
    	for (int i = 0; i < songList.length; i++) {
    		if (songList[i].getValue() == song)
    			return songList[i];
    	}
    	return ESong.NONE;
	}
	
	public void update(long elapsedTime) {
		if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.RIGHT)) {
			curSong = intToESong(curSong.getValue() + 1);
			if (curSong == ESong.NONE) {
				curSong = ESong.DEFIANT_ORDER;
			}
		} else if (KeysManager.getInstance().keyIsPressedOnce(KeysManager.EKeys.LEFT)) {
			curSong = intToESong(curSong.getValue() - 1);
			if (curSong == ESong.NONE) {
				curSong = ESong.THIRD_SONG;
			}
		}
	}

	public void draw(Game parent) {
		parent.camera();
        parent.fill(0, 102, 153);
        parent.text(songLibrary.get(curSong).getTitle(), 100, 200, 0);		
	}

}
