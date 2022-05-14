/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

/**
 *
 * @author yannp
 */
public class Barre {
 
    // Attributs
    private int id;
    private Noeud nd;
    private Noeud nf;
    private double tractionmax;
    private double compressionmax;
    private double prix;

    //Constructeur
    Barre(Noeud n1, Noeud n2, int i, double t, double c, double p) {
        this.nd = n1;
        this.nf = n2;
        this.tractionmax = t;
        this.compressionmax = c;
        this.id = i;
        this.prix = p;
    }
    
    Barre (Noeud n1, int i, double t, double c, double p){
        this.nd=n1;
        this.tractionmax = t;
        this.compressionmax = c;
        this.id = i;
        this.prix = p; 
    }
    
   
    // Méthode get et set
    // Méthode toString (renvoie tout en chaÃ®ne de caractÃ¨re)
    @Override //Permet de modifer la mÃ©thode toString dÃ©jÃ  dÃ©fini dans Java
    public String toString() {
        return ("noeud du début" + this.getNd() + "   noeud de fin" + this.getNf() + "   id  " + this.getId());
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

}
