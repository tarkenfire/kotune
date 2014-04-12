/* 
 * Date: Apr 3, 2014
 * Project: legends-of-kotune
 * Package: com.hinodesoftworks.kotune
 * @author Michael Mancuso
 *
 */
package com.hinodesoftworks.kotune;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

/**
 * The Main Game class.
 */
public class KotuneGame implements ApplicationListener 
{	
	private Stage stage;
	Box2DDebugRenderer debugRenderer;
	World world = new World(new Vector2(0, -10), true); 
	
	Label colText;
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() 
	{		
		stage = new Stage();
		stage.setViewport(new FitViewport(16.0f, 9.0f));
		Gdx.input.setInputProcessor(stage);
		
		debugRenderer = new Box2DDebugRenderer();
		//Background bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//stage.addActor(bg);
		
		Player player = new Player();
		
		player.setTouchable(Touchable.enabled);
		player.setHandle(this);
		
		stage.addActor(player);
		
		
		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(1.5f, 10.0f);

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(6.0f);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit

		// Create our fixture and attach it to the body
		Fixture fixture = body.createFixture(fixtureDef);

		// Remember to dispose of any shapes after you're done with them!
		// BodyDef and FixtureDef don't need disposing, but shapes do.
		circle.dispose();
		
		
		// Create our body definition
		BodyDef groundBodyDef =new BodyDef();  
		// Set its world position
		groundBodyDef.position.set(new Vector2(0, 10));  

		// Create a body from the defintion and add it to the world
		Body groundBody = world.createBody(groundBodyDef);  

		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();  
		// Set the polygon shape as a box which is twice the size of our view port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		groundBox.setAsBox(stage.getCamera().viewportWidth, 10.0f);
		// Create a fixture from our polygon shape and add it to our ground body  
		groundBody.createFixture(groundBox, 0.0f); 
		// Clean up after ourselves
		groundBox.dispose();

	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#dispose()
	 */
	@Override
	public void dispose() 
	{
		stage.dispose();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#render()
	 */
	@Override
	public void render() 
	{		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		
	    stage.act(Gdx.graphics.getDeltaTime());
	    
	    debugRenderer.render(world, stage.getCamera().combined);
	    world.step(1/60f, 6, 2);
		
		
		
	}
	
	//TODO: Demo method to be removed next week
	/**
	 * On hit.
	 *
	 * @param hit the hit
	 */
	public void onHit(boolean hit)
	{
		BitmapFont font = new BitmapFont();
		LabelStyle style = new LabelStyle();
		style.font = font;
		String holderText;
		
		if (hit)
		{
			holderText = "Collision";
			style.fontColor = Color.RED;
		}
		else
		{
			holderText = "No Collision";
			style.fontColor = Color.GREEN;
		}
		
		colText.setText(holderText);
		colText.setStyle(style);
		
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#pause()
	 */
	@Override
	public void pause() {
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#resume()
	 */
	@Override
	public void resume() {
	}
}
