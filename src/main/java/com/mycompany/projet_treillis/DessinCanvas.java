/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import com.mycompany.treilli.Treillis;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

/**
 *
 * @author yannp
 */
public class DessinCanvas extends Pane {

//    public Canvas realCanvas;
    private MainPane main;

    public DessinCanvas(MainPane main) {
        this.main = main;
        this.redrawAll();
    }

    public void redrawAll() {
        System.out.println("redraw");
        this.getChildren().clear();
        Treillis model = this.main.getModel();
        for (int i = 0; i < model.getListnoeud().size(); i++) {
            Group rep = model.getListnoeud().get(i).dessine();
            this.getChildren().add(rep);
        }
        for (int i = 0; i < model.getListbarre().size(); i++) {
            Group rep = model.getListbarre().get(i).Barredessine();
            this.getChildren().add(rep);
        }
    }
}
