package com.hinodesoftworks.kotune.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

public class GameManager
{
	boolean hasWon = false;
	boolean isPaused = false;
	
	int score = 0;
	Stage gameStage;
	Player player;
	
	CollisionManager colManager;
	
	public static GameManager _instance = null;
	
	public static GameManager getInstance(Stage gameStage, Player player)
	{
		if (_instance == null)
		{
			_instance = new GameManager(gameStage, player);
		}
		
		return _instance;
	}
	
	private GameManager(Stage stage, Player player)
	{
		gameStage = stage;
		this.player = player;
		colManager = CollisionManager.getInstance(player);
	}
	
	public boolean toggleGameState()
	{
		if (isPaused)
		{
			isPaused = false;
			return false;
		}
		else
		{
			isPaused = true;
			return true;
		}
	}
	
	public void startGame()
	{
		isPaused = false;
	}
	
	public void pauseGame()
	{
		isPaused = true;
	}
	
	public void addActor(Actor actor)
	{
		gameStage.addActor(actor);
		
		if (actor instanceof Enemy)
		{
			colManager.addEnemy((Enemy) actor);
		}
		
	}

	public void update()
	{
		if (!isPaused)
		{
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		    gameStage.act(Gdx.graphics.getDeltaTime());
		    gameStage.draw();
		    
			if (colManager.hasPlayerCollided())
			{
				player.killPlayer();
			}
		}
	}
}
