/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author yannp
 */
public abstract class Noeud {
    
    // Attibuts
    private int id;
    private double posx;
    private double posy;
    private Vecteur2D force;
    private List<Barre> barresDepart;
    private List<Barre> barresArrivee;
    
    private static final double TAILLE_NOEUD = 10;

    
    protected Color color;
    // Constructeur 1
    Noeud(int n, double x, double y, Vecteur2D f) {
        this.id = n;
        this.posx = x;
        this.posy = y;
        this.force = f;
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.color = Color.BLACK;

    }

    // Constructeur 2
    Noeud(double x, double y, Vecteur2D f) {
        this.id = -1;
        this.posx = x;
        this.posy = y;
        this.force = f;
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.color = Color.BLACK;
    }

    // Constructeur 3
    Noeud(double x, double y) {
        this.id = -1;
        this.posx = x;
        this.posy = y;
        this.force = new Vecteur2D(0, 0);
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.color = Color.BLACK;
    }

    // Constructeur 4
    Noeud(int n, double x, double y) {
        this.id = n;
        this.posx = x;
        this.posy = y;
        this.force = new Vecteur2D(0, 0);
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.color = Color.BLACK;
    }

    
    // get et set
    @Override
    public String toString() {
        return ("posx= " + this.getPosx() + " posy= " + this.getPosy() + " force= " + this.getForce() + " id= " + this.getId());
    }

    public abstract int nbrInconnues();

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

    /**POINT
     * @return the posx
     */
    public double getPosx() {
        return posx;
    }

    /**
     * @param posx the posx to set
     */
    public void setPosx(double posx) {
        this.posx = posx;
    }

    /**
     * @return the posy
     */
    public double getPosy() {
        return posy;
    }

    /**
     * @param posy the posy to set
     */
    public void setPosy(double posy) {
        this.posy = posy;
    }

    /**
     * @return the force
     */
    public Vecteur2D getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(Vecteur2D force) {
        this.force = force;
    }

    /**
     * @return the barresDepart
     */
    public List<Barre> getBarresDepart() {
        return barresDepart;
    }

    /**
     * @param barresDepart the barresDepart to set
     */
    public void setBarresDepart(List<Barre> barresDepart) {
        this.barresDepart = barresDepart;
    }

    /**
     * @return the barresArrivee
     */
    public List<Barre> getBarresArrivee() {
        return barresArrivee;
    }

    /**
     * @param barresArrivee the barresArrivee to set
     */
    public void setBarresArrivee(List<Barre> barresArrivee) {
        this.barresArrivee = barresArrivee;
    }
 
    
    public Group dessine() {
        Ellipse res = new Ellipse(this.posx, this.posy, TAILLE_NOEUD, TAILLE_NOEUD);
        res.setStroke(this.color);
        res.setFill(this.color);
        Label name = new Label(this.id+"");
        name.setLayoutX(this.posx);
        name.setLayoutY(this.posy + 10);
        Group g = new Group(res,name);
        return g;
    }

    public List<Barre> barreincidentes(Noeud n){
        List<Barre> b1= n.getBarresDepart();
        List<Barre> b2=n.getBarresArrivee();
        b1.addAll(b2);
        return b1;
        
    }
}
