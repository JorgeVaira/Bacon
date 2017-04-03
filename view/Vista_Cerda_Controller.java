/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.Cerda;
import model.DB_Connection;
import model.DB_Query;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.stage.*;
import controller.Cerda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
/**
 *
 * @author Jorge Vaira
 */
public class Vista_Cerda_Controller  implements Initializable {
  // @FXML private TableView<Cerda> tabla ;
   @FXML private TableView tabla ;
   // @FXML private final TableView tabla = new TableView();
    //@FXML private TableView tabla;
    //Columnas de la Tabla//
   @FXML private TableColumn<Cerda, String>  c1;
   @FXML private TableColumn<Cerda, String>  c2;
    @FXML private TableColumn<Cerda, String>  c3;
    @FXML private TableColumn<Cerda, String>  c4;
    @FXML private TableColumn<Cerda, String>  c5;
    @FXML private TableColumn<Cerda, String>  c6;
   

   //private ObservableList<Cerda> data;
       //private ObservableList<Cerda> data2= FXCollections.observableArrayList();
     //  @FXML private ObservableList data;
    @FXML
    
    
    
  //  private ObservableList<ObservableList> data;
      //private ObservableList<Cerda> data;
    private ObservableList data;
   // private TableView tableview;
private ObservableList<ObservableList> data2;



    public void load_data() throws SQLException{

        DB_Connection DB_con=DB_Connection.getInstance();
        Connection c=DB_con.getConnection();
        String sql="SELECT caravana as 'Caravana', fecha_inicio as 'Fecha de Inicio',fecha_fin as 'Fecha de Fin', nro_grupo as 'Nro Grupo', observaciones as 'Observaciones', alimento_tipo as 'Tipo Alimento' FROM cerda";
        DB_Query q=new DB_Query();
        ResultSet rs=q.query(c, sql);
       try {
           rs.first();
       } catch (SQLException ex) {
           Logger.getLogger(Vista_Cerda_Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
        
          data = FXCollections.observableArrayList();
          try{
         
                        /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
          for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });
            tabla.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] "+rs.getMetaData());
           }

            /********************************
             * Data added to ObservableList *
             ********************************/
            rs.first();
            
            while(rs.next()){
                //Iterate Row
                
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
                

            }

            //FINALLY ADDED TO TableView
            tabla.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }


    
    /*
    
    public void load_data() throws SQLException{
       
        
       
        buildData();
       /*  System.out.println(1111);
      // data= ObservableList();        
        DB_Connection DB_con=DB_Connection.getInstance();
        Connection con=DB_con.getConnection();
        String sql="SELECT * FROM cerda";
        DB_Query q=new DB_Query();
        ResultSet rs=q.query(con, sql);
        rs.first();
         System.out.println(22);
         
        //tabla.setItems(data);
        
        
        
        
        
        
        
             
           /*
           
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });
            tabla.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] "+rs.getMetaData());
*/
       // }     
   /* ResultSetMetaData rsMd = rs.getMetaData();
              int cantidadColumnas = rsMd.getColumnCount();
        rs.first();
       
            while (rs.next()) {
                  Object[] fila = new Object[cantidadColumnas];

                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                  fila[i]=rs.getObject(i+1);
                    row.add(rs.getString(i));
                    System.out.println(row);
                }

             //  data.add(row);
//data.addAll(row);
 Cerda c =new Cerda(Integer.parseInt((String) fila[0]),Integer.parseInt((String) fila[1]),(String) fila[3],(String) fila[4],(String) fila[5]);
 data.add(c);  
tabla.setItems(data);

            }
           // tabla.setItems(data);//
//tabla.setItems(data);
//tabla.setItems(data);
           System.out.println(111);
       /*    try{
            try {
             if(rs!=null){   
            ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
             
 System.out.println(33);
        //Creando las filas para el JTable
           rs.first();
          
           while(!rs.isAfterLast()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                    System.out.println(fila[i]);
                    //data2.add(new Cerda(11,11,"11","11","22")); //.add(fila[i]);
                    // lista.add(new Cerda(Integer.parseInt(rs.getString("caravana")),Integer.parseInt(rs.getString("nro_grupo")),rs.getString("fecha_inicio"),rs.getString("alimento_tipo"),rs.getString("observaciones")));
            
                }
           //     data.add(new Cerda(Integer.parseInt((String) fila[0]),Integer.parseInt((String) fila[1]),(String) fila[3],(String) fila[4],(String) fila[5]));
         // nombre2.setCellValueFactory(new PropertyValueFactory((String) fila[1]));
  
//tabla.getItems().setAll(new Cerda(Integer.parseInt((String) fila[0]),Integer.parseInt((String) fila[1]),(String) fila[3],(String) fila[4],(String) fila[5]));
//nombre2.setCellValueFactory((Callback) new Cerda(Integer.parseInt(rs.getString("caravana")),Integer.parseInt(rs.getString("nro_grupo")),rs.getString("fecha_inicio"),rs.getString("alimento_tipo"),rs.getString("observaciones")));
   Cerda c =new Cerda(Integer.parseInt((String) fila[0]),Integer.parseInt((String) fila[1]),(String) fila[3],(String) fila[4],(String) fila[5]);
   tabla.getItems().set(1, c);

           }
      
                rs.next();
            
             }
            } catch (Exception ex) {
    
            System.out.println("Nose pudo crear la tabla en utilidad: "+ex.getMessage());
            
            }

            // tabla.setItems(data2);
             //tabla
         System.out.println("1"+tabla);
     
       // tabla.setItems(data);
        rs.first();
        rs.first();
            while(rs.next()){
               // lista.add(new Cerda(Integer.parseInt(rs.getString("caravana")),Integer.parseInt(rs.getString("nro_grupo")),rs.getString("fecha_inicio"),rs.getString("alimento_tipo"),rs.getString("observaciones")));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
        
        
        try{
       
         data = FXCollections.observableArrayList();*/
         //Cerda.llenar_informacion(data);
      //   System.out.println("Pase el llenar info()");
        // tabla.setItems(data);
        // System.out.println("Pasé la carga a la tabla");
         
         //Enlazar columnas con atributos
        // c1.setCellValueFactory(new PropertyValueFactory<>("caravan_num"));
    // c1.setCellValueFactory(new PropertyValueFactory<>("caravana"));
         /*for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;               
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                   
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                            
                        return new SimpleStringProperty(param.getValue().get(j).toString());                       
                    }                   
                });
                
                tabla.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

         
         while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
               data.add(row);
                System.out.println("Me pasé el data.add");

            }
        
          tabla.setItems(data);
          System.out.println("Holis. Pasé la tabla jaja");*/
         /* }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            try {
                load_data();
            } catch (SQLException ex) {
                Logger.getLogger(Vista_Cerda_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }     
}
