package de.respawnproductions.flip;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class testWorld {

	@Test
	public void test() {
		World world = new World();
		Vector2 origin = new Vector2( 0.0f, 0.0f);
		Player player = new Player(origin);
		BLOCK_SOLID block = new BLOCK_SOLID(origin);
		Enemy enemy = new Enemy(origin);
		
		world.Enemies.add(enemy);
		assertEquals(world.Enemies.size, 1);
		
		world.player.position.set(origin);
		assertEquals( world.player.position, origin );
		
		world.blocks.add(block);
		assertEquals( world.blocks.size, 8);
		
		
		 
		
		
		
		
	}

}
