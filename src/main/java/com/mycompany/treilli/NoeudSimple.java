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
public class NoeudSimple extends Noeud {

    public NoeudSimple(double posx, double posy, Vecteur2D force, int identificateur) { //Constructeur 1
        super(identificateur, posx, posy, force);
        this.color = Color.GREEN;
    }

    public NoeudSimple(double posx, double posy, Vecteur2D force) { // Constructeur 2
        super(posx, posy, force);
        this.color = Color.GREEN;
    }

    public NoeudSimple(double posx, double posy) { // Constructeur 3
        super(posx, posy);
        this.color = Color.GREEN;
    }

    public NoeudSimple(double posx, double posy, int identificateur) { // Constructeur 3
        super(identificateur, posx, posy);
        this.color = Color.GREEN;
    }

    @Override
    public String toString() {
        return ("NoeudSimple " + getId() + " : x =" + this.getPosx() + " y = " + this.getPosy());
    }

    @Override
    public int nbrInconnues() {
        return (0);
    }

    @Override
    public void save(Writer w) throws IOException {
        w.append("NoeudSimple;" + this.getId() + ";" + this.getPosx() + ";" + this.getPosy() + "\n");
    }

}
