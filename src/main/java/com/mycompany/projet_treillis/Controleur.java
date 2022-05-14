/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

/**
 *
 * @author yannp
 */
public class Controleur {
    
    private MainPane vue;
    
    private int etat;
    
    public Controleur(MainPane vue){
        this.vue = vue;
        this.changeEtat(30);
    }
    
    public void changeEtat(int nouvelEtat){
        if (nouvelEtat == 30){
            this.vue.getbGrouper().setDisable(true);
            this.vue.getbCouleur().setDisable(true);
            
        }
    }
}
