/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.actors
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Represents an Actor which the player must defeat.
 */
public class Enemy extends Actor
{
	Texture sprite;
	float x = 0, y = 0;
	
	float sWidth = 0, sHeight = 0;
	
	boolean isMovingLeft = false;
	
	static final int SPEED = 200;
	
	
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
	
	public Rectangle getEnemyBounds()
	{
		return new Rectangle(x, y, getWidth(), getHeight());
	}

	@Override
	public void act(float delta)
	{
		if (isMovingLeft)
		{
			x-= SPEED * delta;	
		}
		else
		{
			x+= SPEED * delta;
		}
		
		this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
		
		if (x + sprite.getWidth() > sWidth)
		{
			isMovingLeft = true;
		}
		
		if (x < 0)
		{
			isMovingLeft = false;
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
