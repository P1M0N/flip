package de.respawnproductions.flip;

import java.util.HashMap;
import java.util.Map;

import de.respawnproductions.flip.Player.State;
import de.respawnproductions.flip.World;
import de.respawnproductions.flip.Player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class WorldController {
	enum Keys {
		LEFT, RIGHT, JUMP, FIRE, UP, DOWN
	}

	private World 	world;
	private Player 	player;
	private WorldRenderer renderer;

	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.JUMP, false);
		keys.put(Keys.FIRE, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
	};

	public WorldController(World world, WorldRenderer renderer) {
		this.world = world;
		this.player = world.getPlayer();
		this.renderer = renderer;
	}
	//** Camera extensions **//
	
	public void cameraHunt ( Player player ){
		float cameraSpeed = 0.065f;
		float threshold = 0.1f;
		Vector2 playerPosition = player.getPosition();
		Vector3 cameraPosition = renderer.camera.position.cpy();
		
		if( (playerPosition.x - cameraPosition.x) > threshold ){
			renderer.camera.position.add( cameraSpeed, 0.0f, 0.0f );
		}
		else if( (cameraPosition.x - playerPosition.x) > threshold ){
			renderer.camera.position.sub( cameraSpeed, 0.0f, 0.0f);
		}
		if( (playerPosition.y - cameraPosition.y) > threshold){
			renderer.camera.position.add( 0.0f, cameraSpeed, 0.0f);
		}
		else if( (cameraPosition.y - playerPosition.y) > threshold ){
			renderer.camera.position.sub( 0.0f, cameraSpeed, 0.0f);
		}
		
		renderer.camera.update();
	}
	
	// ** Key presses and touches **************** //

	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
		
		
	}

	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));;
	}
	
	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}
	
	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}

	public void jumpPressed() {
		keys.get(keys.put(Keys.JUMP, true));
	}

	public void firePressed() {
		keys.get(keys.put(Keys.FIRE, false));
	}

	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}
	
	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
	}

	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}

	public void jumpReleased() {
		keys.get(keys.put(Keys.JUMP, false));
	}

	public void fireReleased() {
		keys.get(keys.put(Keys.FIRE, false));
	}

	/** The main update method **/
	public void update(float delta) {
		processInput();
		player.update(delta);
	}

	/** Change Players's state and parameters based on input controls **/
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			player.setFacingLeft(1);
			player.setState(State.MOVE);
			player.getVelocity().x = -Player.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			// right is pressed
			player.setFacingLeft(0);
			player.setState(State.MOVE);
			player.getVelocity().x = Player.SPEED;
		}
		if (keys.get(Keys.UP)) {
			// up is pressed
			player.setFacingDown(0);
			player.setState(State.MOVE);
			player.getVelocity().y = Player.SPEED;
		}
		if (keys.get(Keys.DOWN)) {
			// down is pressed
			player.setFacingDown(1);
			player.setState(State.MOVE);
			player.getVelocity().y = -Player.SPEED;
		}
		// need to check if both or none direction are pressed, then Bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||  ((keys.get(Keys.UP) && (keys.get(Keys.DOWN)))) || !(keys.get(Keys.LEFT)) && !(keys.get(Keys.RIGHT)) && !(keys.get(Keys.UP)) && !(keys.get(Keys.DOWN))) {
			player.setState(State.IDLE);
			// acceleration is 0 on the x
			player.getAcceleration().x = 0;
			player.getAcceleration().y = 0;
			// horizontal speed is 0
			player.getVelocity().x = 0;
			player.getVelocity().y = 0;
		}
	}
}
