package repio.shoot;

import java.awt.Color;

import repio.principale.utile.Rotation;

/**
 * Created by repio on 06/02/17.
 */
public class Tir_Canon extends TirMissile {

	public Tir_Canon(int posx, int posy, int nbBalles, int speed, double angle, int frequence, double direction, boolean isRotate,
			boolean vitesse_Constante, boolean sens, double minSpin,double spin, double maxSpin, boolean wave, Color couleur) {
		
		Rotation rotation = new Rotation(isRotate, sens, !vitesse_Constante, minSpin, spin, maxSpin);
		
		this.init(posx, posy, nbBalles, speed, angle, frequence, direction, rotation, wave, couleur);
		ajoutBalles();
	}

}
