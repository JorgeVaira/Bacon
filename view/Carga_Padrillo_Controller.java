/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Padrillo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Ivan Mansilla
 */
public class Carga_Padrillo_Controller implements Initializable {
    @FXML
    private Button cancelar;
    
    @FXML
    private TextField caravana, alimento;
    
    @FXML
    private TextArea observaciones;
    
    @FXML
    private DatePicker fecha_ingreso;
    
    
    @FXML
    private void cargar(ActionEvent event) {
        //con lo que hay adentro del constructor es lo que extraemos de los campos del formulario de carga de Cerdas, si quieren probarlo, yo ya lo hice y funciona
        //hagan System.out.print(caravana.getText());
        //Nota por favor no tocar los archivos FXML, ni los controllers que haya en la carpeta vista
        System.out.println(caravana.getText());
        Padrillo puerco = new Padrillo(Integer.parseInt(caravana.getText()),fecha_ingreso.getValue().toString(),alimento.getText(),observaciones.getText());
        puerco.save_Padrillo();
    }
    @FXML
    private void cancelar(ActionEvent event) {
        try{
            Stage stage = (Stage) cancelar.getScene().getWindow();
            stage.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}