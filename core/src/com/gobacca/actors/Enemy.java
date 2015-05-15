package com.gobacca.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.EnemyUserData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gobacca.utils.Constants;

public class Enemy extends GameActor
{
	private Animation animation;
    private float stateTime;
    private Body body;
    private boolean deleteFlag;

    public Enemy(Body b)
    {
        super(b);
        body = b;
        
        TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
        TextureRegion[] runningFrames = new TextureRegion[getUserData().getTextureRegions().length];
        
        for (int i = 0; i < getUserData().getTextureRegions().length; i++)
        {
            String path = getUserData().getTextureRegions()[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        animation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
        
        deleteFlag = false;
    }

    @Override
    public EnemyUserData getUserData()
    {
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(stateTime, true), (screenRectangle.x - (screenRectangle.width * 0.1f)), screenRectangle.y, screenRectangle.width * 1.2f, screenRectangle.height * 1.1f);
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
}