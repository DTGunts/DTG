package com.dtg.game;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.dtg.screen.GameScreen;
import com.dtg.screen.SplashScreen;


public class DTGunts extends Game {

	public static final String VERSION = "1.0";
	public static final boolean DEBUG = false;
	FPSLogger log;
	
	@Override
	public void create() {
		
		log = new FPSLogger();
		setScreen(new SplashScreen(this));
		//setScreen(new GameScreen(this));
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
<<<<<<< HEAD

	@Override
	public void render() {
		super.render();
		log.log();
	}

	@Override
	public void pause() {
		super.pause();
=======
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
>>>>>>> FETCH_HEAD
	}

	@Override
	public void resume() {
<<<<<<< HEAD
		super.resume();
=======
		// TODO Auto-generated method stub
>>>>>>> FETCH_HEAD
	}

	@Override
	public void dispose() {
<<<<<<< HEAD
		super.dispose();
		
	}


}
=======
		// TODO Auto-generated method stub
	}
}
>>>>>>> FETCH_HEAD
