package com.gobacca.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gobacca.game.GobaccaGame;
import com.gobacca.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.APP_WIDTH;
        config.height = Constants.APP_HEIGHT;
		new LwjglApplication(new GobaccaGame(), config);
	}
}
