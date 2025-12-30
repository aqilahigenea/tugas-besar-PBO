package service;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DokterService extends BaseService implements CrudService {


    @Override
    public void tambah() {
        try {
            Connection conn = DatabaseConnection.getConnection();
           
            System.out.print("\nID Dokter: ");
            String idDokter = input.nextLine().toUpperCase();
           
            System.out.print("Nama Dokter: ");
            String nama = input.nextLine();

            System.out.print("Email: ");
            String email = input.nextLine();

            System.out.print("Spesialisasi: ");
            String spesialisasi = input.nextLine();

            System.out.print("No HP: ");
            String noHp = input.nextLine();

            System.out.print("Biaya Konsultasi: ");
            double biaya = input.nextDouble();
            input.nextLine();

            String sql = "INSERT INTO dokter " +
                        "(id_dokter, nama_dokter, email, spesialisasi, no_hp, biaya_konsultasi) " +
                        "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idDokter);
            ps.setString(2, nama);
            ps.setString(3, email);
            ps.setString(4, spesialisasi);
            ps.setString(5, noHp);
            ps.setDouble(6, biaya);

            ps.executeUpdate();
            System.out.println("\nDokter berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("\nGagal menambah dokter!");
            e.printStackTrace();
        }
    }

    @Override
    public void tampil() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM dokter");

            List<String> listIdDokter = new ArrayList<>();

            System.out.printf(
                "\n%-10s | %-15s | %-18s | %-17s | %-12s | %-10s\n",
                "ID Dokter", "Nama Dokter","Email", "Spesialisasi","  no HP", "Biaya Konsultasi"
            );
            System.out.println("-----------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                String idDokter = rs.getString("id_dokter");
                listIdDokter.add(idDokter);

                System.out.printf(
                    "%-10s | %-15s | %-18s | %-17s | %-12s | %-10s\n",
                    idDokter,
                    rs.getString("nama_dokter").toUpperCase(),
                    rs.getString("email"),
                    rs.getString("spesialisasi"),
                    rs.getString("no_hp"),
                    rs.getDouble("biaya_konsultasi")
                );
            }

            System.out.println("\nTotal data dokter : " + listIdDokter.size());

        } catch (Exception e) {
            System.out.println("\nGagal tampil dokter");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukan ID Dokter yang akan diupdate: ");
            String id = input.nextLine();

            System.out.print("ID Dokter Baru: ");
            String idDokter = input.nextLine();
            
            System.out.print("Nama Dokter Baru: ");
            String nama = input.nextLine();

            System.out.print("Email Baru: ");
            String email = input.nextLine();

            System.out.print("Spesialisasi Baru: ");
            String spesialisasi = input.nextLine();

            System.out.print("No HP Baru: ");
            String noHp = input.nextLine();

            System.out.print("Biaya Baru: ");
            double biaya = input.nextDouble();

            String sql = "UPDATE dokter SET id_dokter=?, nama_dokter=?, email=?, spesialisasi=?, no_hp=?, biaya_konsultasi=? WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idDokter);
            ps.setString(2, nama);
            ps.setString(3, email);
            ps.setString(4, spesialisasi);
            ps.setString(5, noHp);
            ps.setDouble(6, biaya);
            ps.setString(7, id);

            ps.executeUpdate();
            System.out.println("\nData dokter diperbarui!");

        } catch (Exception e) {
            System.out.println("\nGagal update dokter!");
            e.printStackTrace();
        }
    }

    @Override
    public void hapus() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukan ID Dokter yang akan dihapus: ");
            String id = input.nextLine();

            String sql = "DELETE FROM dokter WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

            System.out.println("\nDokter dihapus!");

        } catch (Exception e) {
            System.out.println("\nGagal hapus dokter!");
            e.printStackTrace();
        }
    }
}
