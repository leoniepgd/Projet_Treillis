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
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author yannp
 */
public class MainPane extends BorderPane {

    /**
     * @return the bSauvegarder
     */


    //private Groupe model;
    private Treillis model;
    
    private Button bGrouper;
    private Button bSelectionner;
    private Button bSauvegarder;
    private Button bOuvrir;
    private Button bSupprimerNoeud;
    private Button bSupprimerBarre;
    private Button bForce ;
    private Button bNoeudSimple;
    private Button bNoeudAppuiSimple;
    private Button bNoeudAppuiDouble;
    private Button bBarre;
    
    private TextField txtFx;
    private TextField txtFy;
    private TextField txtND;
    private TextField txtNA;
    private TextField txtIDN;
    private TextField txtIDB;
    
    private Label labelx;
    private Label labely;
    private Label labelND;
    private Label labelNA;
    private Label labelIDN;
    private Label labelIDB;
    
    private DessinCanvas cDessin;
    
    public Noeud trouveNoeud(int idNd) {
        boolean o = false;
        Noeud NoeudReturn;
        for (int i = 0; i < model.getlistnoeud().size(); i++) {
            NoeudReturn = model.getlistnoeud().get(i);
            int id1 = model.getlistnoeud().get(i).getId();
            if (idNd == id1) {
                o = true;
                
                return model.getlistnoeud().get(i);                
            }
        }
        
        return null;
    }    
    
        public Barre trouveBarre(int idB) {
        boolean o = false;
        Barre BarreReturn;
        for (int i = 0; i < model.getlistbarre().size(); i++) {
            BarreReturn = model.getlistbarre().get(i);
            int id1 = model.getlistbarre().get(i).getId();
            if (idB == id1) {
                o = true;
                
                return model.getlistbarre().get(i);                
            }
        }
        
        return null;
    } 
    
    
    public MainPane(Treillis model) {
        this.model = model;;
        int taille = 100;
        
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Bouton grouper cliqué");
            }
        });
      
        FileChooser fileChooser = new FileChooser();
        this.bSauvegarder = new Button("Sauvegarder");
