package com.gobacca.enums;

import com.gobacca.utils.Constants;

public enum EnemyType
{

    BERNARD		(1, 1.3f, 1.5f, Constants.ENEMY_X, Constants.BERNARD_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.BERNARD_ENEMY_REGION_NAMES),
    ROBERT		(2,	1.8f, 2.3f, Constants.ENEMY_X, Constants.ROBERT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.ROBERT_ENEMY_REGION_NAMES),
    CHATVIOLET	(2,	1.3f, 1f, Constants.ENEMY_X, Constants.CHATVIOLET_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATVIOLET_ENEMY_REGION_NAMES),
    CHATFOU		(3,	2f, 1.2f, Constants.ENEMY_X, Constants.CHATFOU_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATFOU_ENEMY_REGION_NAMES),
    CHATMIGNON	(1,	1f, 1.6f, Constants.ENEMY_X, Constants.CHATMIGNON_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CHATMIGNON_ENEMY_REGION_NAMES),
    ALPHONSE	(2,	1.6f, 2.3f, Constants.ENEMY_X, Constants.ALPHONSE_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.ALPHONSE_ENEMY_REGION_NAMES),
    HELLBOY		(3,	1.8f, 2.3f, Constants.ENEMY_X, Constants.HELLBOY_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.HELLBOY_ENEMY_REGION_NAMES);


	private int hp;
    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String[] regions;

    EnemyType(int hp, float width, float height, float x, float y, float density, String[] regions)
    {
    	this.hp = hp;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.regions = regions;
    }

    // GETTERS
    public int getHP()
    {
        return hp;
    }
    
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
