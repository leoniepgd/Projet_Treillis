/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author francois
 */
public class Point extends FigureSimple {

    public static final double TAILLE_POINT = 5;

    private double px;
    private double py;

    public double getPx() {
        return this.px;
    }

    public void setPx(double x) {
        this.px = x;
    }

    public Point(double abs, double ord, Color c) {
        super(c);
        this.px = abs;
        this.py = ord;
    }

    public Point(double px, double py) {
        this(px, py, Color.BLACK);
    }

    @Override
    public String toString() {
        return "(" + this.px + "," + this.py + " couleur : "
                + this.getCouleur() + ")";
    }

    @Override
    public double maxX() {
        return this.px;
    }

    public static void main(String[] args) {
        Point p1;
        Point p2;

        p1 = new Point(3, 2, new Color(0.1, 0.4, 1, 1));
        p2 = p1;
        p2.px = 4;
        System.out.println("p1 = " + p1);
        System.out.println("p1 = " + p1.toString());
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    @Override
    public Group dessine() {
        Ellipse res = new Ellipse(this.px, this.py, TAILLE_POINT, TAILLE_POINT);
        res.setStroke(this.getCouleur());
        res.setFill(this.getCouleur());
        Group g = new Group(res);
        return g;
    }

}
