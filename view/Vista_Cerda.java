/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;

import javafx.stage.*;
import javafx.scene.layout.Pane;
import javafx.fxml.*;
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Jorge Vaira
 */

public class Vista_Cerda {
     private Stage stage;
    private Scene scene;
    private Pane pane;
    private static final int j = 1980;
    
    public Vista_Cerda() throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("vista_cerda.fxml")); 
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Vista_Cerda_Controller vcc=new Vista_Cerda_Controller();
        vcc.load_data();
    }
}
