package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_sin_three extends TirMissile {

	public Tir_sin_three(int posx, int posy, int direction) {
		this.setName(Consts.TIR_WAVE_3);
		this.init(posx, posy, 3, 4, 45, 5, direction, new Rotation(), true, Color.red);
		ajoutBalles();
	}
}
