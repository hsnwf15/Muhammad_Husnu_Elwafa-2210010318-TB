/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gudang.model;

/**
 *
 * @author Lenovo
 */
public class Barang {
    private int idBarang;
    private String namaBarang;
    private int stok;
    private double harga;

    // Constructor, getter, dan setter
    public Barang(int idBarang, String namaBarang, int stok, double harga) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.harga = harga;
    }

    public int getIdBarang() { return idBarang; }
    public void setIdBarang(int idBarang) { this.idBarang = idBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
}
