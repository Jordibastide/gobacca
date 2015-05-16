package com.gobacca.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gobacca.enums.MenuType;
import com.gobacca.game.GobaccaGame;
import com.gobacca.stages.*;
import com.gobacca.utils.AudioUtils;

public class MenuScreen implements Screen
{
	private GobaccaGame game;
    private Stage stage;

    public MenuScreen(GobaccaGame g, MenuType t)
    {
    	game = g;
    	setStage(t);
    }
    
    public void setStage(MenuType t)
    {
    	switch(t)
    	{
    		case GAME_OVER:
    			setGameOverStage();
    		break;
    		
    		case INFO:
    			setInfoStage();
    		break;
    		
    		case SCORE:
    			setScoreStage();
    		break;
    			
    		default:
    			setMainMenuStage();
    		break;
    	}
    }
    
    public boolean isMusicON()
    {
    	return game.isMusicON();
    }
    
    public boolean isSoundON()
    {
    	return game.isSoundON();
    }
    
    public void setMusicState(boolean state)
    {
    	game.setMusicState(state);
    }
    
    public void setSoundState(boolean state)
    {
    	game.setSoundState(state);
    }
    
    public void setGameOverStage()
    {
    	 stage = new GameOverStage(this);
    }
    
    public void setMainMenuStage()
    {
    	 stage = new MenuStage(this);
    }
    
    public void setInfoStage()
    {
    	 stage = new InfoStage(this);
    }
    
    public void setScoreStage()
    {
    	 stage = new ScoreStage(this);
    }
    
    public void launchGame()
    {
    	game.setGameScreen();
    }

    @Override
    public void render(float delta)
    {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void show()
    {

    }

    @Override
    public void hide()
    {
    	stage.dispose();
    	//AudioUtils.disposeAudio();
    	//AudioUtils.disposeSound();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {
    	stage.dispose();
    	//AudioUtils.disposeAudio();
    	//AudioUtils.disposeSound();
    }

}