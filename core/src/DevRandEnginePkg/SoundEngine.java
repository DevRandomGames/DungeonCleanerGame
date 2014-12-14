/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author ArclorenSarth
 */
public class SoundEngine {
    private DevRandEngine engine;
    private static SoundEngine INSTANCE = null;
    private Audio audio = Gdx.audio;
    private Music music;
    private Array<String> musicNames;
    private Array<String> soundNames;
    private String musicPath;
    private String soundPath;
    
    
    private SoundEngine(DevRandEngine e){
        engine = e;
        musicNames = new Array();
        soundNames = new Array();
    }
    
    private static void createInstance(DevRandEngine e){
        INSTANCE = new SoundEngine(e);
    }
    
    public static SoundEngine getInstance(DevRandEngine e){
        if(INSTANCE == null) createInstance(e);
        return INSTANCE;
    }
    
    public void setMusicPath(String p){
        musicPath = p;
    }
    
    public void setSoundPath(String p){
        soundPath = p;
    }
    
    
    public void addMusic(String m){
        musicNames.add(m);
    }
    
    public void addSound(String s){
        soundNames.add(s);
    }
    
    public void setMusicToPlay(String m){
        if (music != null){music.stop();music.dispose();}
        music = audio.newMusic(Gdx.files.internal(musicPath + m));
        music.play();
       
    }
    
    public void setRandomMusicToPlay(){
        if (music != null){music.stop();music.dispose();}
        int random = engine.randEng.randInt(0,musicNames.size);
        music = audio.newMusic(Gdx.files.internal(musicPath + musicNames.get(random)));
        music.play();
    }
    
    public void autoPlayList(){
        if (music != null && !music.isPlaying()){
            music.stop();
            music.dispose();
            int random = engine.randEng.randInt(0,musicNames.size);
            music = audio.newMusic(Gdx.files.internal(musicPath + musicNames.get(random)));
            music.play();
        }
    }
   
    
}


