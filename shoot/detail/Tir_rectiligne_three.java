package repio.shoot.detail;

import java.awt.*;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_three extends TirMissile {    

    public Tir_rectiligne_three(int posx, int posy, int direction) {
    	this.setName(Consts.TIR_RECTILIGNE_3);
        this.init(posx,posy,3,4,45, 13, direction,new Rotation(),false,Color.orange);        
        ajoutBalles();
    }

}
