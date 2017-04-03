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
import javafx.scene.control.ChoiceBox;
/**
 *
 * @author Ivan Mansilla
 */
public class Carga_Padrillo {
    
    private Stage stage;
    private Scene scene;
    private Pane pane;
    private static final int j = 1980;
    
    /*@FXML
    private ChoiceBox nro_caravana;
    
    @FXML
        public void initialize(){
            nro_caravana = new ChoiceBox();
        ObservableList<String> caravanas =FXCollections.observableArrayList();
 	String[] cadena = new String[37];
 		String subc = "";
			for(int i = 0; i < cadena.length; i++){
			cadena[i] = subc + (j+i);
			caravanas.add(cadena[i]);
			//cadena[i] = subc + (j+i);
			}
        nro_caravana.setItems(caravanas);
        
    }*/
   public Carga_Padrillo() throws Exception {
        pane = FXMLLoader.load(getClass().getResource("carga_padrillo.fxml"));
        
        //////////////////////////
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
   }
}