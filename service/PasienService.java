package service;

import database.DatabaseConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PasienService extends BaseService implements CrudService {

    @Override
    public void tambah() {
        try {
            Connection conn = DatabaseConnection.getConnection();
           
            System.out.print("\nID Pasien: ");
            String idPasien = input.nextLine().toUpperCase();

            System.out.print("Nama Pasien: ");
            String nama = input.nextLine();

            System.out.print("Email: ");
            String email = input.nextLine();

            System.out.print("No HP: ");
            String noHp = input.nextLine();

            System.out.print("Alamat: ");
            String alamat = input.nextLine();

            System.out.print("Tanggal Lahir (yyyy-MM-dd): ");
            LocalDate tglLahir = LocalDate.parse(input.nextLine());

            System.out.print("Jenis Kelamin: ");
            String jk = input.nextLine();

            LocalDate tglDaftar = LocalDate.now();

            String sql = "INSERT INTO pasien " +
                        "(id_pasien, nama_pasien, email, no_hp, alamat, tanggal_lahir, jenis_kelamin, tanggal_daftar) " +
                        "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPasien);
            ps.setString(2, nama);
            ps.setString(3, email);
            ps.setString(4, noHp);
            ps.setString(5, alamat);
            ps.setDate(6, Date.valueOf(tglLahir));
            ps.setString(7, jk);
            ps.setDate(8, Date.valueOf(tglDaftar));

            ps.executeUpdate();
            System.out.println("\nData pasien berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("\nGagal menambahkan pasien!");
            e.printStackTrace();
        }
    }

    @Override
    public void tampil() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM pasien");

            List<String> listIdPasien = new ArrayList<>();

            System.out.printf(
                "\n%-10s | %-10s | %-15s | %-13s | %-15s | %-10s | %-10s\n",
                "ID Pasien", "Nama", "Email", "No HP", "Alamat", "Tgl Lahir", "Jenis Kelamin"
            );
            System.out.println("-------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                String idPasien = rs.getString("id_pasien");
                listIdPasien.add(idPasien);

                System.out.printf(
                    "%-10s | %-10s | %-15s | %-13s | %-15s | %-10s | %-10s\n",
                    idPasien,
                    rs.getString("nama_pasien").toUpperCase(),
                    rs.getString("email"),
                    rs.getString("no_hp"),
                    rs.getString("alamat"),
                    rs.getString("tanggal_lahir"),
                    rs.getString("jenis_kelamin")
                );
            }

            System.out.println("\nTotal data pasien : " + listIdPasien.size());

        } catch (Exception e) {
            System.out.println("\nGagal tampil pasien!");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukkan ID Pasien yang akan diupdate: ");
            String id = input.nextLine();

            System.out.print("ID Pasien Baru: ");
            String idPasien = input.nextLine();

            System.out.print("Nama Baru: ");
            String nama = input.nextLine();

            System.out.print("No HP Baru: ");
            String noHp = input.nextLine();

            System.out.print("Email Baru: ");
            String email = input.nextLine();

            System.out.print("Alamat Baru: ");
            String alamat = input.nextLine();

            System.out.print("Tanggal Lahir Baru: ");
            String tglLahir = input.nextLine();

            System.out.print("Jenis Kelamin Baru: ");
            String jenisKelamin = input.nextLine();

            String sql = "UPDATE pasien SET id_pasien=?, nama_pasien=?, no_hp=?, email=?, alamat=?, tanggal_lahir=?, jenis_kelamin=? WHERE id_pasien=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idPasien);
            ps.setString(2, nama);
            ps.setString(3, noHp);
            ps.setString(4, email);
            ps.setString(5, alamat);
            ps.setString(6, tglLahir);
            ps.setString(7, jenisKelamin);
            ps.setString(8, id);

            int hasil = ps.executeUpdate();

            if (hasil > 0) {
                System.out.println("\nData pasien berhasil diupdate!");
            } else {
                System.out.println("\nID pasien tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("\nGagal update pasien!");
            e.printStackTrace();
        }
    }

    @Override
    public void hapus() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nID Pasien yang akan dihapus: ");
            String id = input.nextLine();

            String sql = "DELETE FROM pasien WHERE id_pasien=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ps.executeUpdate();
            System.out.println("\nData pasien berhasil dihapus!");

        } catch (Exception e) {
            System.out.println("\nGagal hapus pasien!");
            e.printStackTrace();
        }
    }
}
