package repio.shoot.detail;

import java.awt.Color;

import repio.principale.Consts;
import repio.principale.utile.Rotation;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_etoile_spin_8 extends TirMissile {

	public Tir_etoile_spin_8(int posx, int posy) {
		this.setName(Consts.TIR_STAR_SPIN_8);
		Rotation rotation = new Rotation(true, true, false, 1,8, 15);
		this.init(posx, posy, 8,4, 360, 7, 0, rotation, true, Color.darkGray);
		ajoutBalles();
	}
}
