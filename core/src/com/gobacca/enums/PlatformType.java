package com.gobacca.enums;

import com.gobacca.utils.Constants;
import com.gobacca.utils.RandomUtils;

public enum PlatformType
{
	PLATFORM_SMALL	(	8f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
			(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY),
    PLATFORM_MEDIUM	(  10f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
    		(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY),
	PLATFORM_LONG	(  12f, Constants.PLATFORM_HEIGHT, (int)RandomUtils.rangeRandom(Constants.PLATFORM_X_MIN, Constants.PLATFORM_X_MAX), 
			(int)RandomUtils.rangeRandom(Constants.PLATFORM_Y_MIN, Constants.PLATFORM_Y_MAX), Constants.PLATFORM_DENSITY);
	

    private float width;
    private float height;
    private int x;
    private int y;
    private float density;

    PlatformType(float width, float height, int x, int y, float density)
    {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
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
}
