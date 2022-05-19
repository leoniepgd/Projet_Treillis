/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_treillis;

/**
 *
 * @author Elève
 */

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;


public class DirectoryChooserDemo extends Application {
private Button CSauvegarder;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        final DirectoryChooser directoryChooser = new DirectoryChooser();
        configuringDirectoryChooser(directoryChooser);

        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);

        this.CSauvegarder = new Button("Sauvegarder Chooser");

        this.getCSauvegarder().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                File dir = directoryChooser.showDialog(primaryStage);
                if (dir != null) {
                    textArea.setText(dir.getAbsolutePath());
                } else {
                    textArea.setText(null);
                }
            }
        });

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);

        root.getChildren().addAll(textArea, this.getCSauvegarder());

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX DirectoryChooser (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configuringDirectoryChooser(DirectoryChooser directoryChooser) {
        // Set title for DirectoryChooser
        directoryChooser.setTitle("Select Some Directories");

        // Set Initial Directory
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * @return the CSauvegarder
     */
    public Button getCSauvegarder() {
        return CSauvegarder;
    }

}