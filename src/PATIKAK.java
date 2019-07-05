/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ludanyi.tamas
 */
public class PATIKAK {
    public  String Patikak_APP = "";
    public  String Patikak_Organization_id = "";
    public  String Patikak_Name = "";
    public  String Patikak_Hibak = "";
    public  String Patikak_REC_DB = "";
    public  String Patikak_HibaKod_Szoveg = "";

    public PATIKAK() {
    }

    @Override
    public String toString() {
        return   Patikak_APP + " " + Patikak_Organization_id + " " + Patikak_Name + " " + Patikak_Hibak + " " + Patikak_REC_DB + " " + Patikak_HibaKod_Szoveg;
    }

    public String getPatikak_APP() {
        return Patikak_APP;
    }

    public void setPatikak_APP(String Patikak_APP) {
        this.Patikak_APP = Patikak_APP;
    }

    public String getPatikak_Organization_id() {
        return Patikak_Organization_id;
    }

    public void setPatikak_Organization_id(String Patikak_Organization_id) {
        this.Patikak_Organization_id = Patikak_Organization_id;
    }

    public String getPatikak_Name() {
        return Patikak_Name;
    }

    public void setPatikak_Name(String Patikak_Name) {
        this.Patikak_Name = Patikak_Name;
    }

    public String getPatikak_Hibak() {
        return Patikak_Hibak;
    }

    public void setPatikak_Hibak(String Patikak_Hibak) {
        this.Patikak_Hibak = Patikak_Hibak;
    }

    public String getPatikak_REC_DB() {
        return Patikak_REC_DB;
    }

    public void setPatikak_REC_DB(String Patikak_REC_DB) {
        this.Patikak_REC_DB = Patikak_REC_DB;
    }

    public String getPatikak_HibaKod_Szoveg() {
        return Patikak_HibaKod_Szoveg;
    }

    public void setPatikak_HibaKod_Szoveg(String Patikak_HibaKod_Szoveg) {
        this.Patikak_HibaKod_Szoveg = Patikak_HibaKod_Szoveg;
    }
    
}
