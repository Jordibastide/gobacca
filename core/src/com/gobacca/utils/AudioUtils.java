package com.gobacca.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioUtils {
	private static AudioUtils ourInstance = new AudioUtils();
    public static Music music;
    public static Music music_2;
    private static Sound jumpSound;
    private static Sound hitSound;
    private static Sound shurikenSound;
    private static Sound shurikenhitSound;
    private static Sound gameoverSound;
    private static Sound buttonSound;
    
    private AudioUtils() {
    }

    public static AudioUtils getInstance() {
        return ourInstance;
    }

    public Music getMusic() {
        return music;
    }

    public void init() {
        music = Gdx.audio.newMusic(Gdx.files.internal(Constants.GAME_MUSIC));
        music_2 = Gdx.audio.newMusic(Gdx.files.internal(Constants.GAME_MUSIC_2));
        music.setLooping(true);
        music_2.setLooping(true);
        playMusic();
        jumpSound = createSound(Constants.RUNNER_JUMPING_SOUND);
        hitSound = createSound(Constants.RUNNER_HIT_SOUND);
        shurikenSound = createSound(Constants.SHURIKEN_SOUND);
        shurikenhitSound = createSound(Constants.SHURIKEN_HIT_SOUND);
        gameoverSound = createSound(Constants.GAME_OVER_SOUND);
        buttonSound = createSound(Constants.BUTTON_SOUND);
    }
    
    public Sound createSound(String soundFileName) {
        return Gdx.audio.newSound(Gdx.files.internal(soundFileName));
    }
    
    public void playMusic() {
    	music.play();
    	music_2.play();
    }

    public void playSound(Sound sound) {
    	sound.play(1.0f);
    }
    
    public static void disposeAudio() {
        music.dispose();
        music_2.dispose();
    }
    
    public static void disposeSound() {
        jumpSound.dispose();
        hitSound.dispose();
        shurikenSound.dispose();
        shurikenhitSound.dispose();
        gameoverSound.dispose();
        buttonSound.dispose();
    }

    public void pauseMusic() {
        music.pause();
        music_2.pause();
    }
    
    public void stopMusic() {
        music.stop();
        music_2.stop();
    }
    
    public Sound getJumpSound() {
        return jumpSound;
    }

    public Sound getHitSound() {
        return hitSound;
    }
    
    public Sound getShurikenSound() {
        return shurikenSound;
    }
    
    public Sound getShurikenhitSound() {
        return shurikenhitSound;
    }
    
    public Sound getGameoverSound() {
        return gameoverSound;
    }
    
    public Sound getButtonSound() {
        return buttonSound;
    }
}
