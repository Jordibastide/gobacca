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
    public static final float GROUND_DENSITY = 1f;
    
 // Platforms
    public static final float PLATFORM_X_MIN = 14f;
    public static final float PLATFORM_X_MAX = 15f;
    public static final float PLATFORM_Y_MIN = 4f;
    public static final float PLATFORM_Y_MAX = 9f;
    public static final float PLATFORM_HEIGHT = 1f;
    public static final float PLATFORM_DENSITY = 1f;
    public static final Vector2 PLATFORM_LINEAR_VELOCITY = new Vector2(-10f, 0);
    
    // Ninja specifies
    public static final float NINJA_X = 2;
    public static final float NINJA_Y = PLATFORM_Y_MAX + PLATFORM_HEIGHT;
    public static final float NINJA_WIDTH = 1f;
    public static final float NINJA_HEIGHT = 2f;
    public static final float NINJA_GRAVITY_SCALE = 3f;
    public static final float NINJA_DENSITY = 0.5f;
    public static final Vector2 NINJA_JUMPING_LINEAR_IMPULSE = new Vector2(0, 20f);
    public static final float NINJA_HIT_ANGULAR_IMPULSE = 10f;
    
    // Texture Ninja
    public static final String CHARACTERS_ATLAS_PATH = "characters.txt";
    public static final String[] NINJA_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String NINJA_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String NINJA_HIT_REGION_NAME = "alienGreen_hit";
    public static final String NINJA_JUMPING_REGION_NAME = "alienGreen_jump";
    public static final int NB_SHURIKEN_NINJA_AT_START = 500;
    
    // Shuriken
    public static final String SHURIKEN_ATLAS_PATH = "shuriken_pos.txt";
    public static final String[] SHURIKEN_REGION_NAMES = new String[] {	"shuriken_pos_0", "shuriken_pos_1", "shuriken_pos_2",
    																			"shuriken_pos_3", "shuriken_pos_4", "shuriken_pos_5"};
    public static final float SHURIKEN_WIDTH = 1f;
    public static final float SHURIKEN_HEIGHT = 1f;
    public static final float SHURIKEN_GRAVITY_SCALE = 0f;
    public static float SHURIKEN_DENSITY = 0.5f;
    public static final Vector2 SHURIKEN_LINEAR_IMPULSE = new Vector2(10f, 0);
    
    // Enemies
    public static final float ENEMY_X = 40f;
    public static final float ENEMY_DENSITY = 5f;
    public static final float ENEMY_GRAVITY_SCALE = 50f;
    public static final float RUNNING_SHORT_ENEMY_Y = PLATFORM_Y_MAX;
    public static final float RUNNING_LONG_ENEMY_Y = PLATFORM_Y_MAX;
    public static final float FLYING_ENEMY_Y = PLATFORM_Y_MAX;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    
    // Textures world
    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    
    // Enemies
    public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladyBug_walk1", "ladyBug_walk2"};
    public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"spider_walk1", "spider_walk2"};
    public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};
    
    // Menu
    public static final int ICON_SIZE_PX = 128;
    
    public static final String HOME_BUTTON_IMAGE_PATH = "icons/home.png";
    public static final String INFO_BUTTON_IMAGE_PATH = "icons/infos.png";
    public static final String MUSIC_0_BUTTON_IMAGE_PATH = "icons/musique_off.png";
    public static final String MUSIC_1_BUTTON_IMAGE_PATH = "icons/musique_on.png";
    public static final String PLAY_BUTTON_IMAGE_PATH = "icons/play.png";
    public static final String RETRY_BUTTON_IMAGE_PATH = "icons/retry.png";
    public static final String SCORE_BUTTON_IMAGE_PATH = "icons/score.png";
    public static final String SOUND_0_BUTTON_IMAGE_PATH = "icons/sound_off.png";
    public static final String SOUND_1_BUTTON_IMAGE_PATH = "icons/sound_on.png";
    public static final String STOP_BUTTON_IMAGE_PATH = "icons/stop.png";
    public static final String MENU_BACKGROUND_IMAGE_PATH = "bg_menu.png";
    
    // Game over
    public static final String OVER_BACKGROUND_IMAGE_PATH = "game_over.jpg";
    
	// Info
    public static final String CREDITS_BACKGROUND_IMAGE_PATH = "credits.png";
    
	// Score
    public static final String SCORE_BACKGROUND_IMAGE_PATH = "score.jpg";
}