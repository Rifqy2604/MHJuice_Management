-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jul 2025 pada 08.52
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mh_jus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daftar_jus`
--

CREATE TABLE `daftar_jus` (
  `nama_jus` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `daftar_jus`
--

INSERT INTO `daftar_jus` (`nama_jus`, `harga`) VALUES
('Es Jeruk', 6000),
('Jus Alpukat', 10000),
('Jus Apel', 12000),
('Jus Belimbing', 6000),
('Jus Jambu', 6000),
('Jus Kaweni', 10000),
('Jus Lemon', 10000),
('Jus Mangga Aromanis', 10000),
('Jus Melon', 6000),
('Jus Naga Merah', 12000),
('Jus Nanas', 8000),
('Jus Pear', 12000),
('Jus Pepaya', 6000),
('Jus Pisang', 8000),
('Jus Semangka', 6000),
('Jus Sirsak', 8000),
('Jus Strawberry', 10000),
('Jus Sunkist', 12000),
('Jus Tomat', 6000),
('Jus Wortel', 8000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jus`
--

CREATE TABLE `jus` (
  `id_just` int(11) NOT NULL,
  `nama_jus` varchar(20) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jus`
--

INSERT INTO `jus` (`id_just`, `nama_jus`, `id_petugas`, `tanggal`) VALUES
(29, 'Jus Alpukat', 4, '2025-07-07'),
(30, 'Jus Apel', 4, '2025-07-07'),
(31, 'Jus Jambu', 4, '2025-07-07'),
(32, 'Jus Kaweni', 4, '2025-07-07'),
(33, 'Jus Lemon', 4, '2025-07-07'),
(34, 'Jus Alpukat', 4, '2025-07-07'),
(35, 'Jus Kaweni', 4, '2025-07-07'),
(36, 'Jus Strawberry', 4, '2025-07-07'),
(37, 'Jus Sirsak', 4, '2025-07-07'),
(38, 'Jus Alpukat', 4, '2025-07-07'),
(39, 'Jus Strawberry', 4, '2025-07-07'),
(40, 'Jus Alpukat', 4, '2025-07-07'),
(41, 'Jus Jambu', 4, '2025-07-07'),
(42, 'Jus Mangga Aromanis', 4, '2024-07-07'),
(43, 'Jus Kaweni', 4, '2025-07-07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `nama_pengguna` varchar(25) NOT NULL,
  `tugas` int(11) NOT NULL,
  `kata_sandi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama_pengguna`, `tugas`, `kata_sandi`) VALUES
(1, 'rafi', 1, 'rafi'),
(2, 'admin', 2, 'admin'),
(3, 'aulia', 1, 'aulia'),
(4, 'nadira', 1, 'nadira');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `daftar_jus`
--
ALTER TABLE `daftar_jus`
  ADD PRIMARY KEY (`nama_jus`);

--
-- Indeks untuk tabel `jus`
--
ALTER TABLE `jus`
  ADD PRIMARY KEY (`id_just`),
  ADD KEY `id_petugas` (`id_petugas`),
  ADD KEY `jus_ibfk_1` (`nama_jus`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`),
  ADD UNIQUE KEY `nama_pengguna` (`nama_pengguna`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jus`
--
ALTER TABLE `jus`
  MODIFY `id_just` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jus`
--
ALTER TABLE `jus`
  ADD CONSTRAINT `jus_ibfk_1` FOREIGN KEY (`nama_jus`) REFERENCES `daftar_jus` (`nama_jus`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
