package com.gobacca.box2d;

import com.gobacca.enums.UserDataType;

public abstract class UserData
{
    protected UserDataType userDataType;
    protected float width;
    protected float height;
    
    public UserData()
    {

    }
    
    public UserData(float width, float height)
    {
        this.width = width;
        this.height = height;
    }

    public UserDataType getUserDataType()
    {
        return userDataType;
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
    
    // SETTERS
    public void setWidth(float width)
    {
        this.width = width;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

}