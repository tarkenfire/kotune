/* 
 * Date: Apr 12, 2014
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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

// TODO: Auto-generated Javadoc
/**
 * An Actor that represents the human player.
 */
public class Player extends Actor
{
	Texture sprite = new Texture(Gdx.files.internal("data/sprites/player.png"));
	float x = 20, y = 20;
	
	boolean isAlive = true;
	boolean inputActive = true;
	
	Sound deathSound;
	Sound winSound;
	
	/**
	 * Instantiates a new player.
	 */
	public Player()
	{
		this.setWidth(sprite.getWidth());
		this.setHeight(sprite.getHeight());
		
		deathSound = Gdx.audio.newSound(Gdx.files.internal("data/sfx/explosion.mp3"));
		winSound = Gdx.audio.newSound(Gdx.files.internal("data/sfx/victory.mp3"));
		
		this.setBounds(x, y, getWidth(), getHeight());
		this.addListener(listener);
		
	}
	
	/**
	 * Gets the player bounds.
	 *
	 * @return the player bounds
	 */
	public Rectangle getPlayerBounds()
	{
		return new Rectangle(x, y, getWidth(), getHeight());
	}
	
	/**
	 * Kill player.
	 */
	public void killPlayer()
	{
		x = 20;
		y = 20;
		
		if (isAlive)
		{
			deathSound.play();
			isAlive = false;
		}
		
		//hacky way to only play sound once, reset sentinal boolean after timer
		Timer.schedule(new Task()
		{
			@Override
			public void run()
			{
				isAlive = true;
			}
			
		}, .5f);
	}
	
	
    /* (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.g2d.Batch, float)
     */
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, x, y);
    }
    
    /* (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#act(float)
     */
    @Override
	public void act(float delta)
	{
    	super.act(delta);
	}

	public InputListener listener = new InputListener()
    {
		@Override
		public void touchDragged(InputEvent event, float newX, float newY, int pointer)
		{
			//if (!inputActive) return;
			
			y = newY - sprite.getHeight()/2;
			x = newX - sprite.getWidth()/2;
		}    	
		
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button)
		{	
			return true;
		}

		@Override
		public void touchUp(InputEvent event, float newX, float newY, int pointer,
				int button)
		{	
		}
		
    };
    
}
