package repio.shoot.detail;

import java.awt.Color;
import java.util.Iterator;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.Bullet;
import repio.shoot.TirMissile;


/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_spirale_two_left extends TirMissile {
    private int compteur=0;

    public Tir_spirale_two_left(int posx, int posy, int direction) {
        this.setName(Consts.TIR_SPIRALE_2);
        this.init(posx,posy,2,4,540, 7, direction, new Rotation(true,true,false,1,8,15),false,Color.MAGENTA);
        ajoutBalles();
    }
}
