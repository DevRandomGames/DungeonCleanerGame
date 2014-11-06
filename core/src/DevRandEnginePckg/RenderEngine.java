/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePckg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author ArclorenSarth
 */
public class RenderEngine {
    private static RenderEngine INSTANCE = null;
    SpriteBatch batch;
    Texture img;
        
    
    
    private RenderEngine(){
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }
    
    private static void createInstance(){
        INSTANCE = new RenderEngine();
    }
    
    public static RenderEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    
    public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
    
    
}
