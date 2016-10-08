-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2016 at 03:58 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cs_00158132_kiran_duwal_cp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer`
--

CREATE TABLE IF NOT EXISTS `tbl_customer` (
`customer_id` int(10) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(17) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`customer_id`, `first_name`, `middle_name`, `last_name`, `contact_no`, `address`, `email`) VALUES
(1, '', '', '', '', 'fad', 'af'),
(2, 'daf', '', 'adf', 'adf', 'afd', 'dfa');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer_laptop`
--

CREATE TABLE IF NOT EXISTS `tbl_customer_laptop` (
  `tbl_customer_customer_id` int(10) NOT NULL,
  `tbl_laptop_laptop_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_customer_transaction` (
`customer_transaction_id` int(10) NOT NULL,
  `paid` varchar(45) DEFAULT NULL,
  `due` varchar(45) DEFAULT NULL,
  `total_cost` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `customer_id` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer_transaction`
--

INSERT INTO `tbl_customer_transaction` (`customer_transaction_id`, `paid`, `due`, `total_cost`, `date`, `time`, `customer_id`) VALUES
(1, '', '', '', '2016-10-04', '13:16:38', 2),
(2, '', '', '', '2016-10-04', '13:29:55', 2),
(3, '64', '46', '354', '2016-10-04', '13:30:54', 2),
(4, '', '', '', '2016-10-04', '13:35:30', 1),
(5, '', '', '', '2016-10-04', '13:39:08', 1),
(6, '', '65', '56', '2016-10-04', '13:41:42', 1),
(7, '', '65', '56', '2016-10-04', '13:41:49', 2),
(8, '', '', '', '2016-10-04', '13:46:24', 2),
(9, '', '', '', '2016-10-04', '13:53:09', 2),
(10, '', '', '', '2016-10-04', '13:59:55', 2),
(11, '', '', '', '2016-10-04', '14:03:35', 1),
(12, '', '', '', '2016-10-04', '14:03:44', 2),
(13, '', '', '', '2016-10-04', '14:05:16', 2),
(14, '', '', '', '2016-10-04', '14:06:22', 1),
(15, '', '', '', '2016-10-04', '14:06:53', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_laptop`
--

CREATE TABLE IF NOT EXISTS `tbl_laptop` (
`laptop_id` int(10) NOT NULL,
  `model_no` varchar(45) DEFAULT NULL,
  `harddisk` varchar(45) DEFAULT NULL,
  `ram` varchar(45) DEFAULT NULL,
  `graphics` varchar(45) DEFAULT NULL,
  `generation` varchar(45) DEFAULT NULL,
  `processor` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `laptopbrand_id` int(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_laptop`
--

INSERT INTO `tbl_laptop` (`laptop_id`, `model_no`, `harddisk`, `ram`, `graphics`, `generation`, `processor`, `price`, `laptopbrand_id`) VALUES
(1, '', '', '', 'afds', '', '', '43.0', 1),
(2, 'dsf', 'dfs', 'dfs', 'afds', '', '', '43.0', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_laptopbrand`
--

CREATE TABLE IF NOT EXISTS `tbl_laptopbrand` (
`laptopbrand_id` int(3) NOT NULL,
  `brandname` varchar(15) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_laptopbrand`
--

INSERT INTO `tbl_laptopbrand` (`laptopbrand_id`, `brandname`) VALUES
(1, 'dell');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE IF NOT EXISTS `tbl_order` (
`order_id` int(10) NOT NULL,
  `peices` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `laptop_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_supplier`
--

CREATE TABLE IF NOT EXISTS `tbl_order_supplier` (
  `order_id` int(10) NOT NULL,
  `supplier_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_order_transaction` (
`supplier_transaction_id` int(5) NOT NULL,
  `paid` varchar(45) DEFAULT NULL,
  `due` varchar(45) DEFAULT NULL,
  `total_cost` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `order_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_role`
--

CREATE TABLE IF NOT EXISTS `tbl_role` (
  `role_id` int(1) NOT NULL,
  `role_type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_role`
--

INSERT INTO `tbl_role` (`role_id`, `role_type`) VALUES
(1, 'admin'),
(2, 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_supplier`
--

CREATE TABLE IF NOT EXISTS `tbl_supplier` (
`supplier_id` int(2) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE IF NOT EXISTS `tbl_user` (
`user_id` int(3) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `login_name` varchar(45) DEFAULT NULL,
  `login_password` varchar(45) DEFAULT NULL,
  `role_id` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `first_name`, `middle_name`, `last_name`, `contact_no`, `address`, `email`, `login_name`, `login_password`, `role_id`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, NULL, 'a', 'a', 1),
(2, NULL, NULL, NULL, NULL, NULL, NULL, 's', 's', 2),
(3, '', '', '', '', '', '', '', '', 1),
(4, '', '', '', '', '', '', 'ss', 'ss', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_customer_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_user_customer_transaction` (
  `user_id` int(3) NOT NULL DEFAULT '0',
  `customer_transaction_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user_customer_transaction`
--

INSERT INTO `tbl_user_customer_transaction` (`user_id`, `customer_transaction_id`) VALUES
(3, 10),
(3, 14),
(1, 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
 ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `tbl_customer_laptop`
--
ALTER TABLE `tbl_customer_laptop`
 ADD PRIMARY KEY (`tbl_customer_customer_id`,`tbl_laptop_laptop_id`), ADD KEY `fk_tbl_customer_has_tbl_laptop_tbl_laptop1` (`tbl_laptop_laptop_id`), ADD KEY `fk_tbl_customer_has_tbl_laptop_tbl_customer1` (`tbl_customer_customer_id`);

--
-- Indexes for table `tbl_customer_transaction`
--
ALTER TABLE `tbl_customer_transaction`
 ADD PRIMARY KEY (`customer_transaction_id`), ADD KEY `fk_tbl_customer_transaction_tbl_customer1` (`customer_id`);

--
-- Indexes for table `tbl_laptop`
--
ALTER TABLE `tbl_laptop`
 ADD PRIMARY KEY (`laptop_id`), ADD KEY `fk_tbl_laptop_tbl_laptopbrand1` (`laptopbrand_id`);

--
-- Indexes for table `tbl_laptopbrand`
--
ALTER TABLE `tbl_laptopbrand`
 ADD PRIMARY KEY (`laptopbrand_id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
 ADD PRIMARY KEY (`order_id`), ADD KEY `fk_tbl_order_tbl_laptop1` (`laptop_id`);

--
-- Indexes for table `tbl_order_supplier`
--
ALTER TABLE `tbl_order_supplier`
 ADD PRIMARY KEY (`order_id`,`supplier_id`), ADD KEY `fk_tbl_order_has_tbl_supplier_tbl_supplier1` (`supplier_id`), ADD KEY `fk_tbl_order_has_tbl_supplier_tbl_order1` (`order_id`);

--
-- Indexes for table `tbl_order_transaction`
--
ALTER TABLE `tbl_order_transaction`
 ADD PRIMARY KEY (`supplier_transaction_id`,`order_id`), ADD KEY `fk_tbl_supplier_transaction_tbl_order1` (`order_id`);

--
-- Indexes for table `tbl_role`
--
ALTER TABLE `tbl_role`
 ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `tbl_supplier`
--
ALTER TABLE `tbl_supplier`
 ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
 ADD PRIMARY KEY (`user_id`), ADD KEY `fk_tbl_user_tbl_role1` (`role_id`);

--
-- Indexes for table `tbl_user_customer_transaction`
--
ALTER TABLE `tbl_user_customer_transaction`
 ADD PRIMARY KEY (`user_id`,`customer_transaction_id`), ADD KEY `fk_tbl_user_has_tbl_customer_transaction_tbl_customer_transac1` (`customer_transaction_id`), ADD KEY `fk_tbl_user_has_tbl_customer_transaction_tbl_user1` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
MODIFY `customer_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_customer_transaction`
--
ALTER TABLE `tbl_customer_transaction`
MODIFY `customer_transaction_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tbl_laptop`
--
ALTER TABLE `tbl_laptop`
MODIFY `laptop_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_laptopbrand`
--
ALTER TABLE `tbl_laptopbrand`
MODIFY `laptopbrand_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_order_transaction`
--
ALTER TABLE `tbl_order_transaction`
MODIFY `supplier_transaction_id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_supplier`
--
ALTER TABLE `tbl_supplier`
MODIFY `supplier_id` int(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
MODIFY `user_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_customer_laptop`
--
ALTER TABLE `tbl_customer_laptop`
ADD CONSTRAINT `fk_tbl_customer_has_tbl_laptop_tbl_customer1` FOREIGN KEY (`tbl_customer_customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_customer_has_tbl_laptop_tbl_laptop1` FOREIGN KEY (`tbl_laptop_laptop_id`) REFERENCES `tbl_laptop` (`laptop_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_customer_transaction`
--
ALTER TABLE `tbl_customer_transaction`
ADD CONSTRAINT `fk_tbl_customer_transaction_tbl_customer1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_laptop`
--
ALTER TABLE `tbl_laptop`
ADD CONSTRAINT `fk_tbl_laptop_tbl_laptopbrand1` FOREIGN KEY (`laptopbrand_id`) REFERENCES `tbl_laptopbrand` (`laptopbrand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_order`
--
ALTER TABLE `tbl_order`
ADD CONSTRAINT `fk_tbl_order_tbl_laptop1` FOREIGN KEY (`laptop_id`) REFERENCES `tbl_laptop` (`laptop_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_order_supplier`
--
ALTER TABLE `tbl_order_supplier`
ADD CONSTRAINT `fk_tbl_order_has_tbl_supplier_tbl_order1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_order_has_tbl_supplier_tbl_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `tbl_supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_order_transaction`
--
ALTER TABLE `tbl_order_transaction`
ADD CONSTRAINT `fk_tbl_supplier_transaction_tbl_order1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_user`
--
ALTER TABLE `tbl_user`
ADD CONSTRAINT `fk_tbl_user_tbl_role1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_user_customer_transaction`
--
ALTER TABLE `tbl_user_customer_transaction`
ADD CONSTRAINT `fk_tbl_user_has_tbl_customer_transaction_tbl_customer_transac1` FOREIGN KEY (`customer_transaction_id`) REFERENCES `tbl_customer_transaction` (`customer_transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_user_has_tbl_customer_transaction_tbl_user1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
