package repio.shoot.detail;

import java.awt.Color;
import java.util.Iterator;

import repio.shoot.Bullet;
import repio.shoot.TirMissile;


/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_spirale_two_left extends TirMissile {
    private int compteur=0;

    public Tir_spirale_two_left(int posx, int posy, int direction) {
        this.init(posx,posy,2,540, 7, direction,true,1,15,true,Color.MAGENTA);
        ajoutBalles();
    }

    public void update() {
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while (iter.hasNext()) {
            Bullet courant = iter.next();
            courant.update();
            if (!courant.isAlive()) {
                iter.remove();
            }
        }
        if(compteur%getFrequence()==0){
            updateRotation();
            ajoutBalles();
        }
    }

}
