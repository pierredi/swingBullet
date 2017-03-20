package repio.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import repio.shoot.TirMissile;
import repio.shoot.detail.Tir_etoile_spin_8;
import repio.shoot.detail.Tir_rectiligne_one;
import repio.shoot.detail.Tir_rectiligne_three;
import repio.shoot.detail.Tir_rectiligne_two;
import repio.shoot.detail.Tir_sin_one;
import repio.shoot.detail.Tir_sin_three;
import repio.shoot.detail.Tir_sin_two;
import repio.shoot.detail.Tir_spirale_multi;

public class JParam extends JPanel {

	/** generated serial UID. */
	private static final long serialVersionUID = 7502686672150113659L;

	// parametre
	private JPanel params = new JPanel();
	private JTextField champs_posx = new JTextField();
	private JTextField champs_posy = new JTextField();
	private JTextField champs_nb_Balles = new JTextField();
	private JTextField champs_vitesse_Balles = new JTextField();
	private JTextField champs_angle = new JTextField();
	private JTextField champs_direction = new JTextField();
	private JTextField champs_frequence = new JTextField();
	private JPanel rotationGroupPanel = new JPanel();
	private ButtonGroup rotationGroup = new ButtonGroup();	
	private JPanel sensGroupPanel = new JPanel();
	private ButtonGroup sensGroup = new ButtonGroup();
	private JRadioButton sens_horaire = new JRadioButton("horaire");
	private JRadioButton sens_anti_horaire = new JRadioButton("anti horaire");	
	private JPanel vitesseRotationGroupPanel = new JPanel();
	private ButtonGroup vitesseRotationGroup = new ButtonGroup();
	private JRadioButton vitesse_constante = new JRadioButton("Constante");
	private JRadioButton vitesse_progressive = new JRadioButton("Progressive");	
	private JPanel sinusoideGroupPanel = new JPanel();
	private ButtonGroup sinusoideGroup = new ButtonGroup();
	private JTextField champs_spin_min = new JTextField();
	private JTextField champs_spin = new JTextField();
	private JTextField champs_spin_max = new JTextField();
	private JRadioButton rotation_oui = new JRadioButton("Oui");
	private JRadioButton rotation_non = new JRadioButton("Non");
	private JRadioButton sinusoide_oui = new JRadioButton("Oui");
	private JRadioButton sinusoide_non = new JRadioButton("Non");
	private JColorChooser couleur = new JColorChooser();
	private ColorChooserButton colorChooser = new ColorChooserButton(Color.RED);
	private JComboBox<TirMissile> shootListe;
	private JButton charger = new JButton("Charger");

	public JParam() {
		super();
		init();
		this.add(params);
	}

	private void init() {
		initShootList();
		initParametre();
	}

	private void initParametre() {
		
		rotation_non.setSelected(true);
		rotationGroup.add(rotation_oui);
		rotationGroup.add(rotation_non);
		rotationGroupPanel.add(rotation_oui);
		rotationGroupPanel.add(rotation_non);
		
		sens_horaire.setSelected(true);
		sensGroup.add(sens_horaire);
		sensGroup.add(sens_anti_horaire);
		sensGroupPanel.add(sens_horaire);
		sensGroupPanel.add(sens_anti_horaire);
		
		vitesse_constante.setSelected(true);
		vitesseRotationGroup.add(vitesse_constante);
		vitesseRotationGroup.add(vitesse_progressive);
		vitesseRotationGroupPanel.add(vitesse_constante);
		vitesseRotationGroupPanel.add(vitesse_progressive);

		sinusoide_non.setSelected(true);
		sinusoideGroup.add(sinusoide_oui);
		sinusoideGroup.add(sinusoide_non);
		sinusoideGroupPanel.add(sinusoide_oui);
		sinusoideGroupPanel.add(sinusoide_non);

		params.setLayout(new GridLayout(16, 2));
		params.add(new JLabel("Position x: "));
		params.add(champs_posx);
		params.add(new JLabel("Position y: "));
		params.add(champs_posy);
		params.add(new JLabel("Nombre de balles: "));
		params.add(champs_nb_Balles);
		params.add(new JLabel("vitesse des balles: "));
		params.add(champs_vitesse_Balles);
		params.add(new JLabel("Angle: "));
		params.add(champs_angle);
		params.add(new JLabel("Direction: "));
		params.add(champs_direction);
		params.add(new JLabel("Cadence: "));
		params.add(champs_frequence);
		params.add(new JLabel("Rotation: "));
		params.add(rotationGroupPanel);
		params.add(new JLabel("type rotation: "));
		params.add(vitesseRotationGroupPanel);
		params.add(new JLabel("Sens : "));
		params.add(sensGroupPanel);
		params.add(new JLabel("Min Spin: "));
		params.add(champs_spin_min);
		params.add(new JLabel("Spin: "));
		params.add(champs_spin);
		params.add(new JLabel("Max Spin: "));
		params.add(champs_spin_max);
		params.add(new JLabel("Wave: "));
		params.add(sinusoideGroupPanel);
		params.add(colorChooser);
		params.add(shootListe);
		params.add(new JLabel());
		params.add(charger);
	}

