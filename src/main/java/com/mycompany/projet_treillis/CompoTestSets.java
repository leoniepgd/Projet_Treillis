/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author yannp
 */
public class CompoTestSets {
        public static List<Button> desBoutons() {
    List<Button> res = new ArrayList<>();
    Button jb1 = new Button("Valider");
    res.add(jb1);
    Button jb2 = new Button("Un Bouton avec un Grand Nom");
    res.add(jb2);
    Button jb3 = new Button("B");
    res.add(jb3);
    int ph = 50;
    Button jb4 = new Button("pref H = " + ph);
    jb4.setPrefHeight(ph);
    res.add(jb4);
    int pw = 100;
    Button jb5 = new Button("pref W = " + pw);
    jb4.setPrefWidth(pw);
    res.add(jb5);
    return res;
    }
    
}
