-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 07 Jul 2018 pada 13.14
-- Versi Server: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ternak_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `table 1`
--

CREATE TABLE `table 1` (
  `id_ternak` varchar(2) DEFAULT NULL,
  `jenis_ternak` varchar(16) DEFAULT NULL,
  `daya_tahan` varchar(10) DEFAULT NULL,
  `waktu` varchar(17) DEFAULT NULL,
  `pemeliharaan` varchar(12) DEFAULT NULL,
  `biaya` varchar(14) DEFAULT NULL,
  `kat_biaya` varchar(10) DEFAULT NULL,
  `hasil` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `table 1`
--

INSERT INTO `table 1` (`id_ternak`, `jenis_ternak`, `daya_tahan`, `waktu`, `pemeliharaan`, `biaya`, `kat_biaya`, `hasil`) VALUES
('1', 'Nila Jica', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('2', 'Nila Jatimbulan', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('3', 'Nila Nirwana', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('4', 'Nila Larasati', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('5', 'Nila', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('6', 'Gurame Jepun', 'rendah', 'lambat', 'mudah', '10000000', 'Sedang', 'tidak cocok'),
('7', 'Gurame Kapas', 'rendah', 'lambat', 'mudah', '20000000', 'Mahal', 'cocok'),
('8', 'Gurame Batu', 'rendah', 'lambat', 'sulit', '20000000', 'Mahal', 'cocok'),
('9', 'Gurame Porselin', 'sedang', 'lambat', 'sulit', '20000000', 'Mahal', 'tidak cocok'),
('10', 'Gurame Paris', 'rendah', 'lambat', 'sulit', '20000000', 'Mahal', 'cocok'),
('11', 'Gurame Soang', 'tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('12', 'Gurame Bastar', 'tinggi', 'cepat', 'sulit', '10000000', 'Sedang', 'tidak cocok'),
('13', 'Mas Merah', 'sedang', 'cepat', 'mudah', '20000000', 'Mahal', 'tidak cocok'),
('14', 'Mas Punten', 'rendah', 'cepat', 'sulit', '5000000', 'Murah', 'cocok'),
('15', 'Mas Sinyonya', 'sedang ', 'lambat', 'sulit', '20000000', 'Mahal', 'tidak cocok'),
('16', 'Mas Taiwan', 'rendah', 'lambat', 'sulit', '20000000', 'Mahal', 'cocok'),
('17', 'Mas Majalaya', 'rendah', 'cepat', 'sulit', '20000000', 'Mahal', 'tidak cocok'),
('18', 'Mas Yamato', 'rendah', 'lambat', 'sulit', '20000000', 'Mahal', 'tidak cocok'),
('19', 'Mas Lokal', 'tinggi', 'lambat', 'mudah', '5000000', 'Murah', 'cocok'),
('20', 'Patin Lancang', 'rendah', 'lambat', 'sulit', '10000000', 'Sedang', 'tidak cocok'),
('21', 'Patin Juaro', 'sedang', 'lambat', 'sulit', '10000000', 'Sedang', 'tidak cocok'),
('22', 'Patin Siam', 'sedang', 'lambat', 'sulit', '20000000', 'Mahal', 'cocok'),
('23', 'Patin Jambal', 'rendah', 'lambat', 'sulit', '10000000', 'Sedang', 'tidak cocok'),
('24', 'Patin Wakal', 'Tinggi', 'cepat', 'mudah', '5000000', 'Murah', 'tidak cocok'),
('25', 'Patin Muncul', 'sedang', 'cepat', 'mudah', '5000000', 'Murah', 'tidak cocok'),
('26', 'Lele Dumbo', 'sedang ', 'cepat', 'mudah', '10000000', 'Sedang', 'cocok'),
('27', 'Lele Limbat', 'sedang', 'cepat', 'mudah', '5000000', 'Murah', 'cocok'),
('28', 'Lele Sangkuriang', 'Tinggi', 'cepat', 'mudah', '10000000', 'Sedang', 'cocok'),
('29', 'Lele Python', 'Tinggi', 'cepat', 'mudah', '10000000', 'Sedang', 'cocok'),
('30', 'Lele Lokal', 'tinggi', 'lambat', 'mudah', '20000000', 'Mahal', 'cocok');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
