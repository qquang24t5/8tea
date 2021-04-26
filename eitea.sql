-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2021 at 04:41 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eitea`
--

-- --------------------------------------------------------

--
-- Table structure for table `bangcongthuc`
--

CREATE TABLE `bangcongthuc` (
  `MASP` varchar(50) NOT NULL,
  `MANVL` varchar(11) NOT NULL,
  `SOLUONG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bangcongthuc`
--

INSERT INTO `bangcongthuc` (`MASP`, `MANVL`, `SOLUONG`) VALUES
('ET27183', 'NVL1647823', 12),
('ET27183', 'NVL4271077', 12);

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MAHD` varchar(50) NOT NULL,
  `MASP` varchar(10) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONGIA` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MAPN` varchar(10) NOT NULL,
  `MANVL` varchar(10) NOT NULL,
  `DONGIANHAP` double NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVITINH` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `chucnang`
--

CREATE TABLE `chucnang` (
  `MACN` varchar(10) NOT NULL,
  `TENCN` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chucnang`
--

INSERT INTO `chucnang` (`MACN`, `TENCN`) VALUES
('CN01', 'Quản lý sản phẩm'),
('CN02', 'Quản lý nhân viên'),
('CN03', 'Lập hóa đơn'),
('CN04', 'Quản lý công thức'),
('CN05', 'Quản lý kho'),
('CN06', 'Quản lý chức vụ / chức năng');

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `MACV` varchar(10) NOT NULL,
  `TENCV` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`MACV`, `TENCV`) VALUES
('TN', 'Thu ngân'),
('TP', 'Trưởng phòng');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` varchar(10) NOT NULL,
  `MANV` varchar(10) NOT NULL,
  `NGAYTAO` date NOT NULL,
  `MAKM` varchar(10) NOT NULL,
  `TONGTIEN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kho`
--

CREATE TABLE `kho` (
  `MANVL` varchar(10) NOT NULL,
  `MALOAINVL` varchar(10) NOT NULL,
  `TENNVL` varchar(30) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVITINH` varchar(10) NOT NULL,
  `DONGIANHAP` double NOT NULL,
  `MANCC` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kho`
--

INSERT INTO `kho` (`MANVL`, `MALOAINVL`, `TENNVL`, `SOLUONG`, `DONVITINH`, `DONGIANHAP`, `MANCC`) VALUES
('NVL1647823', 'LNVL876821', 'Trân châu', 100, 'kg', 15000, 'NCC7376140'),
('NVL4271077', 'LNVL876821', 'Đường', 100, 'kg', 20000, 'NCC6001358'),
('NVL8138825', 'LNVL344887', 'xyz', 675, 'xyz', 789, 'NCC7376140');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MAKM` varchar(10) NOT NULL,
  `TENCTKM` int(50) NOT NULL,
  `PHANTRAMKM` float NOT NULL,
  `NGAYBD` date NOT NULL,
  `NGAYKT` date NOT NULL,
  `TRANGTHAI` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MANCC` varchar(10) NOT NULL,
  `TENNCC` varchar(30) NOT NULL,
  `SDT` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MANCC`, `TENNCC`, `SDT`) VALUES
('NCC2826767', 'Jack', '0946168964'),
('NCC6001358', 'Bill', '09003615936'),
('NCC7376140', 'Emma', '0919463412'),
('NCC8853644', 'dd', '0907666333');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` varchar(10) NOT NULL,
  `MACV` varchar(10) NOT NULL,
  `HOTEN` varchar(30) NOT NULL,
  `GIOITINH` varchar(10) NOT NULL,
  `SDT` varchar(255) NOT NULL,
  `NGAYSINH` varchar(30) NOT NULL,
  `MATKHAU` varchar(255) NOT NULL,
  `TRANGTHAI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `MACV`, `HOTEN`, `GIOITINH`, `SDT`, `NGAYSINH`, `MATKHAU`, `TRANGTHAI`) VALUES
