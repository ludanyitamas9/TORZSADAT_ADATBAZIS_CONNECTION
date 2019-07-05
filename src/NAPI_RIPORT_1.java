
import com.sun.prism.j2d.J2DPipeline;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ludanyi.tamas
 */
public class NAPI_RIPORT_1 extends javax.swing.JFrame {
//------------------------------------------------------------------------------------------------------------ variables

    public static PreparedStatement preparedStatement = null;
    public static ResultSet rs = null;
    public static String[] array_tables = {"alapnyil", "euszolg_engedely", "euszolg", "euszolg_kozremukodo", "euszolg_szemely",
        "euszolg_telephely", "muknyil", "szemely", "szemely_bizalmas", "diploma", "szakkepzes"};//, "fiok_gyogyszertar", "intezeti_gyogyszertar",
        //"intezeti_lakossagi_egyseg", "kozforgalmu_gyogyszertar", "kezi_gyogyszertar"};
    public static String szoveg;
    public static JOptionPane popup = new JOptionPane();
    public static String[] array_ESTI_query = {"NAPIRIPORT_0_NAPLO", "NAPIRIPORT_1_RECEPTEK", "NAPIRIPORT_2_FORGALMAZOK", "NAPIRIPORT_3_ESZIG_SIKERES", "NAPIRIPORT_4_ESZIG_SIKERTELEN", "NAPIRIPORT_5_ALLAMPOLGARI", "NAPIRIPORT_6_PATIKAK"};
    public static String naplo = "";
    public static String recept1 = "";
    public static String recept2 = "";
    public static String forgalmazok = "";
    public static String eszig_sikeres = "";
    public static String eszig_sikertelen = "";
    public static String allampolgari_belepes = "";
    public static String fuzott_Patikak = "";
    public String password = "";
    public String userName = "";
    public String port = "";
    AUTHENTIKACIO aut;
//  -------------------------------------------------------------------- GET/SET METHOD

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public NAPI_RIPORT_1() {
        initComponents();
        centreWindow(this);

    }

    @SuppressWarnings("unchecked")

    //  ------------------------------------------------------------ FUNCTIONS
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NAPI_RIPORTOK 1.0.1.2");
        setBackground(new java.awt.Color(0, 102, 255));
        setResizable(false);

        jButton1.setText("RUN QUERY");
        jButton1.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\ludanyi.tamas\\Documents\\NetBeansProjects\\TORZSADAT_ADATBAZIS_CONNECTION\\dropbox-carousellogo-dribbble2.gif")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EXIT ON CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(214, 214, 214)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String CHAR_CHANGE(String input_SZOVEG) {
        if (input_SZOVEG.length() == 4) {
            input_SZOVEG = input_SZOVEG.substring(0, 1) + "." + input_SZOVEG.substring(1, 4);
        } else if (input_SZOVEG.length() == 5) {
            input_SZOVEG = input_SZOVEG.substring(0, 2) + "." + input_SZOVEG.substring(2, 5);
        } else if (input_SZOVEG.length() == 6) {
            input_SZOVEG = input_SZOVEG.substring(0, 3) + "." + input_SZOVEG.substring(3, 6);
        } else if (input_SZOVEG.length() == 7) {
            input_SZOVEG = input_SZOVEG.substring(0, 1) + "." + input_SZOVEG.substring(1, 4) + "." + input_SZOVEG.substring(4, 7);
        } else if (input_SZOVEG.length() > 7) {
            input_SZOVEG = "Az eredmény tizedes értéke nincs implementálva.";
        }

