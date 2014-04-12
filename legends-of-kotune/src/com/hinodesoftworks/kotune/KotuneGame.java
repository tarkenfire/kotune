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
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

/**
 * The Main Game class.
 */
public class KotuneGame implements ApplicationListener 
{	
	private Stage stage;
	
	Label colText;
	
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
		
		Player player = new Player();
		
		player.setTouchable(Touchable.enabled);
		player.setHandle(this);
		
		stage.addActor(player);
		

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
		
	}
	
	//TODO: Demo method to be removed next week
	/**
	 * On hit.
	 *
	 * @param hit the hit
	 */
	public void onHit(boolean hit)
	{
		BitmapFont font = new BitmapFont();
		LabelStyle style = new LabelStyle();
		style.font = font;
		String holderText;
		
		if (hit)
		{
			holderText = "Collision";
			style.fontColor = Color.RED;
		}
		else
		{
			holderText = "No Collision";
			style.fontColor = Color.GREEN;
		}
		
		colText.setText(holderText);
		colText.setStyle(style);
		
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
