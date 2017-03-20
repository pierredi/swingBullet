package repio.principale.utile;

public class Rotation {
	/** rotation active. */
	private boolean rotation;
	/** sens de rotation horaire.*/
	private boolean sensHoraire;
	/** vitesse de rotation.*/	
	private double spin ;
	/** vitesse Max de rotation.*/
	private double maxSpin ;	
	/** vitesse Min de rotation.*/
	private double minSpin ;
	/** vitesse constante ou acceleration.*/
	private boolean acceleration;
	
	
	/**
	 * 
	 * @param rotation flag indiquant l'Activation de la rotation.
	 * @param sensHoraire true pour un sens horaire de la rotation false sinon.
	 * @param acceleration true pour acceleration false pour vitesse constante.
	 * @param minSpin vitesse de rotation.
	 * @param spin vitesse de rotation.
	 * @param maxSpin vitesse Max de rotation. 
	 * 
	 */
	public Rotation(boolean rotation, boolean sensHoraire, boolean acceleration, double minSpin, double spin, double maxSpin) {
		super();
		this.rotation = rotation;
		this.sensHoraire = sensHoraire;
		this.acceleration = acceleration;
		this.spin = spin;
		this.maxSpin = maxSpin;
		this.minSpin = minSpin;
	}
	
	public Rotation() {
		super();
		this.rotation = false;
		this.sensHoraire = true;
		this.acceleration = false;
		this.spin = 8;
		this.maxSpin = 2;
		this.minSpin = 12;
	}

	/**
	 * @return the rotation
	 */
	public boolean isRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(boolean rotation) {
		this.rotation = rotation;
	}

	/**
	 * @return the sensHoraire
	 */
	public boolean isSensHoraire() {
		return sensHoraire;
	}

	/**
	 * @param sensHoraire the sensHoraire to set
	 */
	public void setSensHoraire(boolean sensHoraire) {
		this.sensHoraire = sensHoraire;
	}

	/**
	 * @return the spin
	 */
	public double getSpin() {
		return spin;
	}

	/**
	 * @param spin the spin to set
	 */
	public void setSpin(double spin) {
		this.spin = spin;
	}

	/**
	 * @return the maxSpin
	 */
	public double getMaxSpin() {
		return maxSpin;
	}

	/**
	 * @param maxSpin the maxSpin to set
	 */
	public void setMaxSpin(double maxSpin) {
		this.maxSpin = maxSpin;
	}

	/**
	 * @return the minSpin
	 */
	public double getMinSpin() {
		return minSpin;
	}

	/**
	 * @param minSpin the minSpin to set
	 */
	public void setMinSpin(double minSpin) {
		this.minSpin = minSpin;
	}

	/**
	 * @return the acceleration
	 */
	public boolean isAcceleration() {
		return acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(boolean acceleration) {
		this.acceleration = acceleration;
	}
	
}
