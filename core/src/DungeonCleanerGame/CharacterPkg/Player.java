/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 *
 * @author ivan
 */
public class Player extends GameCharacter{
    
    public Player(){
        //super.texture = t;
        setBounds(this.getX(),this.getY(),64,64);
        //CREAMOS EL PLAYERCONTROLLER Y ANADIMOS AL CONTROLS ENGINE
        super.controls = new DungeonPlayerController(this);
    }
    
    public DungeonPlayerController getPlayerControls(){
        return (DungeonPlayerController) super.controls;
    }
   
    
}
