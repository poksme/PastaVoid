package GameEngine;

import java.util.ArrayList;

import PastaVoid.Game;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AScene {
	
	// PRIVATE PROPERTIES
	private boolean isUpdatable;
	private boolean isDrawable;
	private Game	game;

	// ABSTRACT METHODS
    abstract public void start();
    abstract public void update(long elapsedTime);
    abstract public void draw(Game parent);

	// IF OVERRIDE CONSTRUCTOR DON'T FORGET TO CALL SUPER()
	public AScene(Game game, boolean isUpdatable, boolean isDrawable) {
		this.game = game;
		this.isDrawable = isDrawable;
		this.isUpdatable = isUpdatable;
	}
	
    public boolean  isDrawable() {
    	return this.isDrawable;
    }
    
    public boolean  isUpdatable() {
    	return this.isUpdatable;
    }
    
    public void     setDrawable(boolean drawable) {
    	this.isDrawable = drawable;
    }
    
    public void     setUpdatable(boolean updatable) {
    	this.isUpdatable = updatable;
    }
}
