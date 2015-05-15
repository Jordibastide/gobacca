package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class ShurikenUserData extends UserData
{
	private Vector2 linearImpulse;
	
	public ShurikenUserData(float width, float height)
    {
        super(width, height);
        linearImpulse = Constants.SHURIKEN_LINEAR_IMPULSE;
        userDataType = UserDataType.SHURIKEN;
    }

    // GETTERS
    public Vector2 getLinearImpulse()
    {
        return linearImpulse;
    }

}
