package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.ShurikenUserData;
import com.gobacca.utils.Constants;

public class Shuriken extends GameActor
{
	private Animation turningAnimation;
    private float stateTime;
    private Body body;
    private boolean deleteFlag;
    
	public Shuriken(Body b)
    {
    	 super(b);
    	 body = b;
    	 
         TextureAtlas textureAtlas = new TextureAtlas(Constants.SHURIKEN_ATLAS_PATH);
         TextureRegion[] turningFrames = new TextureRegion[Constants.SHURIKEN_REGION_NAMES.length];
         for (int i = 0; i < Constants.SHURIKEN_REGION_NAMES.length; i++)
         {
             String path = Constants.SHURIKEN_REGION_NAMES[i];
             turningFrames[i] = textureAtlas.findRegion(path);
         }
         
         turningAnimation = new Animation(0.005f, turningFrames);
         stateTime = 0f;
         
         deleteFlag = false;
    }
	
	@Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;

        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(turningAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
    }
	
	@Override
	public ShurikenUserData getUserData()
	{
		return (ShurikenUserData) userData;
	}
	
	public Body getBody()
    {
    	return body;
    }
	
	public boolean getDeleteFlag()
    {
    	return deleteFlag;
    }
    
    public void deleteFlagON()
    {
    	deleteFlag = true;
    }
    
    public void launchShuriken()
    {
    	body.applyLinearImpulse(getUserData().getLinearImpulse(), body.getWorldCenter(), true);
    }
    
    public void setBodyNull()
    {
    	body = null;
    }
}