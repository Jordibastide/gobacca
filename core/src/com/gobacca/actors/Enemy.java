package com.gobacca.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.EnemyUserData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gobacca.utils.AudioUtils;
import com.gobacca.utils.Constants;

public class Enemy extends GameActor
{
	private Animation animation;
	private static TextureAtlas textureAtlas;
    private float stateTime;
    private Body body;
    private boolean deleteFlag;
    private int max_hp;
    private int current_hp;
    private Sound shurikenhitSound;

    public Enemy(Body b)
    {
        super(b);
        body = b;
        
        textureAtlas = new TextureAtlas(Constants.ENEMY_ATLAS_PATH);
        TextureRegion[] runningFrames = new TextureRegion[getUserData().getTextureRegions().length];
        
        for (int i = 0; i < getUserData().getTextureRegions().length; i++)
        {
            String path = getUserData().getTextureRegions()[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        animation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
        
        deleteFlag = false;
        shurikenhitSound = AudioUtils.getInstance().getShurikenhitSound();
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
        
        if(body != null)
        	body.setLinearVelocity(getUserData().getLinearVelocity());
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(stateTime, true), (screenRectangle.x - (screenRectangle.width * 0.8f)), screenRectangle.y, screenRectangle.width * 1.8f, screenRectangle.height * 1.5f);
    }
    
    public Body getBody()
    {
    	return body;
    }
    
    public void setMaxHP(int hp)
    {
    	max_hp = hp;
    }
    
    public void setHP(int hp)
    {
    	current_hp = hp;
    }
    
    public int getMaxHP()
    {
    	return max_hp;
    }
    
    public void hit()
    {
    	--current_hp;
    	AudioUtils.getInstance().playSound(shurikenhitSound);
    	
    	
    	if(current_hp <= 0)
    	{
    		deleteFlagON();
    	}
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
    
    protected void finalize() throws Throwable
    {
    	animation = null;
    	body = null;
    	super.finalize();
    }

    public static void dispose() {
    	textureAtlas.dispose();
    }
}