package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.audio.Sound;
import com.gobacca.box2d.NinjaUserData;
import com.gobacca.utils.AudioUtils;
import com.gobacca.utils.Constants;

public class Ninja extends GameActor
{
    private boolean jumping;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion hitTexture;
    private float stateTime;
    
<<<<<<< HEAD
    // Caracteristiques personnage
    int nb_shuriken;
    float pos_x;
    float pos_y;
=======
    private Sound jumpSound;
    private Sound hitSound;
    private Sound gameoverSound;
>>>>>>> sound
	
    public Ninja(Body body)
    {
    	 super(body);
<<<<<<< HEAD
    	 
         TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
=======
         TextureAtlas textureAtlas = new TextureAtlas(Constants.NINJA_ATLAS_PATH);
>>>>>>> sound
         TextureRegion[] runningFrames = new TextureRegion[Constants.NINJA_RUNNING_REGION_NAMES.length];
         for (int i = 0; i < Constants.NINJA_RUNNING_REGION_NAMES.length; i++)
         {
             String path = Constants.NINJA_RUNNING_REGION_NAMES[i];
             runningFrames[i] = textureAtlas.findRegion(path);
         }
<<<<<<< HEAD
         
         runningAnimation = new Animation(0.1f, runningFrames);
         stateTime = 0f;
         jumpingTexture = textureAtlas.findRegion(Constants.NINJA_JUMPING_REGION_NAME);
         hitTexture = textureAtlas.findRegion(Constants.NINJA_HIT_REGION_NAME);
         
         initCharacter();
    }
    
    public void initCharacter()
    {
    	nb_shuriken = Constants.NB_SHURIKEN_NINJA_AT_START;
=======
         runningAnimation = new Animation(0.05f, runningFrames);
         stateTime = 0f;
         jumpingTexture = textureAtlas.findRegion(Constants.NINJA_JUMPING_REGION_NAME);
         hitTexture = textureAtlas.findRegion(Constants.NINJA_HIT_REGION_NAME);
         //jumpSound = Gdx.audio.newSound(Gdx.files.internal(Constants.RUNNER_JUMPING_SOUND));
         //hitSound = Gdx.audio.newSound(Gdx.files.internal(Constants.RUNNER_HIT_SOUND));
         //gameoverSound = Gdx.audio.newSound(Gdx.files.internal(Constants.GAME_OVER_SOUND));
         jumpSound = AudioUtils.getInstance().getJumpSound();
         hitSound = AudioUtils.getInstance().getHitSound();
         gameoverSound = AudioUtils.getInstance().getGameoverSound();
>>>>>>> sound
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;
        
        pos_x = x;
        pos_y = y;

        if(hit)
        {
            // When he's hit we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, x, y, width * 0.5f, screenRectangle.height * 0.5f, width, screenRectangle.height, 1f,
                    1f, (float) Math.toDegrees(body.getAngle()));
        }
        else if(jumping)
        {
            batch.draw(jumpingTexture, x, y, width, screenRectangle.height);
        }
        else
        {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(runningAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        }
    }
    
    @Override
    public NinjaUserData getUserData()
    {
        return (NinjaUserData) userData;
    }
    
    public void jump()
    {
        if (!(jumping))
        {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
            AudioUtils.getInstance().playSound(jumpSound);
        }
    }

    public void landed()
    {
        jumping = false;
    }
    
    public void hit()
    {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
        AudioUtils.getInstance().playSound(hitSound);
        AudioUtils.getInstance().playSound(gameoverSound);
    }

    public boolean isHit()
    {
        return hit;
    }
<<<<<<< HEAD
    
    public int getNbShuriken()
    {
    	return nb_shuriken;
    }
    
    public void useShuriken()
    {
    	if(nb_shuriken > 0)
    	{
    		--nb_shuriken;
    	}
    }
    
    public void addAmmo()
    {
    	// body.applyLinearImpulse(getUserData().getAmmoLinearImpulse(), body.getWorldCenter(), true);
    	++nb_shuriken;
    }
    
    public float getY()
    {
    	return (pos_y / 30) + (1.2f * (1 - pos_y / 120));
    }
=======
>>>>>>> sound
}