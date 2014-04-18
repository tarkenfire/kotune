/* 
 * Date: Apr 12, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.managers
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.managers;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class CollisionManager.
 */
public class CollisionManager
{
	private static CollisionManager _instance = null;
	
	private ArrayList<Enemy> enemyList;
	private Player playerRef;
	
	private Rectangle victoryPoint;
	private Rectangle collisionRect;
	
	
	/**
	 * Instantiates a new collision manager.
	 *
	 * @param playerRef the player ref
	 */
	private CollisionManager(Player playerRef)
	{
		enemyList = new ArrayList<Enemy>();
		this.playerRef = playerRef;
		this.victoryPoint = new Rectangle();
		this.collisionRect = new Rectangle();
	}
	
	/**
	 * Gets the single instance of CollisionManager.
	 *
	 * @param playerRef the player ref
	 * @return single instance of CollisionManager
	 */
	public static CollisionManager getInstance(Player playerRef)
	{
		if (_instance == null)
		{
			_instance = new CollisionManager(playerRef);
		}
		
		return _instance;
	}
	
	/**
	 * Adds the enemy.
	 *
	 * @param newEnemy the new enemy
	 */
	public void addEnemy(Enemy newEnemy)
	{
		this.enemyList.add(newEnemy);
	}
	
	/**
	 * Removes the enemy.
	 *
	 * @param enemyToRemove the enemy to remove
	 * @return true, if successful
	 */
	public boolean removeEnemy(Enemy enemyToRemove)
	{
		return this.enemyList.remove(enemyToRemove);
	}
	
	public int getEnemyCount()
	{
		return enemyList.size();
	}
	
	
	/**
	 * Checks for player collided.
	 *
	 * @return true, if successful
	 */
	public boolean hasPlayerCollided()
	{
		
		Iterator<Enemy> eneIterator = enemyList.iterator();
		
		while (eneIterator.hasNext())
		{
			Enemy testEnemy = eneIterator.next();
			
			if (Intersector.intersectRectangles(playerRef.getPlayerBounds(), testEnemy.getEnemyBounds(), collisionRect))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks for player reached point.
	 *
	 * @param point the point
	 * @return true, if successful
	 */
	public boolean hasPlayerReachedPoint(Vector2 point)
	{
		victoryPoint = new Rectangle(point.x, point.y, 1, 1);
		
		if (Intersector.intersectRectangles(playerRef.getPlayerBounds(), victoryPoint, collisionRect))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
}
