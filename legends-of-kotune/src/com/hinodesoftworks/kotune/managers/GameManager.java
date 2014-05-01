/* 
 * Date: Apr 17, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.managers
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.managers;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.hinodesoftworks.kotune.KotuneGame;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;
import com.hinodesoftworks.kotune.listeners.EnemyChangeListener;
import com.hinodesoftworks.kotune.screens.GameScreen;

public class GameManager implements EnemyChangeListener
{
	boolean hasWon = false;
	boolean isPaused = false;
	
	int score = 0;
	Stage gameStage;
	Player player;
	
	CollisionManager colManager;
	GameScreen gameRef;
	
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
	
	public void setGameInstance(GameScreen gameScreen)
	{
		this.gameRef = gameScreen;
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
	
	public void addActor(Actor actor)
	{
		gameStage.addActor(actor);
		
		if (actor instanceof Enemy)
		{
			colManager.addEnemy((Enemy) actor);
		}
		
	}
	
	public void removeActor (Actor actor)
	{
		actor.remove();
		
		if (actor instanceof Enemy)
		{
			colManager.removeEnemy((Enemy)actor);
		}
	}
	
	public void disposeAllEnemies()
	{
		for (Actor a : gameStage.getActors())
		{
			if (a instanceof Enemy)
			{
				removeActor(a);
			}
		}
	}
	
	private void addNewEnemy()
	{
		Enemy enemyToAdd = new Enemy(new Texture(Gdx.files.internal("data/sprites/enemy1.png")), GameManager.randInt(0, Gdx.graphics.getWidth()),Gdx.graphics.getHeight());
		enemyToAdd.setEnemyListener(this);
		enemyToAdd.setScoreListener(gameRef);
		addActor(enemyToAdd);
	}

	public void update()
	{
		//if (!isPaused)
		//{
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		    gameStage.act(Gdx.graphics.getDeltaTime());
		    gameStage.draw();
		    
			if (colManager.hasPlayerCollided())
			{
				player.killPlayer();
			}
			
			Gdx.app.log("Enemies", Integer.toString(colManager.getEnemyCount()));
			
			if (colManager.getEnemyCount() < 3)
			{
				addNewEnemy();
			}
		//}
	}
	
	public static int randInt(int min, int max)
	{
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	@Override
	public void onEnemyLeftScreen(Enemy enemy)
	{
		removeActor(enemy);
	}
}
