package de.respawnproductions.flip;

import de.respawnproductions.flip.World;
import de.respawnproductions.flip.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;	
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {
	
	private World world;
	private WorldRenderer renderer;
	
	@Override
	public void render( float delta ){
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
	
	}
	@Override
	public void resize( int width, int height ){
		
	}
	@Override
	public void show(){
		world = new World();
		renderer = new WorldRenderer( world );
	}
	@Override
	public void hide(){
		
	}
	@Override
	public void pause(){
		
	}
	@Override
	public void resume(){
		
	}
	@Override
	public void dispose(){
		
	}
}
