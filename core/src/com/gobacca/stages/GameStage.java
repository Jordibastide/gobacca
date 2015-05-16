package com.gobacca.stages;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private ArrayList<Enemy> enemies;
    private ArrayList<Shuriken> shurikens;
    private ArrayList<Ammo> ammos;

    private OrthographicCamera camera;
    
    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;

    private static final int NB_BUTTONS = 3;
    private Button[] buttons;
    private Vector3 touchPoint;

    public GameStage(GameScreen s)
    {
    	super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
    	
    	screen = s;
    	
    	initEnemies();
    	initAmmos();
    	initShurikens();
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
    
    private void initEnemies()
    {
    	enemies = new ArrayList<Enemy>();
    }
    
    private void initAmmos()
    {
    	ammos = new ArrayList<Ammo>();
    }
    
    private void initShurikens()
    {
    	shurikens = new ArrayList<Shuriken>();
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
        screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies)
        {
            update(body);
        }
        
        keyboardEventManager();

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
        		if(rightSideTouched(touchPoint.x, touchPoint.y))
        		{
                    ninja.jump();
                }
        		else if(leftSideTouched(touchPoint.x, touchPoint.y))
        		{
        			launchShuriken();
        		}
        	break;
        }

        return super.touchDown(x, y, pointer, button);
    }
    
    private void keyboardEventManager()
    {
    	if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
    		ninja.jump();
    	
    	if(Gdx.input.isKeyJustPressed(Input.Keys.E))
    		launchShuriken();
    	
    	if(Gdx.input.isKeyJustPressed(Input.Keys.S))
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
    	
    	if(Gdx.input.isKeyJustPressed(Input.Keys.M))
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
    	
    	if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
    		screen.setMainMenuStage();
    }

    private boolean rightSideTouched(float x, float y)
    {
        return screenRightSide.contains(x, y);
    }
    
    private boolean leftSideTouched(float x, float y)
    {
        return screenLeftSide.contains(x, y);
    }
    
    private void update(Body body)
    {
        if (!BodyUtils.bodyInBounds(body))
        {
            if (BodyUtils.bodyIsEnemy(body) && !ninja.isHit())
            {
            	int i = 0;
    	    	while(i < enemies.size() && !body.equals(enemies.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < enemies.size())
    	    	{
    	    		createEnemy();
    	    		
    	    		enemies.get(i).setBodyNull();
    	    		enemies.remove(i);
    	    	}
            }
            else if(BodyUtils.bodyIsShuriken(body))
            {
            	int i = 0;
    	    	while(i < shurikens.size() && !body.equals(shurikens.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < shurikens.size())
    	    	{
    	    		shurikens.get(i).setBodyNull();
    	    		shurikens.remove(shurikens.get(i));
    	    	}
            }
            else if(BodyUtils.bodyIsAmmo(body))
            {
            	int i = 0;
    	    	while(i < ammos.size() && !body.equals(ammos.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < ammos.size())
    	    	{
    	    		ammos.get(i).setBodyNull();
    	    		ammos.remove(ammos.get(i));
    	    	}
            }
            
            
            world.destroyBody(body);
        }
        else
        {
        	if (BodyUtils.bodyIsEnemy(body) && !ninja.isHit())
            {
            	int i = 0;
    	    	while(i < enemies.size() && !body.equals(enemies.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < enemies.size() && enemies.get(i).getDeleteFlag())
    	    	{
    	    		enemies.get(i).setBodyNull();
    	    		enemies.remove(i);
    	    		createEnemy();
    	    		
    	    		if(enemies.get(i).getMaxHP() > 1)
    	    		{
    	    			int higher = enemies.get(i).getMaxHP() + 1;
    	    			int lower = 1;
    	    			int random = (int)(Math.random() * (higher-lower)) + lower;
	    	    		createAmmo(body, random);
    	    		}
    	    		else
    	    		{
    	    			createAmmo(body, 1);
    	    		}
    	    		
    	    		world.destroyBody(body);
    	    	}
            }
        	else if(BodyUtils.bodyIsShuriken(body))
            {
            	int i = 0;
    	    	while(i < shurikens.size() && !body.equals(shurikens.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < shurikens.size() && shurikens.get(i).getDeleteFlag())
    	    	{
    	    		shurikens.get(i).setBodyNull();
    	    		shurikens.remove(shurikens.get(i));
    	    		world.destroyBody(body);
    	    	}
            }
        	else if(BodyUtils.bodyIsAmmo(body))
            {
            	int i = 0;
    	    	while(i < ammos.size() && !body.equals(ammos.get(i).getBody()))
    	    	{
    	    		++i;
    	    	}
    	    	
    	    	if(i < ammos.size() && ammos.get(i).getDeleteFlag())
    	    	{
    	    		ammos.get(i).setBodyNull();
    	    		ammos.remove(ammos.get(i));
    	    		world.destroyBody(body);
    	    	}
            }
        }
    }

    private void createEnemy()
    {
    	int[] hp = new int[1];
    	hp[0] = 0;
        enemies.add(new Enemy(WorldUtils.createEnemy(world, hp)));
        enemies.get(enemies.size() - 1).setMaxHP(hp[0]);
        enemies.get(enemies.size() - 1).setHP(hp[0]);
        addActor(enemies.get(enemies.size() - 1));
    }
    
    private void createAmmo(Body b, int nb)
    {
    	for(int i = 0; i < nb; ++i)
    	{
	        ammos.add(new Ammo(WorldUtils.createAmmo(world, b.getWorldCenter().x + (i * 1.5f) )));
	        addActor(ammos.get(ammos.size() - 1));
    	}
    }
    
    private void launchShuriken()
    {
    	if(ninja.getNbShuriken() > 0)
    	{
	    	shurikens.add(new Shuriken(WorldUtils.createShuriken(world, ninja)));
	        addActor(shurikens.get(shurikens.size() - 1));
	        
	        shurikens.get(shurikens.size() - 1).launchShuriken();
	        
	        ninja.useShuriken();
    	}
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
        else if(BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsShuriken(b))
        {
        	deleteShuriken(b);
        	hitEnemy(a);
        }
        else if(BodyUtils.bodyIsShuriken(a) && BodyUtils.bodyIsEnemy(b))
        {
        	deleteShuriken(a);
        	hitEnemy(b);
        }
        else if((BodyUtils.bodyIsNinja(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsNinja(b)))
        {
        	ninja.landed();
        }
        else if(BodyUtils.bodyIsAmmo(a) && BodyUtils.bodyIsNinja(b))
        {
        	ninja.addAmmo();
        	deleteAmmo(a);
        }
        else if(BodyUtils.bodyIsNinja(a) && BodyUtils.bodyIsAmmo(b))
        {
        	ninja.addAmmo();
        	deleteAmmo(b);
        }
    }
    
    private void hitEnemy(Body b)
    {
    	int i = 0;
    	while(i < enemies.size() && !b.equals(enemies.get(i).getBody()))
    		++i;
    	
    	if(i < enemies.size())
    		enemies.get(i).hit();
    }
    
    private void deleteShuriken(Body b)
    {
    	int i = 0;
    	while(i < shurikens.size() && !b.equals(shurikens.get(i).getBody()))
    		++i;
    	
    	if(i < shurikens.size())
    	{
    		shurikens.get(i).deleteFlagON();
    	}	
    }
    
    private void deleteAmmo(Body b)
    {
    	int i = 0;
    	while(i < ammos.size() && !b.equals(ammos.get(i).getBody()))
    		++i;
    	
    	if(i < ammos.size())
    	{
    		ammos.get(i).deleteFlagON();
    	}
    }
    
    @Override
    public void endContact(Contact contact)
    {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold)
    {
    	Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if(BodyUtils.bodyIsAmmo(a) && BodyUtils.bodyIsAmmo(b))
        {
        	
        }
        else if((BodyUtils.bodyIsAmmo(a) && !BodyUtils.bodyIsGround(b) && !BodyUtils.bodyIsNinja(b)) || (!BodyUtils.bodyIsGround(a) && !BodyUtils.bodyIsNinja(a) && BodyUtils.bodyIsAmmo(b)))
        {
        	contact.setEnabled(false);
        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse)
    {

    }


}