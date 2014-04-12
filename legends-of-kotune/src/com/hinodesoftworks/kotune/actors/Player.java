/* 
 * Date: Apr 3, 2014
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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.hinodesoftworks.kotune.KotuneGame;

/**
 * An Actor that represents the human player
 */
public class Player extends Actor
{
	Texture sprite = new Texture(Gdx.files.internal("data/sprites/player.png"));
	float x = 20, y = 20;
	
	//TODO: Remove next week
	private KotuneGame gameRef = null;
	
	/**
	 * Instantiates a new player.
	 */
	public Player()
	{
		this.setWidth(sprite.getWidth());
		this.setHeight(sprite.getHeight());
		
		this.setBounds(x, y, getWidth(), getHeight());
		this.addListener(listener);
		
	}
	
	public Rectangle getPlayerBounds()
	{
		return new Rectangle(x, y, getWidth(), getHeight());
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
			//setBounds(newX, newY, sprite.getWidth(), sprite.getHeight());
			
		}
		
    };
    
}
