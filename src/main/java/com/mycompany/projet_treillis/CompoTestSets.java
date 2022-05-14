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
    int l = 150;
    Button jb1 = new Button("Noeud simple");
    jb1.setPrefWidth(l);
    res.add(jb1);
    Button jb2 = new Button("Noeud appui simple");
    jb2.setPrefWidth(l);
    res.add(jb2);
    Button jb3 = new Button("Noeud appui double");
    jb3.setPrefWidth(l);
    res.add(jb3);
    Button jb4 = new Button("Barre");
    jb4.setPrefWidth(l);
    res.add(jb4);
    Button jb5 = new Button("Selectionner");
    jb5.setPrefWidth(l);
    res.add(jb5);
    return res;
    }
}