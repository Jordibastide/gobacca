package com.gobacca.box2d;

import com.gobacca.enums.UserDataType;

public abstract class UserData
{
    protected UserDataType userDataType;

    public UserData()
    {

    }

    public UserDataType getUserDataType()
    {
        return userDataType;
    }

}