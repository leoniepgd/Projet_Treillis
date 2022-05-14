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

    NoeudSimple(double posx, double posy, Vecteur2D force, int identificateur) { //Constructeur 1
        super(identificateur,posx, posy, force);
    }
    NoeudSimple(double posx, double posy, Vecteur2D force) { // Constructeur 2
        super(posx, posy, force);
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

