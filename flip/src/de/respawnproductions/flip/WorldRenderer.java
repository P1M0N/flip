package de.respawnproductions.flip;

import de.respawnproductions.flip.BLOCK_SOLID;
import de.respawnproductions.flip.Enemy;
import de.respawnproductions.flip.Player;
import de.respawnproductions.flip.World;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera; 
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {

	private World world;
	private OrthographicCamera camera;
	
	ShapeRenderer debugRenderer = new ShapeRenderer();
	
	public WorldRenderer( World world ){
		this.world = world;
		this.camera = new OrthographicCamera( 10, 7);
		this.camera.position.set( 5, 3.5f, 0);
		this.camera.update();
		
	}
	
	public void render(){
		//Blöcke
		debugRenderer.setProjectionMatrix(camera.combined);
		debugRenderer.begin(ShapeType.Line);
		for (BLOCK_SOLID block : World.getBlocks()){
			Rectangle rect = block.getBounds();
			float x1 = block.getPosition().x + rect.x;
			float y1 = block.getPosition().y + rect.y;
			debugRenderer.setColor(new Color(1, 0, 0, 1));
			debugRenderer.rect( x1, y1, rect.width, rect.height );
		}
		for (Enemy enemy : World.getEnemies()){
			Rectangle rect = enemy.getBounds();
			float x1 = enemy.getPosition().x + rect.x;
			float y1 = enemy.getPosition().y + rect.y;
			debugRenderer.setColor(new Color( 0, 1, 0, 1));
			debugRenderer.rect( x1, y1, rect.width, rect.height );
		}
		Player player = world.getPlayer();
		Rectangle rect = player.getBounds();
		float x1 = player.getPosition().x + rect.x;
		float y1 = player.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(1, 1, 1, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
			debugRenderer.end();
			
		
		
	}
}
