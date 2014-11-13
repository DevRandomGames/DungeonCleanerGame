/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

/**
 *
 * @author ArclorenSarth
 */
public class RenderEngine {
    private static RenderEngine INSTANCE = null;
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture img;
    private TextureAtlas textureAtlas;
    
    
    
    
    
    private RenderEngine(){
        batch = new SpriteBatch();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    private static void createInstance(){
        INSTANCE = new RenderEngine();
    }
    
    public static RenderEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void renderBegin(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
    }
    
    public void renderEnd(){
        batch.end();
    }
    
    
    public void renderSprite(String fileName,int posX,int posY,float scale){
        img = new Texture(fileName);
        sprite = new Sprite(img);
        sprite.setOrigin(0,0);
        sprite.setScale(scale);
        sprite.setPosition(posX,posY);
        
        sprite.draw(batch);
    }
    
    
}
