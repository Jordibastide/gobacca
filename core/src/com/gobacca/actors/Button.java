package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Button extends Actor
{
    private TextureRegion textureRegion;
    private Rectangle bounds;
    
    public Button(String img_path, float x_bounds_1, float y_bounds_1, float x_bounds_2, float y_bounds_2)
    {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(img_path)));
        bounds = new Rectangle(x_bounds_1, y_bounds_1, x_bounds_2, y_bounds_2);
    }
    
    public void setTexture(String img_path)
    {
    	textureRegion = new TextureRegion(new Texture(Gdx.files.internal(img_path)));
    }
    
    public boolean contains(float x, float y)
    {
    	return bounds.contains(x, y);
    }

    @Override
    public void act(float delta)
    {
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
    }
}