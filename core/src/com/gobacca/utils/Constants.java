package com.gobacca.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants
{
	// Screen resolution
    public static final int APP_WIDTH = 960;
    public static final int APP_HEIGHT = 540;
    
    // World specifies
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X = 3;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 50f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;
    
    // Ninja specifies
    public static final float NINJA_X = 2;
    public static final float NINJA_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float NINJA_WIDTH = 1f;
    public static final float NINJA_HEIGHT = 2f;
    public static final float NINJA_GRAVITY_SCALE = 3f;
    public static float NINJA_DENSITY = 0.5f;
    public static final Vector2 NINJA_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    public static final float NINJA_HIT_ANGULAR_IMPULSE = 10f;
    
    // Enemies
    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = NINJA_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);

}