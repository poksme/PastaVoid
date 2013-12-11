package GameEngine;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class KeysManager {
	
	public enum EKeys {
		LEFT(37),
		RIGHT(39),
		SPACE(32),
		ENTER(10),
		NONE(-1);
		
	    private final int id;
	    EKeys(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
	private Map<EKeys, Boolean> pressedKeys;
	private EKeys[] watchedKeys;
    private KeysManager() {
    	pressedKeys = new HashMap<EKeys, Boolean>();
    	for (EKeys key : EKeys.values()) {
    		pressedKeys.put(key, false);
    	}
    	watchedKeys = EKeys.values();
    }
    
    private static KeysManager INSTANCE = new KeysManager();
    
    public static KeysManager getInstance() {
    	return INSTANCE;
    }

    private boolean isWatched(int keyCode) {
    	for (int i = 0; i < watchedKeys.length; i++) {
    		if (watchedKeys[i].getValue() == keyCode)
    			return true;
    	}
    	return false;
    }
    
    private EKeys intToEKeys(int keyCode) {
    	for (int i = 0; i < watchedKeys.length; i++) {
    		if (watchedKeys[i].getValue() == keyCode)
    			return watchedKeys[i];
    	}
    	return EKeys.NONE;
    }
    
	public void setPressed(int keyCode) {
		if (isWatched(keyCode)) {
			pressedKeys.put(intToEKeys(keyCode), true);
		}		
	}

	public void setReleased(int keyCode) {		
		if (isWatched(keyCode)) {
			pressedKeys.put(intToEKeys(keyCode), false);
		}		
	}
	
	public boolean keyIsPressed(EKeys key) {
		return pressedKeys.get(key);
	}
}
