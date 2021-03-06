package repio.shoot.detail;

import java.awt.Color;
import java.util.Iterator;

import repio.principale.utile.Rotation;
import repio.shoot.Bullet;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_ring_50 extends TirMissile {
    private int compteur =0;

    public Tir_ring_50(int posx, int posy, int direction) {
        this.init(posx,posy,50,4,380, 17, direction, new Rotation(),false,Color.RED);
        ajoutBalles();
    }

    public void update(){
        this.compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!courant.isAlive()){
                iter.remove();
            }
        }
    }

}
