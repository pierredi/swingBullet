package repio.shoot.detail;

import java.awt.*;
import java.util.Iterator;

import repio.principale.utile.Rotation;
import repio.shoot.Bullet;
import repio.shoot.TirMissile;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_4_5 extends TirMissile {
    private int compteur=0;
    private boolean pair=true;
    private int cadence =0;

    public Tir_rectiligne_4_5(int posx, int posy, int direction) {
        this.init(posx,posy,8,4, 60,7, direction, new Rotation(),false,Color.RED);
        ajoutBalles();
    }

    @Override
    public void update(){
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!courant.isAlive()){
                iter.remove();
            }
        }

        if(compteur%getFrequence()==0){
            if(cadence<10){
                ajoutBalles();
            }
            if(cadence>40){
                cadence=0;
            }
            cadence++;
        }
    }

    @Override
    public void ajoutBalles(){
        double angleBase = 0.0d;
        if(isPair()){
            setNbBalles(8);
        }else{
            setNbBalles(9);
        }

        if(getNbBalles()>1){
            angleBase = getAngle() / (getNbBalles()-1);
        }

        for (int cpt = 0; cpt<getNbBalles(); cpt++){
            Bullet proj = new Bullet();
            proj.init(getPosX(),getPosY(),2.2,
                    getDirection() - getAngle()/2 + cpt * angleBase);
            getBalles().add(proj);
        }
        setPair(!isPair());
    }

    public boolean isPair() {
        return pair;
    }

    public void setPair(boolean pair) {
        this.pair = pair;
    }

}
