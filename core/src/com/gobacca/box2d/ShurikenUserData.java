package com.gobacca.box2d;

import com.gobacca.enums.UserDataType;

public class ShurikenUserData extends UserData
{

	public ShurikenUserData(float width, float height)
    {
        super(width, height);
        userDataType = UserDataType.SHURIKEN;
    }

}
