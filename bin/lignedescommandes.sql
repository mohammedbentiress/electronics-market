-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 21 juin 2019 à 19:01
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `application`
--

-- --------------------------------------------------------

--
-- Structure de la table `lignedescommandes`
--

DROP TABLE IF EXISTS `lignedescommandes`;
CREATE TABLE IF NOT EXISTS `lignedescommandes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CIN_Client` varchar(30) NOT NULL,
  `ID_Commande` varchar(10) NOT NULL,
  `prix_total` double NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignedescommandes`
--

INSERT INTO `lignedescommandes` (`ID`, `CIN_Client`, `ID_Commande`, `prix_total`, `Date`) VALUES
(1, 'F620144', '1,2,4', 13800, '2019-06-08'),
(2, 'F620411', '3', 6000, '2019-04-24'),
(3, 'F620631', '5,7', 11500, '2019-05-04'),
(4, 'F420220', '6,8', 27000, '2019-06-01');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
