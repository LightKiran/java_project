-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2016 at 11:03 AM
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`customer_id`, `first_name`, `middle_name`, `last_name`, `contact_no`, `address`, `email`) VALUES
(1, 'krishna', 'gopal', 'duwal', '984131522', 'mahankal', 'krishna@outlook.com'),
(2, 'shyam', '', 'tamang', '98415241700', 'new road', 'shyam@gmail.com'),
(3, 'gita', '', 'rai', '98415326400', 'jorpati', 'gita@yahoo.com'),
(4, 'karan', '', 'duwal', '98136059666', 'bhaktapur', 'karan@gmail.com'),
(5, 'sabin', '', 'shrestha', '9841523256', 'jorpati', 'sabin789@yahoo.com'),
(6, 'ajaya', '', 'tamang', '9841315226', 'maitidevi', 'ajaya@hotmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer_laptop`
--

CREATE TABLE IF NOT EXISTS `tbl_customer_laptop` (
  `customer_id` int(10) NOT NULL,
  `laptop_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer_laptop`
--

INSERT INTO `tbl_customer_laptop` (`customer_id`, `laptop_id`) VALUES
(1, 2),
(3, 2),
(4, 2),
(2, 3),
(5, 3);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer_transaction`
--

INSERT INTO `tbl_customer_transaction` (`customer_transaction_id`, `paid`, `due`, `total_cost`, `date`, `time`, `customer_id`) VALUES
(1, '50000', '0', '50000', '2016-09-28', '01:34:55', 1),
(2, '70000', '10000', '60000', '2016-09-30', '01:35:22', 2),
(4, '70000', '', '70000', '2016-10-11', '14:19:49', 6);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_laptop`
--

INSERT INTO `tbl_laptop` (`laptop_id`, `model_no`, `harddisk`, `ram`, `graphics`, `generation`, `processor`, `price`, `laptopbrand_id`) VALUES
(1, '5537', '500 GB', '4 GB', '2 GB', '4 th', 'i7', '45000.0', 1),
(2, '3542', '1 TB', '4 GB', '2 GB', '5 th', 'i5', '60000.0', 2),
(3, '5576', '1 TB', '8 GB', '4 GB', '5 th', 'i7', '80000.0', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_laptopbrand`
--

CREATE TABLE IF NOT EXISTS `tbl_laptopbrand` (
`laptopbrand_id` int(3) NOT NULL,
  `brandname` varchar(15) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_laptopbrand`
--

INSERT INTO `tbl_laptopbrand` (`laptopbrand_id`, `brandname`) VALUES
(1, 'dell'),
(2, 'hp'),
(3, 'alienware'),
(4, 'mac'),
(5, 'tosiba');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order`
--

INSERT INTO `tbl_order` (`order_id`, `peices`, `date`, `time`, `laptop_id`) VALUES
(1, '20', '2016-10-23', '12:23:53', 1),
(2, '10', '2016-10-23', '12:25:16', 3),
(3, '5', '2016-10-23', '12:25:57', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_supplier`
--

CREATE TABLE IF NOT EXISTS `tbl_order_supplier` (
  `order_id` int(10) NOT NULL,
  `supplier_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order_supplier`
--

INSERT INTO `tbl_order_supplier` (`order_id`, `supplier_id`) VALUES
(1, 2),
(2, 3),
(3, 4);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order_transaction`
--

INSERT INTO `tbl_order_transaction` (`supplier_transaction_id`, `paid`, `due`, `total_cost`, `date`, `time`, `order_id`) VALUES
(1, '1500000', '100000', '1600000', '2016-10-23', '12:24:44', 1),
(2, '1200000', '', '1200000', '2016-10-23', '12:25:38', 2),
(3, '600000', '', '600000', '2016-10-23', '12:26:15', 3);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_supplier`
--

INSERT INTO `tbl_supplier` (`supplier_id`, `first_name`, `middle_name`, `last_name`, `contact_no`, `address`, `email`) VALUES
(1, 'ram', 'bahadur', 'shrestha', '9841522756', 'jamal', 'ram@yahoo.com'),
(2, 'shyam', '', 'rai', '9841522648', 'bhaktapur', 'shyam34@hotmail.com'),
(3, 'hari', '', 'tamang', '9803700945', 'new road', 'hari47@outlook.com'),
(4, 'jack', '', 'maharjan', '9808122566', 'new road', 'jack478@gmail.com');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `first_name`, `middle_name`, `last_name`, `contact_no`, `address`, `email`, `login_name`, `login_password`, `role_id`) VALUES
(1, 'kiran', '', 'duwal', '9841315222', 'boudha', 'kiran@gmail.com', 'admin', 'admin', 1),
(2, 'hari', 'bhadur', 'rai', '9803700978', 'maitidev', 'hari@hotmail.com', 'staff', 'staff', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_customer_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_user_customer_transaction` (
  `user_id` int(3) NOT NULL DEFAULT '0',
  `customer_transaction_id` int(10) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
 ADD PRIMARY KEY (`customer_id`,`laptop_id`), ADD KEY `laptop_id` (`laptop_id`), ADD KEY `customer_id` (`customer_id`);

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
 ADD PRIMARY KEY (`user_id`,`customer_transaction_id`), ADD KEY `fk_tbl_user_has_tbl_customer_transaction_tbl_customer_transac1` (`customer_transaction_id`), ADD KEY `fk_tbl_user_has_tbl_customer_transaction_tbl_user1` (`user_id`), ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
MODIFY `customer_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_customer_transaction`
--
ALTER TABLE `tbl_customer_transaction`
MODIFY `customer_transaction_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_laptop`
--
ALTER TABLE `tbl_laptop`
MODIFY `laptop_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_laptopbrand`
--
ALTER TABLE `tbl_laptopbrand`
MODIFY `laptopbrand_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_order_transaction`
--
ALTER TABLE `tbl_order_transaction`
MODIFY `supplier_transaction_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_supplier`
--
ALTER TABLE `tbl_supplier`
MODIFY `supplier_id` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
MODIFY `user_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_customer_laptop`
--
ALTER TABLE `tbl_customer_laptop`
ADD CONSTRAINT `tbl_customer_laptop_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `tbl_customer_laptop_ibfk_2` FOREIGN KEY (`laptop_id`) REFERENCES `tbl_laptop` (`laptop_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_customer_transaction`
--
ALTER TABLE `tbl_customer_transaction`
ADD CONSTRAINT `fk_tbl_customer_transaction_tbl_customer1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_laptop`
--
ALTER TABLE `tbl_laptop`
ADD CONSTRAINT `fk_tbl_laptop_tbl_laptopbrand1` FOREIGN KEY (`laptopbrand_id`) REFERENCES `tbl_laptopbrand` (`laptopbrand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_order`
--
ALTER TABLE `tbl_order`
ADD CONSTRAINT `fk_tbl_order_tbl_laptop1` FOREIGN KEY (`laptop_id`) REFERENCES `tbl_laptop` (`laptop_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_order_supplier`
--
ALTER TABLE `tbl_order_supplier`
ADD CONSTRAINT `fk_tbl_order_has_tbl_supplier_tbl_order1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_tbl_order_has_tbl_supplier_tbl_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `tbl_supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_order_transaction`
--
ALTER TABLE `tbl_order_transaction`
ADD CONSTRAINT `fk_tbl_supplier_transaction_tbl_order1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_user`
--
ALTER TABLE `tbl_user`
ADD CONSTRAINT `fk_tbl_user_tbl_role1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_user_customer_transaction`
--
ALTER TABLE `tbl_user_customer_transaction`
ADD CONSTRAINT `tbl_user_customer_transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `tbl_user_customer_transaction_ibfk_2` FOREIGN KEY (`customer_transaction_id`) REFERENCES `tbl_customer_transaction` (`customer_transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `tbl_user_customer_transaction_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
