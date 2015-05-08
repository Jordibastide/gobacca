package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class EnemyUserData extends UserData
{
    private Vector2 linearVelocity;
    private String[] textureRegions;

    // CONSTRUCTOR
	public EnemyUserData(float width, float height, String[] textureRegions)
	{
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.textureRegions = textureRegions;		
    }

	// GETTERS
    public Vector2 getLinearVelocity()
    {
        return linearVelocity;
    }
    
    public String[] getTextureRegions() {
        return textureRegions;
    }
    
    // SETTERS
    public void setLinearVelocity(Vector2 linearVelocity)
    {
        this.linearVelocity = linearVelocity;
    }
}