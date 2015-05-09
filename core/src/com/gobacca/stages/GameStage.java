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
import com.gobacca.utils.*;


public class GameStage extends Stage implements ContactListener
{

    // This will be our viewport measurements while working with the debug renderer
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private World world;
    private Ground ground;
    private Ninja ninja;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    // private Box2DDebugRenderer renderer;
    
    private Rectangle screenRightSide;

    private Vector3 touchPoint;

    public GameStage()
    {
    	super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        initWorld();
        initCamera();
        initTouchControlAreas();
        // renderer = new Box2DDebugRenderer();
    }

    private void initWorld()
    {
    	world = WorldUtils.createWorld();
        world.setContactListener(this);
        initBackground();
        initGround();
        initNinja();
        createEnemy();
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
    
    private void initTouchControlAreas()
    {
        touchPoint = new Vector3();
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
                getCamera().viewportHeight);
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

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
    }

    /*
    @Override
    public void draw()
    {
        super.draw();
        renderer.render(world, camera.combined);
    }
    */
    
    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {

        // Need to get the actual coordinates
        translateScreenToWorldCoordinates(x, y);

        if (rightSideTouched(touchPoint.x, touchPoint.y)) {
            ninja.jump();
        }

        return super.touchDown(x, y, pointer, button);
    }

    private boolean rightSideTouched(float x, float y)
    {
        return screenRightSide.contains(x, y);
    }
    
    private void translateScreenToWorldCoordinates(int x, int y)
    {
        getCamera().unproject(touchPoint.set(x, y, 0));
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