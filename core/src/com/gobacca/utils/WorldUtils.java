package com.gobacca.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gobacca.box2d.*;
import com.gobacca.enums.EnemyType;
import com.gobacca.enums.PlatformType;
import com.gobacca.enums.StartPlatformType;

public class WorldUtils {

    public static World createWorld()
    {
        return new World(Constants.WORLD_GRAVITY, true);
    }
    
    public static Body createNinja(World world)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.NINJA_X, Constants.NINJA_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.NINJA_WIDTH / 2, Constants.NINJA_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.NINJA_GRAVITY_SCALE);    
        body.createFixture(shape, Constants.NINJA_DENSITY);
        body.resetMassData();
        body.setUserData(new NinjaUserData(Constants.NINJA_WIDTH, Constants.NINJA_HEIGHT));
        shape.dispose();
        return body;
    }
    
    public static Body createShuriken(World world, float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(x, y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.SHURIKEN_WIDTH / 2, Constants.SHURIKEN_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.SHURIKEN_GRAVITY_SCALE);
        body.createFixture(shape, Constants.SHURIKEN_DENSITY);
        body.resetMassData();
        body.setUserData(new ShurikenUserData(Constants.SHURIKEN_WIDTH, Constants.SHURIKEN_HEIGHT));
        shape.dispose();
        return body;
    }
    
    public static Body createEnemy(World world, int[] hp)
    {
        EnemyType enemyType = RandomUtils.getRandomEnemyType();
        hp[0] = enemyType.getHP();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.ENEMY_GRAVITY_SCALE);
        body.createFixture(shape, enemyType.getDensity());
        body.resetMassData();
        EnemyUserData userData = new EnemyUserData(enemyType.getWidth(), enemyType.getHeight(), enemyType.getRegions());
        body.setUserData(userData);
        shape.dispose();
        return body;
    }
    
    public static Body createPlatform(World world, int n)
    {
        PlatformType platformType = RandomUtils.getRandomPlatformType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(platformType.getX() * n, platformType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(platformType.getWidth() / 2, platformType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, platformType.getDensity());
        body.setGravityScale(Constants.NINJA_GRAVITY_SCALE);
        body.resetMassData();
        PlatformUserData userData = new PlatformUserData(platformType.getWidth(), platformType.getHeight());
        body.setUserData(userData);
        shape.dispose();
        return body;
    }

	public static Body createStartPlatform(World world) {
		StartPlatformType platformType = StartPlatformType.PLATFORM_START;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(platformType.getX(), platformType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(platformType.getWidth() / 2, platformType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, platformType.getDensity());
        body.setGravityScale(Constants.NINJA_GRAVITY_SCALE);
        body.resetMassData();
        PlatformUserData userData = new PlatformUserData(platformType.getWidth(), platformType.getHeight());
        body.setUserData(userData);
        shape.dispose();
        return body;
	}

    public static Body createAmmo(World world, float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(x , y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.SHURIKEN_WIDTH / 2, Constants.SHURIKEN_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.AMMO_GRAVITY_SCALE);
        body.createFixture(shape, Constants.AMMO_DENSITY);
        body.resetMassData();
        body.setUserData(new AmmoUserData(Constants.SHURIKEN_WIDTH, Constants.SHURIKEN_HEIGHT));
        shape.dispose();
        return body;
    }
}