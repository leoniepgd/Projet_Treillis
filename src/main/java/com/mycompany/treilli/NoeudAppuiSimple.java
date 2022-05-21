/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import javafx.scene.paint.Color;

/**
 *
 * @author yannp
 */
public class NoeudAppuiSimple extends NoeudAppui implements Serializable  {

	
    NoeudAppuiSimple(double posx, double posy) {
        super(posx, posy);
        this.color = 2; 
    }
    
    public NoeudAppuiSimple(int identificateur,double posx, double posy) {
        super(identificateur, posx, posy);
        this.color = 2;
    }

    @Override
    public String toString() {
        return ("NoeudAppuiSimple " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }

    @Override
    public int nbrInconnues() {
        return (1);
    }
    
       @Override
    public void save(Writer w) throws IOException {
        w.append("NoeudAppuiSimple;" + this.getId() + ";" + this.getPosx() + ";" + this.getPosy() + "\n");
    }

}
