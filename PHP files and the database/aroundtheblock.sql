-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2016 at 12:14 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `aroundtheblock`
--

-- --------------------------------------------------------

--
-- Table structure for table `places`
--

CREATE TABLE IF NOT EXISTS `places` (
  `placeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `apprating` varchar(255) DEFAULT NULL,
  `prices` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`placeid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=73 ;

--
-- Dumping data for table `places`
--

INSERT INTO `places` (`placeid`, `name`, `address`, `phonenumber`, `latitude`, `longitude`, `category`, `apprating`, `prices`, `website`, `email`) VALUES
(2, 'wakishop', '2 taha hussein st.', 'null', '30.0638', '31.2205', 'women clothes shop', '2.5', '2.5', 'theshelter-art.com', 'elalfy@theshelter-art.com'),
(3, 'wafflicious', '2 taha hussein st.', '1000979435', '30.0637', '31.2205', 'restaurant', '4', '3', '', ''),
(4, 'yamama kiosk ', '2 taha hussein st.', 'null ', '30.0638', '31.2206', 'kiosk', 'standard', 'standard', '', ''),
(5, 'nbk', '2 taha hussein st.', 'null', '30.0639', '31.2205', 'bank', 'standard', 'standard', '', ''),
(6, 'pet zone', '2 taha hussein st.', '1025376944', '30.0639', '31.2205', 'pet shop & clinic', '4', '3.5', '', ''),
(7, 'yamama centre', '3 taha hussein st.', 'null', '30.0636', '31.2207', 'mall', '2', '2', '', ''),
(8, 'yamama centre garage', '3 taha hussein st.', 'null', '30.0636', '31.2207', 'garage', '4', '4', '', ''),
(9, 'rigoletto', '3 taha hussein st. outside yamama centre', '27358684', '30.0636', '31.2207', 'restaurant', '4', '3', 'rigolettoicecream.com', ''),
(10, 'buffalo burger', '3 taha hussein st. outside yamama centre', '19914', '30.0636', '31.2207', 'restaurant', '4', '3', 'thebuffaloburger.com', ''),
(11, 'dandasha', '3 taha hussein st. yamama centre ground floor', '27366316', '30.0636', '31.2207', 'women clothes shop', '2.5', '2', '', ''),
(12, 'akher elankood', '3 taha hussein st. yamama centre ground floor', '27363431', '30.0636', '31.2207', 'home &  various accessories shop', '2', '2', '', ''),
(13, '2,5', '3 taha hussein st. yamama centre ground floor', '27363431', '30.0636', '31.2207', 'home &  various accessories shop', '2', '2', '', ''),
(14, 'the four fat ladies', '3 taha hussein st. yamama centre ground floor', '27371922, 01270011701', '30.0636', '31.2207', 'restaurant', '', '4', '', ''),
(15, 'genuine', '3 taha hussein st. yamama centre ground floor', 'null', '30.0636', '31.2207', 'women shoes and bags shop', '2', '2', '', ''),
(16, 'dixis', '3 taha hussein st. yamama centre ground floor', 'null', '30.0636', '31.2207', 'women clothes shop', '2.5', '2.5', '', ''),
(17, 'monkeys', '3 taha hussein st. yamama centre ground floor', 'null', '30.0636', '31.2207', 'toys shop', '2.5', '2.5', '', ''),
(18, 'madrid', '3 taha hussein st. yamama centre ground floor', 'null', '30.0636', '31.2207', 'women shoes and bags shop', '2.5', '2', '', ''),
(19, 'islam thabet', '3 taha hussein st. yamama centre ground floor', 'check', '30.0636', '31.2207', 'jewellery', 'null', 'null', '', ''),
(20, 'set elkol', '3 taha hussein st. yamama centre 1st floor', '27363431, 01014145679', '30.0636', '31.2207', 'home accessories shop', '2.5', '2', '', ''),
(21, 'hello', '3 taha hussein st. yamama centre 1st floor', '1005342540, 0111532217', '30.0636', '31.2207', 'women shoes and bags shop', '1.5', '1.5', '', ''),
(22, 'the shelter', '3 taha hussein st. yamama centre 1st floor', '1222133716', '30.0636', '31.2207', 'art & photography gallery', '3', '3', '', ''),
(23, 'jacques mor', '3 taha hussein st. yamama centre 1st floor', '27358214, 27358215', '30.0636', '31.2207', 'beauty centre', 'check', 'check', 'jacques-moreno.com', 'info@jacques-moreno.com'),
(24, 'drake store', '3 taha hussein st. yamama centre 1st floor', 'null', '30.0636', '31.2207', 'women shoes and bags shop', '1', '1', '', ''),
(25, 'FDA', '3 taha hussein st. yamama centre', 'check', '30.0636', '31.2207', 'gym', 'check', 'check', '', ''),
(26, 'munch & bagel', '2 taha hussein st.', '27354392, 01096155559', '30.064', '31.2205', 'restaurant', '3.5', '3.5', '', ''),
(27, 'joe''s chocolate bar', '2 taha hussein st.', 'null', '30.064', '31.2205', 'restaurant', 'null', 'null', '', ''),
(28, 'alnomrosy', '2 taha hussein st.', '27382504', '30.0641', '31.2204', 'knitting kits &accessories', '4', '3', '', ''),
(29, 'power', '2 taha hussein st.', 'check', '30.0641', '31.2204', 'air conditioning shop', 'check', 'check', '', ''),
(30, 'elhammam', '2 taha hussein st.', 'check', '30.0642', '31.2203', 'check', 'check', 'check', '', ''),
(31, 'abdallah', '2 taha hussein st.', '27381988', '30.0642', '31.2203', 'pharmacy', 'standard', 'standard', '', ''),
(32, 'elfahd', '2 taha hussein st.', '27353700', '30.0643', '31.2203', 'spice dealer', '4', '3.5', '', ''),
(33, 'botros bibawi', '2 taha hussein st.', 'check', '30.0643', '31.2203', 'check', 'check', 'check', '', ''),
(34, 'alex top', '2 taha hussein st.', '27357601', '30.0643', '31.2203', 'restaurant', '3.5', '3.5', '', ''),
(35, 'mohamed amin', '5 taha hussein st.', 'null', '30.064', '31.2205', 'jewellery', '2.5', 'standard', '', ''),
(36, 'yamama mini market', '5 taha hussein st.', '27369797', '30.0642', '31.2205', 'mini market', '2.5', '2.5', '', ''),
(37, 'touch of flower', '5 taha hussein st.', '27369007, 01220001001', '30.0643', '31.2207', 'flower shop', '4', '3', 'touchflower.com', 'info@touchflower.com'),
(38, 'elgalla', '15 taha hussein st.', 'check', '30.0653', '31.2203', 'jewellery', 'check', 'check', '', ''),
(39, 'rassem', '15 taha hussein st.', '27363531, 27382486', '30.0653', '31.2203', 'pharmacy', 'standard', 'standard', '', ''),
(40, 'a touch of glass', '15a taha hussein st.', '27371488', '30.0654', '31.2203', 'home accessories', '4', '3', '', 'moharat@yahoo.com'),
(41, 'zafir', '15b taha hussein st.', 'check', '30.0654', '31.2203', 'check', 'check', 'check', '', ''),
(42, 'munchies', '15b taha hussein st.', '27353370', '30.0655', '31.2203', 'restaurant', '3.5', '4', '', ''),
(43, 'saladero', '15b taha hussein st.', '1099751166', '30.0655', '31.2203', 'restaurant', '4', '4', '', ''),
(44, 'abu auf nuts', '15b taha hussein st.', '27377968', '30.0656', '31.2202', 'nuts shop', '4', '4', '', ''),
(45, 'azza fahmy', '15c taha hussein st.', '1066642365', '30.0658', '31.2202', 'jewellery', '4.5', '4', 'azzafahmy.com', ''),
(46, 'zen', '11b elmarashly st.', 'null', '30.0658', '31.2204', 'art gallery & furniture', '4', 'null', '', ''),
(47, 'caravanserai', '14 maraashly st.', '27371399, 27350517', '30.066', '31.2202', 'furniture', '4', '3.5', 'caravanseraifurniture.com', 'h.messallam@gmail.com'),
(48, 'mit rehan', '13 maraashly st.', '27354378, 27365531, 27381447', '30.0658', '31.2204', 'furniture', '3.5', '3.5', 'mitrehan.com', 'support@mitrehan.com'),
(49, 'k', '16 elmarashly st.', 'null', '30.0659', '31.2205', 'plumbing and electrical services', 'null', 'null', '', ''),
(50, 'talaat', '16 elmarashly st.', '27350851, 0105173258', '30.0659', '31.2205', 'electrical services', '3.5', '3', '', ''),
(51, 'eden', '16 elmarashly st.', 'check', '30.0658', '31.2205', 'real estate  office', 'check', 'check', '', ''),
(52, 'la trattoria', '13 elmarashly st.', '27350470', '30.0655', '31.2211', 'restaurant', '4', '3.5', '', ''),
(53, 'palace', '18 elmarashly st.', '27360560', '30.0655', '31.2211', 'pharmacy', 'standard', 'standard', '', ''),
(54, '69,', '18b elmarashly st.', '27365250', '30.0654', '31.2212', 'women clothes shop', '4', '4', '', ''),
(55, 'alrahma', '18b elmarashly st.', 'null', '30.0653', '31.2214', 'mosque', 'null', 'null', '', ''),
(56, 'mince', '13 ahmed heshmat st.', '16885', '30.0655', '31.2214', 'restaurant', '4', '3', 'minceburgers.com', ''),
(57, 'elramly', '13 ahmed heshmat st.', 'check', '30.0654', '31.2214', 'beauty centre', '2.5', '2.5', '', ''),
(58, 'rashed', '13 ahmed heshmat st.', '27351762', '30.0654', '31.2214', 'men''s salon', '2.5', '2.5', '', ''),
(59, 'jeff de bruges', '13 ahmed heshmat st.', '27357982', '30.0654', '31.2215', 'chocolate shop', '4.5', '4.5', '', ''),
(60, 'new electric', '20 elmarashly st.', '27363793, 01001572803', '30.0654', '31.2215', 'electrical services shop', '4', '3.5', '', ''),
(61, 'seoudi', '20 elmarashly st.', 'check', '30.0654', '31.2216', 'supermarket', '4', '3.5', '', ''),
(62, 'costa coffee', '21 elmarashly st.', '16460', '30.0653', '31.2215', 'caf', '4', '3.5', '', ''),
(63, 'rose land', '18a ahmed heshmat st.', '27380354', '30.0653', '31.2214', 'flower shop', '4', '3.5', '', ''),
(64, 'burg lab', '21 elmarashly st.', '19911', '30.0653', '31.2215', 'health check up laboratory', '4.5', '3', '', ''),
(65, 'alsharif beaute', '15 elmarashly st.', '1000367060', '30.0652', '31.2215', 'cosmetics & Perfumes', '3.5', '3', '', ''),
(66, 'alaska', '11 ahmed heshmat st.', '27356904', '30.0651', '31.2215', 'dry clean', '3.5', '3', '', ''),
(67, 'auntie loulou', '11 ahmed heshmat st.', '27352514, 01211311313', '30.0649', '31.2216', 'restaurant', '3.5', '3', '', ''),
(68, 'don quichotte', '9 ahmed heshmat st.', 'check', '30.0649', '31.2216', 'bar', '4', '4', '', ''),
(69, 'paradise', 'check', 'check', '30.0635', '31.2217', 'travel agency', 'check', 'check', '', ''),
(70, 'la maison de mireille t.', '7 ahmed heshmat st.', '27351925, 27359698, 01224003830', '30.0633', '31.2219', 'home decor', '4', '3.5', '', ''),
(71, 'mondial', '2 ahmed heshmat st.', '27383453, 27361180', '30.0631', '31.2218', 'pharmacy', 'standard', 'standard', '', ''),
(72, 'abou simble', '2 ahmed heshmat st.', '1119561834', '30.0631', '31.2218', 'mini market', '2', 'standard', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `phoneid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  PRIMARY KEY (`phoneid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`phoneid`, `name`, `email`, `address`, `gender`) VALUES
('89014103211118510720', 'Mostafa', 'mostafa.elsayad@hotmail.com', 'Maadi', 'Male');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
