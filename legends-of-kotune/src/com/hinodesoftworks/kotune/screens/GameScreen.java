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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Player;
import com.hinodesoftworks.kotune.listeners.GameEndedListener;
import com.hinodesoftworks.kotune.listeners.ScoreListener;
import com.hinodesoftworks.kotune.managers.GameManager;

// TODO: Auto-generated Javadoc
/**
 * The Class GameScreen.
 */
public class GameScreen implements Screen, GameEndedListener, ScoreListener
{
	
	private Stage stage;
	
	Label colText;
	TextButton pauseButton;
	Player player;
	
	int counter = 0;
	
	int score = 0;
	
	GameManager gameManager;
	
	KotuneGame gameRef;
	
	/**
	 * Instantiates a new game screen.
	 *
	 * @param ref the ref
	 */
	public GameScreen (KotuneGame ref)
	{
		this.gameRef = ref;
	}
	

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta)
	{
		gameManager.update();
		
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
		Gdx.input.setInputProcessor(stage);

		Background bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		player = new Player();
		player.setTouchable(Touchable.enabled);
		
		player.setGameListener(this);
		
		gameManager = GameManager.getInstance(stage, player);
		gameManager.setGameInstance(this);
		
		gameManager.addActor(bg);
		gameManager.addActor(player);
		
		BitmapFont font = new BitmapFont();

		font.setScale(3);
		
		//UI element, score label
		LabelStyle style = new LabelStyle();
	    style.fontColor = Color.WHITE;
		style.font = font;
		
		colText = new Label("0", style);
		colText.setBounds(Gdx.graphics.getWidth() - 120, Gdx.graphics.getHeight() - 60,100,40);
		colText.setFontScale(3);
		
		//pause button
	    TextButtonStyle textButtonStyle = new TextButtonStyle();
	    textButtonStyle.font = font;
	    
	    
	    pauseButton = new TextButton("Pause", textButtonStyle);
	    pauseButton.setSize(100, 50);
	    pauseButton.setBounds(50, Gdx.graphics.getHeight() - 60, 100, 50);
	    
	    pauseButton.addListener(new ClickListener()
	    {
	    	public void clicked(InputEvent event, float x, float y) 
	    	{
	    		gameManager.toggleGameState();
	    	}
	    }
	    );
	    
	    //add ui
		gameManager.addActor(colText);
		gameManager.addActor(pauseButton);
		
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

	/* (non-Javadoc)
	 * @see com.hinodesoftworks.kotune.listeners.GameEndedListener#onGameEnded()
	 */
	@Override
	public void onGameEnded()
	{
	    TextButtonStyle textButtonStyle = new TextButtonStyle();
	    BitmapFont font = new BitmapFont();
	    font.setScale(3);
	    textButtonStyle.font = font;
	    
	    final TextButton retry = new TextButton("Game Over.", textButtonStyle);
	    retry.setSize(200, 40);
	    retry.setBounds(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 , 200, 40);
		  
	    retry.addListener(new ChangeListener() 
	    {
	        public void changed (ChangeEvent event, Actor actor) 
	        {
	        	gameManager.toggleGameState();
	        	score = 0;
	        	colText.setText("0");
	        	gameManager.removeActor(retry);
	        	
	        }
	    });
	    gameManager.addActor(retry);
	    gameManager.disposeAllEnemies();
		gameManager.toggleGameState();
		
		gameRef.transitionToMenu();
		
	}

	/* (non-Javadoc)
	 * @see com.hinodesoftworks.kotune.listeners.ScoreListener#onScore()
	 */
	@Override
	public void onScore()
	{
		score++;
		colText.setText(Integer.toString(score));
	}

}
