-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2014 at 07:15 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `curriculum`
--

-- --------------------------------------------------------

--
-- Table structure for table `approval`
--

CREATE TABLE IF NOT EXISTS `approval` (
  `requestId` int(45) NOT NULL,
  `userId` int(45) NOT NULL,
  `approved` enum('Approved','Denied','Unset') NOT NULL,
  PRIMARY KEY (`requestId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `approval`
--

INSERT INTO `approval` (`requestId`, `userId`, `approved`) VALUES
(76, 2, 'Approved'),
(76, 3, 'Denied'),
(76, 5, 'Denied'),
(77, 1, 'Approved'),
(77, 3, 'Unset'),
(77, 5, 'Unset'),
(78, 1, 'Unset'),
(78, 2, 'Unset'),
(78, 3, 'Unset');

-- --------------------------------------------------------

--
-- Table structure for table `createprogramrequest`
--

CREATE TABLE IF NOT EXISTS `createprogramrequest` (
  `id` int(11) NOT NULL,
  `userId` varchar(45) NOT NULL,
  `programName` varchar(500) NOT NULL,
  `term` varchar(500) NOT NULL,
  `rationale` varchar(500) NOT NULL,
  `crossImpact` varchar(500) NOT NULL,
  `studentImpact` varchar(500) NOT NULL,
  `comments` varchar(500) NOT NULL,
  `calendar` varchar(500) NOT NULL,
  `libraryImpact` varchar(500) NOT NULL,
  `itsImpact` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `createprogramrequest`
--

INSERT INTO `createprogramrequest` (`id`, `userId`, `programName`, `term`, `rationale`, `crossImpact`, `studentImpact`, `comments`, `calendar`, `libraryImpact`, `itsImpact`) VALUES
(75, '', 'Bachelor of .NET', 'Fall 2014', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam. Phasellus pharetra viverra commodo. Curabitur ornare ullamcorper lacus eu mollis.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam. Phasellus pharetra viverra commodo. Curabitur ornare ullamcorper lacus eu mollis.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam. Phasellus pharetra viverra commodo. Curabitur ornare ullamcorper lacus eu mollis.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam. Phasellus pharetra viverra commodo. Curabitur ornare ullamcorper lacus eu mollis.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis vulputate enim. Ut blandit dapibus elementum. Pellentesque tempor fringilla orci eu commodo. Vestibulum placerat viverra sapien. Nullam mollis nisl non sapien finibus posuere. Etiam dictum est sit amet pretium porttitor. Nunc aliquam, dolor nec sollicitudin blandit, odio mauris luctus nunc, nec luctus risus sem a quam. Phasellus pharetra viverra commodo. Curabitur ornare ullamcorper lacus eu mollis.'),
(76, '', 'Bachelor of PHP Development', 'Fall 2014', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet. Donec aliquet, magna eu sollicitudin elementum, mauris orci aliquet dolor, ac mollis lacus ante eu ipsum. ', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet.', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet. Donec aliquet, magna eu sollicitudin elementum, mauris orci aliquet dolor, ac mollis lacus ante eu ipsum. ', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet. Donec aliquet, magna eu sollicitudin elementum, mauris orci aliquet dolor, ac mollis lacus ante eu ipsum. ', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida.', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet. Donec aliquet, magna eu sollicitudin elementum, mauris orci aliquet dolor, ac mollis lacus ante eu ipsum. ', 'Sed id lacus molestie, suscipit quam eu, molestie est. Aenean fringilla odio ac augue convallis, in suscipit ex gravida. Mauris dictum sapien vitae purus scelerisque imperdiet. '),
(77, '', 'Bachelor of Web Development', 'Winter 2016', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec. Pellentesque id tincidunt massa, ullamcorper dictum sem.', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec.', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec. Pellentesque id tincidunt massa, ullamcorper dictum sem.', 'Pellentesque id tincidunt massa, ullamcorper dictum sem.', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec. Pellentesque id tincidunt massa, ullamcorper dictum sem.', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec. Pellentesque id tincidunt massa, ullamcorper dictum sem.', 'Suspendisse eleifend enim fringilla, feugiat mi quis, suscipit turpis. Nullam consectetur quam turpis, vel ornare diam pretium nec. Pellentesque id tincidunt massa, ullamcorper dictum sem.'),
(78, '', 'Diploma of PHP Coding', 'Fall 2015', 'Vivamus pulvinar eros in mauris congue vehicula. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.', 'Nullam posuere tempus vestibulum. Duis rutrum quam nisi, at varius sem ultricies id. Ut convallis sollicitudin tempor. Vestibulum sed ligula sit amet sem accumsan suscipit bibendum ac velit. Donec ut egestas nunc. Integer ut enim eu sem egestas mollis mollis ut nibh. Sed vel urna ut leo bibendum imperdiet.', 'Nunc sed nulla accumsan, facilisis odio vitae, varius nisi. Pellentesque nec metus accumsan, consequat lacus vel, posuere magna. ', 'Cras ut risus quis elit fringilla iaculis et nec nulla. Vestibulum ligula dolor, auctor et viverra ut, eleifend quis tortor. Duis sed faucibus felis, a ultrices odio. ', 'Cras blandit, tortor id sodales sollicitudin, enim mi varius arcu, vel imperdiet nisl ligula ut lacus. Nulla convallis fringilla lacus, eu feugiat arcu tincidunt id. ', ' Quisque congue turpis nec nibh pretium tincidunt. Duis varius enim blandit tortor congue convallis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'Ut libero metus, interdum quis interdum ut, bibendum sit amet dolor. Maecenas posuere, mauris sit amet feugiat venenatis, erat ipsum ultrices eros, at posuere arcu est et lectus.');

-- --------------------------------------------------------

--
-- Table structure for table `group`
--

CREATE TABLE IF NOT EXISTS `group` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(45) NOT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `group`
--

INSERT INTO `group` (`groupId`, `groupName`) VALUES
(1, 'FCC'),
(2, 'AB');

-- --------------------------------------------------------

--
-- Table structure for table `groupmember`
--

CREATE TABLE IF NOT EXISTS `groupmember` (
  `groupId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupmember`
--

INSERT INTO `groupmember` (`groupId`, `userId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 4),
(1, 5),
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE IF NOT EXISTS `request` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `userId` int(45) NOT NULL,
  `creationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` varchar(45) NOT NULL,
  `currentApprover` tinyint(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=79 ;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `userId`, `creationDate`, `state`, `currentApprover`, `type`) VALUES
(75, 2, '2014-10-07 13:20:48', 'Complete', 1, 'create-program'),
(76, 1, '2014-10-07 13:25:07', 'in-progress', 0, 'create-program'),
(77, 2, '2014-10-08 02:15:59', 'in-progress', 0, 'create-program'),
(78, 5, '2014-10-22 01:11:34', 'in-progress', 0, 'create-program');

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE IF NOT EXISTS `term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season` varchar(45) NOT NULL,
  `year` year(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `term`
--

INSERT INTO `term` (`id`, `season`, `year`) VALUES
(1, 'Fall', 2014),
(2, 'Winter', 2015),
(3, 'Spring', 2015),
(4, 'Fall', 2015),
(5, 'Winter', 2016),
(6, 'Spring', 2016);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(45) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `faculty` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  `discipline` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `firstname`, `lastname`, `faculty`, `director`, `discipline`, `phone`, `title`) VALUES
(1, 'trop315@mtroyal.ca', 'cd73502828457d15655bbd7a63fb0bc8', 'Tyler', 'Rop', 'N/A', 'N/A', 'Computer Science, Business', '403.909.1364', 'Bachelor of Computer Information Systems Stud'),
(2, 'rhoar@mtroyal.ca', '8c806f53844372f6f5f8cdf4cdd92b6e', 'Ricardo', 'Hoar', 'Computer Information Systems', 'N/A', 'Computer Science', '403.440.7061', 'BCIS Associate Professor, Department Chair'),
(3, 'ddocherty@mtroyal.ca', '1ee657b6c1a7bcb0d408ff83a49feccf', 'David', 'Docherty', 'Arts', 'President', 'Political Science', 'N/A', 'President'),
(4, 'jkidney@mtroyal.ca', '4f3232e3061c0e48cf2daee286811881', 'Jordan', 'Kidney', 'Computer Information Systems', 'N/A', 'Computer Science', '403.440.6376', 'Instructor'),
(5, 'rconnolly@mtroyal.ca', 'b49cce42c5e5cd773152799f907c3abb', 'Randy', 'Connolly', 'Computer Information Systems', 'N/A', 'Computer Science', '403.440.6061', 'Full Professor');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
