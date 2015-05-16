package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class AmmoUserData extends UserData
{
    private Vector2 linearVelocity;

    // CONSTRUCTOR
	public AmmoUserData(float width, float height)
	{
        super(width, height);
        userDataType = UserDataType.AMMO;
        linearVelocity = Constants.AMMO_LINEAR_VELOCITY;
    }

	// GETTERS
    public Vector2 getLinearVelocity()
    {
        return linearVelocity;
    }
    
    // SETTERS
    public void setLinearVelocity(Vector2 linearVelocity)
    {
        this.linearVelocity = linearVelocity;
    }
}