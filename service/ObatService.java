package service;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObatService extends BaseService implements CrudService {


    @Override
    public void tambah() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nID Obat: ");
            String idObat = input.nextLine().toUpperCase();

            System.out.print("Nama Obat: ");
            String namaObat = input.nextLine();

            System.out.print("Kategori: ");
            String kategori = input.nextLine();

            System.out.print("Stok: ");
            int stok = input.nextInt();

            System.out.print("Harga: ");
            double harga = input.nextDouble();

            String sql = "INSERT INTO obat " +
                         "(id_obat, nama_obat, kategori, stok, harga) " +
                         "VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idObat);
            ps.setString(2, namaObat);
            ps.setString(3, kategori);
            ps.setInt(4, stok);
            ps.setDouble(5, harga);

            ps.executeUpdate();
            System.out.println("\nObat berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("\nGagal menambah obat!");
            e.printStackTrace();
        }
    }

    @Override
    public void tampil() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM obat");

            List<String> listIdObat = new ArrayList<>();

            System.out.printf(
                "\n%-10s | %-15s | %-15s | %-8s | %-10s\n",
                "ID Obat", "Nama Obat", "Kategori", "Stok", "Harga"
            );
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) {
                String idObat = rs.getString("id_obat");
                listIdObat.add(idObat); 
                System.out.printf(
                    "%-10s | %-15s | %-15s | %-8d | %-10.0f\n",
                    idObat,
                    rs.getString("nama_obat").toUpperCase(),
                    rs.getString("kategori"),
                    rs.getInt("stok"),
                    rs.getDouble("harga")
                    );
                }

                System.out.println("\nTotal data obat : " + listIdObat.size());

        } catch (Exception e) {
            System.out.println("\nGagal tampil obat!");
            e.printStackTrace();
        }
    }
    
    @Override
    public void update() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukan ID Obat yang akan diupdate: ");
            String id = input.nextLine();

            System.out.print("ID Obat Baru: ");
            String idObat = input.nextLine();

            System.out.print("Nama Obat Baru: ");
            String namaObat = input.nextLine();

            System.out.print("Kategori Baru: ");
            String kategori = input.nextLine();

            System.out.print("Stok Baru: ");
            int stok = input.nextInt();

            System.out.print("Harga Baru: ");
            Double harga = input.nextDouble();
            input.nextLine();

            String sql = "UPDATE obat SET id_obat=?, nama_obat=?, kategori=?, stok=?, harga=? WHERE id_obat=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idObat);
            ps.setString(2, namaObat);
            ps.setString(3, kategori);
            ps.setInt(4, stok);
            ps.setDouble(5, harga);
            ps.setString(6, id);
            ps.executeUpdate();

            System.out.println("\nStok obat diperbarui!");

        } catch (Exception e) {
            System.out.println("\nGagal update obat!");
            e.printStackTrace();
        }
    }

    @Override
    public void hapus() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.print("\nMasukan ID Obat yang akan dihapus: ");
            String id = input.nextLine();

            String sql = "DELETE FROM obat WHERE id_obat=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

            System.out.println("\nObat dihapus!");

        } catch (Exception e) {
            System.out.println("\nGagal hapus obat!");
            e.printStackTrace();
        }
    }
}
