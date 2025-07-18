/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mhjuice_management;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTextField;
/**
 *
 * @author asus
 */
public class frm_pemilik2 extends javax.swing.JFrame {

    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
//    Untuk Proses Edit
boolean addMode = false;
boolean editMode = false;
String namaJusEdit = "";


    /**
     * Creates new form frm_pemilik2
     */
    public frm_pemilik2() {
        initComponents();
        k.connect();
        
        //Warna Tabel Jus
        tabel_jus.setBackground(Color.WHITE);
        tabel_jus.setForeground(Color.BLACK);
        tabel_jus.getTableHeader().setBackground(new Color(220, 220, 220));
        tabel_jus.getTableHeader().setForeground(Color.BLACK);
        tabel_jus.setRowHeight(25);
        refreshTable();
//    Nama Text 
    setPlaceholder(text_jus1, "Nama Jus...");
    setPlaceholder(text_harga1, "Harga...");
    
//    Text field Monaktif semua
    text_jus1.setEnabled(false);
    text_harga1.setEnabled(false);
    text_jus2.setEnabled(false);
    text_harga2.setEnabled(false);
    }

     public void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Jus");
        model.addColumn("Harga");

        // Pastikan nama JTable sama dengan nama di form designer
        tabel_jus.setModel(model);

        try {
            String sql = "SELECT * FROM daftar_jus";
            PreparedStatement stat = k.getCon().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("nama_jus"),
                    rs.getInt("harga")
                };
                model.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        }
    }
     
     private void setPlaceholder(JTextField field, String placeholder) {
    field.setText(placeholder);
    field.setForeground(Color.GRAY);

    field.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (field.getText().equals(placeholder)) {
                field.setText("");
                field.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (field.getText().trim().equals("")) {
                field.setText(placeholder);
                field.setForeground(Color.GRAY);
            }
        }
    });
}
     
     private void bersihkanField() {
    setPlaceholder(text_jus1, "Nama Jus...");
    setPlaceholder(text_harga1, "Harga...");
//    setPlaceholder(text_jus2, "Nama Jus...");
//    setPlaceholder(text_harga2, "Harga...");
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_jus = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        text_jus1 = new javax.swing.JTextField();
        text_harga1 = new javax.swing.JTextField();
        text_harga2 = new javax.swing.JTextField();
        text_jus2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 120, 30));

        tabel_jus.setBackground(new java.awt.Color(204, 204, 204));
        tabel_jus.setForeground(new java.awt.Color(255, 255, 255));
        tabel_jus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Jus", "Harga"
            }
        ));
        tabel_jus.setGridColor(new java.awt.Color(0, 0, 0));
        tabel_jus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_jusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_jus);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 900, 330));

        btn_hapus.setBackground(new java.awt.Color(255, 51, 51));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 120, 30));

        text_jus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_jus1.setForeground(new java.awt.Color(153, 153, 153));
        text_jus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_jus1ActionPerformed(evt);
            }
        });
        jPanel1.add(text_jus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 240, 30));

        text_harga1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_harga1.setForeground(new java.awt.Color(153, 153, 153));
        text_harga1.setToolTipText("");
        text_harga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_harga1ActionPerformed(evt);
            }
        });
        jPanel1.add(text_harga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 240, 30));

        text_harga2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_harga2.setForeground(new java.awt.Color(153, 153, 153));
        text_harga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_harga2ActionPerformed(evt);
            }
        });
        jPanel1.add(text_harga2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 240, 30));

        text_jus2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_jus2.setForeground(new java.awt.Color(153, 153, 153));
        text_jus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_jus2ActionPerformed(evt);
            }
        });
        jPanel1.add(text_jus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 240, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MH FRESH JUICE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        btn_tambah.setBackground(new java.awt.Color(102, 204, 255));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 120, 30));

        btn_simpan.setBackground(new java.awt.Color(102, 204, 255));
        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 120, 30));

        btn_edit.setBackground(new java.awt.Color(102, 204, 255));
        btn_edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 120, 30));

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

    private void text_jus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_jus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_jus1ActionPerformed

    private void text_harga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_harga1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_harga1ActionPerformed

    private void text_harga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_harga2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_harga2ActionPerformed

    private void text_jus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_jus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_jus2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frm_pemilik frm = new frm_pemilik();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
    try {
        if (addMode) {
            // ===== TAMBAH DATA =====
            String namaJus = text_jus1.getText().trim();
            String hargaStr = text_harga1.getText().trim();

            if (namaJus.isEmpty() || hargaStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                return;
            }

            int harga = Integer.parseInt(hargaStr);

            // Cek duplikasi nama_jus
            String cekSql = "SELECT COUNT(*) FROM daftar_jus WHERE nama_jus = ?";
            PreparedStatement cekStat = k.getCon().prepareStatement(cekSql);
            cekStat.setString(1, namaJus);
            ResultSet rsCek = cekStat.executeQuery();
            rsCek.next();
            int count = rsCek.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Nama jus sudah ada. Silakan gunakan nama lain.");
                return;
            }

            String sql = "INSERT INTO daftar_jus (nama_jus, harga) VALUES (?, ?)";
            PreparedStatement stat = k.getCon().prepareStatement(sql);
            stat.setString(1, namaJus);
            stat.setInt(2, harga);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");

            bersihkanField();

        } else if (editMode) {
            // ===== EDIT DATA =====
            String namaBaru = text_jus2.getText().trim();
            String hargaStr = text_harga2.getText().trim();

            if (namaBaru.isEmpty() || hargaStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                return;
            }

            int hargaBaru = Integer.parseInt(hargaStr);

            String sql = "UPDATE daftar_jus SET nama_jus = ?, harga = ? WHERE nama_jus = ?";
            PreparedStatement stat = k.getCon().prepareStatement(sql);
            stat.setString(1, namaBaru);
            stat.setInt(2, hargaBaru);
            stat.setString(3, namaJusEdit);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");

            //Kosongkan field & disable
            text_jus2.setText("");
            text_harga2.setText("");
            
        }
        
        refreshTable();

        // Reset mode
        addMode = false;
        editMode = false;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Harga harus angka!");
    }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
            //  textfield atas aktif BUN
    addMode = true;
    editMode = false;

    text_jus1.setEnabled(true);
    text_harga1.setEnabled(true);
    text_jus2.setEnabled(false);
    text_harga2.setEnabled(false);
    bersihkanField();


    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
     //  textfield bawah aktif BUN
     editMode = true;
     addMode = false;
    text_jus2.setEnabled(true);
    text_harga2.setEnabled(true);
    
      // textfield atas Monaktif Bun
    text_jus1.setEnabled(false);
    text_harga1.setEnabled(false);
    }//GEN-LAST:event_btn_editActionPerformed

    private void tabel_jusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_jusMouseClicked
        // TODO add your handling code here:
    int baris = tabel_jus.getSelectedRow();
    if (baris != -1) {
        text_jus2.setEnabled(true);
        text_harga2.setEnabled(true);

        String namaJus = tabel_jus.getValueAt(baris, 0).toString();
        String harga = tabel_jus.getValueAt(baris, 1).toString();

        text_jus2.setText(namaJus);
        text_harga2.setText(harga);

        namaJusEdit = namaJus;
    }
    bersihkanField();

    }//GEN-LAST:event_tabel_jusMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
            try {
        int baris = tabel_jus.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data dulu yang mau dihapus!");
            return;
        }

        String namaJus = tabel_jus.getValueAt(baris, 0).toString();

        int konfirmasi = JOptionPane.showConfirmDialog(
                null,
                "Yakin mau menghapus jus: " + namaJus + "?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM daftar_jus WHERE nama_jus = ?";
            PreparedStatement stat = k.getCon().prepareStatement(sql);
            stat.setString(1, namaJus);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");

            //Kosongkan field & disable
            text_jus2.setText("");
            text_harga2.setText("");
            refreshTable();
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(frm_pemilik2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pemilik2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pemilik2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pemilik2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pemilik2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_jus;
    private javax.swing.JTextField text_harga1;
    private javax.swing.JTextField text_harga2;
    private javax.swing.JTextField text_jus1;
    private javax.swing.JTextField text_jus2;
    // End of variables declaration//GEN-END:variables
}
