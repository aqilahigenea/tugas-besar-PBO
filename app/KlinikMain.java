package app;

import java.util.Scanner;
import service.PasienService;
import service.DokterService;
import service.KunjunganService;
import service.ObatService;

public class KlinikMain {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            // Object service (OOP)
            PasienService pasienService = new PasienService();
            DokterService dokterService = new DokterService();
            KunjunganService kunjunganService = new KunjunganService();
            ObatService obatService = new ObatService();

            int pilihMenuUtama = 0;

            // ====== LOOP MENU UTAMA ======
            while (true) {
                System.out.println("=============================");
                System.out.println("   SISTEM INFORMASI KLINIK  ");
                System.out.println("=============================");
                System.out.println("1. Manajemen Pasien");
                System.out.println("2. Manajemen Dokter");
                System.out.println("3. Manajemen Kunjungan");
                System.out.println("4. Manajemen Obat");
                System.out.println("5. Statistik & Laporan Kunjungan Harian");
                System.out.println("6. Keluar");
                System.out.println("============================");
                System.out.print("Pilih menu : ");
                pilihMenuUtama = input.nextInt();

                switch (pilihMenuUtama) {

                    // PASIEN 
                    case 1:
                        int pilihPasien;
                        do {
                            System.out.println("\n===   MANAJEMEN PASIEN   ===");
                            System.out.println("1. Tambah Pasien");
                            System.out.println("2. Lihat Pasien");
                            System.out.println("3. Update Pasien");
                            System.out.println("4. Hapus Pasien");
                            System.out.println("5. Kembali");
                            System.out.print("\nPilih menu : ");
                            pilihPasien = input.nextInt();

                            switch (pilihPasien) {
                                case 1:
                                    pasienService.tambah();
                                    break;
                                case 2:
                                    pasienService.tampil();
                                    break;
                                case 3:
                                    pasienService.update();
                                    break;
                                case 4:
                                    pasienService.hapus();
                                    break;
                                case 5:
                                    System.out.println("\nKembali ke menu utama...\n");
                                    break;
                                default:
                                    System.out.println("\nMenu tidak valid!\n");
                            }
                        } while (pilihPasien != 5);
                        break;

                    // DOKTER 
                    case 2:
                        int pilihDokter;
                        do {
                            System.out.println("\n===   MANAJEMEN DOKTER   ===");
                            System.out.println("1. Tambah Dokter");
                            System.out.println("2. Lihat Dokter");
                            System.out.println("3. Update Dokter");
                            System.out.println("4. Hapus Dokter");
                            System.out.println("5. Kembali");
                            System.out.print("Pilih menu : ");
                            pilihDokter = input.nextInt();

                            switch (pilihDokter) {
                                case 1:
                                    dokterService.tambah();
                                    break;
                                case 2:
                                    dokterService.tampil();
                                    break;
                                case 3:
                                    dokterService.update();
                                    break;
                                case 4:
                                    dokterService.hapus();
                                    break;
                                case 5:
                                    System.out.println("\nKembali ke menu utama...\n");
                                    break;
                                default:
                                    System.out.println("\nMenu tidak valid!\n");
                            }
                        } while (pilihDokter != 5);
                        break;

                    // KUNJUNGAN 
                    case 3:
                        int pilihKunjungan;
                        do {
                            System.out.println("\n===   MANAJEMEN KUNJUNGAN   ===");
                            System.out.println("1. Tambah Kunjungan");
                            System.out.println("2. Lihat Kunjungan");
                            System.out.println("3. Update Kunjungan");
                            System.out.println("4. Hapus Kunjungan");
                            System.out.println("5. Kembali");
                            System.out.print("Pilih menu : ");
                            pilihKunjungan = input.nextInt();

                            switch (pilihKunjungan) {
                                case 1:
                                    kunjunganService.tambah();
                                    break;
                                case 2:
                                    kunjunganService.tampil();
                                    break;
                                case 3:
                                    kunjunganService.update();
                                    break;
                                case 4:
                                    kunjunganService.hapus();
                                    break;
                                case 5:
                                    System.out.println("\nKembali ke menu utama...\n");
                                    break;
                                default:
                                    System.out.println("\nMenu tidak valid!\n");
                            }
                        } while (pilihKunjungan != 5);
                        break;

                    // OBAT 
                    case 4:
                        int pilihObat;
                        do {
                            System.out.println("\n===   MANAJEMEN OBAT   ===");
                            System.out.println("1. Tambah Obat");
                            System.out.println("2. Lihat Obat");
                            System.out.println("3. Update Obat");
                            System.out.println("4. Hapus Obat");
                            System.out.println("5. Kembali");
                            System.out.print("Pilih menu : ");
                            pilihObat = input.nextInt();

                            switch (pilihObat) {
                                case 1:
                                    obatService.tambah();
                                    break;
                                case 2:
                                    obatService.tampil();
                                    break;
                                case 3:
                                    obatService.update();
                                    break;
                                case 4:
                                    obatService.hapus();
                                    break;
                                case 5:
                                    System.out.println("\nKembali ke menu utama...\n");
                                    break;
                                default:
                                    System.out.println("\nMenu tidak valid\n!");
                            }
                        } while (pilihObat != 5);
                        break;

                    // STATISTIK 
                    case 5:
                        System.out.println("\n=== STATISTIK & LAPORAN HARIAN ===");
                        kunjunganService.laporanHarian();
                        break;

                    // KELUAR
                    case 6:
                        System.out.println("\nTerima kasih telah menggunakan sistem.\n");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\nMenu tidak valid!\n");
                }
            }
        }
    }
}
