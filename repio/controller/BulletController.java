package repio.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import repio.panel.JGraph;
import repio.panel.JParam;
import repio.principale.GUIHelper;
import repio.shoot.TirMissile;
import repio.shoot.Tir_Canon;

public class BulletController {
	
	private JFrame win;
	private TirMissile tir;
	private JParam param;	
	private JGraph jg;
	private JPanel screen;
	
	public BulletController(){				 
    	init();    			
	}
	
	private void init(){
		screen = new JPanel(new BorderLayout());
		//screen.setPreferredSize(new Dimension(1024, 600) );
		param = new JParam();
		param.getCharger().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chargerMissile();
			}
		});
		
		param.getShootListe().addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				chargementShootFromListe(e);
			}
		});	
		tir = (TirMissile) param.getShootListe().getSelectedItem();
		affichageTir();		
    	jg = new JGraph(10, tir);		
		jg.setBackground(Color.white);
        jg.setPreferredSize(new Dimension(800,600));  
        afficher();
        GUIHelper.showOnFrame(screen,"Bullet Generator", win);
	}
	
	private void afficher(){		
		screen.removeAll();
		screen.add(getParam(),BorderLayout.WEST);
		screen.add(getJg(),BorderLayout.EAST);
		screen.revalidate();
		screen.repaint();				
	}
	
	private void chargementShootFromListe(ItemEvent e){		
		tir = (TirMissile)e.getItem();
		affichageTir();        
        jg = new JGraph(10,tir);
        afficher();        
	}
	
	private void affichageTir(){
		/* Traitement des données du formulaire */
		param.getChamps_posx().setText(""+tir.getPosX());
		param.getChamps_posy().setText(""+tir.getPosY());
		param.getChamps_nb_Balles().setText(""+tir.getNbBalles());
		param.getChamps_vitesse_Balles().setText(""+tir.getSpeed());
		param.getChamps_angle().setText(""+tir.getAngle());
		param.getChamps_frequence().setText(""+tir.getFrequence());
		param.getChamps_direction().setText(""+tir.getDirection());		
		param.getRotation_oui().setSelected(tir.getRotation().isRotation());
		param.getRotation_non().setSelected(!tir.getRotation().isRotation());
		param.getVitesse_constante().setSelected(!tir.getRotation().isAcceleration());
		param.getVitesse_progressive().setSelected(tir.getRotation().isAcceleration());
		param.getSens_horaire().setSelected(tir.getRotation().isSensHoraire());
		param.getSens_anti_horaire().setSelected(!tir.getRotation().isSensHoraire());
        param.getChamps_spin_min().setText(""+tir.getRotation().getMinSpin());
        param.getChamps_spin().setText(""+tir.getRotation().getSpin());
        param.getChamps_spin_max().setText(""+tir.getRotation().getMaxSpin());
        param.getSinusoide_oui().setSelected(tir.isWave());
        param.getSinusoide_non().setSelected(!tir.isWave());
        param.getColorChooser().setSelectedColor(tir.getColorShoot());
		param.getBalles_compteur().setText(""+tir.getBalles().size());
	}
	
	private void chargerMissile(){		
		/* Traitement des données du formulaire */
		String positionX = param.getChamps_posx().getText();
		String positionY = param.getChamps_posy().getText();
		String  nbBallesTxt = param.getChamps_nb_Balles().getText();
		String  vitesseBallesTxt = param.getChamps_vitesse_Balles().getText();
		String angleTxt = param.getChamps_angle().getText();
		String  frequenceTxt = param.getChamps_frequence().getText();
		String directionTxt = param.getChamps_direction().getText();		
		boolean rotation = param.getRotation_oui().isSelected();
		boolean vitesse_Constante = param.getVitesse_constante().isSelected();
		boolean sens = param.getSens_horaire().isSelected();
        String  minSpinTxt = param.getChamps_spin_min().getText();
        String  spinTxt = param.getChamps_spin().getText();
        String  maxSpinTxt = param.getChamps_spin_max().getText();
        boolean wave = param.getSinusoide_oui().isSelected();
        Color couleurSelect = param.getColorChooser().getSelectedColor(); 
        
        int posX = Integer.valueOf(positionX);
        int posY = Integer.valueOf(positionY);
        double angle = Double.valueOf(angleTxt);
        int nbBalles= Integer.valueOf(nbBallesTxt);
        int speed = Integer.valueOf(vitesseBallesTxt);
        int frequence= Integer.valueOf(frequenceTxt);
        double direction= Double.valueOf(directionTxt);
        double minSpin= Double.valueOf(minSpinTxt);
        double spin= Double.valueOf(spinTxt);
        double maxSpin= Double.valueOf(maxSpinTxt);        
		
		//creation         
        tir = new Tir_Canon(posX, posY, nbBalles,speed, angle, frequence, direction, rotation,vitesse_Constante,sens, minSpin, spin, maxSpin, wave, couleurSelect);
        
		//affichage
        jg = new JGraph(10,tir);
        afficher();
	}

	/**
	 * @return the tir
	 */
	public TirMissile getTir() {
		return tir;
	}

	/**
	 * @param tir the tir to set
	 */
	public void setTir(TirMissile tir) {
		this.tir = tir;
	}

	/**
	 * @return the param
	 */
	public JParam getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(JParam param) {
		this.param = param;
	}

	/**
	 * @return the jg
	 */
	public JGraph getJg() {
		return jg;
	}

	/**
	 * @param jg the jg to set
	 */
	public void setJg(JGraph jg) {
		this.jg = jg;
	}

	/**
	 * @return the win
	 */
	public JFrame getWin() {
		return win;
	}

	/**
	 * @param win the win to set
	 */
	public void setWin(JFrame win) {
		this.win = win;
	}

	/**
	 * @return the screen
	 */
	public JPanel getScreen() {
		return screen;
	}

	/**
	 * @param screen the screen to set
	 */
	public void setScreen(JPanel screen) {
		this.screen = screen;
	}
	

}
