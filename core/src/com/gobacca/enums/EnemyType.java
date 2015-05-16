package com.gobacca.enums;

import com.gobacca.utils.Constants;

public enum EnemyType
{
	//RUNNING_SMALL	(	1f, 1f,	Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_SMALL_ENEMY_REGION_NAMES),
    //RUNNING_WIDE	(	2f, 1f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_WIDE_ENEMY_REGION_NAMES),
    //RUNNING_LONG	(	1f, 2f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_LONG_ENEMY_REGION_NAMES),
    //RUNNING_BIG	(	2f, 2f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_BIG_ENEMY_REGION_NAMES);
    //FLYING_SMALL	(	1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.FLYING_SMALL_ENEMY_REGION_NAMES),
    //FLYING_WIDE	(	2f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.FLYING_WIDE_ENEMY_REGION_NAMES);
    BERNARD		(	1.3f, 1.5f, Constants.ENEMY_X, Constants.BERNARD_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.BERNARD_ENEMY_REGION_NAMES),
    ROBERT		(	1.8f, 2.3f, Constants.ENEMY_X, Constants.ROBERT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.ROBERT_ENEMY_REGION_NAMES),
    CHATVIOLET		(	1.3f, 1f, Constants.ENEMY_X, Constants.CHATVIOLET_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATVIOLET_ENEMY_REGION_NAMES),
    CHATFOU		(	2f, 1.2f, Constants.ENEMY_X, Constants.CHATFOU_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATFOU_ENEMY_REGION_NAMES),
    CHATMIGNON		(	1f, 1.6f, Constants.ENEMY_X, Constants.CHATMIGNON_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATMIGNON_ENEMY_REGION_NAMES),
    ALPHONSE		(	1.6f, 2.3f, Constants.ENEMY_X, Constants.ALPHONSE_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.ALPHONSE_ENEMY_REGION_NAMES),
    HELLBOY		(	1.8f, 2.3f, Constants.ENEMY_X, Constants.HELLBOY_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.HELLBOY_ENEMY_REGION_NAMES);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String[] regions;

    EnemyType(float width, float height, float x, float y, float density, String[] regions)
    {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.regions = regions;
    }

    // GETTERS
    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getDensity()
    {
        return density;
    }
    
    public String[] getRegions() {
        return regions;
    }
}
