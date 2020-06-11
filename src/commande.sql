-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 21 juin 2019 à 18:58
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
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CIN_Client` varchar(30) NOT NULL,
  `Code_Produit` int(11) NOT NULL,
  `Prix_t` decimal(10,0) NOT NULL,
  `Quantite` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `clecin` (`CIN_Client`),
  KEY `cleid` (`Code_Produit`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`ID`, `CIN_Client`, `Code_Produit`, `Prix_t`, `Quantite`) VALUES
(1, 'F620144', 3021, '5000', 1),
(2, 'F620144', 1200, '1800', 3),
(3, 'F620411', 2020, '6000', 2),
(4, 'F620144', 2020, '7000', 3),
(5, 'F620631', 3022, '4500', 1),
(6, 'F420220', 4100, '20000', 1),
(7, 'F620631', 2020, '7000', 1),
(8, 'F420220', 3025, '700', 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
