package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


public class DungeonCleaner extends ApplicationAdapter {
	DevRandEngine gameEngine;
        private int posX;
        private int posY;
        private float scale;
        private int mvSpeed;
        
        @Override
	public void create () {
            gameEngine = DevRandEngine.getInstance();
            posX=0; posY=0; scale=0.1f; mvSpeed=5;
	}

	@Override
	public void render () {
            renderGame();
	}
        
        
        private void renderGame(){
            inputControl();
            gameEngine.gameRender().renderBegin();
            gameEngine.gameRender().renderSprite("knight.jpg",posX,posY,scale);
            gameEngine.gameRender().renderEnd();
        }
        
        private void inputControl(){
            if(Gdx.input.isKeyPressed(Input.Keys.W)) posY+=mvSpeed;
            if(Gdx.input.isKeyPressed(Input.Keys.S)) posY-=mvSpeed;
            if(Gdx.input.isKeyPressed(Input.Keys.A)) posX-=mvSpeed;
            if(Gdx.input.isKeyPressed(Input.Keys.D)) posX+=mvSpeed;
        }
}
