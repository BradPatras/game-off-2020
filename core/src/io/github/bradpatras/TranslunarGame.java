package io.github.bradpatras;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.bradpatras.screens.EndScreen;
import io.github.bradpatras.screens.MainScreen;
import io.github.bradpatras.screens.MenuScreen;

public class TranslunarGame extends Game {
	SpriteBatch batch;
	Texture img;
	public AssetManager assetManager;

	/**
	 * Screens
	 */
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;

	public final static int MENU = 0;
	public final static int GAME = 1;
	public final static int ENDGAME = 2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen();
				this.setScreen(menuScreen);
				break;
			case GAME:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen();
				this.setScreen(endScreen);
				break;
		}
	}
}
