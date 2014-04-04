/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.hinodesoftworks.kotune.KotuneGame;

public class Player extends Actor
{
	Texture sprite = new Texture(Gdx.files.internal("data/sprites/player.png"));
	float x = 20, y = 20;
	
	//TODO: Remove next week
	private KotuneGame gameRef = null;
	
	public Player()
	{
		this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
		this.addListener(listener);
	}
	
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, x, y);
    }
    
    //TODO demo methods to be removed next week.
    public void setHandle(KotuneGame game)
    {
    	gameRef = game;
    }
    
    @Override
	public void act(float delta)
	{
    	Actor hittingActor = this.getStage().hit(x, y, false);
    	
    	if (hittingActor != null && hittingActor instanceof Enemy)
    	{
    		Gdx.app.log("Hit Detection", "Has Hit");
    		gameRef.onHit(true);
    	}
    	else
    	{
    		gameRef.onHit(false);
    	}
	}

	public InputListener listener = new InputListener()
    {
		@Override
		public void touchDragged(InputEvent event, float newX, float newY, int pointer)
		{
			y = newY;
		}    	
		
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button)
		{	
			return true;
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer,
				int button)
		{
			//setBounds(x, y, sprite.getWidth(), sprite.getHeight());
		}
		
    };
    
}
