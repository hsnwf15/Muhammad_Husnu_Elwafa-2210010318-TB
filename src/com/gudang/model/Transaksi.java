/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gudang.model;

import java.util.Date;
/**
 *
 * @author Lenovo
 */
public class Transaksi {
    private int idTransaksi;
    private int idBarang;
    private int idSupplier;
    private int jumlah;
    private Date tanggal;

    // Constructor, getter, dan setter
    public Transaksi(int idTransaksi, int idBarang, int idSupplier, int jumlah, Date tanggal) {
        this.idTransaksi = idTransaksi;
        this.idBarang = idBarang;
        this.idSupplier = idSupplier;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public int getIdBarang() { return idBarang; }
    public void setIdBarang(int idBarang) { this.idBarang = idBarang; }

    public int getIdSupplier() { return idSupplier; }
    public void setIdSupplier(int idSupplier) { this.idSupplier = idSupplier; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public Date getTanggal() { return tanggal; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }
}
