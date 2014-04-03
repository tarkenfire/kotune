/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

public class KotuneGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	
	//sprites
	private Sprite background;
	
	private Stage stage;
	
	//movement handler
	
	@Override
	public void create() 
	{		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		Background bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(bg);
		
		Player player = new Player();
		stage.addActor(player);
		
		Texture enemy1Tex = new Texture(Gdx.files.internal("data/sprites/enemy1.png"));
		Texture enemy2Tex = new Texture(Gdx.files.internal("data/sprites/enemy2.png"));
		
		Enemy e1 = new Enemy(enemy1Tex, 250, 40);
		Enemy e2 = new Enemy(enemy2Tex, 500, 40);
		
		stage.addActor(e1);
		stage.addActor(e2);
		
		
	}

	@Override
	public void dispose() 
	{
		batch.dispose();
		texture.dispose();
		stage.dispose();
	}

	@Override
	public void render() 
	{		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    //stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
