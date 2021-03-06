package com.ipartek.formacion.inigo.modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Clase que permite conectar con la base de datos
 * @author inigo
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "inigo";
   static String login = "root";
   static String password = "";
  static String url = "jdbc:mysql://localhost/"+bd;
  
  private final static Logger log = Logger.getLogger(DbConnection.class);
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
         }
         
      }catch(SQLException e){
    	  log.error("Excepcion SQL al conectarse a base de datos "
					+ e.getMessage());
      }catch(ClassNotFoundException e){
    	  log.error("Excepcion SQL al conectarse a base de datos "
					+ e.getMessage());
      }catch(Exception e){
    	  log.error("Excepcion SQL al conectarse a base de datos "
					+ e.getMessage());
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}