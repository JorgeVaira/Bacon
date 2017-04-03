package controller;
import java.sql.*;
import javafx.collections.ObservableList;
import model.*;

public class Cerda {

     public static void llenar_informacion( ObservableList<Cerda> lista){
     /*   DB_Connection DB_con=DB_Connection.getInstance();
        Connection con=DB_con.getConnection();
        String sql="SELECT * FROM cerda";
        DB_Query q=new DB_Query();
        ResultSet rs=q.query(con, sql);
        try{
            try {
             if(rs!=null){   
            ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
             

        //Creando las filas para el JTable
           rs.first();
          
           while(!rs.isAfterLast()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                    System.out.println(fila[i]);
                   lista.add(new Cerda(Integer.parseInt(rs.getString("caravana")),Integer.parseInt(rs.getString("nro_grupo")),rs.getString("fecha_inicio"),rs.getString("alimento_tipo"),rs.getString("observaciones")));
            }
                lista.add(new Cerda(Integer.parseInt((String) fila[0]),Integer.parseInt((String) fila[1]),(String) fila[3],(String) fila[4],(String) fila[5]));
           }
                
                 
                rs.next();
            
             }
            } catch (Exception ex) {
    
            System.out.println("Nose pudo crear la tabla en utilidad: "+ex.getMessage());
            
            }
        
        rs.first();
        rs.first();
            while(rs.next()){*/
               // lista.add(new Cerda(Integer.parseInt(rs.getString("caravana")),Integer.parseInt(rs.getString("nro_grupo")),rs.getString("fecha_inicio"),rs.getString("alimento_tipo"),rs.getString("observaciones")));
     /*       }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }*/
    }

    private int caravan_num;
    private int group_num;
    private String start_date;
    //private Date end_date;
    private String food_type;
    private String observation;
    private Connection connection;
    
    public void setCaravan_num(String num_caravan) {
        this.caravan_num = caravan_num;
    }

    public void setGroup_num(String group) {
        this.group_num = group_num;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setFood_type(String food) {
        this.food_type = food;
    }

    public void setObservations(String observations) {
        this.observation = observations;
    }
    /*public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }*/

    /*public Date getEnd_date() {
        return end_date;
    }*/

    public int getCaravan_num() {
        return caravan_num;
    }

    public int getGroup_num() {
        return group_num;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getFood_type() {
        return food_type;
    }

    public String getObservations() {
        return observation;
    }
    
    public Cerda(int caravan_num, int group_num, String start_date, String food, String observations) {
        this.caravan_num = caravan_num;
        this.group_num = group_num;
        this.start_date = start_date;
        this.food_type = food;
        this.observation = observations;
        
        
    }
    public void save_Cerda(){
        Connection connection = null;
        PreparedStatement stmt;
        try{
            DB_Connection bd = DB_Connection.getInstance();
            connection = bd.getConnection();
            //nuevos cambios!! para poder cargar y funciona!!! pd: ivan te rompi todo el codigo :)
            stmt = connection.prepareStatement("INSERT INTO cerda (caravana,fecha_inicio,nro_grupo,observaciones,alimento_tipo) VALUES (?,?,?,?,?)");
            stmt.setInt(1,caravan_num);
            stmt.setString(2,start_date);
            stmt.setInt(3,group_num);
            stmt.setString(4,observation);
            stmt.setString(5,food_type);
            DB_Insert.insert(connection,stmt);
            
	} catch(Exception sql_exce){
            sql_exce.printStackTrace();
	}
    }
}
