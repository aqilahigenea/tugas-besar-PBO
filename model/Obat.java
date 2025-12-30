package model;

public class Obat {
    public String idObat;
    public String namaObat;
    public String kategori;
    public int stok;
    public double harga;

    public Obat(String idObat, String namaObat, String kategori, int stok, double harga) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }
}
