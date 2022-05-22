/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;


import static java.lang.Math.acos;
import static java.lang.Math.sqrt;


/**
 *
 * @author yannp
 */
public class Test {

    public static void main(String[] args) {
        Noeud n1 = entreeNoeud();
        System.out.println(n1 + " " + n1.nbrInconnues() + " inconnues");
    }

    public static Noeud entreeNoeud() {
        Vecteur2D v;
        int id = -1;
        double x, y;
        Noeud n;
        double px, py;
        String type;
        System.out.println("Indiquer le type de noeud (NS=Noeud Simple, NAD=Noeud Appui Double, NAS=Noeud Appui Simple");
        type = Lire.S();
        if ("NS".equals(type)) {
            System.out.println("Entrer la compsoante en x de la force");
            x = Lire.d();
            System.out.println("Entrer la composante en y de la force");
            y = Lire.d();
            v = new Vecteur2D(x, y);
            System.out.println("Entrer la position en x du noeud");
            px = Lire.d();
            System.out.println("Entrer la position en y du noeud");
            py = Lire.d();
            n = new NoeudSimple(px, py, v);
            return (n);

        } else if ("NAS".equals(type)) {
            System.out.println("Entrer la position en x du noeud");
            px = Lire.d();
            System.out.println("Entrer la position en y du noeud");
            py = Lire.d();
            n = new NoeudAppuiSimple(px, py);
            return (n);
        } else if ("NAD".equals(type)) {
            System.out.println("Entrer la position en x du noeud");
            px = Lire.d();
            System.out.println("Entrer la position en y du noeud");
            py = Lire.d();
            n = new NoeudAppuiDouble(px, py);
            return (n);
        } else {
            n = new NoeudAppuiSimple(0, 0);
            return (n);
        }
    }

    public static Noeud noeudOppose(Barre b, Noeud n1) {
        if (n1.getId() == b.getNd().getId()) {
            Noeud n2 = b.getNf();
            return (n2);
        } else {
            Noeud n2 = b.getNd();
            return (n2);
        }

    }

    public static double angle(Barre b, Noeud n1) {
        double x, y;
        Noeud n2 = noeudOppose(b, n1);
        if (n1.getPosx() < n2.getPosx()) {
            x = n2.getPosx() - n1.getPosx();
            if (n1.getPosy() < n2.getPosy()) {
                y = n2.getPosy() - n1.getPosy();
            } else {
                y = n1.getPosy() - n2.getPosy();
            }
        } else {
            x = n1.getPosx() - n2.getPosx();
            if (n1.getPosy() < n2.getPosy()) {
                y = n2.getPosy() - n1.getPosy();
            } else {
                y = n1.getPosy() - n2.getPosy();
            }
        }
        Vecteur2D v = new Vecteur2D(x, y);
        Vecteur2D ox = new Vecteur2D(0, 1);
        double a = acos((v.getVx() * ox.getVx() + v.getVy() * ox.getVy()) / (sqrt(v.getVx() * v.getVx() + v.getVy() * v.getVy()) * sqrt(ox.getVx() * ox.getVx() + ox.getVy() * ox.getVy())));
        return (a);
    }
}

