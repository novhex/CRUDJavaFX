CREATE DATABASE `crudfx` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `crudfx`;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `prod_code` int(11) NOT NULL AUTO_INCREMENT,
  `prod_desc` varchar(30) NOT NULL,
  `prod_price` double NOT NULL,
  `prod_qty` int(11) NOT NULL,
  PRIMARY KEY (`prod_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prod_code`, `prod_desc`, `prod_price`, `prod_qty`) VALUES
(6, 'Fubu', 1300, 1),
(7, 'Sketchers', 2999, 2),
(8, 'Converse', 2995, 3),
(9, 'Pony', 1995, 3);
