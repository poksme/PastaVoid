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
	private Map<EKeys, Boolean> bufferedKeys;
	private Map<EKeys, Boolean> prevPressedKeys;
	private Map<EKeys, Boolean> curPressedKeys;
	private EKeys[] watchedKeys;
    private KeysManager() {
    	bufferedKeys = new HashMap<EKeys, Boolean>();
    	prevPressedKeys = new HashMap<EKeys, Boolean>();
    	curPressedKeys = new HashMap<EKeys, Boolean>();
    	for (EKeys key : EKeys.values()) {
    		bufferedKeys.put(key, false);
    		prevPressedKeys.put(key, false);
    		bufferedKeys.put(key, false);
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
			bufferedKeys.put(intToEKeys(keyCode), true);
		}		
	}

	public void setReleased(int keyCode) {		
		if (isWatched(keyCode)) {
			bufferedKeys.put(intToEKeys(keyCode), false);
		}		
	}
	
	public boolean keyIsPressed(EKeys key) {
		return bufferedKeys.get(key);
	}
	
	public boolean keyIsPressedOnce(EKeys key) {
		return curPressedKeys.get(key) && !prevPressedKeys.get(key);
	}
	
	public void update() {
    	for (EKeys key : EKeys.values()) {
    		prevPressedKeys.put(key, curPressedKeys.get(key));
    		curPressedKeys.put(key, bufferedKeys.get(key));
    	}
	}
}
