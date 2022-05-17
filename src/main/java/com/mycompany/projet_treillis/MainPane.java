/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

import com.mycompany.treilli.Barre;
import com.mycompany.treilli.Noeud;
import com.mycompany.treilli.NoeudAppuiDouble;
import com.mycompany.treilli.NoeudAppuiSimple;
import com.mycompany.treilli.NoeudSimple;
import com.mycompany.treilli.Treillis;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


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
    private Button bSave;
    private Button bLoad;
    
    private Button bNoeudSimple;
    private Button bNoeudAppuiSimple;
    private Button bNoeudAppuiDouble;
    private Button bBarre;
    
    private TextField txtFx;
    private TextField txtFy;
    private TextField txtND;
    private TextField txtNA;

    private Label labelx;
    private Label labely;
    private Label labelND;
    private Label labelNA;
    private Label labelIdN;
    
    private DessinCanvas cDessin;
    

    public MainPane(Treillis model){
        this.model = model;
        this.rbSelect = new RadioButton("Select");
        this.rbPoint = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        
        
        VBox vbGauche = new VBox(this.getRbSelect(), this.getRbPoint(), this.getRbSegments());
        this.setLeft(vbGauche);

        this.labelx = new Label ();
        this.labelx.setText("pos x : ");
        this.txtFx = new TextField();
        this.txtFx.setText("0");
        this.txtFx.setMaxWidth(50);
        this.labely = new Label ();
        this.labely.setText("pos y : ");
        this.txtFy = new TextField();
        this.txtFy.setText("0");
        this.txtFy.setMaxWidth(50);
        
        this.labelIdN = new Label ();
        this.labelIdN.setText(String.valueOf(getId())); //Faut-il le convertir ?
             
        this.bNoeudSimple = new Button("Noeud Simple");
        this.bNoeudSimple.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        this.bNoeudAppuiSimple  = new Button("Noeud Appui Simple");;
        this.bNoeudAppuiSimple.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.bNoeudAppuiDouble  = new Button("Noeud Appui Double ");;
        this.bNoeudAppuiDouble.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            
        this.labelND = new Label ();
        this.labelND.setText("Noeud de depart : ");
        this.txtND = new TextField();
        this.txtND.setText("1");
        this.txtND.setMaxWidth(50);
        this.labelNA = new Label ();
        this.labelNA.setText("Noeud d'arrivee :   ");
        this.txtNA = new TextField();
        this.txtNA.setText("2");
        this.txtNA.setMaxWidth(50);
        
        this.bBarre = new Button("Barre");
        
        HBox hbpx = new HBox (this.labelx, this.txtFx);
        HBox hbpy = new HBox (this.labely, this.txtFy);
        HBox hbND = new HBox (this.labelND, this.txtND);
        HBox hbNA = new HBox (this.labelNA, this.txtNA);
        HBox hbButton = new HBox (this.bNoeudSimple,this.bNoeudAppuiSimple ,this.bNoeudAppuiDouble); 
        VBox vbNoeud = new VBox(hbButton, hbpx, hbpy, this.bBarre, hbND, hbNA);
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
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Simple id : %s - x : %s - y : %s\n",nd.getId(), nd.getPosx(),nd.getPosy());
        });
        
        this.bNoeudAppuiSimple.setOnAction(evt -> {
            Noeud nd = new NoeudAppuiSimple (model.maxIdNoeud(model.getlistnoeud()) + 1,Double.parseDouble (this.txtFx.getText()),Double.parseDouble(this.txtFy.getText()));
            model.ajouteNoeud(model.getlistnoeud(),nd );
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Appui Simple id : %s - x : %s - y : %s\n",nd.getId(), nd.getPosx(),nd.getPosy());
        });
        
        this.bNoeudAppuiDouble.setOnAction(evt -> {
            Noeud nd = new NoeudAppuiDouble (model.maxIdNoeud(model.getlistnoeud()) + 1,Double.parseDouble (this.txtFx.getText()),Double.parseDouble(this.txtFy.getText()));
            model.ajouteNoeud(model.getlistnoeud(),nd );
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Appui Double id : %s - x : %s - y : %s\n",nd.getId(), nd.getPosx(),nd.getPosy());
        });
        
        this.bBarre.setOnAction(evt -> {
//            int idNd = Integer.parseInt (this.txtND.getText());
//            Noeud Nd = model.trouveNoeud(idNd);
//           Noeud Nd = new Noeud (Integer.parseInt (this.txtND.getText()), getPosx(), getPosy());
//           Noeud Na = new Noeud (Integer.parseInt (this.txtNA.getText()), getPosx(), getPosy());
//           Barre b = new Barre (Nd, Na, model.maxIdBarre(model.getlistbarre())+1);
//            //Pour dessiner
//            this.cDessin.getChildren().add(b.Barredessine());
//            System.out.printf("Bouton Barre id : %s - x : %s - y : %s\n",b.getId(), b.getNd(),b.getNf());
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
