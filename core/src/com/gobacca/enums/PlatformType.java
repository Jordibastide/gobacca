package com.gobacca.enums;

import com.gobacca.utils.Constants;
import com.gobacca.utils.RandomUtils;

public enum PlatformType
{
	PLATFORM_GRASS_SMALL	(	8f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
			(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass_small.png"),
    PLATFORM_GRASS_MEDIUM	(  10f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
    		(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass_medium.png"),
	PLATFORM_GRASS_LONG	(  12f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
			(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass_large.png"),

    PLATFORM_GRASS2_SMALL  (   8f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass2_small.png"),
    PLATFORM_GRASS2_MEDIUM (  10f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass2_medium.png"),
    PLATFORM_GRASS2_LONG   (  12f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "grass2_large.png"),

    PLATFORM_YARD_SMALL  (   8f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "yard_small.png"),
    PLATFORM_YARD_MEDIUM (  10f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "yard_medium.png"),
    PLATFORM_YARD_LONG   (  12f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "yard_large.png"),

    PLATFORM_ROCK_SMALL  (   8f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "rock_small.png"),
    PLATFORM_ROCK_MEDIUM (  10f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "rock_medium.png"),
    PLATFORM_ROCK_LONG   (  12f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
            (int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY, "rock_large.png");
	

    private float width;
    private float height;
    private int x;
    private int y;
    private float density;
    private String filePath;

    PlatformType(float width, float height, int x, int y, float density, String filepath)
    {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.filePath = filepath;
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
    
    public String getFilePath()
    {
        return filePath;
    }
}
