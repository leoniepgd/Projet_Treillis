/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import static com.mycompany.treilli.Treillis.maxIdBarre;
import static com.mycompany.treilli.Treillis.maxIdNoeud;

import java.io.Serializable;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Line;

/**
 *
 * @author yannp
 */
public class Barre implements Serializable  {
 
    // Attributs
    private int id;
    private Noeud nd;
    private Noeud nf;
    private double tractionmax;
    private double compressionmax;
    private double prix;
    protected int color;

    //Constructeur
    Barre(Noeud n1, Noeud n2, int i, double t, double c, double p) {
        this.nd = n1;
        this.nf = n2;
        this.tractionmax = t;
        this.compressionmax = c;
        this.id = i;
        this.prix = p;
        this.color = 2;
    }
    
    Barre (Noeud n1, int i, double t, double c, double p){
        this.nd=n1;
        this.tractionmax = t;
        this.compressionmax = c;
        this.id = i;
        this.prix = p; 
        this.color = 2;
    }
    
    public Barre (Noeud n1, Noeud n2, int i){
        this.nd = n1;
        this.nf = n2;
        this.id = i;
    }
    
   
    private Color getColor (int code) {
    	switch (code) {
    	case 0 : return Color.BLACK;
    			
    	case 1 : return Color.YELLOW;

    	case 2 : return Color.BLUE;
    			
    	case 3 : return Color.GREEN;
    
    	case 4 : return Color.RED;
        
    	}
    	
    	return Color.BLACK;
    }
    // Méthode get et set
    // Méthode toString (renvoie tout en chaîne de caractère)
    @Override //Permet de modifer la méthode toString déjà  défini dans Java
    public String toString() {
        return ("noeud du début" + this.getNd() + "   noeud de fin" + this.getNf() + "   id  " + this.getId());
    }

    //@Override
    public Group Barredessine() {
    	System.out.printf("Dessin de la Barre id : %s - (x : %s - y : %s) - (x : %s - y : %s)\n",getId(), this.getNd().getPosx(),this.getNd().getPosy(),this.getNf().getPosx(), this.getNf().getPosy());
        Line barre = new Line(this.getNd().getPosx(), this.getNd().getPosy(), this.getNf().getPosx(), this.getNf().getPosy());
        barre.setStroke(getColor(2));
        barre.setFill(getColor(2));
        Label nameB = new Label("B"+this.id+"");
        nameB.setTextFill(getColor(4));
        nameB.setLayoutX((this.getNd().getPosx()+this.getNf().getPosx())/2 +10 );
        nameB.setLayoutY((this.getNd().getPosy()+this.getNf().getPosy())/2 );
        Group gb = new Group(barre, nameB);
        return gb;
    }
    

    public void ajouteBarre(List<Barre> t, Barre b){
    if (t.contains(b)){  //Permet de vérifier si b existe dans la liste 
       System.out.println("Erreur la barre est déjà présente"); 
    }
    else{
       int max=maxIdBarre(t)+1;
       Barre nouvellebarre= new Barre (b.getNd(), b.getNf(), max);
       t.add(nouvellebarre);   
    }
}
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nd
     */
    public Noeud getNd() {
        return nd;
    }

    /**
     * @param nd the nd to set
     */
    public void setNd(Noeud nd) {
        this.nd = nd;
    }

    /**
     * @return the nf
     */
    public Noeud getNf() {
        return nf;
    }

    /**
     * @param nf the nf to set
     */
    public void setNf(Noeud nf) {
        this.nf = nf;
    }

    /**
     * @return the tractionmax
     */
    public double getTractionmax() {
        return tractionmax;
    }

    /**
     * @param tractionmax the tractionmax to set
     */
    public void setTractionmax(double tractionmax) {
        this.tractionmax = tractionmax;
    }

    /**
     * @return the compressionmax
     */
    public double getCompressionmax() {
        return compressionmax;
    }

    /**
     * @param compressionmax the compressionmax to set
     */
    public void setCompressionmax(double compressionmax) {
        this.compressionmax = compressionmax;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    private Object geNd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
