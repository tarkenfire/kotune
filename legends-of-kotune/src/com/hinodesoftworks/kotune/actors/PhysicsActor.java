package com.hinodesoftworks.kotune.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class PhysicsActor extends Actor
{
	protected Body boundingBody = null;
	protected Texture sprite = null;
	
	abstract boolean createPhysicsBody();

	//mutators and accessors
	public Body getBoundingBody()
	{
		return boundingBody;
	}

	public Texture getSprite()
	{
		return sprite;
	}

	public void setSprite(Texture sprite)
	{
		this.sprite = sprite;
	}
	
	
	
	
}
