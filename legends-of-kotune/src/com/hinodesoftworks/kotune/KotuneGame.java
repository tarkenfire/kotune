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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.hinodesoftworks.kotune.actors.Background;
import com.hinodesoftworks.kotune.actors.Enemy;
import com.hinodesoftworks.kotune.actors.Player;

public class KotuneGame implements ApplicationListener 
{	
	private Stage stage;
	
	Label colText;
	
	@Override
	public void create() 
	{		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		Background bg = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(bg);
		
		Player player = new Player();
		
		player.setTouchable(Touchable.enabled);
		player.setHandle(this);
		
		stage.addActor(player);
		
		Texture enemy1Tex = new Texture(Gdx.files.internal("data/sprites/enemy1.png"));
		Texture enemy2Tex = new Texture(Gdx.files.internal("data/sprites/enemy2.png"));
		
		Enemy e1 = new Enemy(enemy1Tex, 300, 40);
		Enemy e2 = new Enemy(enemy2Tex, 500, 40);
		
		e1.setTouchable(Touchable.enabled);
		e2.setTouchable(Touchable.enabled);
		
		Sound explosion = Gdx.audio.newSound(Gdx.files.internal("data/sfx/explosion.mp3"));
		Sound tripleShot = Gdx.audio.newSound(Gdx.files.internal("data/sfx/three-shot.mp3"));
		
		e1.setSound(explosion);
		e2.setSound(tripleShot);
		
		stage.addActor(e1);
		stage.addActor(e2);
		
		
		BitmapFont font = new BitmapFont();
		LabelStyle style = new LabelStyle();
		style.fontColor = Color.GREEN;
		style.font = font;
		
		colText = new Label("No Collision", style);
		colText.setBounds(200,800,100,40);
		colText.setFontScale(3);
		
		stage.addActor(colText);
		
		style.fontColor = Color.WHITE;
		
		Label soundLabel = new Label("Tap for Sounds", style);
		soundLabel.setBounds(350, 350, 100, 40);
		soundLabel.setFontScale(3);
		stage.addActor(soundLabel);
		
		Label dragLabel = new Label("Drag Up", style);
		dragLabel.setBounds(20, 350, 100, 40);
		dragLabel.setFontScale(3);
		stage.addActor(dragLabel);
		
		//collision detection enemy
		Enemy meh = new Enemy(enemy1Tex, 20, 700);
		stage.addActor(meh);
	}

	@Override
	public void dispose() 
	{
		stage.dispose();
	}

	@Override
	public void render() 
	{		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}
	
	//TODO: Demo method to be removed next week
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

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
