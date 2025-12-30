package service;

import database.DatabaseConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KunjunganService extends BaseService implements CrudService {


    @Override
    public void tambah() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nID Kunjungan: ");
            String idKunjungan = input.nextLine().toUpperCase();

            System.out.print("ID Pasien: ");
            String idPasien = input.nextLine();

            System.out.print("ID Dokter: ");
            String idDokter = input.nextLine();

            System.out.print("Tanggal Kunjungan: ");
            LocalDate tanggalKunjungan = LocalDate.parse(input.nextLine());

            System.out.print("Keluhan: ");
            String keluhan = input.nextLine();

            System.out.print("Diagnosa: ");
            String diagnosa = input.nextLine();

            System.out.print("Resep: ");
            String resep = input.nextLine();

            System.out.print("Biaya Konsultasi: ");
            double biayaKonsultasi = input.nextDouble();

            System.out.print("Biaya Obat: ");
            double biayaObat = input.nextDouble();

            double biayaTotal = biayaKonsultasi + biayaObat; // perhitungan
            input.nextLine();

            System.out.print("status: ");
            String status = input.nextLine();

            String sql = "INSERT INTO kunjungan " +
                        "(id_kunjungan, id_pasien, id_dokter, tanggal_kunjungan, keluhan, diagnosa, resep, biaya_konsultasi, biaya_obat, biaya_total, status) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKunjungan);
            ps.setString(2, idPasien);
            ps.setString(3, idDokter);
            ps.setDate(4, Date.valueOf(tanggalKunjungan));
            ps.setString(5, keluhan);
            ps.setString(6, diagnosa);
            ps.setString(7, resep);
            ps.setDouble(8, biayaKonsultasi);
            ps.setDouble(9, biayaObat);
            ps.setDouble(10, Double.valueOf(biayaTotal));
            ps.setString(11, status);

            ps.executeUpdate();
            System.out.println("\nKunjungan berhasil dicatat!");

        } catch (Exception e) {
            System.out.println("\nGagal tambah kunjungan!");
            e.printStackTrace();
        }
    }

    @Override
    public void tampil() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kunjungan");

            List<String> listIdKunjungan = new ArrayList<>();

            System.out.printf(
                "\n%-7s | %-7s | %-7s | %-10s | %-12s | %-10s | %-12s | %-8s | %-8s | %-8s | %-10s\n",
                "ID Kunj", "ID Pas", "ID Dok", "Tgl Kunj", "Keluhan", "Diagnosa", "Resep", "B Konsul", "B Obat", "B Total", "Status"
            );
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                String idKunjungan = rs.getString("id_kunjungan");
                listIdKunjungan.add(idKunjungan);

                System.out.printf(
                    "%-7s | %-7s | %-7s | %-10s | %-12s | %-10s | %-12s | %-8s | %-8s | %-8s | %-10s\n",
                    idKunjungan,
                    rs.getString("id_pasien"),
                    rs.getString("id_dokter"),
                    rs.getDate("tanggal_kunjungan"),
                    rs.getString("keluhan"),
                    rs.getString("diagnosa"),
                    rs.getString("resep"),
                    rs.getDouble("biaya_konsultasi"),
                    rs.getDouble("biaya_obat"),
                    rs.getDouble("biaya_total"),
                    rs.getString("status")
                );
            }

            System.out.println("\nTotal data kunjungan : " + listIdKunjungan.size());

        } catch (Exception e) {
            System.out.println("\nGagal tampil kunjungan!");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukan ID Kunjungan yang akan diupdate: ");
            String id = input.nextLine();

            System.out.print("ID Kunjungan Baru: ");
            String idKunjungan = input.nextLine();

            System.out.print("ID Pasien Baru: ");
            String idPasien = input.nextLine();

            System.out.print("ID Dokter Baru: ");
            String idDokter = input.nextLine();

            System.out.print("Tanggal Kunjungan Baru: ");
            String tanggalKunjungan = input.nextLine();

            System.out.print("Keluhan Baru: ");
            String keluhan = input.nextLine();

            System.out.print("Diagnosa Baru: ");
            String diagnosa = input.nextLine();

            System.out.print("Resep Baru: ");
            String resep = input.nextLine();
            
            System.out.print("Biaya Konsultasi Baru: ");
            double biayaKonsultasi = input.nextDouble();
            
            System.out.print("Biaya Obat Baru: ");
            Double biayaObat = input.nextDouble();
            
            Double biayaTotal = biayaKonsultasi + biayaObat; 
            input.nextLine();
            
            System.out.print("Status Baru : ");
            String status = input.nextLine();

            String sql = "UPDATE kunjungan SET id_kunjungan=?, id_pasien=?, id_dokter=?, tanggal_kunjungan=?, keluhan=?, diagnosa=?, resep=?, biaya_konsultasi=?, biaya_obat=?, biaya_total=?, status=? WHERE id_kunjungan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKunjungan);
            ps.setString(2, idPasien);
            ps.setString(3, idDokter);
            ps.setString(4, tanggalKunjungan);
            ps.setString(5, keluhan);
            ps.setString(6, diagnosa);
            ps.setString(7, resep);
            ps.setDouble(8, biayaKonsultasi);
            ps.setDouble(9, biayaObat);
            ps.setDouble(10, biayaTotal);
            ps.setString(11, status);
            ps.setString(12, id);

            ps.executeUpdate();
            System.out.println("\nStatus kunjungan berhasil diupdate!");

        } catch (Exception e) {
            System.out.println("\nGagal update kunjungan!");
            e.printStackTrace();
        }
    }

    @Override
    public void hapus() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nID Kunjungan yang akan dihapus: ");
            String id = input.nextLine();

            String sql = "DELETE FROM kunjungan WHERE id_kunjungan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ps.executeUpdate();
            System.out.println("\nData kunjungan berhasil dihapus!");

        } catch (Exception e) {
            System.out.println("\nGagal hapus kunjungan!");
            e.printStackTrace();
        }
    }

    public void laporanHarian() {

        String sql = """
            SELECT id_kunjungan, id_pasien, id_dokter, status, biaya_total
            FROM kunjungan
            WHERE DATE(tanggal_kunjungan) = CURDATE()
        """;

        int totalKunjungan = 0;
        double totalPendapatan = 0;

        Map<String, Integer> statusMap = new HashMap<>();
        Map<String, Integer> dokterMap = new HashMap<>();

        System.out.println("\n========================================");
        System.out.println("        LAPORAN KUNJUNGAN HARIAN");
        System.out.println("Tanggal : " + LocalDate.now());
        System.out.println("========================================");

        System.out.println("\nDetail Kunjungan   : \n");
        System.out.printf(
            "%-12s | %-10s | %-10s | %-10s | %-10s\n",
            "ID ", "Pasien", "Dokter", "Status", "Biaya"
        );
        System.out.println("-------------------------------------------------------------");

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // ====== DATA ======
            while (rs.next()) {
                totalKunjungan++;
                totalPendapatan += rs.getDouble("biaya_total");

                String status = rs.getString("status");
                String dokter = rs.getString("id_dokter");

                statusMap.put(status, statusMap.getOrDefault(status, 0) + 1);
                dokterMap.put(dokter, dokterMap.getOrDefault(dokter, 0) + 1);

                System.out.printf(
                    "%-12s | %-10s | %-10s | %-10s | %-10.0f\n",
                    rs.getString("id_kunjungan"),
                    rs.getString("id_pasien"),
                    dokter,
                    status,
                    rs.getDouble("biaya_total")
                );
            }

        } catch (Exception e) {
            System.out.println("Gagal menampilkan laporan harian");
            e.printStackTrace();
            return;
        }


        // ====== RINGKASAN (SETELAH LOOP) ======
        System.out.println("-------------------------------------------------------------");
        System.out.println("\nTotal Kunjungan   : " + totalKunjungan);
        System.out.println("Total Pendapatan  : Rp " + totalPendapatan);

        System.out.println("\nStatus Kunjungan:");
        for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("========================================");
        System.out.println("\nTekan ENTER untuk kembali...");
        input.nextLine();
    }
}
