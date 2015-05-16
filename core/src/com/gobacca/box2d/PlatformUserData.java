package com.gobacca.box2d;

import com.badlogic.gdx.math.Vector2;
import com.gobacca.enums.UserDataType;
import com.gobacca.utils.Constants;

public class PlatformUserData extends UserData{
	
    private Vector2 linearVelocity;
    private String textureFilePath;

    // CONSTRUCTOR
	public PlatformUserData(float width, float height, String filePath)
	{
        super(width, height);
        userDataType = UserDataType.PLATFORM;
        linearVelocity = Constants.PLATFORM_LINEAR_VELOCITY;
        textureFilePath = filePath;
    }

	// GETTERS
    public Vector2 getLinearVelocity()
    {
        return linearVelocity;
    }
    
    public String getTextureFilePath()
    {
    	return textureFilePath;
    }

    // SETTERS
    public void setLinearVelocity(Vector2 linearVelocity)
    {
        this.linearVelocity = linearVelocity;
    }
}
