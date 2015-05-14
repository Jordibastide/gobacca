package com.gobacca.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gobacca.enums.MenuType;
import com.gobacca.game.GobaccaGame;
import com.gobacca.stages.*;

public class GameScreen implements Screen
{
	private GobaccaGame game;
    private Stage stage;

    public GameScreen(GobaccaGame g)
    {
    	game = g;
        stage = new GameStage(this);
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
    
    public void launchGameOver()
    {
    	game.setMenuScreen(MenuType.GAME_OVER);
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
    }

}