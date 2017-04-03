
package view;

import controller.Alimento;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Ivan Mansilla
 */
public class Carga_Alimento_Controller implements Initializable {
    
    @FXML private Button cancelar;
    
    @FXML
    private TextField tipe, stock;
    
    @FXML
    private TextArea recipe;
    
    @FXML
    private void cancelar(ActionEvent event) {
        try{
            Stage stage = (Stage) cancelar.getScene().getWindow();
            stage.close();
        }catch(Exception e){
            System.out.print(e);
        }
        
    } 
    @FXML
      private void cargar(ActionEvent event) throws SQLException {
          
         System.out.println("cargar alimento");
        //con lo que hay adentro del constructor es lo que extraemos de los campos del formulario de carga de Cerdas, si quieren probarlo, yo ya lo hice y funciona
        //hagan System.out.print(caravana.getText());
        //Nota por favor no tocar los archivos FXML, ni los controllers que haya en la carpeta vista
        //System.out.println(caravana.getText());
        //Alimentos(String tipe, String food_stock, String used_food, String recipe)
       Alimento alimento;
        //alimento = new Alimento(tipe.getText(),Integer.parseInt(stock.getText()),recipe.getText());
        alimento = new Alimento(tipe.getText(),Integer.parseInt(stock.getText()),recipe.getText());
        alimento.save_Alimento();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
//