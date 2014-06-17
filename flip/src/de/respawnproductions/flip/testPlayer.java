package de.respawnproductions.flip;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import de.respawnproductions.flip.Player.State;

public class testPlayer {

	@Test
	public void test() {
		Vector2 origin = new Vector2( 0.0f, 0.0f );
		Player player = new Player(null);
		
		player.setFacingLeft(1);
		assertTrue(player.facingLeft);
		
		player.setFacingLeft(0);
		assertFalse(player.facingLeft);
		
		player.setFacingDown(1);
		assertTrue(player.facingDown);
		
		player.setFacingDown(0);
		assertFalse(player.facingDown);
		
		player.setState(State.DEAD);
		assertEquals(player.state, State.DEAD);
		
		player.setState(State.IDLE);
		assertEquals(player.state, State.IDLE);
		
		player.setState(State.JUMP);
		assertEquals(player.state, State.JUMP);
		
		
		player.setState(State.MOVE);
		assertEquals(player.state, State.MOVE);	
		
		assertEquals( player.velocity, origin );
		
	}
	
	

}
