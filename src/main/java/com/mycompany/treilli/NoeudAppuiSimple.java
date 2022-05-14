/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

/**
 *
 * @author yannp
 */
public class NoeudAppuiSimple extends NoeudAppui {

    NoeudAppuiSimple(double posx, double posy) {
        super(posx, posy);
    }

    @Override
    public String toString() {
        return ("NoeudAppuiSimple " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }

    @Override
    public int nbrInconnues() {
        return (1);
    }
}
