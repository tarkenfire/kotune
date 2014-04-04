/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune.actors
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
	
	Sound demoSound = null;
	
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
		
		sprite = enemyTexture;
		
		this.addListener(listener);

		this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	//TODO demo method to be removed in week 2
	/**
	 * Sets the sound.
	 *
	 * @param sound the new sound
	 */
	public void setSound(Sound sound)
	{
		demoSound = sound;
	}
	
    /* (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.g2d.Batch, float)
     */
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, x, y);
    }
    
    //TODO: No input required in week 2
    public InputListener listener = new InputListener()
    {

		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button)
		{
			if (demoSound != null)
			{
				demoSound.play();
				return true;
			}
			
			
			return false;
		}
    	
    };
    
    
}
