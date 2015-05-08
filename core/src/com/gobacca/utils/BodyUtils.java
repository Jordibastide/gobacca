package com.gobacca.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.UserData;
import com.gobacca.enums.UserDataType;

public class BodyUtils
{
	public static boolean bodyInBounds(Body body)
	{
		UserData userData = (UserData) body.getUserData();

		// float p;
		switch (userData.getUserDataType())
		{
			case NINJA:
			case ENEMY:
				return body.getPosition().x + userData.getWidth() / 2 > 0;
			case GROUND:
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

    public static boolean bodyIsGround(Body body)
    {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

}