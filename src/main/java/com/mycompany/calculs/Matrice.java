/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculs;

import com.mycompany.treilli.Lire;

/**
 *
 * @author Elève
 */
public class Matrice {
    //atributs
    int nbrLig;
    int nbrCol;
    double[][] coeffs;
    //Constructeur
   
    Matrice(int nl, int nc){

        this.nbrLig=nl;
        this.nbrCol=nc;
        this.coeffs= new double[nl][nc];
        for (int i=0; i<nl; i++){
            for (int j =0; j<nc; j++){
                System.out.println("donnez les coeffs");
                coeffs[i][j]= Lire.d();
            }

        }
    }
    public static void main(String[] args){
//        int i,j;
//        int nc, nl;
//        Matrice m;
//        System.out.println("donnez le nombre de ligne");
//        nl = Lire.i();
//        System.out.println("donnez le nombre de colonne");
//        nc = Lire.i();
//        m = new Matrice(nl,nc);
//        for (i=0; i<nl; i++){
//            for (j =0; j<nc; j++){
//                System.out.print("   "+m.coeffs[i][j]);
//            }
//            System.out.println();
//        }

    }
}