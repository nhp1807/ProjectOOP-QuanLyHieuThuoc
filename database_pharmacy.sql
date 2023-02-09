-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2023 at 01:11 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('admin', '1');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `idDonThuoc` int(11) NOT NULL,
  `idKhach` int(11) NOT NULL,
  `maThuoc` varchar(30) NOT NULL,
  `tenThuoc` varchar(30) NOT NULL,
  `donGia` double NOT NULL,
  `soLuong` int(11) NOT NULL,
  `cachDung` varchar(100) NOT NULL,
  `ngayThanhToan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`idDonThuoc`, `idKhach`, `maThuoc`, `tenThuoc`, `donGia`, `soLuong`, `cachDung`, `ngayThanhToan`) VALUES
(3, 1, 'MED003', 'Bổ phế', 250000, 5, 'Dung uong', '2023-01-25'),
(4, 2, 'MED002', 'Bổ phế', 100000, 2, '2 lan 1 ngay', '2023-01-26'),
(6, 2, 'MED002', 'Bổ phế', 100000, 2, '10 vien 10 ngay', '2023-01-26'),
(7, 2, 'MED001', 'Panadol', 80000, 1, '2 vien 2 ngay', '2023-01-26'),
(8, 3, 'MED001', 'Panadol', 320000, 4, 'Eat', '2023-01-26'),
(14, 4, 'MED001', 'Panadol', 160000, 2, '1314', '2023-01-26'),
(15, 5, 'MED001', 'Panadol', 160000, 2, '10', '2023-01-26'),
(16, 5, 'MED002', 'Bổ phế', 50000, 1, 'Hit', '2023-01-26'),
(17, 6, 'MED003', 'KIT Test Covid', 50000, 1, 'Hit', '2023-01-26'),
(18, 7, 'MED001', 'Panadol', 400000, 5, 'Uong 2 lan 1 ngay', '2023-01-27'),
(19, 8, 'MED001', 'Panadol', 80000, 1, '', '2023-01-27'),
(20, 9, 'MED001', 'Panadol', 240000, 3, 'Eat', '2023-01-27'),
(21, 10, 'MED003', 'KIT Test Covid', 100000, 2, '15 phut', '2023-01-27'),
(22, 11, 'MED001', 'Panadol', 160000, 2, '2 vien 1 ngay', '2023-01-27'),
(23, 12, 'MED002', 'Bổ phế', 100000, 2, '3-4 lần 1 ngày', '2023-01-27'),
(24, 13, 'MED002', 'Bổ phế', 50000, 1, 'Uống', '2023-01-28'),
(25, 13, 'MED001', 'Panadol', 160000, 2, 'Uống', '2023-01-28'),
(26, 14, 'MED001', 'Panadol', 80000, 1, 'Ngày 2 viên', '2023-01-28'),
(27, 15, 'MED001', 'Panadol', 80000, 1, 'Uống 2 viên 1 ngày', '2023-01-28'),
(29, 15, 'MED003', 'KIT Test Covid', 50000, 1, 'Chọc vào mồm', '2023-01-28'),
(30, 16, 'MED001', 'Panadol', 320000, 4, '', '2023-01-30'),
(31, 17, 'MED002', 'Bổ phế', 150000, 3, 'Uống', '2023-01-30'),
(32, 18, 'MED001', 'Panadol', 80000, 1, 'Uống', '2023-01-30'),
(33, 18, 'MED003', 'KIT Test Covid', 100000, 2, 'Đút vào mồm', '2023-01-30');

-- --------------------------------------------------------

--
-- Table structure for table `donhang_info`
--

CREATE TABLE `donhang_info` (
  `idDonThuoc` int(11) NOT NULL,
  `idKhach` int(11) NOT NULL,
  `tongTien` double NOT NULL,
  `ngayThanhToan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donhang_info`
--

INSERT INTO `donhang_info` (`idDonThuoc`, `idKhach`, `tongTien`, `ngayThanhToan`) VALUES
(1, 1, 250000, '2023-01-26'),
(2, 2, 280000, '2023-01-26'),
(3, 3, 320000, '2023-01-26'),
(4, 4, 160000, '2023-01-26'),
(5, 5, 210000, '2023-01-26'),
(6, 6, 50000, '2023-01-26'),
(7, 7, 400000, '2023-01-27'),
(8, 8, 80000, '2023-01-27'),
(9, 9, 240000, '2023-01-27'),
(10, 10, 100000, '2023-01-27'),
(11, 11, 160000, '2023-01-27'),
(12, 12, 100000, '2023-01-27'),
(13, 13, 210000, '2023-01-28'),
(14, 14, 80000, '2023-01-28'),
(15, 15, 130000, '2023-01-28'),
(16, 16, 320000, '2023-01-30'),
(17, 17, 150000, '2023-01-30'),
(18, 18, 180000, '2023-01-30');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `maThuoc` varchar(10) NOT NULL,
  `tenThuoc` varchar(50) NOT NULL,
  `nsx` date NOT NULL,
  `hsd` date NOT NULL,
  `donGia` double NOT NULL,
  `thuongHieu` varchar(30) NOT NULL,
  `loai` varchar(10) NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`maThuoc`, `tenThuoc`, `nsx`, `hsd`, `donGia`, `thuongHieu`, `loai`, `soLuong`) VALUES
('MED001', 'Panadol', '2022-01-14', '2023-01-14', 80000, 'VN', 'Viên', 100),
('MED002', 'Bổ phế', '2022-01-01', '2024-01-01', 50000, 'VN', 'Nước', 50),
('MED003', 'KIT Test Covid', '2022-01-30', '2025-01-30', 50000, 'USA', 'Bột', 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`idDonThuoc`);

--
-- Indexes for table `donhang_info`
--
ALTER TABLE `donhang_info`
  ADD PRIMARY KEY (`idDonThuoc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `idDonThuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `donhang_info`
--
ALTER TABLE `donhang_info`
  MODIFY `idDonThuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
