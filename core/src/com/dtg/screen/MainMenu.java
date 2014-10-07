package com.dtg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dtg.game.DTGunts;

public class MainMenu implements Screen{
	
	DTGunts game;
	Stage stage;
	BitmapFont white;
	BitmapFont black;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch batch;
	TextButton button;
	Label label;
	
	
	public MainMenu(DTGunts game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);	
		stage.act(delta);	
		batch.begin();	
		stage.draw();
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
		if(stage == null)
			stage = new Stage();
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		

		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("button");
		style.down = skin.getDrawable("button2");
		style.font = black;
		style.fontColor = Color.WHITE;

		button = new TextButton("", style);			
		button.setWidth(400);
		button.setHeight(100);
		button.setX(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2);
		button.setY(Gdx.graphics.getWidth() / 2 - button.getHeight() / 2);
		button.addListener(new InputListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y, int pointer, int button ){
				//game.setScreen(new GameScreen(game));
			}
			
		});
		LabelStyle ls = new LabelStyle(white, Color.WHITE);
		
		label = new Label("New Game!", ls);
		label.setX(0);
		label.setY(Gdx.graphics.getWidth() / 2 + 100);
		label.setWidth(width);
		label.setAlignment(Align.center);
		
		stage.addActor(button);
		stage.addActor(label);
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		
		atlas = new TextureAtlas("button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		white = new BitmapFont(Gdx.files.internal("default.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("default.fnt"), false);
		
		white.setColor(Color.WHITE);
		
	}

	@Override
	public void hide() {
		dispose();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		white.dispose();
		black.dispose();
		stage.dispose();
	}

}
