package de.respawnproductions.flip;

import de.respawnproductions.flip.GameScreen;
import com.badlogic.gdx.Game;

public class Flip extends Game {
	@Override
	public void create(){
		setScreen(new GameScreen());
	}
}
