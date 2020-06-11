-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 21 juin 2019 à 19:16
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
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `CIN` varchar(20) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telephone` varchar(30) NOT NULL,
  `Adresse` varchar(70) NOT NULL,
  PRIMARY KEY (`CIN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`CIN`, `Nom`, `Prenom`, `Email`, `Telephone`, `Adresse`) VALUES
('F652210', 'Sefrioui', 'kamal', 'kamalSef@outlook.com', '0632148577', 'Hay el zaytoun,nr 20 rue alrachad Rabat'),
('F651442', 'Ahimd', 'Ilyass', 'Ilyass_Ahmidi@outlook.com', '0652144765', 'Hay el Bernoussi, rue 4 nr 10 Casablanca '),
('F651200', 'Fillali', 'Amine', 'Fillali_amine@outlook.com', '0687412358', 'hay alQuods ,Bd NAKHIL nr 11 Oujda'),
('F644120', 'marceli', 'ihssan', 'marceli_ihssan@outlook.com', '0652213310', 'rue Fez nr 14,Bd Mohammed V Oujda');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
