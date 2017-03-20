package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_sin_two extends TirMissile {

	public Tir_sin_two(int posx, int posy, int direction) {
		this.setName(Consts.TIR_WAVE_2);
		this.init(posx, posy, 2, 4, 20, 5, direction, new Rotation(), true, Color.red);
		ajoutBalles();
	}
}