	public void initShootList() {
		TirMissile[] listeMissile = new TirMissile[] { new Tir_rectiligne_one(400, 100, 60), new Tir_rectiligne_two(400, 100, 60), new Tir_rectiligne_three(400, 100, 60),
				new Tir_sin_one(400, 100, 60), new Tir_sin_two(400, 100, 60), new Tir_sin_three(400, 100, 60) , new Tir_etoile_spin_8(400, 200),new Tir_spirale_multi(400, 300, 60)};
				shootListe = new JComboBox<TirMissile>(listeMissile);
	}

	/**
	 * @return the params
	 */
	public JPanel getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(JPanel params) {
		this.params = params;
	}

	/**
	 * @return the champs_posx
	 */
	public JTextField getChamps_posx() {
		return champs_posx;
	}

	/**
	 * @param champs_posx
	 *            the champs_posx to set
	 */
	public void setChamps_posx(JTextField champs_posx) {
		this.champs_posx = champs_posx;
	}

	/**
	 * @return the champs_posy
	 */
	public JTextField getChamps_posy() {
		return champs_posy;
	}

	/**
	 * @param champs_posy
	 *            the champs_posy to set
	 */
	public void setChamps_posy(JTextField champs_posy) {
		this.champs_posy = champs_posy;
	}

	/**
	 * @return the champs_nb_Balles
	 */
	public JTextField getChamps_nb_Balles() {
		return champs_nb_Balles;
	}

	/**
	 * @param champs_nb_Balles
	 *            the champs_nb_Balles to set
	 */
	public void setChamps_nb_Balles(JTextField champs_nb_Balles) {
		this.champs_nb_Balles = champs_nb_Balles;
	}

	/**
	 * @return the champs_angle
	 */
	public JTextField getChamps_angle() {
		return champs_angle;
	}

	/**
	 * @param champs_angle
	 *            the champs_angle to set
	 */
	public void setChamps_angle(JTextField champs_angle) {
		this.champs_angle = champs_angle;
	}

	/**
	 * @return the champs_direction
	 */
	public JTextField getChamps_direction() {
		return champs_direction;
	}

	/**
	 * @param champs_direction
	 *            the champs_direction to set
	 */
	public void setChamps_direction(JTextField champs_direction) {
		this.champs_direction = champs_direction;
	}

	/**
	 * @return the champs_frequence
	 */
	public JTextField getChamps_frequence() {
		return champs_frequence;
	}

	/**
	 * @param champs_frequence
	 *            the champs_frequence to set
	 */
	public void setChamps_frequence(JTextField champs_frequence) {
		this.champs_frequence = champs_frequence;
	}

	/**
	 * @return the rotationGroupPanel
	 */
	public JPanel getRotationGroupPanel() {
		return rotationGroupPanel;
	}

	/**
	 * @param rotationGroupPanel
	 *            the rotationGroupPanel to set
	 */
	public void setRotationGroupPanel(JPanel rotationGroupPanel) {
		this.rotationGroupPanel = rotationGroupPanel;
	}

