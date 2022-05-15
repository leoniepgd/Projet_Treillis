/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import com.mycompany.treilli.Treillis;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author yannp
 */
public class DessinCanvas extends Pane{
    
    public Canvas realCanvas;
    private MainPane main;
    
    public DessinCanvas(MainPane main) {
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
        System.out.println("w = " +this.realCanvas.getWidth()+ " ;h = " + this.realCanvas.getHeight());
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
    }
    
    public void redrawAll() {
        System.out.println("redraw");
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setFill(Color.RED);  // Pour faire apparaitre le canvas en rouge
        context.fillRect(0,0, this.realCanvas.getWidth(), this.realCanvas.getHeight());  // pour obtenir la taille en temps réel du canvas
        Treillis model = this.main.getModel();
    }
}
