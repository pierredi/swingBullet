package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_one extends TirMissile {

    public Tir_rectiligne_one(int posx, int posy, int direction) {
    	this.setName(Consts.TIR_RECTILIGNE_1);
        this.init(posx,posy,1,4,180, 17, direction,new Rotation(),false,Color.blue);        
        ajoutBalles();
    }
}
