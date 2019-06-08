
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ludanyi.tamas
 */
public class KAPCSOLAT {
    
    public static PreparedStatement preparedStatement = null;
    public static ResultSet rs = null;
    public static String select_alapnyil = ("SELECT distinct cASE WHEN  count(TORZSADAT.e$alapnyil.bejegyzes_dt) = 0\n" +
"THEN 'Aktív'\n" +
"Else 'Nem aktív'\n" +
"END AS SZINKRON\n" +
"FROM  TORZSADAT.e$alapnyil WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
      public static   String select_EUSZOLG_ENGEDELY = ("SELECT distinct cASE WHEN  count(TORZSADAT.e$euszolg_engedely.bejegyzes_dt) = 0\n" +
"THEN 'Aktív'\n" +
"Else 'Nem aktív'\n" +
"END AS valami\n" +
"FROM  TORZSADAT.e$euszolg_engedely WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
      
      public static String select_EUSZOLG = ("SELECT distinct cASE WHEN  count(TORZSADAT.e$euszolg.bejegyzes_dt) = 0\n" +
"THEN 'Aktív'\n" +
"Else 'Nem aktív'\n" +
"END AS SZINKRON\n" +
"FROM  TORZSADAT.e$euszolg WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
      public static String select_EUSZOLG_KOZREMUKODO = ("SELECT distinct cASE WHEN  count(TORZSADAT.e$euszolg_kozremukodo.bejegyzes_dt) = 0\n" +
"THEN 'Aktív'\n" +
"Else 'Nem aktív'\n" +
"END AS SZINKRON\n" +
"FROM  TORZSADAT.e$euszolg_kozremukodo WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
      
              
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws ClassNotFoundException {
         
            
         
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:23830:CORE1", "ludanyitamas", "Skorpio95@");
            
                              preparedStatement = con.prepareStatement(select_alapnyil);
                              rs = preparedStatement.executeQuery(select_alapnyil);
                              while (rs.next()) {
                        System.out.println("Alapnyilvántartás: "+rs.getString(1));
                    }
                              preparedStatement = con.prepareStatement(select_EUSZOLG_ENGEDELY);
                              rs = preparedStatement.executeQuery(select_EUSZOLG_ENGEDELY);
                              while (rs.next()) {
                        System.out.println("EUSZOLG_Engedély: "+rs.getString(1));
                    }
                         
 
                              
                              
                    

            //step5 close the connection object  
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
