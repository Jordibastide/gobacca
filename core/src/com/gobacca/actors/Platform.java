package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.PlatformUserData;

public class Platform extends GameActor
{
    private Body body;
    private TextureRegion textureRegion;
    public  Platform(Body b)
    {
        super(b);
        body = b;
        
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(getUserData().getTextureFilePath())));
    }

    @Override
    public PlatformUserData getUserData()
    {
        return (PlatformUserData) userData;
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);
        
        if(body != null) {
        	body.setLinearVelocity(getUserData().getLinearVelocity());
        }
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, screenRectangle.x, screenRectangle.y, screenRectangle.width, screenRectangle.height);
    }
    
    public Body getBody()
    {
    	return body;
    }
    
    public void setBodyNull()
    {
    	body = null;
    }
}