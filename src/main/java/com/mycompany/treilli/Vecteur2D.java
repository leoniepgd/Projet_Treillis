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
public class Vecteur2D implements Serializable   {

    // Attributs
    private double vx;
    private double vy;

    // Constructeur
    Vecteur2D(double x, double y) {
        this.vx = x;
        this.vy = y;
    }

    @Override
    public String toString() {
        return ("Vx= " + this.getVx() + " Vy= " + this.getVy());
    }

    /**
     * @return the vx
     */
    public double getVx() {
        return vx;
    }

    /**
     * @param vx the vx to set
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * @return the vy
     */
    public double getVy() {
        return vy;
    }

    /**
     * @param vy the vy to set
     */
    public void setVy(double vy) {
        this.vy = vy;
    }
}
