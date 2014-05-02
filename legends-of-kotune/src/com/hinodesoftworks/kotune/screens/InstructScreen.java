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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Background;

// TODO: Auto-generated Javadoc
/**
 * The Class InstructScreen.
 */
public class InstructScreen implements Screen
{
	
	KotuneGame gameRef;
	
	Stage stage;
	Background bg;
	
	TextButton backButton;
	
	/**
	 * Instantiates a new instruct screen.
	 *
	 * @param ref the ref
	 */
	public InstructScreen(KotuneGame ref)
	{
		gameRef = ref;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta)
	{
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
				new Texture(Gdx.files.internal("data/instruct.png")));
		
		Gdx.input.setInputProcessor(stage);
		
		BitmapFont font = new BitmapFont();
		font.setScale(6);
		
	    TextButtonStyle textButtonStyle = new TextButtonStyle();
	    textButtonStyle.font = font;
		
	    backButton = new TextButton("Back", textButtonStyle);
	    backButton.setSize(300, 50);
	    backButton.setBounds(Gdx.graphics.getWidth() / 2 - 100, 50, 300, 50);
	    
	    backButton.addListener(new ClickListener()
	    {
	    	public void clicked(InputEvent event, float x, float y) 
	    	{
	    		gameRef.transitionToMenu();
	    	}
	    }
	    );
	    
	    stage.addActor(bg);
	    stage.addActor(backButton);
		
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
