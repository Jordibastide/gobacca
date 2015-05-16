package com.gobacca.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.gobacca.actors.Background;
import com.gobacca.actors.Button;
import com.gobacca.screens.MenuScreen;
import com.gobacca.utils.AudioUtils;
import com.gobacca.utils.Constants;

public class InfoStage extends Stage 
{
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private MenuScreen screen;
    
    private static final int NB_BUTTONS = 3;
    private Button[] buttons;
    private Vector3 touchPoint;
    
    private Sound buttonSound;
    
    public InfoStage(MenuScreen s)
    {
    	super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
    	
    	screen = s;
    	
        initBackground();
        initButtons();
        
        touchPoint = new Vector3();
        Gdx.input.setInputProcessor(this);
        buttonSound = AudioUtils.getInstance().getButtonSound();
    }
    
    private void initBackground()
    {
        addActor(new Background(Constants.CREDITS_BACKGROUND_IMAGE_PATH, 0, 0, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, 0));
    }
    
    private void initButtons()
    {
    	buttons = new Button[NB_BUTTONS];
    	
    	buttons[0] = new Button(Constants.HOME_BUTTON_IMAGE_PATH, (VIEWPORT_WIDTH - Constants.ICON_SIZE_PX - 10), (VIEWPORT_HEIGHT - Constants.ICON_SIZE_PX - 10), Constants.ICON_SIZE_PX, Constants.ICON_SIZE_PX);
    	buttons[1] = new Button(Constants.MUSIC_1_BUTTON_IMAGE_PATH, 10, (VIEWPORT_HEIGHT - Constants.ICON_SIZE_PX - 10), Constants.ICON_SIZE_PX, Constants.ICON_SIZE_PX);
    	buttons[2] = new Button(Constants.SOUND_1_BUTTON_IMAGE_PATH, (Constants.ICON_SIZE_PX + 20), (VIEWPORT_HEIGHT - Constants.ICON_SIZE_PX - 10), Constants.ICON_SIZE_PX, Constants.ICON_SIZE_PX);
        
    	if(!screen.isMusicON())
			buttons[1].setTexture(Constants.MUSIC_0_BUTTON_IMAGE_PATH);

		if(!screen.isSoundON())
			buttons[2].setTexture(Constants.SOUND_0_BUTTON_IMAGE_PATH);
		
    	for(int i = 0; i < NB_BUTTONS; ++i)
    		addActor(buttons[i]);
    }
    
    private void translateScreenToWorldCoordinates(int x, int y)
    {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }
    
    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        translateScreenToWorldCoordinates(x, y);
        
        int i = 0;
        while(i < NB_BUTTONS && !buttons[i].contains(touchPoint.x, touchPoint.y))
        {
        	++i;
        }
        
        switch(i)
        {
        	case 0:
        		AudioUtils.getInstance().playSound(buttonSound);
        		screen.setMusicState(false);
        		AudioUtils.disposeAudio();
        		screen.setMainMenuStage();
        	break;
        	
        	case 1:
        		AudioUtils.getInstance().playSound(buttonSound);
        		if(screen.isMusicON())
        		{
        			buttons[1].setTexture(Constants.MUSIC_0_BUTTON_IMAGE_PATH);
        			screen.setMusicState(false);
        			//AudioUtils.disposeAudio();
        		}
        		else
        		{
        			buttons[1].setTexture(Constants.MUSIC_1_BUTTON_IMAGE_PATH);
        			screen.setMusicState(true);
        		}
        	break;
        	
        	case 2:
        		AudioUtils.getInstance().playSound(buttonSound);
        		if(screen.isSoundON())
        		{
        			buttons[2].setTexture(Constants.SOUND_0_BUTTON_IMAGE_PATH);
        			screen.setSoundState(false);
        		}
        		else
        		{
        			buttons[2].setTexture(Constants.SOUND_1_BUTTON_IMAGE_PATH);
        			screen.setSoundState(true);
        		}
        	break;
        	
        	default:
        	break;
        }
        
        return super.touchDown(x, y, pointer, button);
    }
}
