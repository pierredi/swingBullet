package repio.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import repio.shoot.TirMissile;
import repio.shoot.detail.Tir_rectiligne_one;

/**
 * Created by osboxes on 30/01/17.
 */
public class JGraph extends JPanel implements ActionListener {

	/** generated serial uid. */
	private static final long serialVersionUID = 8043740788705910522L;
	Timer timer;
	private List<TirMissile> canon = new ArrayList<>();
	private TirMissile tir;

	public JGraph(int tempo) {
		super();
		this.setPreferredSize(new Dimension(800, 600));
		init();
		timer = new Timer(tempo, this);
		timer.start();
	}

	public JGraph(int tempo, TirMissile tir) {
		super();
		this.setPreferredSize(new Dimension(800, 600));
		this.setTir(tir);
		timer = new Timer(tempo, this);
		timer.start();
		canon.add(tir);
	}

	public void init() {
		tir = new Tir_rectiligne_one(200, 200, 50);
		canon.add(tir);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		affichage(g);
		g.setColor(c);
	}

	private void affichage(Graphics g) {
		Iterator<TirMissile> iter = canon.iterator();
		while (iter.hasNext()) {
			TirMissile coudDeFeu = iter.next();
			coudDeFeu.affichage(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == timer) {
			repaint();
		}
	}

	/**
	 * @return the tir
	 */
	public TirMissile getTir() {
		return tir;
	}

	/**
	 * @param tir
	 *            the tir to set
	 */
	public void setTir(TirMissile tir) {
		this.tir = tir;
	}
}