        return input_SZOVEG;

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public String MALMOS_LEKERES() throws SQLException, ClassNotFoundException, InterruptedException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String email;
        try (Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:" + port + ":CORE1", userName, password)) {
            int index = 0;
            StringBuilder builder = new StringBuilder();
            for (String Variables : array_ESTI_query) {
                String select_QUERY = ("SELECT * FROM MALMOSB." + Variables);
                preparedStatement = con.prepareStatement(select_QUERY);
                rs = preparedStatement.executeQuery(select_QUERY);
                index++;

                while (rs.next()) {
                    switch (index) {
                        case 1:
                            naplo = rs.getString(1).toUpperCase();
                            break;
                        case 2:
                            recept1 = rs.getString(1);
                            recept2 = rs.getString(2);
                            break;
                        case 3:
                            forgalmazok = rs.getString(1);
                            forgalmazok = CHAR_CHANGE(forgalmazok);
                            break;
                        case 4:
                            eszig_sikeres = rs.getString(2);
                            eszig_sikeres = CHAR_CHANGE(eszig_sikeres);
                            break;
                        case 5:
                            eszig_sikertelen = rs.getString(2);
                            eszig_sikertelen = CHAR_CHANGE(eszig_sikertelen);
                            break;
                        case 6:
                            allampolgari_belepes = rs.getString(1);
                            allampolgari_belepes = CHAR_CHANGE(allampolgari_belepes);
                            break;
                        case 7:
                            try {
                                String Patikak_APP_IN_DB = rs.getString("APPLICATION_ID");
                                String Patikak_Organization_id_IN_DB = rs.getString("ORGANIZATION_ID");
                                String Patikak_Name_IN_DB = rs.getString("NAME");
                                String Patikak_Hibak_IN_DB = rs.getString("CUSTOM_STRING4");
                                String Patikak_REC_DB_IN_DB = rs.getString("RECEPTEK");
                                String Patikak_HibaKod_Szoveg_IN_DB = rs.getString("SZOVEG");

                                PATIKAK patika_Hibak = new PATIKAK();

                                patika_Hibak.setPatikak_APP(Patikak_APP_IN_DB + " | ");
                                patika_Hibak.setPatikak_Organization_id(Patikak_Organization_id_IN_DB + " | ");
                                patika_Hibak.setPatikak_Name(Patikak_Name_IN_DB + " | ");
                                patika_Hibak.setPatikak_Hibak(Patikak_Hibak_IN_DB + " | ");
                                patika_Hibak.setPatikak_REC_DB(Patikak_REC_DB_IN_DB + " db" + " | ");
                                patika_Hibak.setPatikak_HibaKod_Szoveg(Patikak_HibaKod_Szoveg_IN_DB);
                                builder.append(patika_Hibak).append("\n");

                            } catch (SQLException ex) {
                                System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
                                String Hiba = (ex.getMessage() + " " + "SQL State: %s\n%s" + " " + ex.getSQLState());
                                JOptionPane.showMessageDialog(popup, Hiba);
                                ex.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            break;

                        default:
                            szoveg += "Nincs vizsgálat" + "\n";
                            break;
                    }
                }

            }
            email = ("Napló áttöltés: " + naplo + "\n" + "\n"
                    + "Sziasztok,\n"
                    + " \n"
                    + "Hány receptet forgalmaztunk a tárgynapon:\n"
                    + "1         " + recept1 + "(sikeres)\n"
                    + "2          " + recept2 + " (sikertelen)\n"
                    + " \n"
                    + "Hány intézmény forgalmazott a tárgynapon (készített értékelhető üzleti adatot)?\n"
                    + "" + forgalmazok + "\n"
                    + " \n"
                    + "eSZIG belépések száma:\n"
                    + eszig_sikeres + "      sikeres\n"
                    + " \n"
                    + eszig_sikertelen + "   sikertelen\n"
                    + " \n"
                    + "Egyedi állampolgári belépések száma a Lakossági Portálon a tárgynapon:\n"
                    + allampolgari_belepes + "\n");
            index = 0;
            fuzott_Patikak = builder.toString();
            con.close();
            rs.close();
        }
        return email;

    }

