package repio.shoot;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by osboxes on 30/01/17.
 */
public class Bullet {

	private double speed;
	private double posx;
	private double posy;
	private double direction;

	private double beta = 0.0d;
	private double distance = 0.0d;
	private int amplitude = 10;
	private double frequency = 0.0d;
	private double sinx = 0.0d;
	private double siny = 0.0d;
	private boolean wave = false;

	public Bullet() {
		this.posx = 0;
		this.posy = 0;
		this.speed = 0;
		this.direction = 0;
		this.beta = Math.toRadians(direction) + Math.PI / 2;
		this.sinx = 0;
		this.siny = 0;
	}

	public void init(int x, int y, double speed, double direction) {
		this.posx = x;
		this.posy = y;
		this.speed = speed;
		this.direction = direction;
		this.beta = Math.toRadians(direction) + Math.PI / 2;
		this.sinx = x;
		this.siny = y;
	}

	public void affichage(Graphics g, boolean bool, Color shootColor) {
		g.setColor(shootColor);
		if (bool) {
			g.fillOval((int) this.getSinx(), (int) this.getSiny(), 8, 8);
		} else {
			g.fillOval((int) this.getPosx(), (int) this.getPosy(), 8, 8);
		}
	}

	public void update() {
		setPosx((getPosx() + speed * Math.cos(Math.toRadians(direction))));
		setPosy((getPosy() + speed * Math.sin(Math.toRadians(direction))));
		distance = amplitude * Math.sin(frequency);
		sinx = getPosx() + Math.cos(beta) * distance;
		siny = getPosy() + Math.sin(beta) * distance;
		frequency += 0.16d;
		direction += 0.01d;
	}

	public boolean isAlive() {
		boolean result = true;
		if (this.getPosx() <= 10 || this.getPosx() >= 790 || this.getPosy() <= 10 || this.getPosy() >= 590) {
			result = false;
		}
		return result;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getSinx() {
		return sinx;
	}

	public void setSinx(double sinx) {
		this.sinx = sinx;
	}

	public double getSiny() {
		return siny;
	}

	public void setSiny(double siny) {
		this.siny = siny;
	}

	public boolean isWave() {
		return wave;
	}

	public void setWave(boolean wave) {
		this.wave = wave;
	}

}
