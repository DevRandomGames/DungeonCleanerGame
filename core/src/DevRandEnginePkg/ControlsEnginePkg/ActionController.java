/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg.ControlsEnginePkg;

/**
 *
 * @author ArclorenSarth
 */
public abstract class ActionController {
     protected Object ctrlIdentity;
     public float timer = 0;

     public void computeAction(int p, int e, int f){
         //metodo sobreescrito por las subclases
     }
}
