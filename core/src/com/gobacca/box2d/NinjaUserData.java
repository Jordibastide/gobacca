package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class NinjaUserData extends UserData
{

    private Vector2 jumpingLinearImpulse;

    public NinjaUserData()
    {
        super();
        jumpingLinearImpulse = Constants.NINJA_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.NINJA;
    }

    public Vector2 getJumpingLinearImpulse()
    {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse)
    {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

}