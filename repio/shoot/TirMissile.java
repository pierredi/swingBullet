package repio.shoot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import repio.principale.utile.Rotation;

/**
 * Created by osboxes on 06/02/17.
 */
abstract public class TirMissile {

	private List<Bullet> balles = new ArrayList<Bullet>();
	private String name = "Shoot name to display";

	private double direction;
	private double angle;
	private int posX;
	private int posY;
	private int nbBalles;
	private int speed;	
	private int frequence;
	private int compteur = 0;	
	private boolean wave;
	private Color colorShoot;
	private boolean accelere = true;
	
	private Rotation rotation;	

	/**
	 * 
	 * @param posx
	 *            position de depart x du projectile.
	 * @param posy
	 *            position de depart y du projectile
	 * @param nbBalles
	 *            Nombre de balles
	 * @param angle
	 *            angle de couverture du tir
	 * @param frequence
	 *            Cadence de tir.
	 * @param direction
	 *            Direction du tir.
	 * @param rotation
	 *            Flag controlant la rotation du canon
	 * @param wave
	 *            Flag de gestion des trajectoires sinusoïdales
	 * @param couleur
	 *            couleur du tir.
	 */
	public void init(int posx, int posy, int nbBalles,int speed, double angle, int frequence, double direction, Rotation rotation, boolean wave, Color couleur) {
		this.setPosX(posx);
		this.setPosY(posy);
		this.setAngle(angle);
		this.setNbBalles(nbBalles);
		this.setSpeed(speed);
		this.setFrequence(frequence);
		this.setDirection(direction - angle / 2);
		this.setCompteur(0);		
		this.setRotation(rotation);		
		this.setWave(wave);
		this.setColorShoot(couleur);
		//initialisation du pool de balles
        /**for (int cpt = 0; cpt < nbBalles; cpt++) {
            Bullet proj = new Bullet();
            balles.add(proj);
        }**/
	}

	public void ajoutBalles() {
		double angleBase = 0.0d;
		if (nbBalles > 1) {
			angleBase = angle / (nbBalles - 1);
		}

		for (int cpt = 0; cpt < nbBalles; cpt++) {
			Bullet proj = new Bullet();
			proj.init(this.posX, this.posY, this.speed, direction - angle + cpt * angleBase);
			balles.add(proj);
		}
	}

	public void affichage(Graphics g) {
		for (Bullet projectile : this.getBalles()) {
			projectile.affichage(g, isWave(), getColorShoot());
		}
		this.update();
	}

	public void update() {
		compteur++;
		Iterator<Bullet> iter = getBalles().iterator();
		while (iter.hasNext()) {
			Bullet courant = iter.next();
			courant.update();
			if (!courant.isAlive()) {
				iter.remove();
			}
		}
		if (compteur % getFrequence() == 0) {			
			if (rotation.isRotation()) {
				updateRotation();
			}
			ajoutBalles();
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		return result.toString();
	}

	/**
	 * Mise a jour de la rotation
	 */
	public void updateRotation() {
		if (rotation.isSensHoraire()) {
			setDirection(getDirection() + rotation.getSpin());
		} else {
			setDirection(getDirection() - rotation.getSpin());
		}

		if (rotation.isAcceleration()) {
			if (accelere) {
				rotation.setSpin(1.91d * rotation.getSpin());
			} else {
				rotation.setSpin(0.8d * rotation.getSpin());
			}
			if (rotation.getSpin() > rotation.getMaxSpin()) {
				accelere = false;
			}
			if (rotation.getSpin() < rotation.getMinSpin()) {
				accelere = true;
				rotation.setSensHoraire(!rotation.isSensHoraire());
			}
		}

	}

	public List<Bullet> getBalles() {
		return balles;
	}

	public void setBalles(List<Bullet> balles) {
		this.balles = balles;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNbBalles() {
		return nbBalles;
	}

	public void setNbBalles(int nbBalles) {
		this.nbBalles = nbBalles;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	public boolean isWave() {
		return wave;
	}

	public void setWave(boolean wave) {
		this.wave = wave;
	}

	public Color getColorShoot() {
		return colorShoot;
	}

	public void setColorShoot(Color colorShoot) {
		this.colorShoot = colorShoot;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the rotation
	 */
	public Rotation getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}
}
