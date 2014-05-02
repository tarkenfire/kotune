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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Background;

public class MenuScreen implements Screen
{
	KotuneGame gameRef;
	
	Stage stage;
	Background bg;
	
	TextButton playButton, instructButton, creditButton;

	public MenuScreen(KotuneGame ref)
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
				new Texture(Gdx.files.internal("data/main.png")));

		Gdx.input.setInputProcessor(stage);

		
		//setup horrid text buttons
		BitmapFont font = new BitmapFont();
		font.setScale(6);
		
	    TextButtonStyle textButtonStyle = new TextButtonStyle();
	    textButtonStyle.font = font;
	    
	    playButton = new TextButton("Play Game", textButtonStyle);
	    playButton.setSize(300, 50);
	    playButton.setBounds(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2, 300, 50);
	    
	    instructButton = new TextButton("Instructions", textButtonStyle);
	    instructButton.setSize(300, 50);
	    instructButton.setBounds(playButton.getX(), playButton.getY() - 200 , 300, 50);
	    
	    creditButton = new TextButton("Credits", textButtonStyle);
	    creditButton.setSize(300, 50);
	    creditButton.setBounds(instructButton.getX(), instructButton.getY() - 200, 300, 50);
	    
	    
	    //button listeners
	    playButton.addListener(new ChangeListener() 
	    {
	        public void changed (ChangeEvent event, Actor actor) 
	        {
	        	Gdx.app.log("STRING", "GAME");
	        	gameRef.transitionToGame();
	        }
	    });
	    
	    instructButton.addListener(new ClickListener()
	    {
	    	public void clicked(InputEvent event, float x, float y) 
	    	{
	    		Gdx.app.log("STRING", "INST");
	    		gameRef.transitionToInstructions();
	    	}
	    }
	    );
	    
	    creditButton.addListener(new ClickListener()
	    {
	    	public void clicked(InputEvent event, float x, float y) 
	    	{
	    		gameRef.transitionToCredits();
	    	}
	    }
	    );
	    
	    
	    //add to stage
	    stage.addActor(bg);
	    stage.addActor(playButton);
	    stage.addActor(instructButton);
	    stage.addActor(creditButton);
	    
	    
		
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
