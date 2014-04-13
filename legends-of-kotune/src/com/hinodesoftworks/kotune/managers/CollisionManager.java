package com.hinodesoftworks.kotune.managers;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

public class CollisionManager
{
	private static CollisionManager _instance = null;
	
	private ArrayList<Enemy> enemyList;
	private Player playerRef;
	
	private Rectangle victoryPoint;
	private Rectangle collisionRect;
	
	
	private CollisionManager(Player playerRef)
	{
		enemyList = new ArrayList<Enemy>();
		this.playerRef = playerRef;
		this.victoryPoint = new Rectangle();
		this.collisionRect = new Rectangle();
	}
	
	public static CollisionManager getInstance(Player playerRef)
	{
		if (_instance == null)
		{
			_instance = new CollisionManager(playerRef);
		}
		
		return _instance;
	}
	
	public void addEnemy(Enemy newEnemy)
	{
		this.enemyList.add(newEnemy);
	}
	
	public boolean removeEnemy(Enemy enemyToRemove)
	{
		return this.enemyList.remove(enemyToRemove);
	}
	
	
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
