package com.gobacca.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.AmmoUserData;
import com.gobacca.utils.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ammo extends GameActor
{
	private TextureRegion textureRegion;
    private Rectangle bounds;
    private Body body;
    private boolean deleteFlag;

    public Ammo(Body b)
    {
        super(b);
        body = b;
        
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.SHURIKEN_IMAGE_PATH)));
        bounds = new Rectangle(0, 0, Constants.SHURIKEN_WIDTH, Constants.SHURIKEN_HEIGHT);
        
        deleteFlag = false;
    }

    @Override
    public AmmoUserData getUserData()
    {
        return (AmmoUserData) userData;
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);
        
        if(body != null)
        	body.setLinearVelocity(getUserData().getLinearVelocity());
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
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
    
    public void setBodyNull()
    {
    	body = null;
    }
}