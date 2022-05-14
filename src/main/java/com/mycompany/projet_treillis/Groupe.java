/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * test github
 * @author francois
 */
public class Groupe extends Figure {

    private List<Figure> contient;

    public Groupe(List<Figure> contient) {
        this.contient = contient;
    }

    public Groupe() {
        this.contient = new ArrayList<Figure>();
    }

    @Override
    public double maxX() {
        if (this.getContient().size() == 0) {
            return 0;
        } else {
            double max = this.getContient().get(0).maxX();
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    public static Groupe groupeAlea(int nbrPoint, int nbrSegment) {
        Groupe res = new Groupe();
        for (int i = 0; i < nbrPoint; i++) {
            res.addFigure(new Point(Math.random() * 400-50, Math.random() * 300-50,
                    new Color(Math.random(), Math.random(), Math.random(), 1)));
        }
        for (int i = 0; i < nbrSegment; i++) {
            res.addFigure(new Segment(new Point(Math.random() * 400-50, Math.random() * 300-50),
                    new Point(Math.random() * 400-50, Math.random() * 300-50),
                    new Color(Math.random(), Math.random(), Math.random(), 1)));
        }
        return res;
    }

    public void addFigure(Figure f) {
        if (f.getContenuDans() != null) {
            throw new Error("figure déjà dans groupe");
        }
        this.getContient().add(f);
        f.setContenuDans(this);
    }

       @Override
    public Group dessine() {
        
        Group g = new Group();
        for(int i = 0 ; i < this.getContient().size() ; i ++) {
            g.getChildren().add(this.getContient().get(i).dessine());
        }
        return g;
    }

    /**
     * @return the contient
     */
    public List<Figure> getContient() {
        return contient;
    }
}
