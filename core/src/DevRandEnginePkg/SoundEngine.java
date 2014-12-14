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
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;
import java.util.TreeMap;

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
    private TreeMap<String,Sound> sounds;
    private String musicPath;
    private String soundPath;
    
    
    private SoundEngine(DevRandEngine e){
        engine = e;
        musicNames = new Array();
        sounds = new TreeMap();
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
    
    private void addSound(String name, String path){
        sounds.put(name,audio.newSound(Gdx.files.internal(soundPath + path)));
    }
    
    public void playSoundWeapon(){
        //sounds.get("sword").play();
        sounds.get("swing3").play();
    }
    
    public void playSoundDoor(){
        sounds.get("door").play();
    }
    
    public void playSoundWorm(){
        sounds.get("slime10").play();
    }
    
    public void playSoundGhost(){
        sounds.get("shade11").play();
    }
    
    public void playSoundBoss(){
        sounds.get("ogre5").play();
    }
    
    public void playSoundPlayer(){
        sounds.get("chainmail2").play();
    }
    
    public void playSoundProjectile(){
        sounds.get("random2").play();
    }
    
    
    public void loadSounds(){
        addSound("swing","swing.mp3");
        addSound("swing3","swing3.mp3");
        addSound("sword","sword.mp3");
              
        addSound("door","door.mp3");
        
        addSound("shade11","shade11.mp3");
        addSound("slime10","slime10.mp3");
        addSound("ogre5","ogre5.mp3");
        addSound("random2","random2.mp3");
        addSound("chainmail2","chainmail2.mp3");
        
    }
    
    public void setMusicToPlay(String m){
        if (music != null){music.stop();music.dispose();}
        music = audio.newMusic(Gdx.files.internal(musicPath + m));
        music.setVolume(0.8f);
        music.play();
       
    }
    
    public void setRandomMusicToPlay(){
        if (music != null){music.stop();music.dispose();}
        int random = engine.randEng.randInt(0,musicNames.size);
        music = audio.newMusic(Gdx.files.internal(musicPath + musicNames.get(random)));
        music.setVolume(0.8f);
        music.play();
    }
    
    public void autoPlayList(){
        if (music != null && !music.isPlaying()){
            music.stop();
            music.dispose();
            int random = engine.randEng.randInt(0,musicNames.size);
            music = audio.newMusic(Gdx.files.internal(musicPath + musicNames.get(random)));
            music.setVolume(0.8f);
            music.play();
        }
    }
   
    
}


