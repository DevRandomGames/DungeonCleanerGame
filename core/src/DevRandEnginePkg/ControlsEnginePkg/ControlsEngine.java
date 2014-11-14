/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg.ControlsEnginePkg;

import java.util.ArrayList;

/**
 *
 * @author ArclorenSarth
 */
public class ControlsEngine {
    private ArrayList<ActionController> actionCtrls;
    private int plyrSts, enmSts, frndSts;
    


    public ControlsEngine(){
        actionCtrls = new ArrayList();
        plyrSts = 0;
        enmSts = 0;
        frndSts = 0;
    }

    public void computeControls(){
        for(int i=0; i<actionCtrls.size(); ++i)
	    actionCtrls.get(i).computeAction(plyrSts,enmSts,frndSts);
    }

    public void addControl(ActionController c){
        actionCtrls.add(c);
    }

    public void removeControl(ActionController c){
        actionCtrls.remove(c);
    }
    
    public void changeStatus(int p,int e,int f){
        plyrSts = p;
        enmSts = e;
        frndSts = f;
    }


}