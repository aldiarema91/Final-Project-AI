/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naivebayes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldi, Imam, Rahardian
 */
public class Ternak extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ternak_db";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "";
    static Statement stmt; 
    static Connection conn;
    static ResultSet rs;
    
    static void createStmt() throws SQLException {
        stmt = (Staasdtement) conn.createStatement();
    }
    
    int no=0;
    String id;
    String jenis;
    String daya;
    String waktu;
    String pelihara;
    String biaya;
    String hasil;
    
    public Ternak() {
        initComponents();
        getData();
        System.out.println(no);
        
    }
    
    void setData(int id, String jenis, String daya,String waktu,String pelihara,String biaya, String kate, String hasil){
        try {

            conn = konek();

            if (conn != null) {
                System.out.println("koneksi sukses!");
            }  

            createStmt();
            String sql = "INSERT INTO `table 1` "
                    + "(`id_ternak`, `jenis_ternak`, `daya_tahan`, `waktu`, `pemeliharaan`, `biaya`, `kat_biaya`,`hasil`)"
                    + " VALUES "
                    + "('"+id+"','"+jenis+"','"+daya+"','"+waktu+"','"+pelihara+"','"+biaya+"','"+kate+"','"+hasil+"')";

            if(stmt.executeUpdate(sql) > 0){
                System.out.println("Tambah berhasil");
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void getData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            
            conn = konek();
            
            if (conn != null) {
                System.out.println("koneksi sukses!");
            }  
            
            createStmt()
            String sql,kate;
            sql = "SELECT * from `table 1`";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                id = rs.getString("id_ternak");
                jenis = rs.getString("jenis_ternak");
                daya = rs.getString("daya_tahan");
                waktu = rs.getString("waktu");
                pelihara = rs.getString("pemeliharaan");
                biaya = rs.getString("biaya");
                hasil = rs.getString("hasil");
                Object[] row = {id, jenis, daya, waktu, pelihara, biaya, hasil};
                model.addRow(row);
                
                no++;
            }
            
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void Hitung(String daya,String waktu,String pelihara,String biaya){
        float cocok = 0;
        float tcocok = 0;
        float dayaC = 0;float waktuC = 0;float peliharaC = 0;float biayaC = 0;
        float dayaT = 0;float waktuT = 0;float peliharaT = 0;float biayaT = 0;
        int a = Integer.parseInt(biaya);
        String kate;
        if (a <= 5000000) {
            kate = "Murah";
        } else if (a<=10000000) {
            kate = "Sedang";
        }else{
            kate = "Mahal";
        }
        try {
            
            conn = konek();
            
            if (conn != null) {
                System.out.println("koneksi sukses!");
            }  
            
            
            String[] sql = new String[10];
            sql[1] = "SELECT id_ternak from `table 1` where hasil='cocok'";
            sql[2] = "SELECT id_ternak from `table 1` where hasil='tidak cocok'";
            sql[3] = "SELECT id_ternak from `table 1` where hasil='cocok' and daya_tahan='"+daya+"'";
            sql[4] = "SELECT id_ternak from `table 1` where hasil='tidak cocok' and daya_tahan='"+daya+"'";
            sql[5] = "SELECT id_ternak from `table 1` where hasil='cocok' and waktu='"+waktu+"'";
            sql[6] = "SELECT id_ternak from `table 1` where hasil='tidak cocok' and waktu='"+waktu+"'";
            sql[7] = "SELECT id_ternak from `table 1` where hasil='cocok' and pemeliharaan='"+pelihara+"'";
            sql[8] = "SELECT id_ternak from `table 1` where hasil='tidak cocok' and pemeliharaan='"+pelihara+"'";
            sql[9] = "SELECT id_ternak from `table 1` where hasil='cocok' and kat_biaya='"+kate+"'";
            sql[0] = "SELECT id_ternak from `table 1` where hasil='tidak cocok' and kat_biaya='"+kate+"'";
            
            for (int i = 0; i < 10; i++) {
                createStmt();
                ResultSet rs = stmt.executeQuery(sql[i]);
                
                switch(i){
                    case 0:
                        while (rs.next()) {                
                            biayaT++;
                        }
                    case 1:
                        while (rs.next()) {                
                            cocok++;
                        }
                    case 2:
                        while (rs.next()) {                
                            tcocok++;
                        }
                    case 3:
                        while (rs.next()) {                
                            dayaC++;
                        }
                    case 4:
                        while (rs.next()) {                
                            dayaT++;
                        }
                    case 5:
                        while (rs.next()) {                
                            waktuC++;
                        }
                    case 6:
                        while (rs.next()) {                
                            waktuT++;
                        }
                    case 7:
                        while (rs.next()) {                
                            peliharaC++;
                        }
                    case 8:
                        while (rs.next()) {                
                            peliharaT++;
                        }
                    case 9:
                        while (rs.next()) {                
                            biayaC++;
                        }
                }
            }
            rs.close();//rs2.close();rs3.close();rs4.close();rs6.close();rs7.close();rs8.close();//rs9.close();rs0.close();
            stmt.close();
            conn.close();
            System.out.println("cocok = "+cocok+ "\n" +"Tidak cocok = "+tcocok+ "\n" +
                                " Daya cocok = "+dayaC+ "\n" +" dayaT cocok = "+dayaT+ "\n" +
                                        "waktuC cocok = "+waktuC+"\n"+"waktuT cocok = "+waktuT+"\n"+" pelihara cocok = "+peliharaC+"\n"+"peliharaT cocok = "+
                                peliharaT+"\n"+"biaya cocok = "+biayaC+"\n"+"biayaT cocok = "+biayaT+"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String HC = "COCOK";
        String HT = "TIDAK COCOK";
        String HA = null;
        float HasilSC,HasilST,Hcocok,HTcocok,Hdaya,HTdaya,Hwaktu,HTwaktu,Hpelihara,HTpelihara,Hbiaya,HTbiaya;
        Hcocok = cocok/no;
        HTcocok = tcocok/no;
        System.out.println("COCOK = "+Hcocok);
        System.out.println("TIDAK COCOK = "+HTcocok);
        Hdaya = dayaC/cocok;
        HTdaya = dayaT/tcocok;
        System.out.println("DAYA TAHAN = "+ daya +"HASIL COCOK = " + Hdaya );
        System.out.println("DAYA TAHAN = "+ daya +"HASIL TIDAK COCOK= " + HTdaya);
        Hwaktu = waktuC/cocok;
        HTwaktu = waktuT/tcocok;
        System.out.println("WAKTU PERTUMBUHAN = " + waktu +"HASIL COCOK = " + Hwaktu);
        System.out.println("WAKTU PERTUMBUHAN = " + waktu +"HASIL TIDAK COCOK= " + HTwaktu);
         Hpelihara = peliharaC/cocok;
        HTpelihara = peliharaT/tcocok;
        System.out.println("PEMELIHARAAN = " + pelihara +"HASIL COCOK = " + Hpelihara);
        System.out.println("PEMELIHARAAN = " + pelihara +"HASIL TIDAK COCOK = " + HTpelihara);
        Hbiaya = biayaC/cocok;
        HTbiaya = biayaT/tcocok;
        System.out.println("BIAYA = " + kate +"HASIL COCOK = " + Hbiaya);
        System.out.println("BIAYA = " + kate +"HASIL TIDAK COCOK = " + HTbiaya);
        HasilSC = (Hdaya*Hwaktu*Hpelihara*Hbiaya);
        System.out.println("HASIL KESELURUHAN (COCOK) = "+HasilSC);
        HasilST = (HTdaya*HTwaktu*HTpelihara*HTbiaya);
        System.out.println("HASIL KESELURUHAN (TIDAK COCOK) = "+HasilST);
        if(HasilSC > HasilST){
            System.out.println("Kesimpulan = " + HC );
            HA = HC;
        }else{
            System.out.println("kesimpulan = " + HT);
            HT = HA;
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        no+=1;
        jenis = txtJenis.getText();
        daya = (String) cbDaya.getSelectedItem();
        waktu = (String) cbWaktu.getSelectedItem();
        pelihara = (String) cbPelihara.getSelectedItem();
        biaya = txtBiaya.getText();
        hasil = "";
        int a = Integer.parseInt(biaya);
        String kate;
        if (a>0) {            
            if (a <= 5000000) {
                kate = "Murah";
            } else if (a<=10000000) {
                kate = "Sedang";
            }else{
                kate = "Mahal";
            }
            //Hitung
            setData(no, jenis, daya, waktu, pelihara, biaya, kate, Hitung(daya, waktu, pelihara, biaya));
            getData();
            txtJenis.setText("");
            txtBiaya.setText("");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static Connection konek(){
        Connection conn = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Coba koneksi DB");
            conn = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ternak().setVisible(true);
            }
        });
    }

}
