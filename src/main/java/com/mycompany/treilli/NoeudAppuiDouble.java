/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.paint.Color;

/**
 *
 * @author yannp
 */
public class NoeudAppuiDouble extends NoeudAppui {

    NoeudAppuiDouble(double posx, double posy) {
        super(posx, posy);
        this.color = Color.YELLOW;
    }
    
    public NoeudAppuiDouble(int identificateur,double posx, double posy) {
        super(identificateur, posx, posy);
        this.color = Color.YELLOW;
    }

    
    @Override
    public String toString() {
        return ("NoeudAppuiDouble " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }

    @Override
    public int nbrInconnues() {
        return (2);
    }
    
       @Override
    public void save(Writer w) throws IOException {
        w.append("NoeudAppuiDouble;" + this.getId() + ";" + this.getPosx() + ";" + this.getPosy() + "\n");
    }

}