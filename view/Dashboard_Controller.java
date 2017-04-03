/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Ivan Mansilla
 */
public class Dashboard_Controller implements Initializable {
    
    @FXML
    private void carga_cerda(ActionEvent event) {
        try{
            Carga_Cerda cc = new Carga_Cerda();
        }catch(Exception e){
        
        }
    }  
    @FXML
    private void carga_padrillo(ActionEvent event) {
        try{
            Carga_Padrillo cc = new Carga_Padrillo();
        }catch(Exception e){
        
        }
    }  
    @FXML
    private void carga_alimento(ActionEvent event) {
        try{
            Carga_Alimento ca = new Carga_Alimento();
        }catch(Exception e){
        
        }
    }
    @FXML
    private void ver_cerda(ActionEvent event){
        try {
            Vista_Cerda vc=new Vista_Cerda();
        } catch (Exception ex) {
           
        }
    }
    @FXML
    private void ver_padrillo(ActionEvent event){
        try{
            Vista_Padrillo vp=new Vista_Padrillo();
        }
        catch(Exception e){
        
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
