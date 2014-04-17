/* 
 * Date: Apr 12, 2014
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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;
import com.hinodesoftworks.kotune.managers.CollisionManager;
import com.hinodesoftworks.kotune.managers.GameManager;

// TODO: Auto-generated Javadoc
/**
 * The Main Game class.
 */
public class KotuneGame implements ApplicationListener 
{	
	private Stage stage;
	
	Label colText;
	TextButton pauseButton;
	Player player;
	
	int counter = 0;
	
	Rectangle rect;
	
	GameManager gameManager;
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
		player = new Player();
		player.setTouchable(Touchable.enabled);
		
		gameManager = GameManager.getInstance(stage, player);
		
		gameManager.addActor(bg);
		gameManager.addActor(player);
		
		Enemy enemy = new Enemy(new Texture(Gdx.files.internal("data/sprites/enemy1.png")), 100, 350);
		gameManager.addActor(enemy);
		
		BitmapFont font = new BitmapFont();

		font.setScale(3);
		
		//UI element, score label
		LabelStyle style = new LabelStyle();
	    style.fontColor = Color.WHITE;
		style.font = font;
		
		colText = new Label("0000", style);
		colText.setBounds(Gdx.graphics.getWidth() - 120, Gdx.graphics.getHeight() - 60,100,40);
		colText.setFontScale(3);
		
		//pause button
	    TextButtonStyle textButtonStyle = new TextButtonStyle();
	    textButtonStyle.font = font;
	    
	    
	    pauseButton = new TextButton("Pause", textButtonStyle);
	    pauseButton.setSize(100, 50);
	    pauseButton.setBounds(50, Gdx.graphics.getHeight() - 60, 100, 50);
	    
	    pauseButton.addListener(new ChangeListener() 
	    {
	        public void changed (ChangeEvent event, Actor actor) 
	        {
	        	gameManager.toggleGameState();
	        	pauseButton.getLabel().setText("Resume");
	        	
	        }
	    });
	    
	    //add ui
		gameManager.addActor(colText);
		gameManager.addActor(pauseButton);
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
		gameManager.update();
	 
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
