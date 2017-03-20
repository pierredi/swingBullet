package repio.shoot.detail;

import java.awt.Color;
import java.util.Iterator;

import repio.shoot.Bullet;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_explo extends TirMissile {
    private int compteur = 0;

    public Tir_rectiligne_explo(int posx, int posy, int direction) {
        this.init(posx,posy,1,0, 27, direction,false,1,15,false,Color.BLUE);
        ajoutBalles();
    }

    public void update(){
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (compteur==100){
            	setColorShoot(Color.RED);            	                
                TirMissile ring =  new Tir_ring_50((int)courant.getPosx(),(int)courant.getPosy(),(int)courant.getDirection());                
                setBalles(ring.getBalles());                
            }
        }
    }

}