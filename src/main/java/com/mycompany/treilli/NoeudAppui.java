/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.Serializable;

/**
 *
 * @author yannp
 */
public abstract class NoeudAppui extends Noeud implements Serializable {

    NoeudAppui(double posx, double posy) {
        super(posx, posy);
    }
    
    NoeudAppui(int identificateur, double posx, double posy) {
        super(identificateur, posx, posy);
    }

    @Override
    public String toString() {
        return ("NoeudAppui " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }
}
