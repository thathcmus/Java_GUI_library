-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 09, 2022 lúc 05:17 AM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `slibrary`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `authorID` int(11) NOT NULL,
  `authorName` varchar(255) NOT NULL,
  `authorAddress` text NOT NULL,
  `authorPhone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`authorID`, `authorName`, `authorAddress`, `authorPhone`) VALUES
(6, 'nguyen van a', 'hcm', 811),
(7, 'nguyen van b', 'hn', 911);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `bookID` int(11) NOT NULL,
  `bookName` varchar(255) NOT NULL,
  `bookCat` int(11) NOT NULL,
  `bookAuthor` int(11) NOT NULL,
  `bookPublisher` int(11) NOT NULL,
  `bookContents` varchar(255) NOT NULL,
  `bookNoPages` int(11) NOT NULL,
  `bookEdition` int(11) NOT NULL,
  `bookStock` int(11) NOT NULL,
  `bookPrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`bookID`, `bookName`, `bookCat`, `bookAuthor`, `bookPublisher`, `bookContents`, `bookNoPages`, `bookEdition`, `bookStock`, `bookPrice`) VALUES
(8, 'Sách 1', 23, 6, 5, 'a', 111, 2, 100, 1000),
(10, 'B', 23, 6, 5, 'B', 123, 1, 200, 2000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `catID` int(11) NOT NULL,
  `catName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`catID`, `catName`) VALUES
(23, 'Sách Lập Trình'),
(24, 'Sách Toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lendbook`
--

CREATE TABLE `lendbook` (
  `lendID` int(11) NOT NULL,
  `lendmemID` int(11) NOT NULL,
  `lendbookID` int(11) NOT NULL,
  `lendDate` date NOT NULL,
  `lendReturn` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member`
--

CREATE TABLE `member` (
  `memID` int(11) NOT NULL,
  `memName` varchar(255) NOT NULL,
  `memAddress` varchar(255) NOT NULL,
  `memPhone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `member`
--

INSERT INTO `member` (`memID`, `memName`, `memAddress`, `memPhone`) VALUES
(4, 'Nguyen Van A', 'SG', 1),
(5, 'Nguyen Thi B', 'HN', 2),
(6, 'Tran Be C', 'HP', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `pubID` int(11) NOT NULL,
  `pubName` varchar(255) NOT NULL,
  `pubAddress` text NOT NULL,
  `pubPhone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`pubID`, `pubName`, `pubAddress`, `pubPhone`) VALUES
(5, 'Nha XB AAA', 'CM', 111),
(6, 'Nha XB ZZZ', 'SG', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `returnbook`
--

CREATE TABLE `returnbook` (
  `id` int(11) NOT NULL,
  `MemID` int(11) NOT NULL,
  `MemName` varchar(255) NOT NULL,
  `BookName` int(11) NOT NULL,
  `ReturnDate` date NOT NULL,
  `Elaps` int(11) NOT NULL,
  `Fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `returnbook`
--

INSERT INTO `returnbook` (`id`, `MemID`, `MemName`, `BookName`, `ReturnDate`, `Elaps`, `Fine`) VALUES
(10, 4, 'Nguyen Van A', 6, '2022-11-05', 4, 4000),
(11, 4, 'Nguyen Van A', 6, '2022-11-05', 4, 4000),
(12, 4, 'Nguyen Van A', 7, '2022-11-12', 0, 0),
(13, 5, 'Nguyen Thi B', 6, '2022-11-06', 3, 3000),
(14, 4, 'Nguyen Van A', 6, '2022-11-11', 0, 7000),
(15, 4, 'Nguyen Van A', 7, '2022-11-08', 1, 8000),
(16, 5, 'Nguyen Thi B', 7, '2022-11-09', 0, 10000),
(17, 4, 'Nguyen Van A', 8, '2022-11-07', 2, 3000),
(18, 4, 'Nguyen Van A', 10, '2022-11-11', 0, 14000),
(19, 5, 'Nguyen Thi B', 8, '2022-11-02', 7, 1000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorID`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`catID`);

--
-- Chỉ mục cho bảng `lendbook`
--
ALTER TABLE `lendbook`
  ADD PRIMARY KEY (`lendID`);

--
-- Chỉ mục cho bảng `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memID`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`pubID`);

--
-- Chỉ mục cho bảng `returnbook`
--
ALTER TABLE `returnbook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `authorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `bookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `catID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `lendbook`
--
ALTER TABLE `lendbook`
  MODIFY `lendID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `member`
--
ALTER TABLE `member`
  MODIFY `memID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `pubID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `returnbook`
--
ALTER TABLE `returnbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
