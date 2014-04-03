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
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor
{
	Texture sprite = new Texture(Gdx.files.internal("data/background.png"));
	
	public Background(float width, float height)
	{
		this.setBounds(0, 0, width, height);
	}
	
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    

	
}
