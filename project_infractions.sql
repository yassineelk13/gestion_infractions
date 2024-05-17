-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 18 mai 2024 à 01:02
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `project_infractions`
--

-- --------------------------------------------------------

--
-- Structure de la table `conducteur`
--

CREATE TABLE `conducteur` (
  `id` int(11) NOT NULL,
  `CIN` varchar(20) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `note_permis` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `conducteur`
--

INSERT INTO `conducteur` (`id`, `CIN`, `nom`, `prenom`, `adresse`, `note_permis`) VALUES
(1, 'JB782322', 'Elkrik', 'Yassine', 'agadir', '38'),
(2, 'JB239423', 'ELMALAKI', 'Hamid', 'Casablanca', '37'),
(10, 'JB876453', 'moha', 'Youssef', 'hay zohor, Rabat', '36'),
(11, 'JB128242', 'el bakassi ', 'ismail', 'houara', '39');

-- --------------------------------------------------------

--
-- Structure de la table `infraction`
--

CREATE TABLE `infraction` (
  `id` int(11) NOT NULL,
  `vehicule_id` int(11) DEFAULT NULL,
  `type_infraction_id` int(11) DEFAULT NULL,
  `date_infraction` date DEFAULT NULL,
  `heure_infraction` time DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `montant` decimal(10,2) DEFAULT NULL,
  `statut_paiement` enum('payée','en_attente') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `infraction`
--

INSERT INTO `infraction` (`id`, `vehicule_id`, `type_infraction_id`, `date_infraction`, `heure_infraction`, `lieu`, `montant`, `statut_paiement`) VALUES
(1, 4, 1, '2024-05-03', '19:16:52', 'Agadir', '400.00', 'payée'),
(5, 6, 6, '2024-05-04', '12:52:25', 'tassila,Agadir', '350.00', 'en_attente'),
(8, 9, 1, '2024-05-10', '12:06:52', 'oulad dahou', '400.00', 'en_attente');

-- --------------------------------------------------------

--
-- Structure de la table `typeinfraction`
--

CREATE TABLE `typeinfraction` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `typeinfraction`
--

INSERT INTO `typeinfraction` (`id`, `nom`, `description`) VALUES
(1, 'Excès de vitesse', 'Dépassement de la limite de vitesse autorisée sur la route.'),
(2, 'Non-port de la ceinture de sécurité', 'Conducteur ou passager ne portant pas la ceinture de sécurité.'),
(3, 'Stationnement illégal', 'Stationnement du véhicule dans une zone interdite ou sans autorisation.'),
(4, 'Non-respect du feu rouge', 'Passage au feu rouge sans s\'arrêter.'),
(5, 'Non-respect de la distance de sécurité', 'Suivi d\'un autre véhicule à une distance inférieure à celle recommandée.'),
(6, 'Conduite en état d\'ébriété', 'Conduite d\'un véhicule sous l\'influence de l\'alcool ou de substances illicites.');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `nom_utilisateur` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `role` enum('Administrateur','Agent') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `nom_utilisateur`, `mot_de_passe`, `role`) VALUES
(1, 'ahmed', 'ahmed', 'admin', '1234', 'Administrateur'),
(2, 'mohamed', 'amine', 'agent_1', '1234', 'Agent'),
(3, 'hass', 'hassan', 'agent_2', '1234', 'Agent'),
(8, 'test', 'test', 'test12', '1234', 'Agent');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL,
  `marque` varchar(100) NOT NULL,
  `modele` varchar(100) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `couleur` varchar(50) DEFAULT NULL,
  `plaque_immatriculation` varchar(20) DEFAULT NULL,
  `conducteur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `marque`, `modele`, `annee`, `couleur`, `plaque_immatriculation`, `conducteur_id`) VALUES
(4, 'Chevrolet', 'Malibu', 2018, 'Grise', '82191|A|33', 2),
(6, 'BMW', 'X5', 2017, 'Argentée', '11111|B|1', 1),
(8, 'Honda', 'Civil', 2020, 'Noir', '42712|A|52', 10),
(9, 'BMW', 'Série 3', 2014, 'noir', '1234|A|33', 11);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `conducteur`
--
ALTER TABLE `conducteur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_permis` (`note_permis`);

--
-- Index pour la table `infraction`
--
ALTER TABLE `infraction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicule_id` (`vehicule_id`),
  ADD KEY `type_infraction_id` (`type_infraction_id`);

--
-- Index pour la table `typeinfraction`
--
ALTER TABLE `typeinfraction`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nom_utilisateur` (`nom_utilisateur`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plaque_immatriculation` (`plaque_immatriculation`) USING BTREE,
  ADD KEY `conducteur_id` (`conducteur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `conducteur`
--
ALTER TABLE `conducteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `infraction`
--
ALTER TABLE `infraction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `typeinfraction`
--
ALTER TABLE `typeinfraction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `infraction`
--
ALTER TABLE `infraction`
  ADD CONSTRAINT `infraction_ibfk_1` FOREIGN KEY (`vehicule_id`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `infraction_ibfk_2` FOREIGN KEY (`type_infraction_id`) REFERENCES `typeinfraction` (`id`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`conducteur_id`) REFERENCES `conducteur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
