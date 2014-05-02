/* 
 * Date: May 1, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.screens
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Background;

// TODO: Auto-generated Javadoc
/**
 * The Class SplashScreen.
 */
public class SplashScreen implements Screen
{
	KotuneGame gameRef;
	
	Stage stage;
	Background bg;
	
	

	/**
	 * Instantiates a new splash screen.
	 *
	 * @param ref the ref
	 */
	public SplashScreen(KotuneGame ref)
	{
		this.gameRef = ref;
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show()
	{
		stage = new Stage();
		bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 
				new Texture(Gdx.files.internal("data/splash.png")));
		
		stage.addActor(bg);
		
		Timer.schedule(new Task()
		{
			@Override
			public void run()
			{
				gameRef.transitionToMenu();
			}
			
		}, 2f);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

}
