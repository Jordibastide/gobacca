package com.gobacca.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.gobacca.actors.*;
import com.gobacca.screens.GameScreen;
import com.gobacca.utils.*;

public class GameStage extends Stage implements ContactListener
{
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;		// This will be our viewport measurements while working with the debug renderer
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private GameScreen screen;
    
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private World world;
    private Ground ground;
    private Ninja ninja;

    private OrthographicCamera camera;
    
    private Rectangle screenRightSide;

    private static final int NB_BUTTONS = 3;
    private Button[] buttons;
    private Vector3 touchPoint;

    public GameStage(GameScreen s)
    {
    	super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
    	
    	screen = s;
    	
        initWorld();
        initCamera();
        initTouchControlAreas();
    }

    private void initWorld()
    {
    	world = WorldUtils.createWorld();
        world.setContactListener(this);
        initBackground();
        initGround();
        initNinja();
        createEnemy();
        
        initButtons();
    }
    
    private void initBackground()
    {
        addActor(new Background());
    }

    private void initGround()
    {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void initNinja()
    {
        ninja = new Ninja(WorldUtils.createNinja(world));
        addActor(ninja);
    }

    private void initCamera()
    {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
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
    
    private void initTouchControlAreas()
    {
        touchPoint = new Vector3();
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }

        // Fix timestep
        accumulator += delta;

        while (accumulator >= delta)
        {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
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
        	++i;
        
        switch(i)
        {
        	case 0:
        		screen.setMainMenuStage();
        	break;
        	
        	case 1:
        		if(screen.isMusicON())
        		{
        			buttons[1].setTexture(Constants.MUSIC_0_BUTTON_IMAGE_PATH);
        			screen.setMusicState(false);
        		}
        		else
        		{
        			buttons[1].setTexture(Constants.MUSIC_1_BUTTON_IMAGE_PATH);
        			screen.setMusicState(true);
        		}
        	break;
        	
        	case 2:
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
        		if (rightSideTouched(touchPoint.x, touchPoint.y))
        		{
                    ninja.jump();
                }
        	break;
        }

        return super.touchDown(x, y, pointer, button);
    }

    private boolean rightSideTouched(float x, float y)
    {
        return screenRightSide.contains(x, y);
    }
    
    private void update(Body body)
    {
        if (!BodyUtils.bodyInBounds(body))
        {
            if (BodyUtils.bodyIsEnemy(body) && !ninja.isHit())
            {
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy()
    {
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        addActor(enemy);
    }
    
    @Override
    public void beginContact(Contact contact)
    {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsNinja(a) && BodyUtils.bodyIsEnemy(b)) || (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsNinja(b)))
        {
            ninja.hit();
            screen.launchGameOver();
        }
        else if((BodyUtils.bodyIsNinja(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsNinja(b)))
        {
        	ninja.landed();
        }

    }
    
    @Override
    public void endContact(Contact contact)
    {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold)
    {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse)
    {

    }


}