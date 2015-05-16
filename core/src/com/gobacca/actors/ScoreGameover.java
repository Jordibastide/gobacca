package com.gobacca.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gobacca.utils.Constants;

public class ScoreGameover extends Actor {

    private float score;
    private Rectangle bounds;
    private BitmapFont font;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_NAME));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    public ScoreGameover(Rectangle bounds, int score) {
        this.bounds = bounds;
        this.score = score;
        setWidth(bounds.width);
        setHeight(bounds.height);
        parameter.size = 36;
        font = generator.generateFont(parameter);
        font.setColor(0f, 0f, 0f, 1f);
        generator.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (getScore() == 0) {
            return;
        }
        font.drawWrapped(batch, String.format("%d points, seulement...", getScore()), bounds.x, bounds.y, bounds.width, BitmapFont.HAlignment.CENTER);
    }

    public int getScore() {
        return (int) Math.floor(score);
    }
    
    public void dispose() {
        font.dispose();
    }

}
