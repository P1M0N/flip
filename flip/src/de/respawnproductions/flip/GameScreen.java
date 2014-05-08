package de.respawnproductions.flip;

import de.respawnproductions.flip.World;
import de.respawnproductions.flip.WorldRenderer;
import de.respawnproductions.flip.WorldController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen, InputProcessor {
	
	private World world;
	private WorldRenderer renderer;
	private WorldController controller;
	
	private int width, height;
	
	@Override
	public void render( float delta ){
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		controller.update(delta);
		renderer.render();
	
	}
	@Override
	public void resize( int width, int height ){
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;
	}
	@Override
	public void show(){
		world = new World();
		renderer = new WorldRenderer( world );
		controller = new WorldController (world);
		Gdx.input.setInputProcessor(this);
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
	
	
	
	// * InputProcessor methods ***************************//

		@Override
		public boolean keyDown(int keycode) {
			if (keycode == Keys.LEFT)
				controller.leftPressed();
			if (keycode == Keys.RIGHT)
				controller.rightPressed();
			if (keycode == Keys.UP)
				controller.upPressed();
			if (keycode == Keys.DOWN)
				controller.downPressed();
			if (keycode == Keys.Z)
				controller.jumpPressed();
			if (keycode == Keys.X)
				controller.firePressed();
			return true;
		}

		@Override
		public boolean keyUp(int keycode) {
			if (keycode == Keys.LEFT)
				controller.leftReleased();
			if (keycode == Keys.RIGHT)
				controller.rightReleased();
			if (keycode == Keys.UP)
				controller.upReleased();
			if (keycode == Keys.DOWN)
				controller.downReleased();
			if (keycode == Keys.Z)
				controller.jumpReleased();
			if (keycode == Keys.X)
				controller.fireReleased();
			return true;
		}

		@Override
		public boolean keyTyped(char character) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDown(int x, int y, int pointer, int button) {
			if (x < width / 2 && y > height / 2) {
				controller.leftPressed();
			}
			if (x > width / 2 && y > height / 2) {
				controller.rightPressed();
			}
			return true;
		}

		@Override
		public boolean touchUp(int x, int y, int pointer, int button) {
			if (x < width / 2 && y > height / 2) {
				controller.leftReleased();
			}
			if (x > width / 2 && y > height / 2) {
				controller.rightReleased();
			}
			return true;
		}

		@Override
		public boolean touchDragged(int x, int y, int pointer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean mouseMoved(int x, int y) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean scrolled(int amount) {
			// TODO Auto-generated method stub
			return false;
		}
}
