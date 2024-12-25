/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gudang.model;

/**
 *
 * @author Lenovo
 */
public class Supplier {
    private int idSupplier;
    private String namaSupplier;
    private String kontak;

    // Constructor, getter, dan setter
    public Supplier(int idSupplier, String namaSupplier, String kontak) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.kontak = kontak;
    }

    public int getIdSupplier() { return idSupplier; }
    public void setIdSupplier(int idSupplier) { this.idSupplier = idSupplier; }

    public String getNamaSupplier() { return namaSupplier; }
    public void setNamaSupplier(String namaSupplier) { this.namaSupplier = namaSupplier; }

    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }
}
