package de.respawnproductions.flip;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.respawnproductions.flip.Player.State;

public class Enemy {
	public enum State{
		IDLE, MOVE, JUMP, DEAD
	}
	
	static final float SPEED = 2f; //einheiten pro sekunde
	static final float SIZE = 0.4f;
	
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Rectangle bounds = new Rectangle();
	State state = State.IDLE;
	
	public Enemy(Vector2 position){
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
	public Vector2 getPosition(){
		return position;
	}
}
