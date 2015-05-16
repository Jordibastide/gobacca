package com.gobacca.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.UserData;
import com.gobacca.enums.UserDataType;

public class BodyUtils
{
	public static boolean bodyInBounds(Body body)
	{
		UserData userData = (UserData) body.getUserData();

		switch (userData.getUserDataType())
		{
			case NINJA:
				return (body.getPosition().y >= 0f);
			case ENEMY:
				return (body.getPosition().x + userData.getWidth() / 2 > 0) && (body.getPosition().y >= 0f);
			case GROUND:
			case SHURIKEN:
			case PLATFORM:
				return body.getPosition().x + userData.getWidth() / 2 > 0;
			case AMMO:
		}
		
		return true;
	}

	public static boolean bodyIsEnemy(Body body)
	{
	    UserData userData = (UserData) body.getUserData();
	    return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
	}

    public static boolean bodyIsNinja(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.NINJA;
    }
    
    public static boolean bodyIsShuriken(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.SHURIKEN;
    }

    public static boolean bodyIsGround(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
    
    public static boolean bodyIsPlatform(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.PLATFORM;
    }

    public static boolean bodyIsAmmo(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.AMMO;
    }
}