package com.dtg.screen;

import com.badlogic.gdx.Screen;
import com.dtg.game.DTGunts;


public class GameScreen implements Screen {
	
	DTGunts game;

	public GameScreen(DTGunts game){
		this.game = game;

	}

	@Override
	public void render(float delta) {

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
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

	}

}
