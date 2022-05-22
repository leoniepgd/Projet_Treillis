package com.mycompany.projet_treillis;

import com.mycompany.treilli.Barre;
import static com.mycompany.treilli.Lire.b;
import com.mycompany.treilli.Noeud;
import com.mycompany.treilli.Treillis;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX Main
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        primaryStage.setTitle("TREILLIS");  
        List<Noeud> n = new ArrayList<Noeud>();
        List<Barre> b = new ArrayList<Barre>() ;
        Treillis model = new Treillis(n, b);
        MainPane mp = new MainPane(model); 
        Scene scene = new Scene(mp,800,600); // Soit FlowPaneExemple ou HBoxExemple ou BorderPaneExemple ou MainPane

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}