/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

/**
 *
 * @author yannp
 */
public class NoeudSimple extends Noeud {

	public NoeudSimple(double posx, double posy, Vecteur2D force, int identificateur) { //Constructeur 1
        super(identificateur,posx, posy, force);
    }
    public NoeudSimple(double posx, double posy, Vecteur2D force) { // Constructeur 2
        super(posx, posy, force);
    }

    public NoeudSimple(double posx, double posy ) { // Constructeur 3
        super(posx, posy);
    }


    public NoeudSimple(double posx, double posy , int identificateur) { // Constructeur 3
        super(identificateur,posx, posy);
    }

    
    @Override
    public String toString() {
        return ("NoeudSimple " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }

    @Override
    public int nbrInconnues() {
        return (0);
    }
}

