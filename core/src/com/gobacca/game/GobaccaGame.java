package com.gobacca.game;

import com.badlogic.gdx.Game;
import com.gobacca.screens.GameScreen;

public class GobaccaGame extends Game {

	@Override
	public void create ()
	{
		setScreen(new GameScreen());
	}

	@Override
	public void render ()
	{
		super.render();
	}
}
