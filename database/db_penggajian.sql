-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2021 at 10:21 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `absen`
--

CREATE TABLE `absen` (
  `id` varchar(10) NOT NULL,
  `id_kar` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `departement` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `hadir` int(10) NOT NULL,
  `cuti` int(10) NOT NULL,
  `absen` int(10) NOT NULL,
  `sakit` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absen`
--

INSERT INTO `absen` (`id`, `id_kar`, `nama`, `jabatan`, `departement`, `tanggal`, `hadir`, `cuti`, `absen`, `sakit`) VALUES
('A0001', '345', 'Dion', 'Leader', 'Production', '2021-02-02', 28, 0, 1, 1),
('A0002', '123', 'Arum', 'Staff', 'HRD & GA', '2021-02-01', 29, 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cuti`
--

CREATE TABLE `cuti` (
  `id` varchar(10) NOT NULL,
  `id_kar` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `departement` varchar(20) NOT NULL,
  `sisa_cuti` int(10) NOT NULL,
  `tanggal` date NOT NULL,
  `cuti` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuti`
--

INSERT INTO `cuti` (`id`, `id_kar`, `nama`, `jabatan`, `departement`, `sisa_cuti`, `tanggal`, `cuti`) VALUES
('C0001', '123', 'Arum', 'Staff', 'HRD & GA', 12, '2021-02-01', 1),
('C0002', '345', 'Dion', 'Leader', 'Production', 12, '2021-02-09', 2);

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id` varchar(10) NOT NULL,
  `id_kar` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `departement` varchar(20) NOT NULL,
  `norek` varchar(20) NOT NULL,
  `namarek` varchar(30) NOT NULL,
  `hadir` varchar(20) NOT NULL,
  `gaji` int(30) NOT NULL,
  `periode` date NOT NULL,
  `bpjstk` int(30) NOT NULL,
  `bpjskes` int(30) NOT NULL,
  `tunjangan` int(30) NOT NULL,
  `pph21` int(30) NOT NULL,
  `total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id`, `id_kar`, `nama`, `jabatan`, `departement`, `norek`, `namarek`, `hadir`, `gaji`, `periode`, `bpjstk`, `bpjskes`, `tunjangan`, `pph21`, `total`) VALUES
('G0001', '123', 'Arum', 'Staff', 'HRD & GA', '122233', 'harumi', '29', 4000000, '2021-02-02', 320000, 40000, 0, 200000, 3440000),
('G0002', '345', 'Dion', 'Leader', 'Production', '23322', 'leonardo', '28', 4200000, '2021-02-02', 336000, 42000, 0, 210000, 3612000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `hp` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `pendidikan` varchar(20) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `departement` varchar(20) NOT NULL,
  `cuti` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `tgl_lahir`, `alamat`, `agama`, `jk`, `hp`, `email`, `pendidikan`, `jabatan`, `departement`, `cuti`) VALUES
('123', 'Arum', '1997-02-06', 'Jakarta', 'Kristen', 'Perempuan', '02123232', 'arum@gmail.com', 'S1', 'Staff', 'HRD & GA', 11),
('345', 'Dion', '1997-02-10', 'Depok', 'Islam', 'Laki-Laki', '085743432', 'dion@gmail.com', 'S1', 'Leader', 'Production', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `password`) VALUES
('1', 'admin', 'admin', 'admin'),
('2', 'harumi', '1234', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absen`
--
ALTER TABLE `absen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cuti`
--
ALTER TABLE `cuti`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
