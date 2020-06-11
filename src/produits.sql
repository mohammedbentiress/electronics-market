-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 21 juin 2019 à 10:21
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
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `produit` varchar(30) NOT NULL,
  `designation` text NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` decimal(10,0) NOT NULL,
  `remise` double NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `fournisseur` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fou_cin` (`fournisseur`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`id`, `code`, `produit`, `designation`, `quantite`, `prix`, `remise`, `categorie`, `fournisseur`) VALUES
(1, 3021, 'Samsung Galaxy S9', 'Le Samsung Galaxy S9 est un smartphone équipé d\'un écran Super Amoled incurvé de 5,8 pouces. Il embarque le processeur Exynos 9810 épaulé par 4 Go de mémoire vive et 64 Go de stockage extensible.', 15, '5000', 10, 'smartphones', 'F652210'),
(2, 3022, 'Acer Swift 5', 'l\'Acer Swift 5, un puissant PC portable 15 pouces.', 8, '4500', 0, 'PC portable', 'F651200'),
(3, 4102, ' iPad mini 5', 'Apple iPad mini 5 256 Go Wi-Fi + 4G', 6, '8000', 0, 'Tablettes', 'F651442'),
(4, 2100, 'Leica Q2', 'Appareil photo\r\nDéfinition du capteur	46.7 Mpx\r\nOuverture max en grand angle	1.7\r\nEcran (diagonale)	7.6 cm', 10, '4800', 3, 'Appareil photo', 'F644120'),
(5, 3025, 'SSD portable Samsung T5', 'un SSD portable,500 Go,débits jusqu\'à 540 Mo/s.', 20, '999', 30, 'SSD', 'F652210'),
(7, 4100, 'MacBook Pro Retina', 'Apple MacBook Pro Retina 13 pouces 256 Go Core i5 2,4 GHz', 5, '20000', 0, 'MAC', 'F651442'),
(6, 2020, ' iPhone 7 Plus', 'le nouveau smartphone haut de gamme grand format du constructeur américain. Il conserve la dalle 5,5 pouces de l’iPhone 6 Plus, mais il s’annonce bien plus puissant grâce à sa puce A10 Fusion. L’iPhone7 Plus serait particulièrement doué pour la photo grâce à son double capteur 12 Mpixels avec stabilisation optique.', 15, '7000', 3, 'Smartphones', 'F651442'),
(8, 5001, 'Galaxy S8 Plus', 'Le Samsung Galaxy S8 Plus est la version grand format du nouveau fleuron de la marque coréenne. Son écran Super Amoled bord à bord atteint 6,2 pouces de diagonale tout en conservant un format allongé (18,5:9). Comme son petit frère, il embarque le nouveau processeur Exynos 8895 avec 4 Go de mémoire vive et dispose d\'un capteur photo principal de 12 mégapixels (identique à celui du Galaxy S7). ', 19, '4999', 13, 'Smartphones', 'F652210'),
(10, 3010, 'P20 Lite', 'Le Huawei P20 Lite est un smartphone équipé d\'un écran bord à bord de 5,84 pouces au format 19/9. Fonctionnant avec Android 8 et la surcouche EMUI 8, il embarque le processeur Kirin 659 couplé à 4 Go de mémoire vive et 64 Go d\'espace de stockage extensible. Côté photo, il dispose d\'un double module principal (16 Mpix + 2 Mpix) et pour les selfies d\'un capteur de 16 Mpix. ', 20, '4000', 20, 'smartphones', 'F651200'),
(11, 3120, 'Xbox One ', 'La nouvelle version de la console NextGen Xbox One de Microsoft est équipée d\'un disque dur de 1 To et de plastiques mats. Une nouvelle manette, dont la connectique audio a été étendue, est présente dans la boîte. L\'ensemble est annoncé au prix de 450 euros et est déjà disponible sur le Microsoft Store.', 10, '5699', 10, 'Gaming', 'F651200'),
(9, 1200, 'Flip 4', 'La Flip 4 de JBL est une enceinte portable stéréo étanche (IPX7). Déclinée en six couleurs, elle comporte une interface Bluetooth 4.2 et une batterie rechargeable de 3000 mAh, qui procure une très bonne autonomie (près de 25 h selon nos mesures). Le son est satisfaisant mais manque de basses, malgré les deux radiateurs placés sur les côtés. Il est conseillé d\'utiliser la Flip 4 en position horizontale pour profiter de la stéréo.', 20, '1990', 15, 'Speakers', 'F644120');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
