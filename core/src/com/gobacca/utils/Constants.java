package com.gobacca.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants
{
	// Screen resolution
    public static final int APP_WIDTH = 960;
    public static final int APP_HEIGHT = 540;
    public static final float WORLD_TO_SCREEN = 32;
    
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
    
    // Textures world
    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    
    // Texture sprites
    public static final String CHARACTERS_ATLAS_PATH = "characters.txt";
    public static final String[] NINJA_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String NINJA_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String NINJA_HIT_REGION_NAME = "alienGreen_hit";
    public static final String NINJA_JUMPING_REGION_NAME = "alienGreen_jump";
    
    // Enemies
    public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladyBug_walk1", "ladyBug_walk2"};
    public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"spider_walk1", "spider_walk2"};
    public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};

}