package repio.shoot.detail;

import java.awt.Color;
import java.util.Iterator;

import repio.principale.utile.Rotation;
import repio.shoot.Bullet;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_spirale_three_left extends TirMissile {
    private int compteur=0;

    public Tir_spirale_three_left(int posx, int posy, int direction) {
        this.init(posx,posy,3,4,480, 7, direction, new Rotation(),false,Color.GRAY);
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
