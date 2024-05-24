-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 06:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medico`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_staff`
--

CREATE TABLE `admin_staff` (
  `a_id` int(100) NOT NULL,
  `a_name` varchar(100) NOT NULL,
  `a_email` varchar(100) NOT NULL,
  `a_contact` varchar(100) NOT NULL,
  `a_username` varchar(100) NOT NULL,
  `a_pass` varchar(100) NOT NULL,
  `a_gender` varchar(100) NOT NULL,
  `a_type` varchar(100) NOT NULL,
  `a_status` varchar(100) NOT NULL,
  `a_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_staff`
--

INSERT INTO `admin_staff` (`a_id`, `a_name`, `a_email`, `a_contact`, `a_username`, `a_pass`, `a_gender`, `a_type`, `a_status`, `a_image`) VALUES
(2, 'Jaijai Candia', 'jai1@ph.com', '09686155441', 'jai', 'lV7gNW9OXoeprmpqgM/SXFw72/9L7r28zyRzr7G42X0=', 'Female', 'Admin', 'Active', 'src/userimages/CATT.jpg'),
(4, 'James Arpilang', 'jaes234@ph.com', '09787765654', 'james', 'ZRMS2FXUMttzwVsV8QPrOYqFs9jZXl1tJw52vpfnlkY=', 'Male', 'Pharmacist', 'Archive', ''),
(5, 'Ava Benzon', 'ava2@gma.com', '09778765432', 'ava', 'KKH9i9Pcox70NiUaLNWmK7unniCWZeGSqhcyqu2jjUM=', 'Male', 'Pharmacist', 'Archive', ''),
(6, 'Aiden', 'ai3@.com', '09887676565', 'ai', 'EtArMgMzHi6yc/0s2KdizqotcIH2O1/E1k+typp9X3s=', 'Male', 'Pharmacist', 'Active', '');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `u_id` int(100) NOT NULL,
  `u_name` varchar(100) NOT NULL,
  `u_email` varchar(100) NOT NULL,
  `u_contact` varchar(100) NOT NULL,
  `u_username` varchar(100) NOT NULL,
  `u_pass` varchar(100) NOT NULL,
  `u_gender` varchar(100) NOT NULL,
  `u_type` varchar(100) NOT NULL,
  `u_status` varchar(100) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`u_id`, `u_name`, `u_email`, `u_contact`, `u_username`, `u_pass`, `u_gender`, `u_type`, `u_status`, `u_image`) VALUES
(6, 'Jandeb', 'jan22@gmail.com', '09778786767', 'jan', 'gVrG+E0aaEOkFZ6LkDHwA3Vw+hD9+fn61zw6Q3Z0zTA=', 'Male', 'Patient', 'Archive', ''),
(8, 'Jam Anoba', 'jam2@ph.com', '09778733212', 'jam', 'Ul5FpKb4erGgCG/jjhkv1jOQKf0t5ZO2WeyMDeak13M=', 'Female', 'Patient', 'Active', '');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `n_id` int(100) NOT NULL,
  `notif` varchar(500) NOT NULL,
  `u_id` int(100) NOT NULL,
  `p_id` int(100) NOT NULL,
  `date` date NOT NULL,
  `time` time(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prescriptions`
--

CREATE TABLE `prescriptions` (
  `p_id` int(100) NOT NULL,
  `u_id` int(100) NOT NULL,
  `p_pic` varchar(100) NOT NULL,
  `p_status` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `time` time(6) NOT NULL,
  `a_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prescriptions`
--

INSERT INTO `prescriptions` (`p_id`, `u_id`, `p_pic`, `p_status`, `date`, `time`, `a_id`) VALUES
(9, 8, 'src/userimages/presciption.png', 'Received', '2024-05-23', '02:34:30.000000', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_staff`
--
ALTER TABLE `admin_staff`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`n_id`),
  ADD KEY `u_id` (`u_id`),
  ADD KEY `p_id` (`p_id`);

--
-- Indexes for table `prescriptions`
--
ALTER TABLE `prescriptions`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `u_id` (`u_id`),
  ADD KEY `a_id` (`a_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_staff`
--
ALTER TABLE `admin_staff`
  MODIFY `a_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `u_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `n_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `prescriptions`
--
ALTER TABLE `prescriptions`
  MODIFY `p_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `customer` (`u_id`),
  ADD CONSTRAINT `notification_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `prescriptions` (`p_id`);

--
-- Constraints for table `prescriptions`
--
ALTER TABLE `prescriptions`
  ADD CONSTRAINT `prescriptions_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `customer` (`u_id`),
  ADD CONSTRAINT `prescriptions_ibfk_2` FOREIGN KEY (`a_id`) REFERENCES `admin_staff` (`a_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
