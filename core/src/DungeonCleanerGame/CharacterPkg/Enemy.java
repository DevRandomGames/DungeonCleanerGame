/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ConstantEngine;
import DevRandEnginePkg.DevRandEngine;
import DevRandEnginePkg.RandomEngine;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.walk;
import DungeonCleanerGame.ControlsPkg.DungeonIAController;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import DungeonCleanerGame.IAPkg.IA;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;



/**
 *
 * @author ivan
 */
public class Enemy extends GameCharacter {
    private final static DevRandEngine gameEng = DevRandEngine.getInstance();
    protected final static ConstantEngine constant = gameEng.gameConstant();
    private IA myIA;
    private static final short GROUP_MONSTER = constant.getShortConstant("GROUP_MONSTER");
    private static final short GROUP_MONSTER_VISION = constant.getShortConstant("GROUP_MONSTER_VISION");
    private static final short BULLET = constant.getShortConstant("BULLET");
    private static int ID=0;
    
    private int enemyID;
    private int bulletID;
    private Body bulletbody;
    
    public Enemy(float unitScale){
        enemyID = ID;
        bulletID = ID;
        myIA = new IA();
        ++ID;
        //CREAMOS EL PLAYERCONTROLLER
        super.controls = new DungeonIAController(this);
        
    }
    
    public int getEnemyID(){
        return enemyID;
    }
    
    public void killEnemy(){
        super.body.setLinearVelocity(0f,0f);
        gameEng.gamePhysics().addDeadBodie(super.body);
        if(bulletbody != null) gameEng.gamePhysics().addDeadBodie(bulletbody);
        this.remove();
        //aqui reproducir sonido o algo
    }
    
    public void createBody(float x, float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        super.body = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        super.body.setUserData(enemyID);
        
        /*PolygonShape shape = new PolygonShape();
        shape.setAsBox(this.getWidth()/5f, this.getHeight()/5f);*/
        CircleShape shape = new CircleShape();
        shape.setRadius(this.getWidth()/4f);
        FixtureDef fixtureBox = new FixtureDef();
        fixtureBox.shape = shape;
        fixtureBox.density = 2f;
        fixtureBox.filter.groupIndex = GROUP_MONSTER;
        body.createFixture(fixtureBox);
        shape.dispose();
        
        /*PolygonShape Areashape = new PolygonShape();
        Areashape.setAsBox(this.getWidth()*2, this.getHeight()*2);*/
        CircleShape Areashape = new CircleShape();
        shape.setRadius(this.getWidth()*2);
        FixtureDef fixtureArea = new FixtureDef();
        fixtureArea.isSensor = true;
        fixtureArea.shape = Areashape;
        fixtureArea.density = 2f;
        fixtureArea.filter.groupIndex = GROUP_MONSTER_VISION;
        body.createFixture(fixtureArea);
        Areashape.dispose();
        
        
    }
    
    public void createBullet(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(super.body.getPosition().x,super.body.getPosition().y);
        if(bulletbody != null) gameEng.gamePhysics().addDeadBodie(bulletbody);
        bulletbody = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        bulletbody.setUserData(bulletID);
        
        CircleShape cshape = new CircleShape();
        cshape.setRadius(0.1f);
        FixtureDef fixtureBull = new FixtureDef();
        fixtureBull.shape = cshape;
        fixtureBull.density = 0.5f;
        fixtureBull.filter.groupIndex = BULLET ;
        bulletbody.createFixture(fixtureBull);
        cshape.dispose();
        
    }
    
    public Body getBullet(){
        return bulletbody;
    }
    
    public int getTotalID(){
        return ID;
    }
    
    public void iaComputeState(){
        if(myIA.getAlert() && myIA.getTime()>0){
            this.st = st.stalk;
        }
        else if(myIA.getHit()){
            this.st = st.strike;
            myIA.setHit(false);
            myIA.actStnby();
        }
        else if(myIA.getStnby() && myIA.getTime()<2) {
            this.st = st.standby;
            myIA.addTime(Gdx.graphics.getDeltaTime());
        }
        else{
            myIA.decAlert();
            myIA.clearTimer();
            myIA.decStnby();
            this.st = walk;
        }
    }
    
    public void iaComputeDir(){
        if(this.st == st.walk){
            this.d =  myIA.RandomDir(RandomEngine.randInt(0,5));
        }
        else {
           this.d = myIA.nextDirToPlayer(this.getBodyX(),this.getBodyY()); 
        }
    }
    
    public DungeonIAController getEnemyControls(){
        return (DungeonIAController) super.controls;
    }
    
    public IA getIA(){
        return myIA;
    }
}
