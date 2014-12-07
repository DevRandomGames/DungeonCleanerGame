/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author ArclorenSarth
 */
public class SoundEngine {
    private static SoundEngine INSTANCE = null;
    private Audio audio = Gdx.audio;
    private Music music;
    private Array<String> musicNames;
    private Array<String> soundNames;
    private String musicPath;
    private String soundPath;
    
    
    private SoundEngine(){
        musicNames = new Array();
        soundNames = new Array();
    }
    
    private static void createInstance(){
        INSTANCE = new SoundEngine();
    }
    
    public static SoundEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void setMusicPath(String p){
        musicPath = p;
    }
    
    public void setSoundpath(String p){
        soundPath = p;
    }
    
    
    public void setMusicToPlay(String m){
        if (music != null){music.stop();music.dispose();}
        music = audio.newMusic(Gdx.files.internal(musicPath + m));
        music.play();
    }
    
    public void setRandomMusicToPlay(){
        if (music != null){music.stop();music.dispose();}
        music = audio.newMusic(Gdx.files.internal(musicPath + musicNames.get(0)));
        music.play();
    }
}
