/* 
 * Date: Apr 12, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
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
import com.hinodesoftworks.kotune.listeners.GameEndedListener;
import com.hinodesoftworks.kotune.listeners.ScoreListener;
import com.hinodesoftworks.kotune.managers.CollisionManager;
import com.hinodesoftworks.kotune.managers.GameManager;
import com.hinodesoftworks.kotune.screens.CreditsScreen;
import com.hinodesoftworks.kotune.screens.GameScreen;
import com.hinodesoftworks.kotune.screens.MenuScreen;
import com.hinodesoftworks.kotune.screens.SplashScreen;

// TODO: Auto-generated Javadoc
/**
 * The Main Game class.
 */
public class KotuneGame extends Game
{		
	
	GameScreen gameScreen;
	SplashScreen splashScreen;
	MenuScreen menuScreen;
	CreditsScreen creditsScene;
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() 
	{		
		splashScreen = new SplashScreen(this);
		menuScreen = new MenuScreen(this);
		
		setScreen(splashScreen);
	}
	
	public void transitionToMenu()
	{
		setScreen(menuScreen);
	}
	
	public void transitionToGame()
	{
		
	}
	
	public void transitionToCredits()
	{
		
	}
	
	public void transitionToInstructions(){}
}