	/**
	 * @return the rotationGroup
	 */
	public ButtonGroup getRotationGroup() {
		return rotationGroup;
	}

	/**
	 * @param rotationGroup
	 *            the rotationGroup to set
	 */
	public void setRotationGroup(ButtonGroup rotationGroup) {
		this.rotationGroup = rotationGroup;
	}

	/**
	 * @return the sinusoideGroupPanel
	 */
	public JPanel getSinusoideGroupPanel() {
		return sinusoideGroupPanel;
	}

	/**
	 * @param sinusoideGroupPanel
	 *            the sinusoideGroupPanel to set
	 */
	public void setSinusoideGroupPanel(JPanel sinusoideGroupPanel) {
		this.sinusoideGroupPanel = sinusoideGroupPanel;
	}

	/**
	 * @return the sinusoideGroup
	 */
	public ButtonGroup getSinusoideGroup() {
		return sinusoideGroup;
	}

	/**
	 * @param sinusoideGroup
	 *            the sinusoideGroup to set
	 */
	public void setSinusoideGroup(ButtonGroup sinusoideGroup) {
		this.sinusoideGroup = sinusoideGroup;
	}

	/**
	 * @return the champs_spin_min
	 */
	public JTextField getChamps_spin_min() {
		return champs_spin_min;
	}

	/**
	 * @param champs_spin_min
	 *            the champs_spin_min to set
	 */
	public void setChamps_spin_min(JTextField champs_spin_min) {
		this.champs_spin_min = champs_spin_min;
	}

	/**
	 * @return the champs_spin_max
	 */
	public JTextField getChamps_spin_max() {
		return champs_spin_max;
	}

	/**
	 * @param champs_spin_max
	 *            the champs_spin_max to set
	 */
	public void setChamps_spin_max(JTextField champs_spin_max) {
		this.champs_spin_max = champs_spin_max;
	}

	/**
	 * @return the rotation_oui
	 */
	public JRadioButton getRotation_oui() {
		return rotation_oui;
	}

	/**
	 * @param rotation_oui
	 *            the rotation_oui to set
	 */
	public void setRotation_oui(JRadioButton rotation_oui) {
		this.rotation_oui = rotation_oui;
	}

	/**
	 * @return the rotation_non
	 */
	public JRadioButton getRotation_non() {
		return rotation_non;
	}

	/**
	 * @param rotation_non
	 *            the rotation_non to set
	 */
	public void setRotation_non(JRadioButton rotation_non) {
		this.rotation_non = rotation_non;
	}

	/**
	 * @return the sinusoide_oui
	 */
	public JRadioButton getSinusoide_oui() {
		return sinusoide_oui;
	}

	/**
	 * @param sinusoide_oui
	 *            the sinusoide_oui to set
	 */
	public void setSinusoide_oui(JRadioButton sinusoide_oui) {
		this.sinusoide_oui = sinusoide_oui;
	}

	/**
	 * @return the sinusoide_non
	 */
	public JRadioButton getSinusoide_non() {
		return sinusoide_non;
	}

	/**
	 * @param sinusoide_non
	 *            the sinusoide_non to set
	 */
	public void setSinusoide_non(JRadioButton sinusoide_non) {
		this.sinusoide_non = sinusoide_non;
	}

	/**
	 * @return the charger
	 */
	public JButton getCharger() {
		return charger;
	}

	/**
	 * @param charger
	 *            the charger to set
	 */
	public void setCharger(JButton charger) {
		this.charger = charger;
	}

