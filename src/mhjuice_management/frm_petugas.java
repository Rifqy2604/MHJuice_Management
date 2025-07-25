/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mhjuice_management;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class frm_petugas extends javax.swing.JFrame {

    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    /**
     * Creates new form frm_petugas
     */
    public frm_petugas() {
        initComponents();
        k.connect();
        //Warna Tabel Petugas
        tabel_petugas.setBackground(Color.WHITE);
        tabel_petugas.setForeground(Color.BLACK);
        tabel_petugas.getTableHeader().setBackground(new Color(220, 220, 220));
        tabel_petugas.getTableHeader().setForeground(Color.BLACK);
        tabel_petugas.setRowHeight(25);
        
        //Warna TextFiled
        text_cari.setBackground(Color.WHITE);
        text_cari.setForeground(Color.BLACK);

        text_tanggal.setBackground(Color.WHITE);
        text_tanggal.setForeground(Color.BLACK);

        // Dropdown
        cb_jus.setBackground(Color.WHITE);
        cb_jus.setForeground(Color.BLACK);

        cb_petugas.setBackground(Color.WHITE);
        cb_petugas.setForeground(Color.BLACK);
        refreshTable();
        refreshCombo1();
        refreshCombo2();
    }
    
      class pengguna extends frm_petugas {

        int id_jus, id_petugas, harga;
        String nama, tanggal;

        public pengguna() {
            tanggal = text_tanggal.getText();
        }
    }

    public void refreshCombo1() {
        try {
            this.stat = k.getCon().prepareStatement("SELECT id_pengguna, "
                    + "nama_pengguna FROM pengguna WHERE tugas = 1");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                cb_petugas.addItem(rs.getString("nama_pengguna"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        public void refreshCombo2() {
        try {
            this.stat = k.getCon().prepareStatement("select * from daftar_jus");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                cb_jus.addItem(rs.getString("nama_jus"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

   public void refreshTable() {
    model = new DefaultTableModel();
    model.addColumn("TANGGAL");
    model.addColumn("NAMA JUS");
    model.addColumn("NAMA PETUGAS");
    model.addColumn("HARGA");
    tabel_petugas.setModel(model);

    int totalHarga = 0;

    try {
        String sql = "SELECT jus.nama_jus, jus.tanggal, pengguna.nama_pengguna, daftar_jus.harga "
                   + "FROM jus "
                   + "JOIN pengguna ON jus.id_petugas = pengguna.id_pengguna "
                   + "JOIN daftar_jus ON jus.nama_jus = daftar_jus.nama_jus "
                   + "WHERE pengguna.tugas = 1";

        this.stat = k.getCon().prepareStatement(sql);
        this.rs = this.stat.executeQuery();

        model.setRowCount(0);

        while (rs.next()) {
            String tanggal = rs.getString("tanggal");
            String namaJus = rs.getString("nama_jus");
            String namaPetugas = rs.getString("nama_pengguna");
            int harga = rs.getInt("harga");

            Object[] data = {
                tanggal,
                namaJus,
                namaPetugas,
                harga
            };
            model.addRow(data);

            totalHarga += harga;
        }

        // Tampilkan total ke text_jumlah
        text_jumlah.setText(String.valueOf(totalHarga));

        text_tanggal.setText("");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_cari = new javax.swing.JTextField();
        cb_jus = new javax.swing.JComboBox<>();
        cb_petugas = new javax.swing.JComboBox<>();
        text_tanggal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_petugas = new javax.swing.JTable();
        txt_semua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        text_jumlah = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        txt_cari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tanggal :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MH FRESH JUICE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        text_cari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_cari.setForeground(new java.awt.Color(153, 153, 153));
        text_cari.setText("Cari...");
        text_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_cariActionPerformed(evt);
            }
        });
        jPanel1.add(text_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 200, 30));

        cb_jus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_jus.setForeground(new java.awt.Color(153, 153, 153));
        cb_jus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_jusActionPerformed(evt);
            }
        });
        jPanel1.add(cb_jus, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 210, 30));

        cb_petugas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_petugas.setForeground(new java.awt.Color(153, 153, 153));
        cb_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_petugasActionPerformed(evt);
            }
        });
        jPanel1.add(cb_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 210, 30));

        text_tanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_tanggal.setForeground(new java.awt.Color(153, 153, 153));
        text_tanggal.setText("dd/mm/yyy");
        text_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tanggalActionPerformed(evt);
            }
        });
        jPanel1.add(text_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Jus :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Petugas :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, 20));

        btn_keluar.setBackground(new java.awt.Color(102, 204, 255));
        btn_keluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 120, 30));

        tabel_petugas.setBackground(new java.awt.Color(204, 204, 204));
        tabel_petugas.setForeground(new java.awt.Color(255, 255, 255));
        tabel_petugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Jus", "Tanggal", "Nama Petugas", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_petugas.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabel_petugas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 900, 290));

        txt_semua.setBackground(new java.awt.Color(102, 204, 255));
        txt_semua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_semua.setForeground(new java.awt.Color(255, 255, 255));
        txt_semua.setText("Semua data\n");
        txt_semua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_semuaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_semua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 120, 30));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("JUMLAH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel5)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 660, 40));
        jPanel1.add(text_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 240, 40));

        btn_simpan.setBackground(new java.awt.Color(102, 204, 255));
        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Masukan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 120, 30));

        txt_cari.setBackground(new java.awt.Color(102, 204, 255));
        txt_cari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(255, 255, 255));
        txt_cari.setText("cari\n");
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_cariActionPerformed

    private void text_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tanggalActionPerformed

    private void cb_jusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_jusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_jusActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here                                   
    String keyword = text_cari.getText();

    model = new DefaultTableModel();
    model.addColumn("NAMA JUS");
    model.addColumn("NAMA PETUGAS");
    model.addColumn("HARGA");
    model.addColumn("TANGGAL");
    tabel_petugas.setModel(model);

    int totalHarga = 0;

    try {
        String sql = "SELECT jus.nama_jus, jus.tanggal, pengguna.nama_pengguna, daftar_jus.harga "
                   + "FROM jus "
                   + "JOIN pengguna ON jus.id_petugas = pengguna.id_pengguna "
                   + "JOIN daftar_jus ON jus.nama_jus = daftar_jus.nama_jus "
                   + "WHERE pengguna.tugas = 1 "
                   + "AND (jus.nama_jus LIKE ? OR pengguna.nama_pengguna LIKE ?"
                + "OR jus.tanggal LIKE ? OR daftar_jus.harga LIKE ?)";

        PreparedStatement ps = k.getCon().prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ps.setString(3, "%" + keyword + "%");
        ps.setString(4, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        model.setRowCount(0);

        while (rs.next()) {
            String namaJus = rs.getString("nama_jus");
            String namaPetugas = rs.getString("nama_pengguna");
            int harga = rs.getInt("harga");
            String tanggal = rs.getString("tanggal");

            Object[] data = {
                namaJus,
                namaPetugas,
                harga,
                tanggal
            };
            model.addRow(data);

            totalHarga += harga;
        }

        text_jumlah.setText(String.valueOf(totalHarga));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
    }


    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_semuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_semuaActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_txt_semuaActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
          try {
        String namaJus = cb_jus.getSelectedItem().toString();
        String namaPetugas = cb_petugas.getSelectedItem().toString();
        String tanggal = text_tanggal.getText();

        // Validasi sederhana
        if (tanggal.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tanggal harus diisi!");
            return;
        }

        // Cari id_petugas dari nama_petugas
        int idPetugas = 0;
        String sql = "SELECT id_pengguna FROM pengguna WHERE nama_pengguna = ?";
        PreparedStatement ps = k.getCon().prepareStatement(sql);
        ps.setString(1, namaPetugas);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idPetugas = rs.getInt("id_pengguna");
        } else {
            JOptionPane.showMessageDialog(null, "Petugas tidak ditemukan!");
            return;
        }

        // INSERT ke tabel jus
        String insert = "INSERT INTO jus (nama_jus, id_petugas, tanggal) VALUES (?, ?, ?)";
        PreparedStatement psInsert = k.getCon().prepareStatement(insert);
        psInsert.setString(1, namaJus);
        psInsert.setInt(2, idPetugas);
        psInsert.setString(3, tanggal);
        psInsert.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        refreshTable();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:        
        frm_login frm = new frm_login();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void cb_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_petugasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frm_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cb_jus;
    private javax.swing.JComboBox<String> cb_petugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_petugas;
    private javax.swing.JTextField text_cari;
    private javax.swing.JTextField text_jumlah;
    private javax.swing.JTextField text_tanggal;
    private javax.swing.JButton txt_cari;
    private javax.swing.JButton txt_semua;
    // End of variables declaration//GEN-END:variables
}
