package de.respawnproductions.flip;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	static Array<BLOCK_SOLID> blocks = new Array<BLOCK_SOLID>(); 
	static Array<Enemy> Enemies = new Array<Enemy>();
	
	
	Player player;
	Enemy AI1;
	
	
	public static Array<BLOCK_SOLID> getBlocks(){
		return blocks;
	}
	
	public static Array<Enemy> getEnemies(){
		return Enemies;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public World(){
		createDemoWorld();
	}
	
	private void createDemoWorld(){
		player = new Player(new Vector2( 5, 5));
		AI1 = new Enemy(new Vector2(7,5));
		
		blocks.add(new BLOCK_SOLID( new Vector2(9, 2)));
		blocks.add(new BLOCK_SOLID( new Vector2(9, 3)));
		blocks.add(new BLOCK_SOLID( new Vector2(9, 4)));
		blocks.add(new BLOCK_SOLID( new Vector2(9, 5)));
		
		blocks.add(new BLOCK_SOLID( new Vector2(6, 3)));
		blocks.add(new BLOCK_SOLID( new Vector2(6, 4)));
		blocks.add(new BLOCK_SOLID( new Vector2(6, 5)));
		
		
	}
}
