package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_sin_one extends TirMissile {

	public Tir_sin_one(int posx, int posy, int direction) {
		this.setName(Consts.TIR_WAVE_1);
		this.init(posx, posy, 1,4, 0, 5, direction, new Rotation(), true, Color.red);
		ajoutBalles();
	}
}
