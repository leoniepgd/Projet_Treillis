/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import com.mycompany.treilli.Noeud;
import com.mycompany.treilli.NoeudSimple;
import com.mycompany.treilli.Treillis;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author yannp
 */
public class MainPane extends BorderPane{
    
    //private Groupe model;
    
    private Treillis model;
    
    private RadioButton rbSelect;
    private RadioButton rbPoint;
    private RadioButton rbSegments;
    
    private Button bGrouper;
    private Button bCouleur;
    private Button bNoeudSimple;
    private Button bNoeudAppuiSimple;
    private Button bNoeudAppuiDouble;
    
    private TextField txtFx;
    private TextField txtFy;

    private Label labelx;
    private Label labely;
    
	private DessinCanvas cDessin;

	
	
    public MainPane(Treillis model){
        this.rbSelect = new RadioButton("Select");
        this.rbPoint = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        
        
        VBox vbGauche = new VBox(this.getRbSelect(), this.getRbPoint(), this.getRbSegments());
        this.setLeft(vbGauche);

        this.labelx = new Label ();
        this.labelx.setText("pos x : ");
        this.txtFx = new TextField();
        this.txtFx.setText("0");
        this.labely = new Label ();
        this.labely.setText("pos x : ");
        this.txtFy = new TextField();
        this.txtFy.setText("0");
       
                
        this.bNoeudSimple = new Button("Noeud Simple");
        this.bNoeudAppuiSimple  = new Button("Noeud Appui Simple");;
        this.bNoeudAppuiDouble  = new Button("Noeud Appui Double ");;
            
        
        HBox hbButton = new HBox (this.bNoeudSimple,this.bNoeudAppuiSimple ,this.bNoeudAppuiDouble); 
        VBox vbNoeud = new VBox(this.labelx,this.txtFx, this.labely,this.txtFy, hbButton );
               this.setBottom(vbNoeud);

   

        this.bGrouper = new Button("Grouper");
   
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Bouton grouper cliqué");
            }
        });
        this.bCouleur = new Button("Couleur");
        this.bCouleur.setOnAction((t) -> {  //Raccourci du "setOnAction" just au-dessus
            System.out.println("bouton couleur clique");
        });
        this.bCouleur.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent t) {
                System.out.println("entered couleur en : " + t.getX() + " , " + t.getY());
            }
            
        });
        VBox vbDroit = new VBox(this.getbGrouper(), this.getbCouleur());
        this.setRight(vbDroit);

        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);

        
        this.bNoeudSimple.setOnAction(evt -> {
            
        	Noeud nd = new NoeudSimple (Double.parseDouble (this.txtFx.getText()),Double.parseDouble(this.txtFy.getText()),model.maxIdNoeud(model.getlistnoeud()) + 1);
        	
        	model.ajouteNoeud(model.getlistnoeud(),nd );
        
            System.out.printf("Bouton Noeux Simple id : %s - x : %s - y : %s\n",nd.getId(), nd.getPosx(),nd.getPosy());
        
    });
            

    }

    /**
     * @return the rbSelect
     */
    public RadioButton getRbSelect() {
        return rbSelect;
    }

    /**
     * @return the rbPoint
     */
    public RadioButton getRbPoint() {
        return rbPoint;
    }

    /**
     * @return the rbSegments
     */
    public RadioButton getRbSegments() {
        return rbSegments;
    }

    /**
     * @return the bGrouper
     */
    public Button getbGrouper() {
        return bGrouper;
    }

    /**
     * @return the bCouleur
     */
    public Button getbCouleur() {
        return bCouleur;
    }

    /**
     * @return the cDessin
     */
    public DessinCanvas getcDessin() {
        return cDessin;
    }

    /**
     * @return the model
     */
    public Treillis getModel() {
        return model;
    }
    
}
