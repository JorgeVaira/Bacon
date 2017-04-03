package controller;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class Alimento {
     private String tipe;
    private double food_stock;
    private String used_food;
    private String recipe;
    private Connection connection;

    public Alimento(String tipe, double food_stock, String recipe) {
        this.tipe = tipe;
        this.food_stock = food_stock;
       // this.used_food = used_food;
        this.recipe = recipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setFood_stock(double food_stock) {
        this.food_stock = food_stock;
    }

    public void setUsed_food(String used_food) {
        this.used_food = used_food;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getTipe() {
        return tipe;
    }

    public double getFood_stock() {
        return food_stock;
    }

    public String getUsed_food() {
        return used_food;
    }

    public String getRecipe() {
        return recipe;
    }
    
    
public void save_Alimento(){
    
    System.out.println("Save Alimento");
        Connection connection = null;
        PreparedStatement stmt;
        try{
            DB_Connection bd = DB_Connection.getInstance();
            connection = bd.getConnection();
            //nuevos cambios!! para poder cargar y funciona!!! pd: ivan te rompi todo el codigo :)
        //    stmt = connection.prepareStatement("INSERT INTO alimento (tipo,cantidad_disponible,receta) VALUES (?,?,?);");
           /* stmt.setString(1,(getTipe()));
            stmt.setDouble(2,(getFood_stock()));
           // stmt.setString(3,(getUsed_food()));
            stmt.setString(3,(getRecipe()));

             
           // System.out.println(">>>>>"+stmt);*/
           stmt = connection.prepareStatement("INSERT INTO alimento (tipo,cantidad_disponible,receta) VALUES ('"+tipe+"','"+food_stock+"','"+recipe+"');");    
           System.out.println(">>>>>"+stmt); 
           DB_Insert.insert(connection,stmt);
            
            
           
	} catch(Exception sql_exce){
            sql_exce.printStackTrace();
	}
    }      
    
}
