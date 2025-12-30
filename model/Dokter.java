package model;

public class Dokter extends Person {
    public String spesialisasi;
    public double biayaKonsultasi;

    public Dokter(String id, String nama, String email, String noHp,
                  String spesialisasi, double biayaKonsultasi) {

        super(id, nama, email, noHp);
        this.spesialisasi = spesialisasi;
        this.biayaKonsultasi = biayaKonsultasi;
    }

    public double getBiayaKonsultasi() {
        return biayaKonsultasi;
    }
}
