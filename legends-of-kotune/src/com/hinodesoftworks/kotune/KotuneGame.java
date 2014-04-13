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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;
import com.hinodesoftworks.kotune.managers.CollisionManager;

/**
 * The Main Game class.
 */
public class KotuneGame implements ApplicationListener 
{	
	private Stage stage;
	
	Label colText;
	Player player;
	Enemy enemy, enemy2;
	
	Rectangle rect;
	
	CollisionManager colManager;
	Vector2 victoryPoint;
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() 
	{		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		
		Background bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(bg);
		
		player = new Player();
		player.setTouchable(Touchable.enabled);
		
		stage.addActor(player);
		
		colManager = CollisionManager.getInstance(player);
		
		enemy = new Enemy(new Texture(Gdx.files.internal("data/sprites/enemy1.png")), 100, 350);
		stage.addActor(enemy);
		
		colManager.addEnemy(enemy);
		
		enemy2 = new Enemy(new Texture(Gdx.files.internal("data/sprites/enemy1.png")), 300, 700);
		stage.addActor(enemy2);
		
		colManager.addEnemy(enemy2);
		
		BitmapFont font = new BitmapFont();

		LabelStyle style = new LabelStyle();
	    style.fontColor = Color.GREEN;
		style.font = font;
		
		colText = new Label("<< Point of Supreme Victory", style);
		colText.setBounds(190,1100,100,40);
		colText.setFontScale(3);
		stage.addActor(colText);
		
		victoryPoint = new Vector2(140, 1100);

	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#dispose()
	 */
	@Override
	public void dispose() 
	{
		stage.dispose();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#render()
	 */
	@Override
	public void render() 
	{		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	 
	    //handle collisions
	    if (colManager.hasPlayerCollided())
	    {
	    	player.killPlayer();
	    }
	    
	    if (colManager.hasPlayerReachedPoint(victoryPoint))
	    {
	    	player.winGame();
	    }
	}


	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#pause()
	 */
	@Override
	public void pause() {
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#resume()
	 */
	@Override
	public void resume() {
	}
}
