package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class NinjaUserData extends UserData
{

    private Vector2 jumpingLinearImpulse;

    // CONSTRUCTORS
    /*
    public NinjaUserData()
    {
        super();
        jumpingLinearImpulse = Constants.NINJA_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.NINJA;
    }
    */
    
    public NinjaUserData(float width, float height)
    {
        super(width, height);
        jumpingLinearImpulse = Constants.NINJA_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.NINJA;
    }

    // GETTERS
    public Vector2 getJumpingLinearImpulse()
    {
        return jumpingLinearImpulse;
    }
    
    public float getHitAngularImpulse()
    {
        return Constants.NINJA_HIT_ANGULAR_IMPULSE;
    }

    // SETTERS
    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse)
    {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

}