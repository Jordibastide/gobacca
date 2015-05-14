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

	@Override
	public void render ()
	{
		super.render();
	}
}