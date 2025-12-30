package model;

import java.time.LocalDate;

public class Kunjungan {
    public int idKunjungan;
    public int idPasien;
    public int idDokter;
    public LocalDate tanggalKunjungan;
    public String keluhan;
    public String diagnosa;
    public String resep;
    public double biayaTotal;
    public String status;

    public Kunjungan(int idKunjungan, int idPasien, int idDokter,
                     LocalDate tanggalKunjungan, String keluhan,
                     String diagnosa, String resep,
                     double biayaTotal, String status) {

        this.idKunjungan = idKunjungan;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggalKunjungan = tanggalKunjungan;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.resep = resep;
        this.biayaTotal = biayaTotal;
        this.status = status;
    }
}