('231', 'TP', 'Tuan', '0', '0123456389', '23/09/2000', '123456', 1),
('LMAO', 'TP', 'Trường kute', '0', '0903615936', '24/08/2000', 'darkdark', 1),
('siapa', 'TN', 'Trieu', '0', '0123456789', '27/02/2000', 'trieubaby', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phanloainvl`
--

CREATE TABLE `phanloainvl` (
  `MALOAINVL` varchar(10) NOT NULL,
  `TENLOAINVL` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phanloainvl`
--

INSERT INTO `phanloainvl` (`MALOAINVL`, `TENLOAINVL`) VALUES
('LNVL344887', 'Trà'),
('LNVL876821', 'Bột');

-- --------------------------------------------------------

--
-- Table structure for table `phanloaisp`
--

CREATE TABLE `phanloaisp` (
  `MALOAISP` varchar(10) NOT NULL,
  `TENLOAISP` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phanloaisp`
--

INSERT INTO `phanloaisp` (`MALOAISP`, `TENLOAISP`) VALUES
('LSP13737', 'Đá xay'),
('LSP83272', 'Trà trái cây'),
('LSP98931', 'CAFE');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MAPN` varchar(10) NOT NULL,
  `MANV` varchar(10) NOT NULL,
  `MANCC` varchar(10) NOT NULL,
  `NGAYNHAP` date NOT NULL,
  `TONGTIEN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `quyen_chucnang`
--

CREATE TABLE `quyen_chucnang` (
  `MACN` varchar(10) NOT NULL,
  `MACV` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quyen_chucnang`
--

INSERT INTO `quyen_chucnang` (`MACN`, `MACV`) VALUES
('CN01', 'TN'),
('CN03', 'TN'),
('CN04', 'TN'),
('CN01', 'TP'),
('CN02', 'TP'),
('CN04', 'TP'),
('CN05', 'TP'),
('CN06', 'TP');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` varchar(40) NOT NULL,
  `TENSP` varchar(40) NOT NULL,
  `MALOAISP` varchar(10) NOT NULL,
  `GIABAN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `MALOAISP`, `GIABAN`) VALUES
('ET27183', 'Trà đào', 'LSP83272', 25000),
('SP21847', 'Trà dâu', 'LSP83272', 30000),
('SP82787', 'Kiwi đá xay', 'LSP13737', 35000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bangcongthuc`
--
ALTER TABLE `bangcongthuc`
  ADD KEY `MASP` (`MASP`);

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MASP` (`MASP`),
  ADD KEY `MAHD` (`MAHD`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `MANVL` (`MANVL`),
  ADD KEY `MAPN` (`MAPN`);

--
-- Indexes for table `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`MACN`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MACV`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKM` (`MAKM`);

--
-- Indexes for table `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`MANVL`),
  ADD KEY `MALOAINVL` (`MALOAINVL`),
  ADD KEY `MANCC` (`MANCC`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MAKM`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MANCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`,`SDT`),
  ADD KEY `MACV` (`MACV`);

--
-- Indexes for table `phanloainvl`
--
ALTER TABLE `phanloainvl`
  ADD PRIMARY KEY (`MALOAINVL`);

--
-- Indexes for table `phanloaisp`
--
ALTER TABLE `phanloaisp`
  ADD PRIMARY KEY (`MALOAISP`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPN`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MANCC` (`MANCC`);

--
-- Indexes for table `quyen_chucnang`
--
ALTER TABLE `quyen_chucnang`
  ADD KEY `MACN` (`MACN`),
  ADD KEY `MANV` (`MACV`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`),
  ADD KEY `MALOAISP` (`MALOAISP`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`);

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MANVL`) REFERENCES `kho` (`MANVL`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MAPN`) REFERENCES `phieunhap` (`MAPN`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MAKM`) REFERENCES `khuyenmai` (`MAKM`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
