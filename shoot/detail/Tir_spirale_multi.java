package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_spirale_multi extends TirMissile {
	
    public Tir_spirale_multi(int posx, int posy, double direction) {
    	this.setName(Consts.TIR_SPIRALE_MULTI);
    	Rotation rotation = new Rotation(true,true,true,1,8,15);
        this.init(posx,posy,5,4,360, 7, direction,rotation,false,Color.YELLOW);
        ajoutBalles();
    }    
}
