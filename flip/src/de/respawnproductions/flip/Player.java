package de.respawnproductions.flip;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	public enum State{
		IDLE, MOVE, JUMP, DEAD
	}
	
	static final float SPEED = 2f; //einheiten pro sekunde
	static final float JUMP_VELO = 1f;
	static final float SIZE = 0.4f;
	
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	State state = State.IDLE;
	boolean facingLeft = true;
	
	public Player(Vector2 position){
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
	public Vector2 getVelocity(){
		return velocity;
	}
	
	public Vector2 getAcceleration(){
		return acceleration;
	}

	public void setState(State newState){
		this.state = newState;
	}

	public void update(float delta){
		position.add(velocity.cpy().scl(delta));
	}
	
	public void setFacingLeft( int i){
		if(i == 1)
			facingLeft = true;
		if(i == 0)
			facingLeft = false;
	}

}
