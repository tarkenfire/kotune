/* 
 * Date: Apr 12, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.actors
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hinodesoftworks.kotune.listeners.EnemyChangeListener;
import com.hinodesoftworks.kotune.listeners.ScoreListener;

// TODO: Auto-generated Javadoc
/**
 * Represents an Actor which the player must defeat.
 */
public class Enemy extends Actor
{	
	Texture sprite;
	float x = 0, y = 0;
	
	float sWidth = 0, sHeight = 0;
	
	boolean isMovingLeft = false;
	
	static final int SPEED = 400;
	
	EnemyChangeListener eListener;
	ScoreListener sListener;
	
	/**
	 * Instantiates a new enemy.
	 *
	 * @param enemyTexture the enemy texture
	 * @param initialX the initial x position
	 * @param initialY the initial y position
	 */
	public Enemy(Texture enemyTexture, float initialX, float initialY)
	{
		this.x = initialX;
		this.y = initialY;
		
		sWidth = Gdx.graphics.getWidth();
		
		sprite = enemyTexture;

		this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	public void setEnemyListener(EnemyChangeListener ecl)
	{
		this.eListener = ecl;
	}
	
	public void setScoreListener(ScoreListener sl)
	{
		this.sListener = sl;
	}
	
	/**
	 * Gets the enemy bounds.
	 *
	 * @return the enemy bounds
	 */
	public Rectangle getEnemyBounds()
	{
		return new Rectangle(x, y, getWidth(), getHeight());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#act(float)
	 */
	@Override
	public void act(float delta)
	{
		y-= SPEED*delta;
		
		if (y <= -200)
		{
			eListener.onEnemyLeftScreen(this);
			sListener.onScore();
		}
		
	}
	
    /* (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.g2d.Batch, float)
     */
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, x, y);
    }
   
    
    
}
