/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author yannp
 */
public class DessinCanvas1 extends Canvas {  // cette classe peut être suprimmé
    public DessinCanvas1(double w, double h){
        super(w,h);  // les variables w et h servent à definir la taille du canvas
        GraphicsContext context = this.getGraphicsContext2D();
        context.setFill(Color.RED);
        context.fillRect(0,0, this.getWidth(), this.getHeight());
    }
    
}