//        this.bSauvegarder.setOnAction((t) -> {
//            Stage stage = new Stage(); stage.setScene(new Scene(new Group(new Text(100,100, "Fenêtre de sauvegarde")))); 
//            //stage.show();
//            fileChooser.setTitle("Save");
//            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*", ".txt"));
//            File selectedFile = fileChooser.showSaveDialog(stage);
//
//            //File nom = new File("save.txt");
////            try {
////                this.model.sauvegarde(nom);  //Faire apparaître la fenêtre
////            } catch (IOException ex) {
////                Alert a = new Alert(Alert.AlertType.ERROR);
////                a.setHeaderText("Probleme : " + ex.getLocalizedMessage());
////            }
//            
//        });
        
        this.bSauvegarder.setPrefWidth(taille);
        this.bOuvrir = new Button("Ouvrir");        
        this.bOuvrir.setPrefWidth(taille);
        this.bSelectionner = new Button("Sélectionner");
        this.bSelectionner.setPrefWidth(taille);
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setPrefWidth(taille);
        this.bForce = new Button("Force");
        this.bForce.setPrefWidth(taille);
        
        HBox hbHaut = new HBox();
        hbHaut.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        this.setTop(hbHaut);
        
        VBox vbDroit = new VBox(this.bSauvegarder, this.bOuvrir);
        vbDroit.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        this.setRight(vbDroit);
        
        VBox vbGauche = new VBox(this.bSelectionner, this.bGrouper);
        vbGauche.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        this.setLeft(vbGauche);
        
        
        this.bSupprimerNoeud = new Button("Supprimer Noeud");
        this.bSupprimerNoeud.setPrefWidth(taille+30);
        this.bSupprimerBarre = new Button("Supprimer Barre");
        this.bSupprimerBarre.setPrefWidth(taille+30);
        
        this.labelIDN = new Label();
        this.labelIDN.setText(" Id Noeud : ");
        this.txtIDN = new TextField();
        this.txtIDN.setText("1");
        this.txtIDN.setMaxWidth(50);
        this.labelIDB = new Label();
        this.labelIDB.setText(" Id Barre : ");
        this.txtIDB = new TextField();
        this.txtIDB.setText("1");
        this.txtIDB.setMaxWidth(50);
        
        this.labelx = new Label();
        this.labelx.setText(" Pos x : ");
        this.txtFx = new TextField();
        this.txtFx.setText("0");
        this.txtFx.setMaxWidth(50);
        this.labely = new Label();
        this.labely.setText(" Pos y : ");
        this.txtFy = new TextField();
        this.txtFy.setText("0");
        this.txtFy.setMaxWidth(50);
        
        this.bNoeudSimple = new Button("Noeud Simple");
        this.bNoeudSimple.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        this.bNoeudAppuiSimple = new Button("Noeud Appui Simple");;
        this.bNoeudAppuiSimple.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.bNoeudAppuiDouble = new Button("Noeud Appui Double ");;
        this.bNoeudAppuiDouble.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        
        this.labelND = new Label();
        this.labelND.setText(" Noeud de départ : ");
        this.txtND = new TextField();
        this.txtND.setText("1");
        this.txtND.setMaxWidth(50);
        this.labelNA = new Label();
        this.labelNA.setText(" Noeud d'arrivée :   ");
        this.txtNA = new TextField();
        this.txtNA.setText("2");
        this.txtNA.setMaxWidth(50);
        
        this.bBarre = new Button("Barre");
        this.bBarre.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        this.bBarre.setPrefWidth(taille);
        
        HBox hbsn = new HBox(this.labelIDN, this.txtIDN);
        VBox vbsn = new VBox(this.bSupprimerNoeud, hbsn);
        vbsn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        HBox hbsb = new HBox(this.labelIDB, this.txtIDB);
        VBox vbsb = new VBox(this.bSupprimerBarre, hbsb);
        vbsb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        HBox hbpx = new HBox(this.labelx, this.txtFx);
        HBox hbpy = new HBox(this.labely, this.txtFy);
        HBox hbND = new HBox(this.labelND, this.txtND);
        HBox hbNA = new HBox(this.labelNA, this.txtNA);
        HBox hbButton = new HBox(this.bNoeudSimple, this.bNoeudAppuiSimple, this.bNoeudAppuiDouble);
        VBox vbcc = new VBox(hbButton, hbpx, hbpy);
        vbcc.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        VBox vbBarre = new VBox(this.bBarre, hbND, hbNA);
        vbBarre.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        HBox hbNoeud = new HBox(vbcc, vbBarre, vbsn, vbsb, this.bForce);
        hbNoeud.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        this.setBottom(hbNoeud);
        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);
        
        
        this.bNoeudSimple.setOnAction(evt -> {
            Noeud nd = new NoeudSimple(Double.parseDouble(this.txtFx.getText()), Double.parseDouble(this.txtFy.getText()), model.maxIdNoeud(model.getlistnoeud()) + 1);
            model.ajouteNoeud(model.getlistnoeud(), nd);
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Simple id : %s - x : %s - y : %s\n", nd.getId(), nd.getPosx(), nd.getPosy());
        });
        
        this.bNoeudAppuiSimple.setOnAction(evt -> {
            Noeud nd = new NoeudAppuiSimple(model.maxIdNoeud(model.getlistnoeud()) + 1, Double.parseDouble(this.txtFx.getText()), Double.parseDouble(this.txtFy.getText()));
            model.ajouteNoeud(model.getlistnoeud(), nd);
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Appui Simple id : %s - x : %s - y : %s\n", nd.getId(), nd.getPosx(), nd.getPosy());
        });
        
        this.bNoeudAppuiDouble.setOnAction(evt -> {
            Noeud nd = new NoeudAppuiDouble(model.maxIdNoeud(model.getlistnoeud()) + 1, Double.parseDouble(this.txtFx.getText()), Double.parseDouble(this.txtFy.getText()));
            model.ajouteNoeud(model.getlistnoeud(), nd);
            // Pour dessiner
            this.cDessin.getChildren().add(nd.dessine());
            System.out.printf("Bouton Noeud Appui Double id : %s - x : %s - y : %s\n", nd.getId(), nd.getPosx(), nd.getPosy());
        });
        
        this.bBarre.setOnAction(evt -> {
            int idNd = Integer.parseInt(this.txtND.getText());
            Noeud Nd = trouveNoeud(idNd);
            
            int idNf = Integer.parseInt(this.txtNA.getText());
            Noeud Nf = trouveNoeud(idNf);
            if (Nd != null && Nf != null) {
                Barre b = new Barre(Nd, Nf, model.maxIdBarre(model.getlistbarre()) + 1);
                model.ajouteBarre(model.getlistbarre(),b);
                //Pour dessiner
                this.cDessin.getChildren().add(b.Barredessine());
                System.out.printf("Bouton Barre id : %s - x : %s - y : %s\n", b.getId(), b.getNd(), b.getNf());
                
            } else {                
                if (Nd == null) {
                    this.txtND.setText("");
                }
                if (Nf == null) {
                    this.txtNA.setText("");
                }
            }
        });
        
        
        this.bSupprimerNoeud.setOnAction(evt -> {
            int IDNoeud = Integer.parseInt(this.txtIDN.getText());
            //Noeud NoeudSupp = trouveNoeud(IDNoeud);
            model.getlistnoeud().remove(IDNoeud-1);
            this.cDessin.redrawAll();
        });
        
        this.bSupprimerBarre.setOnAction(evt -> {
            int IDBarre = Integer.parseInt(this.txtIDB.getText());
            //Barre BarreSupp = trouveBarre(IDBarre);
            model.getlistbarre().remove(IDBarre-1);
            this.cDessin.redrawAll();
        });
        
    }


    public DessinCanvas getcDessin() {
        return cDessin;
    }

    public Treillis getModel() {
        return model;
    }
    
    
}//Fin 