	/**
	 * @return the couleur
	 */
	public JColorChooser getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur
	 *            the couleur to set
	 */
	public void setCouleur(JColorChooser couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the colorChooser
	 */
	public ColorChooserButton getColorChooser() {
		return colorChooser;
	}

	/**
	 * @param colorChooser
	 *            the colorChooser to set
	 */
	public void setColorChooser(ColorChooserButton colorChooser) {
		this.colorChooser = colorChooser;
	}

	/**
	 * @return the shootListe
	 */
	public JComboBox<TirMissile> getShootListe() {
		return shootListe;
	}

	/**
	 * @param shootListe
	 *            the shootListe to set
	 */
	public void setShootListe(JComboBox<TirMissile> shootListe) {
		this.shootListe = shootListe;
	}

	/**
	 * @return the sensGroupPanel
	 */
	public JPanel getSensGroupPanel() {
		return sensGroupPanel;
	}

	/**
	 * @param sensGroupPanel the sensGroupPanel to set
	 */
	public void setSensGroupPanel(JPanel sensGroupPanel) {
		this.sensGroupPanel = sensGroupPanel;
	}

	/**
	 * @return the sensGroup
	 */
	public ButtonGroup getSensGroup() {
		return sensGroup;
	}

	/**
	 * @param sensGroup the sensGroup to set
	 */
	public void setSensGroup(ButtonGroup sensGroup) {
		this.sensGroup = sensGroup;
	}

	/**
	 * @return the sens_horaire
	 */
	public JRadioButton getSens_horaire() {
		return sens_horaire;
	}

	/**
	 * @param sens_horaire the sens_horaire to set
	 */
	public void setSens_horaire(JRadioButton sens_horaire) {
		this.sens_horaire = sens_horaire;
	}

	/**
	 * @return the sens_anti_horaire
	 */
	public JRadioButton getSens_anti_horaire() {
		return sens_anti_horaire;
	}

	/**
	 * @param sens_anti_horaire the sens_anti_horaire to set
	 */
	public void setSens_anti_horaire(JRadioButton sens_anti_horaire) {
		this.sens_anti_horaire = sens_anti_horaire;
	}

	/**
	 * @return the vitesseRotationGroupPanel
	 */
	public JPanel getVitesseRotationGroupPanel() {
		return vitesseRotationGroupPanel;
	}

	/**
	 * @param vitesseRotationGroupPanel the vitesseRotationGroupPanel to set
	 */
	public void setVitesseRotationGroupPanel(JPanel vitesseRotationGroupPanel) {
		this.vitesseRotationGroupPanel = vitesseRotationGroupPanel;
	}

	/**
	 * @return the vitesseRotationGroup
	 */
	public ButtonGroup getVitesseRotationGroup() {
		return vitesseRotationGroup;
	}

	/**
	 * @param vitesseRotationGroup the vitesseRotationGroup to set
	 */
	public void setVitesseRotationGroup(ButtonGroup vitesseRotationGroup) {
		this.vitesseRotationGroup = vitesseRotationGroup;
	}

	/**
	 * @return the vitesse_constante
	 */
	public JRadioButton getVitesse_constante() {
		return vitesse_constante;
	}

	/**
	 * @param vitesse_constante the vitesse_constante to set
	 */
	public void setVitesse_constante(JRadioButton vitesse_constante) {
		this.vitesse_constante = vitesse_constante;
	}

	/**
	 * @return the vitesse_progressive
	 */
	public JRadioButton getVitesse_progressive() {
		return vitesse_progressive;
	}

	/**
	 * @param vitesse_progressive the vitesse_progressive to set
	 */
	public void setVitesse_progressive(JRadioButton vitesse_progressive) {
		this.vitesse_progressive = vitesse_progressive;
	}

	/**
	 * @return the champs_vitesse_Balles
	 */
	public JTextField getChamps_vitesse_Balles() {
		return champs_vitesse_Balles;
	}

	/**
	 * @param champs_vitesse_Balles the champs_vitesse_Balles to set
	 */
	public void setChamps_vitesse_Balles(JTextField champs_vitesse_Balles) {
		this.champs_vitesse_Balles = champs_vitesse_Balles;
	}

	/**
	 * @return the champs_spin
	 */
	public JTextField getChamps_spin() {
		return champs_spin;
	}

	/**
	 * @param champs_spin the champs_spin to set
	 */
	public void setChamps_spin(JTextField champs_spin) {
		this.champs_spin = champs_spin;
	}

}
