package model;

import java. sql.*;

public class DB_Create_Table{
            
    public DB_Create_Table (){
    }
    
    public static void create(Connection connection){ 
        Statement stmt = null;       
        String sql = "CREATE TABLE IF NOT EXISTS alimento " +
                       "(tipo VARCHAR(100) NOT NULL, " +
                       " cantidad_disponible DOUBLE NOT NULL, " + 
                       " cantidad_usada DOUBLE, " + 
                       " receta LONGTEXT NOT NULL, " + 
                       " PRIMARY KEY ( tipo ))";
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("hola");
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
        sql = "CREATE TABLE IF NOT EXISTS cerda " +
                "(caravana INT NOT NULL, " +
                " fecha_inicio DATE NOT NULL, " + 
                //" fecha_fin DATE NOT NULL, " + 
                " nro_grupo TINYINT NOT NULL, " + 
                " observaciones LONGTEXT , " + 
                " alimento_tipo VARCHAR(100) NOT NULL, " + 
                " INDEX `fk_cerda_alimento_idx` (`alimento_tipo` ASC), " +
                " PRIMARY KEY ( caravana ), " +
                " CONSTRAINT `fk_cerda_alimento` " +
                " FOREIGN KEY (`alimento_tipo`) " +
                " REFERENCES `mydb`.`alimento` (`tipo`) " +
                " ON DELETE NO ACTION " +
                " ON UPDATE NO ACTION)";
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
        sql = "CREATE TABLE IF NOT EXISTS padrillo " +
                "(caravana INT NOT NULL, " +
                " fecha_inicio DATE NOT NULL, " + 
                " fecha_fin DATE NOT NULL, " + 
                " observaciones LONGTEXT , " + 
                " alimento_tipo VARCHAR(100) NOT NULL, " + 
                " INDEX `fk_cerda_alimento_idx` (`alimento_tipo` ASC), " +
                " PRIMARY KEY ( caravana ), " +
                " CONSTRAINT `fk_padrillo_alimento` " +
                " FOREIGN KEY (`alimento_tipo`) " +
                " REFERENCES `mydb`.`alimento` (`tipo`) " +
                " ON DELETE NO ACTION " +
                " ON UPDATE NO ACTION)";
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
    }
}