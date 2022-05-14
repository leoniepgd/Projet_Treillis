/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author francois
 */
public class Segment extends FigureSimple {

    private Point debut;
    private Point fin;

    public Segment(Point debut, Point fin, Color c) {
        super(c);
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public double maxX() {
        return Math.max(this.debut.maxX(), this.fin.maxX());
    }

    public String toString() {
        return "[" + this.debut.toString() + " ; " + this.fin + "]";
    }

    public Segment(Point debut, Point fin) {
        this(debut, fin, Color.BLUE);
    }

    public static void main(String[] args) {
        Segment s = new Segment(new Point(1, 2), new Point(3, 4),
                Color.ALICEBLUE);
        System.out.println("s = " + s);

    }

    /**
     * @return the debut
     */
    public Point getDebut() {
        return debut;
    }

    /**
     * @return the fin
     */
    public Point getFin() {
        return fin;
    }

    @Override
    public Group dessine() {
        Line res = new Line(this.getDebut().getPx(), this.getDebut().getPy(),
                this.getFin().getPx(), this.getFin().getPy());
        res.setStroke(this.getCouleur());
        res.setFill(this.getCouleur());
        Group g = new Group(res);
        return g;
    }

}
