package de.respawnproductions.flip;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BLOCK_SOLID {
	
	static final float SIZE = 1f;
	
	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	
	public BLOCK_SOLID( Vector2 pos ){
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
	public Vector2 getPosition(){
		return position;
	}

}
