/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author yannp
 */
public class HBoxExemple extends HBox{
    public HBoxExemple() {
        for(Button b : CompoTestSets.desBoutons()) {
            this.getChildren().add(b);
        }
    }   
}
