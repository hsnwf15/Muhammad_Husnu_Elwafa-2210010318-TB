/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gudang.ui;

import com.gudang.database.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 *
 * @author Lenovo
 */
public class TransaksiGUI extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiGUI
     */
    private DefaultTableModel tableModel;
    public TransaksiGUI() {
        initComponents();
    }

    private void tambahTransaksi() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO transaksi (id_barang, id_supplier, jumlah, tanggal) VALUES (?, ?, ?, CURRENT_DATE)")) {
            stmt.setInt(1, comboBarang.getSelectedIndex() + 1); // Assuming combo index matches ID
            stmt.setInt(2, comboSupplier.getSelectedIndex() + 1);
            stmt.setInt(3, Integer.parseInt(txtJumlah.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan!");
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void loadComboBoxes() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            // Load Barang
            ResultSet rsBarang = stmt.executeQuery("SELECT nama_barang FROM barang");
            while (rsBarang.next()) {
                comboBarang.addItem(rsBarang.getString("nama_barang"));
            }

            // Load Supplier
            ResultSet rsSupplier = stmt.executeQuery("SELECT nama_supplier FROM supplier");
            while (rsSupplier.next()) {
                comboSupplier.addItem(rsSupplier.getString("nama_supplier"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT t.id_transaksi, b.nama_barang, s.nama_supplier, t.jumlah, t.tanggal FROM transaksi t " +
                     "JOIN barang b ON t.id_barang = b.id_barang " +
                     "JOIN supplier s ON t.id_supplier = s.id_supplier")) {
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id_transaksi"),
                        rs.getString("nama_barang"),
                        rs.getString("nama_supplier"),
                        rs.getInt("jumlah"),
                        rs.getDate("tanggal")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
        java.awt.GridBagConstraints gridBagConstraints;

        txtJumlah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        comboBarang = new javax.swing.JComboBox<>();
        comboSupplier = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        getContentPane().add(txtJumlah, gridBagConstraints);

        jLabel1.setText("Barang:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 12, 13);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Supplier:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 12, 13);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Jumlah:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 12, 13);
        getContentPane().add(jLabel3, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(475, 180));

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Barang", "Supplier", "Jumlah", "Tanggal"
            }
        ));
        jScrollPane2.setViewportView(tableSupplier);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 13, 13);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Manajemen Transaksi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 40, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanel1.add(btnTambah, gridBagConstraints);

        btnLoad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoad.setText("Load Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel1.add(btnLoad, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 13, 13);
        getContentPane().add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        getContentPane().add(comboBarang, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        getContentPane().add(comboSupplier, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        loadData();
    }//GEN-LAST:event_btnLoadActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> comboBarang;
    private javax.swing.JComboBox<String> comboSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
