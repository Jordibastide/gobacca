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
    public static final float NINJA_WIDTH = 2f;
    public static final float NINJA_HEIGHT = 3f;
    public static final float NINJA_GRAVITY_SCALE = 3f;
    public static float NINJA_DENSITY = 0.5f;
    public static final Vector2 NINJA_JUMPING_LINEAR_IMPULSE = new Vector2(0, 38f); //13f
    public static final float NINJA_HIT_ANGULAR_IMPULSE = 10f;
    
    // Enemies
    public static final float ENEMY_X = 40f;
    public static final float ENEMY_DENSITY = NINJA_DENSITY;
    //public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    //public static final float RUNNING_LONG_ENEMY_Y = 1.8f;
    //public static final float FLYING_ENEMY_Y = 3f;
    public static final float BERNARD_ENEMY_Y = 1.8f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    
    // Textures world
    public static final String BACKGROUND_IMAGE_PATHz1 = "backgroundz1.png";
    public static final String BACKGROUND_IMAGE_PATHz2 = "backgroundz2.png";
    public static final String BACKGROUND_IMAGE_PATHz3 = "backgroundz3.png";
    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    
    // Texture sprites
    public static final String CHARACTERS_ATLAS_PATH = "characters.txt";
    public static final String ENNEMY_ATLAS_PATH = "en1.txt";
    public static final String NINJA_ATLAS_PATH = "ninja.txt";
    public static final String[] NINJA_RUNNING_REGION_NAMES = new String[] {"ninja_pos1", "ninja_pos2", "ninja_pos3", "ninja_pos4", "ninja_pos5", "ninja_pos6", "ninja_pos7", "ninja_pos8", "ninja_pos9", "ninja_pos10", "ninja_pos11", "ninja_pos12", "ninja_pos13", "ninja_pos14", "ninja_pos15", "ninja_pos16", "ninja_pos17"};
    public static final String NINJA_DODGING_REGION_NAME = "ninja_pos11";
    public static final String NINJA_HIT_REGION_NAME = "ninja_pos3";
    public static final String NINJA_JUMPING_REGION_NAME = "ninja_pos8";
    
    // Enemies
    //public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladyBug_walk1", "ladyBug_walk2"};
    //public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    //public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"spider_walk1", "spider_walk2"};
    //public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    //public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    //public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};
    public static final String[] BERNARD_ENEMY_REGION_NAMES = new String[] {"gros1", "gros2", "gros3", "gros4", "gros5", "gros6", "gros7", "gros8"};
    
    // Menu
    public static final int ICON_SIZE_PX = 128;
    public static final int ICON_SIZE_PX_INGAME = 64;
    
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
    public static final String OVER_BACKGROUND_IMAGE_PATH = "game_over.png";
    
	// Info
    public static final String CREDITS_BACKGROUND_IMAGE_PATH = "credits.png";
    
	// Score
    public static final String SCORE_BACKGROUND_IMAGE_PATH = "score.jpg";
    
    //Sounds
    public static final String RUNNER_JUMPING_SOUND = "jump.wav";
    public static final String RUNNER_HIT_SOUND = "hit.mp3";
    public static final String GAME_OVER_SOUND = "gameover.mp3";
    public static final String BUTTON_SOUND = "button.mp3";
    public static final String GAME_MUSIC = "tropic.mp3";
    public static final String GAME_MUSIC_2 = "epic.mp3";
    
    //Font
    public static final String FONT_NAME = "roboto_bold.ttf";
}