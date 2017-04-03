package controller;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class Padrillo {

    private int caravan_num;
    private String start_date;
    private String end_date;
    private String food_type;
    private String observation;
    private Connection connection;
    
    public void setCaravan_num(int num_caravan) {
        this.caravan_num = caravan_num;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setFood_tipe(String food_type) {
        this.food_type = food_type;
    }

    public void setObservations(String observations) {
        this.observation = observations;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getCaravan_num() {
        return caravan_num;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getFood_tipe() {
        return food_type;
    }

    public String getObservations() {
        return observation;
    }
    
    public Padrillo(int caravan_num, String start_date, String food, String observations) {
        this.caravan_num = caravan_num;
        this.start_date = start_date;
        this.food_type = food;
        this.observation = observations;
        
        
    }
    public void save_Padrillo(){
        
        Connection connection = null;
        PreparedStatement stmt;
        try{
            DB_Connection bd = DB_Connection.getInstance();
            connection = bd.getConnection();
            //nuevos cambios!! para poder cargar y funciona!!! pd: ivan te rompi todo el codigo :)
            
            stmt = connection.prepareStatement("INSERT INTO padrillo (caravana,fecha_inicio,fecha_fin,observaciones,alimento_tipo) VALUES (?,?,?,?,?);");
            stmt.setInt(1,caravan_num);
            stmt.setString(2,start_date);
            stmt.setString(3,end_date);
            stmt.setString(4,observation);
            stmt.setString(5,food_type);
            System.out.println(">>>>>"+stmt); 
            DB_Insert.insert(connection,stmt);
            
	} catch(Exception sql_exce){
            sql_exce.printStackTrace();
	}
    }
}
