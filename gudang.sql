-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for gudang
DROP DATABASE IF EXISTS `gudang`;
CREATE DATABASE IF NOT EXISTS `gudang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gudang`;

-- Dumping structure for table gudang.barang
DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(100) NOT NULL,
  `stok` int NOT NULL,
  `harga` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table gudang.barang: ~5 rows (approximately)
INSERT INTO `barang` (`id_barang`, `nama_barang`, `stok`, `harga`) VALUES
	(1, 'handphone', 17, 500000.00),
	(2, 'headset', 90, 80000.00),
	(3, 'keyboard', 76, 100000.00),
	(4, 'mouse', 22, 15000.00),
	(5, 'laptop', 34, 1000000.00),
	(6, 'kabel usb', 19, 19000.00);

-- Dumping structure for table gudang.supplier
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int NOT NULL AUTO_INCREMENT,
  `nama_supplier` varchar(100) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `kontak` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table gudang.supplier: ~6 rows (approximately)
INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `alamat`, `kontak`) VALUES
	(1, 'wafa supply', 'karang intan', '08764628'),
	(2, 'najmy supply', 'banjarbaru', '93842921'),
	(3, 'ridho supply', 'sungai sipai', '89083173'),
	(4, 'adam supply', 'tanjung', '08774294'),
	(5, 'sapik supply', 'banjarbaru', '083763472');

-- Dumping structure for table gudang.transaksi
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int NOT NULL AUTO_INCREMENT,
  `id_barang` int NOT NULL,
  `id_supplier` int NOT NULL,
  `jumlah` int NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_barang` (`id_barang`),
  KEY `id_supplier` (`id_supplier`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table gudang.transaksi: ~2 rows (approximately)
INSERT INTO `transaksi` (`id_transaksi`, `id_barang`, `id_supplier`, `jumlah`, `tanggal`) VALUES
	(1, 1, 1, 12, '2024-12-26'),
	(2, 3, 3, 11, '2024-12-26'),
	(3, 2, 4, 15, '2024-12-26');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
