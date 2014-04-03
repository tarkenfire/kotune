/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor
{
	Texture sprite;
	float x = 0, y = 0;
	
	
	public Enemy(Texture enemyTexture, float initialX, float initialY)
	{
		this.x = initialX;
		this.y = initialY;
		
		sprite = enemyTexture;
		this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(sprite, x, y);
    }
}
