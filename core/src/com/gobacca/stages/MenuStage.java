package com.gobacca.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.gobacca.actors.Background;
import com.gobacca.actors.Button;
import com.gobacca.utils.Constants;

public class MenuStage extends Stage
{
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    
    private Button startButton;

    private Vector3 touchPoint;
    
	public MenuStage()
	{
		super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
		initBackground();
		initButtons();
		initTouchControlAreas();
	}
	
	private void initBackground()
    {
        addActor(new Background(Constants.MENU_BACKGROUND_IMAGE_PATH, 0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT, 0));
    }
	
	private void initButtons()
    {
		startButton = new Button(Constants.START_BUTTON_IMAGE_PATH, 0, 0, 50, 50);
        addActor(startButton);
    }
	
	private void initTouchControlAreas()
    {
        touchPoint = new Vector3();
        Gdx.input.setInputProcessor(this);
    }
	
	@Override
    public void act(float delta)
    {
        super.act(delta);

        // Fix timestep
        accumulator += delta;

        while (accumulator >= delta)
        {
            accumulator -= TIME_STEP;
        }
    }
	
	@Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        translateScreenToWorldCoordinates(x, y);

        if (startButtonTouched(touchPoint.x, touchPoint.y))
        {
            // TODO: lancer le jeu
        	System.out.println("J'ai perdu ma couille au fond du ravin !");
        }

        return super.touchDown(x, y, pointer, button);
    }

    private boolean startButtonTouched(float x, float y)
    {
        return startButton.contains(x, y);
    }
    
    private void translateScreenToWorldCoordinates(int x, int y)
    {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }
}