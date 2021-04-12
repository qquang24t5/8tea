-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2021 at 06:52 AM
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
  `SOLUONG` int(11) NOT NULL,
  `DONVITINH` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
('CN05', 'Quản lý kho');

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
('TP', 'Trưởng phòng'),
('TT', 'Trống');

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
('231', 'TT', 'tuan', '0', '0123456389', '23/09/2000', '123456', 1),
('2313', 'TP', 'Tuan', '0', '0934045700', '23/09/2000', '123456789', 1),
('32131', 'TT', '444', '1', '0934021311', '22/04/1999', '123456789', 1),
('321313', 'TT', 'laocong', '0', '0875765211', '08/04/1999', '123456789', 1),
('60093690', 'TP', 'ramdon', '0', '0827817288', '13/03/1998', '123456789', 1),
('LMAO', 'TN', 'Truong Kute', '1', '113', '24/08/2000', 'darkdark', 1),
('NV001', 'TT', 'ABC', '0', '0986457958', '12/04/2000', '123456789', 1),
('NV20421514', 'TP', 'petruogkute', '0', '0975786211', '17/04/1997', '123456789', 1),
('NV35569663', 'TP', 'tranducbo', '0', '0972877166', '18/04/1997', '123456789', 1),
('NV43240710', 'TN', 'lololo', '0', '0927182311', '08/04/1998', '123456789', 1),
('NV72837659', 'TP', 'trieugay', '1', '0617455322', '16/04/1998', '123456789', 2),
('NV77434461', 'TP', 'dsada21', '0', '0982713133', '10/04/1997', '123456789', 1),
('QQ123', 'TP', 'Quang', '0', '0907666555', '12/04/2000', '123456789', 1),
('sdsa', 'TT', 'Linh', '1', '0934034231', '19/03/1998', '123456789', 1),
('siapa', 'TN', 'Trieu', '0', '0123456789', '27/02/2000', 'trieubaby', 1),
('tk12313', 'TT', 'kenny sang', '0', '0827124122', '10/04/1997', '123456789', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phanloainvl`
--

CREATE TABLE `phanloainvl` (
  `MALOAINVL` varchar(10) NOT NULL,
  `TENNVL` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phanloaisp`
--

CREATE TABLE `phanloaisp` (
  `MALOAISP` varchar(10) NOT NULL,
  `TENLOAISP` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
('CN01', 'TP'),
('CN02', 'TP'),
('CN01', 'TN');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` varchar(10) NOT NULL,
  `TENSP` varchar(10) NOT NULL,
  `MALOAISP` varchar(10) NOT NULL,
  `SIZE` varchar(255) NOT NULL,
  `GIABAN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Constraints for table `bangcongthuc`
--
ALTER TABLE `bangcongthuc`
  ADD CONSTRAINT `bangcongthuc_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

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
-- Constraints for table `kho`
--
ALTER TABLE `kho`
  ADD CONSTRAINT `kho_ibfk_1` FOREIGN KEY (`MALOAINVL`) REFERENCES `phanloainvl` (`MALOAINVL`),
  ADD CONSTRAINT `kho_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MALOAISP`) REFERENCES `phanloaisp` (`MALOAISP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
