package com.gobacca.game;

import com.badlogic.gdx.Game;
import com.gobacca.enums.MenuType;
import com.gobacca.screens.*;

public class GobaccaGame extends Game
{
	@Override
	public void create ()
	{
		setMenuScreen(MenuType.MAIN);
	}
	
	public void setMenuScreen(MenuType t)
	{
		setScreen(new MenuScreen(this, t));
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