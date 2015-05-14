package com.gobacca.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.gobacca.actors.Background;
import com.gobacca.actors.Button;
import com.gobacca.screens.GameOverScreen;
import com.gobacca.utils.Constants;

public class GameOverStage extends Stage 
{
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private GameOverScreen screen;
    
    private Button start_button;
    private Vector3 touchPoint;
    
    public GameOverStage(GameOverScreen s)
    {
    	super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
    	
    	screen = s;
    	
        initBackground();
        initButtons();
        
        touchPoint = new Vector3();
        Gdx.input.setInputProcessor(this);
    }
    
    private void initBackground()
    {
        addActor(new Background(Constants.OVER_BACKGROUND_IMAGE_PATH, 0, 0, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, 0));
    }
    
    private void initButtons()
    {
    	start_button = new Button(Constants.MENU_BUTTON_IMAGE_PATH, VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2, 100, 100);
        addActor(start_button);
    }
    
    private void translateScreenToWorldCoordinates(int x, int y)
    {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }
    
    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        translateScreenToWorldCoordinates(x, y);

        if (start_button.contains(touchPoint.x, touchPoint.y))
        {
        	System.out.println("GO !\n");
            screen.launchMenu();
        }

        return super.touchDown(x, y, pointer, button);
    }
}
