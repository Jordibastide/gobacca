package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gobacca.utils.Constants;

public class BackgroundBACK extends Actor
{
    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed = 100;

    public BackgroundBACK()
    {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH)));
        textureRegionBounds1 = new Rectangle(0 - Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds2 = new Rectangle(Constants.APP_WIDTH / 2, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }
    
    public BackgroundBACK(String img_path, float x_bounds_1, float y_bounds_1, float x_bounds_2, float y_bounds_2, int s)
    {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(img_path)));
        textureRegionBounds1 = new Rectangle(x_bounds_1, y_bounds_1, x_bounds_2, y_bounds_2);
        textureRegionBounds2 = new Rectangle(x_bounds_1, y_bounds_1, x_bounds_2, y_bounds_2);
        
        speed = s;
    }

    @Override
    public void act(float delta)
    {
        if (leftBoundsReached(delta))
        {
            resetBounds();
        }
        else
        {
            updateXBounds(-delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, 4800, 540);
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, 4800, 540);
    }

    private boolean leftBoundsReached(float delta)
    {
        return (textureRegionBounds2.x - (delta * speed)) <= 0;
    }

    private void updateXBounds(float delta)
    {
        textureRegionBounds1.x += delta * speed;
        textureRegionBounds2.x += delta * speed;
    }

    private void resetBounds()
    {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(4800, 0, 4800, 540);
    }

}