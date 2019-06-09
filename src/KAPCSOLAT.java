
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

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
    public static String[] array_table = {"e$alapnyil", "e$euszolg_engedely", "e$euszolg", "e$euszolg_kozremukodo", "e$euszolg_szemely",
        "e$euszolg_telephely", "e$muknyil", "e$szemely", "e$szemely_bizalmas", "e$diploma", "e$szakkepzes", "e$fiok_gyogyszertar", "e$intezeti_gyogyszertar",
        "e$intezeti_lakossagi_egyseg", "e$kozforgalmu_gyogyszertar", "e$kezi_gyogyszertar"};
    public static String szoveg;
    public static JOptionPane popup = new JOptionPane();

    @SuppressWarnings("empty-statement")

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:23830:CORE1", "ludanyitamas", "Skorpio95@");
            int index = 0;
            for (String Variables : array_table) {
                String select_QUERY = ("SELECT distinct cASE WHEN  count(TORZSADAT." + Variables + ".bejegyzes_dt) = 0\n"
                        + "THEN 'Aktív'\n"
                        + "Else 'Nem aktív'\n"
                        + "END AS SZINKRON\n"
                        + "FROM  TORZSADAT." + Variables + " WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
                preparedStatement = con.prepareStatement(select_QUERY);
                rs = preparedStatement.executeQuery(select_QUERY);
                index++;
                while (rs.next()) {
                    switch (index) {
                        case 1:
                            szoveg = "Alapnyilvántartás tábla: " + rs.getString(1) + "\n";
                            break;
                        case 2:
                            szoveg += "Euszolg_Engedely tábla: " + rs.getString(1) + "\n";
                            break;
                        case 3:
                            szoveg += "Euszolg tábla: " + rs.getString(1) + "\n";
                            break;
                        case 4:
                            szoveg += "Euszolg_kozremukodo tábla: " + rs.getString(1) + "\n";
                            break;
                        case 5:
                            szoveg += "Euszolg_szemely tábla: " + rs.getString(1) + "\n";
                            break;
                        case 6:
                            szoveg += "Euszolg_telephely tábla: " + rs.getString(1) + "\n";
                            break;
                        case 7:
                            szoveg += "Muknyil tábla: " + rs.getString(1) + "\n";
                            break;
                        case 8:
                            szoveg += "Szemely tábla: " + rs.getString(1) + "\n";
                            break;
                        case 9:
                            szoveg += "Szemely_bizalmas tábla: " + rs.getString(1) + "\n";
                            break;
                        case 10:
                            szoveg += "Diploma tábla: " + rs.getString(1) + "\n";
                            break;
                        case 11:
                            szoveg += "Szakkepzes tábla: " + rs.getString(1) + "\n";
                            break;
                        case 12:
                            szoveg += "Fiok_gyogyszertar tábla: " + rs.getString(1) + "\n";
                            break;
                        case 13:
                            szoveg += "Intezeti_gyogyszertar tábla: " + rs.getString(1) + "\n";
                            break;
                        case 14:
                            szoveg += "Intezeti_lakossagi_egyseg tábla: " + rs.getString(1) + "\n";
                            break;
                        case 15:
                            szoveg += "Kozforgalmu_gyogyszertar tábla: " + rs.getString(1) + "\n";
                            break;
                        case 16:
                            szoveg += "Kezi_gyogyszertar tábla: " + rs.getString(1) + "\n";
                            break;
                        default: 
                            szoveg += "Nincs vizsgálat" + "\n";
                            break;
                    }

                }
            }
           
            JOptionPane.showMessageDialog(popup, szoveg);
            //step5 close the connection object  
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
