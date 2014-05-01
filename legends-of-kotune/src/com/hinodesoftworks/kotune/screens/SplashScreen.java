/* 
 * Date: Apr 29, 2014
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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Background;

public class SplashScreen implements Screen
{
	KotuneGame gameRef;
	
	Stage stage;
	Background bg;
	
	

	public SplashScreen(KotuneGame ref)
	{
		this.gameRef = ref;
	}
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}

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

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

}
