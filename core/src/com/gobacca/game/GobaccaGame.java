package com.gobacca.game;

import com.badlogic.gdx.Game;
import com.gobacca.screens.*;

public class GobaccaGame extends Game
{
	@Override
	public void create ()
	{
		setMenuScreen();
	}
	
	public void setMenuScreen()
	{
		setScreen(new MenuScreen(this));
	}
	
	public void setGameScreen()
	{
		setScreen(new GameScreen(this));
	}
	
	public void setGameOverScreen()
	{
		setScreen(new GameOverScreen(this));
	}

	@Override
	public void render ()
	{
		super.render();
	}
}