-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 31 jan. 2021 à 16:59
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `exam_jee_elhadji`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image_link` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `employed_at` date NOT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` enum('admin','user') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `lastname`, `firstname`, `image_link`, `employed_at`, `phone_number`, `role`) VALUES
(3, 'admin', 'admin', 'chanfi', 'elhadji', '/uploads/6521e73b-f3cc-480d-b7fd-3915809b3dd7.jpg', '2021-01-28', '+33123456789', 'admin'),
(5, 'toto', 'toto', 'toto', 'toto', '/uploads/fd8a5581-0ccd-49da-9696-00aa39f8f2d2.jpg', '2021-01-28', '+33123456789', 'user'),
(9, 'tata', 'tata', 'tata', 'tata', '/uploads/db32ebc3-c919-4090-9e15-476bc6de834e.jpg', '2021-01-29', '+33123456789', 'user'),
(10, 'titi', 'titi', 'titi', 'titi', '/uploads/cfbabd9c-e022-42a6-ab09-d15a2672d7e8.jpg', '2021-01-31', '+3312346554', 'user'),
(11, 'tutu', 'tutu', 'tutu', 'tutu', '/uploads/7fbc4a96-5d27-40be-9361-77871e3e3a34.jpg', '2021-01-31', '+33123456789', 'user'),
(12, 'tyty', 'tyty', 'tyty', 'tyty', '/uploads/d355fad8-2b3a-4dc8-8999-aaa8e46df3fb.jpg', '2021-01-31', '+33645768977', 'user'),
(13, 'aurelien', 'aurelien', 'delorme', 'aurelien', '/uploads/12221e1e-7b89-4641-863c-bd8f4f97afb6.jpg', '2021-01-22', '+33765879334', 'admin'),
(14, 'dddd', 'jnjbj', 'bhbhb', 'jbjbj', '/uploads/2b9c3b17-0912-435e-a49a-be76a04c64b2.jpg', '2021-01-31', '+33123456789', 'user'),
(16, 'hello', 'hello', 'hello', 'hello', '/uploads/90c4177c-02a3-4f8d-8c64-8a7509c04555.jpg', '2021-01-31', '+33123456789', 'user'),
(17, 'dgreg', 'rytytr', 'tryr', 'tryrtuyt', '/uploads/a7b85961-561c-4062-9418-6286b808be82.jpg', '2021-01-31', '+33123456789', 'user'),
(18, 'dfdrg', 'fegfer', 'grtrehgrt', 'rgrttr', '/uploads/988357d7-54a1-4e56-85c7-f9c0d2f15242.jpg', '2021-01-31', '+33123456789', 'user'),
(19, 'momo', 'momo', 'momo', 'momo', '/uploads/95aba358-a03d-4312-a503-25edced5f0d6.jpg', '2021-01-31', '+33758656734', 'user');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