    public String TORZSADAT_LEKERES() throws SQLException, ClassNotFoundException, InterruptedException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:" + port + ":CORE1", userName, password);
        int index = 0;
        int index_patikak = 0;
        for (String Variables : array_tables) {
            String select_QUERY = ("SELECT CASE WHEN (CAST(SYSTIMESTAMP AS DATE))-CAST(MAX(BEJEGYZES_DT) AS DATE) < 4 "
                    + "THEN 'Aktív' Else 'Nem aktív'END AS Áttöltés FROM TORZSADAT.T$" + Variables + " UNION SELECT TO_CHAR(COUNT(*)) AS Áttöltés FROM TORZSADAT.E$" + Variables);

//            String select_QUERY = ("SELECT distinct cASE WHEN  count(TORZSADAT." + Variables + ".bejegyzes_dt) = 0\n"
//                    + "THEN 'Aktív'\n"
//                    + "Else 'Nem aktív'\n"
//                    + "END AS SZINKRON\n"
//                    + "FROM  TORZSADAT." + Variables + " WHERE SUBSTR(bejegyzes_dt,1,10) >= TRUNC(SYSDATE-1) AND SUBSTR(bejegyzes_dt,1,10) < TRUNC(SYSDATE)");
            preparedStatement = con.prepareStatement(select_QUERY);
            rs = preparedStatement.executeQuery(select_QUERY);
            index++;

            int i = 0;
            while (rs.next()) {
                switch (index) {
                    case 1:
                        if (i == 0) {
                            szoveg = "Törzsadatok betöltés az elmúlt napon: \n" + "\n";
                            szoveg += "E$Alapnyilvántartás tábla sorai: " + rs.getString(1).toUpperCase()+"      " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Alapnyilvántartás tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 2:
                        if (i == 0) {
                            szoveg += "E$Euszolg_engedely tábla sorai: " + rs.getString(1).toUpperCase() +"   "+ "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Euszolg_engedely tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 3:
                        if (i == 0) {
                            szoveg += "E$Euszolg tábla sorai: " + rs.getString(1).toUpperCase()+"                   " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg +="      "+ "T$Euszolg tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 4:
                        if (i == 0) {
                            szoveg += "E$Euszolg_közreműködő tábla sorai: " + rs.getString(1).toUpperCase() + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Euszolg_közreműködő tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 5:
                        if (i == 0) {
                            szoveg += "E$Euszolg_személy tábla sorai: " + rs.getString(1).toUpperCase()+"    " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Euszolg_személy tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 6:
                        if (i == 0) {
                            szoveg += "E$Euszolg_telephely tábla sorai: " + rs.getString(1).toUpperCase()+"          " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Euszolg_telephely tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 7:
                        if (i == 0) {
                            szoveg += "E$munknyil tábla sorai: " + rs.getString(1).toUpperCase()+"           " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$munknyil tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            
                            i = 0;
                        }
                        break;
                    case 8:
                        if (i == 0) {
                            szoveg += "E$Személy tábla sorai: " + rs.getString(1).toUpperCase()+"            " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Személy tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 9:
                        if (i == 0) {
                            szoveg += "E$Személy_bizalmas tábla sorai: " + rs.getString(1).toUpperCase()+"   " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Személy_bizalmas tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 10:
                        if (i == 0) {
                            szoveg += "E$Diploma tábla sorai: " + rs.getString(1).toUpperCase()+"            " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Diploma tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
                    case 11:
                        if (i == 0) {
                            szoveg += "E$Szakképzés tábla sorai: " + rs.getString(1).toUpperCase()+"         " + "                ";
                            System.out.println(Variables);
                            i++;
                        } else if (i == 1) {
                            szoveg += "T$Szakképzés tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
                            i = 0;
                        }
                        break;
//                    case 12:
//                        if (i == 0) {
//                            szoveg += "E$Fiókgyógyszertárak tábla sorai: " + rs.getString(1).toUpperCase() + "    ";
//                            i++;
//                        } else if (i == 1) {
//                            szoveg += "T$Fiókgyógyszertárak tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
//                            i = 0;
//                        }
//                        break;
//                    case 13:
//                        if (i == 0) {
//                            szoveg += "E$Intézeti_gyógyszertár tábla sorai: " + rs.getString(1).toUpperCase() + "    ";
//                            i++;
//                        } else if (i == 1) {
//                            szoveg += "T$Intézeti_gyógyszertár tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
//                            i = 0;
//                        }
//                        break;
//                    case 14:
//                        if (i == 0) {
//                            szoveg += "E$Intézeti_lakossági_egység tábla sorai: " + rs.getString(1).toUpperCase() + "    ";
//                            i++;
//                        } else if (i == 1) {
//                            szoveg += "T$Intézeti_lakossági_egység tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
//                            i = 0;
//                        }
//                        break;
//                    case 15:
//                        if (i == 0) {
//                            szoveg += "E$Közforgalmű_gyógyszertár tábla sorai: " + rs.getString(1).toUpperCase() + "    ";
//                            i++;
//                        } else if (i == 1) {
//                            szoveg += "T$Közforgalmű_gyógyszertár tábla: " + rs.getString(1).toUpperCase() + "\n" + "\n";
//                            i = 0;
//                        }
//                        break;
//                    case 16:
//                        if (i == 0) {
//                            szoveg += "E$Kézi_gyógyszertár tábla sorai: " + rs.getString(1).toUpperCase() + "    ";
//                            i++;
//                        } else if (i == 1) {
//                            szoveg += "T$Kézi_gyógyszertár: " + rs.getString(1).toUpperCase() + "\n" + "\n";
//                            i = 0;
//                        }
//                        break;
                    default:
                        szoveg += "Nincs vizsgálat" + "\n";
                        break;
                }

            }
        }
        jLabel2.setText("");
        con.close();
        rs.close();
        return szoveg;

    }

    public static ImageIcon image = new ImageIcon("dropbox-carousellogo-dribbble2.gif");

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            //JOptionPane.showMessageDialog( popup, image, "RUNING::", 100);

            jTextArea1.setText(MALMOS_LEKERES() + "\n" + TORZSADAT_LEKERES() + "\n" + fuzott_Patikak);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(popup, e);
            e.printStackTrace();
            jLabel2.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NAPI_RIPORT_1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(popup, ex);
            jLabel2.setText("");
        } catch (InterruptedException ex) {
            Logger.getLogger(NAPI_RIPORT_1.class.getName()).log(Level.SEVERE, null, ex);
            jLabel2.setText("");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jLabel2.setText("LOADING....");
        
    }//GEN-LAST:event_jButton1MousePressed

    static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NAPI_RIPORT_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NAPI_RIPORT_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NAPI_RIPORT_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NAPI_RIPORT_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NAPI_RIPORT_1().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
