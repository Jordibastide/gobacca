package com.gobacca.enums;

import com.gobacca.utils.Constants;

public enum PlatformType
{
	PLATFORM_SMALL	(	25f, Constants.PLATFORM_HEIGHT, Constants.PLATFORM_X, Constants.PLATFORM_Y, Constants.PLATFORM_DENSITY),
    PLATFORM_MEDIUM	(  30f, Constants.PLATFORM_HEIGHT, Constants.PLATFORM_X, Constants.PLATFORM_Y, Constants.PLATFORM_DENSITY),
	PLATFORM_LONG	(  55f, Constants.PLATFORM_HEIGHT, Constants.PLATFORM_X, Constants.PLATFORM_Y, Constants.PLATFORM_DENSITY);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;

    PlatformType(float width, float height, float x, float y, float density)
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
