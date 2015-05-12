package com.gobacca.game;

import com.badlogic.gdx.Game;
import com.gobacca.screens.*;

public class GobaccaGame extends Game {

	@Override
	public void create ()
	{
		setScreen(new MenuScreen());
	}

	@Override
	public void render ()
	{
		super.render();
	}
}
