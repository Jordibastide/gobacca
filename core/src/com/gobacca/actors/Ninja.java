package com.gobacca.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.gobacca.box2d.NinjaUserData;

public class Ninja extends GameActor
{
	private boolean jumping;
	private boolean hit;
	
    public Ninja(Body body)
    {
        super(body);
    }
    
    @Override
    public NinjaUserData getUserData()
    {
        return (NinjaUserData) userData;
    }
    
    public void jump()
    {
        if (!jumping)
        {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
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
    }

    public boolean isHit()
    {
        return hit;
    }

}