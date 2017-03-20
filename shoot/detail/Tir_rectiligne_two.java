package repio.shoot.detail;

import java.awt.*;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_two extends TirMissile {

    public Tir_rectiligne_two(int posx, int posy, int direction) {
    	this.setName(Consts.TIR_RECTILIGNE_2);
        this.init(posx,posy,2,4,30, 17, direction,new Rotation(),false,Color.CYAN);        
        ajoutBalles();
    }

}
