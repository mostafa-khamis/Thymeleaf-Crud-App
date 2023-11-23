CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employees`
--

INSERT INTO `employees` VALUES 
	(1,'Mostafa','Khamis','Mostafa@gmail.com'),
	(2,'Rouqia','Mostafa','Rouqia@gmail.com'),
	(3,'Yossef','fareed','Yossef@gamil.com');

