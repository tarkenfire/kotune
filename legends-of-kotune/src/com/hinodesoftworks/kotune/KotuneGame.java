/* 
 * Date: Apr 12, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.hinodesoftworks.kotune.screens.CreditsScreen;
import com.hinodesoftworks.kotune.screens.GameScreen;
import com.hinodesoftworks.kotune.screens.InstructScreen;
import com.hinodesoftworks.kotune.screens.MenuScreen;
import com.hinodesoftworks.kotune.screens.SplashScreen;

// TODO: Auto-generated Javadoc
/**
 * The Main Game class.
 */
public class KotuneGame extends Game
{		
	SplashScreen splashScreen;
	MenuScreen menuScreen;
	InstructScreen instructScreen;
	CreditsScreen creditsScreen;
	
	Music bgm;
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() 
	{		
		splashScreen = new SplashScreen(this);
		menuScreen = new MenuScreen(this);
		creditsScreen = new CreditsScreen(this);
		instructScreen = new InstructScreen(this);
		
		bgm= Gdx.audio.newMusic(Gdx.files.internal("data/bgm/bgm.mp3"));
		
		setScreen(splashScreen);
	}
	
	public void transitionToMenu()
	{
		if (!bgm.isPlaying())
		{
			bgm.play();
		}
		setScreen(menuScreen);
	}
	
	public void transitionToGame()
	{
		setScreen(new GameScreen(this));
	}
	
	public void transitionToCredits()
	{
		setScreen(creditsScreen);
	}
	
	public void transitionToInstructions()
	{
		setScreen(instructScreen);
	}
	
	@Override
	public void pause()
	{
		bgm.pause();
		
	}

	@Override
	public void resume()
	{
		if (!bgm.isPlaying())
		{
			bgm.play();
		}
	}
}
