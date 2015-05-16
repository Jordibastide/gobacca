package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gobacca.utils.Constants;
import com.gobacca.actors.Ninja;

public class ScoreShuriken extends Actor {

    private Rectangle bounds;
    private BitmapFont font;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_NAME));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    public ScoreShuriken(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        parameter.size = 24;
        font = generator.generateFont(parameter);
        font.setColor(.21f, .22f, .21f, 1f);
        generator.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (getScore() == 0) {
            return;
        }
        font.drawWrapped(batch, String.format("%d shurikens, Ninja !", getScore()), bounds.x, bounds.y, bounds.width, BitmapFont.HAlignment.RIGHT);
    }

    public int getScore() {
        return (int) Ninja.getNbShuriken();
    }
    
    public void dispose() {
        font.dispose();
    }

}
