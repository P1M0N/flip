package de.respawnproductions.flip;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class FlipDesktop {
	public static void main( String[] args){
		new LwjglApplication( new Flip(), "Flip", 480, 320 );
	}
}
