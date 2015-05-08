package com.gobacca.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.UserData;
import com.gobacca.enums.UserDataType;

public class BodyUtils
{

    public static boolean bodyIsNinja(Body body)
    {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.NINJA;
    }

    public static boolean bodyIsGround(Body body)
    {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

}