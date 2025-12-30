-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 30, 2025 at 01:52 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_klinik`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` varchar(20) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `spesialisasi` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `biaya_konsultasi` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `email`, `spesialisasi`, `no_hp`, `biaya_konsultasi`) VALUES
('DKT001', 'sarah amelia', 'sarahamelia@gmsil', 'umum', '081234567890', 100000),
('DKT002', 'budi santoso', 'budisantoso@gmail', 'anak', '082435465768', 125000),
('DKT003', 'rudi hartono', 'rudihartono@gmail', 'penyakit dalam', '081221233234', 150000);

-- --------------------------------------------------------

--
-- Table structure for table `kunjungan`
--

CREATE TABLE `kunjungan` (
  `id_kunjungan` varchar(20) NOT NULL,
  `id_pasien` varchar(20) DEFAULT NULL,
  `id_dokter` varchar(20) DEFAULT NULL,
  `tanggal_kunjungan` date DEFAULT NULL,
  `keluhan` text,
  `diagnosa` text,
  `resep` text,
  `biaya_konsultasi` double DEFAULT NULL,
  `biaya_obat` double DEFAULT NULL,
  `biaya_total` double DEFAULT NULL,
  `status` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kunjungan`
--

INSERT INTO `kunjungan` (`id_kunjungan`, `id_pasien`, `id_dokter`, `tanggal_kunjungan`, `keluhan`, `diagnosa`, `resep`, `biaya_konsultasi`, `biaya_obat`, `biaya_total`, `status`) VALUES
('KJG001', 'PSN001', 'DKT001', '2025-12-30', 'demam', 'flu', 'paracetamol', 100000, 10000, 110000, 'proses'),
('KJG002', 'PSN002', 'DKT002', '2025-12-30', 'pilek', 'ispa', 'amoxillin', 125000, 20000, 145000, 'proses'),
('KJG003', 'PSN003', 'DKT003', '2025-12-30', 'nyeri perut', 'maag', 'vitamin c', 150000, 10000, 160000, 'selesai');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` varchar(20) NOT NULL,
  `nama_obat` varchar(100) NOT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `stok` int DEFAULT NULL,
  `harga` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `kategori`, `stok`, `harga`) VALUES
('OBT001', 'paracetamol', 'analgesik', 100, 5000),
('OBT002', 'amoxcillin', 'antibiotik', 50, 10000),
('OBT003', 'vitamin c', 'vitamin', 150, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` varchar(20) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text,
  `tanggal_lahir` date DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `tanggal_daftar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `email`, `no_hp`, `alamat`, `tanggal_lahir`, `jenis_kelamin`, `tanggal_daftar`) VALUES
('PSN001', 'ani', 'ani@gmail', '082391283905', 'padang', '2005-12-20', 'perempuan', '2025-12-30'),
('PSN002', 'budi', 'budi@gmail', '082143658709', 'padang', '2006-06-17', 'laki-laki', '2025-12-30'),
('PSN003', 'caca', 'caca@gmail', '081324354657', 'padang', '2006-02-18', 'perempuan', '2025-12-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indexes for table `kunjungan`
--
ALTER TABLE `kunjungan`
  ADD PRIMARY KEY (`id_kunjungan`),
  ADD KEY `fk_pasien` (`id_pasien`),
  ADD KEY `fk_dokter` (`id_dokter`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kunjungan`
--
ALTER TABLE `kunjungan`
  ADD CONSTRAINT `fk_dokter` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
