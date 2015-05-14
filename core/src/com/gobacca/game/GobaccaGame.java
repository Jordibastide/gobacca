package com.gobacca.game;

import com.badlogic.gdx.Game;
import com.gobacca.enums.MenuType;
import com.gobacca.screens.*;

public class GobaccaGame extends Game
{
	private boolean sound_ON;
    private boolean music_ON;
    
	@Override
	public void create ()
	{
        sound_ON = true;
        music_ON = true;
        
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
	
	public boolean isMusicON()
    {
    	return music_ON;
    }
    
    public boolean isSoundON()
    {
    	return sound_ON;
    }
    
    public void setMusicState(boolean state)
    {
    	music_ON = state;
    }
    
    public void setSoundState(boolean state)
    {
    	sound_ON = state;
    }

	@Override
	public void render ()
	{
		super.render();
	}
}