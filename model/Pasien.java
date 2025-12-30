package model;

import java.time.LocalDate;

public class Pasien extends Person {
    public String alamat;
    public LocalDate tanggalLahir;
    public String jenisKelamin;
    public LocalDate tanggalDaftar;

    public Pasien(String id, String nama, String email, String noHp,
                  String alamat, LocalDate tanggalLahir,
                  String jenisKelamin, LocalDate tanggalDaftar) {

        super(id, nama, email, noHp);
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.tanggalDaftar = tanggalDaftar;
    }
}
