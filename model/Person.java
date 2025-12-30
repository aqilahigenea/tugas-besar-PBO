package model;

// Superclass untuk Pasien dan Dokter
public class Person {
    protected String id;
    protected String nama;
    protected String email;
    protected String noHp;

    // Constructor
    public Person(String id, String nama, String email, String noHp) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
