# LunetteSITE

## Description

LunetteSITE est une application web permettant aux utilisateurs de s'inscrire, se connecter et acheter des lunettes. Elle comporte plusieurs interfaces principales : une interface d'inscription, une interface de connexion, une interface de présentation des lunettes, et une interface d'administration.

## Fonctionnalités

### Inscription et Connexion

- Inscription de nouveaux utilisateurs
- Connexion des utilisateurs existants

### Présentation des Lunettes

- Affichage des lunettes disponibles
- Recherche de lunettes par prix et couleur
- Ajout de lunettes au panier
- Visualisation du panier

### Administration

- Ajout de nouvelles lunettes
- Suppression de lunettes existantes

## Installation

### Prérequis

- Serveur Apache
- Serveur MySQL
- PHP

### Configuration de la base de données

Ouvrez votre terminal MySQL et exécutez les commandes suivantes pour créer la base de données et les tables nécessaires :

```sql
DROP DATABASE IF EXISTS LunetteSITE;
CREATE DATABASE IF NOT EXISTS LunetteSITE;
USE LunetteSITE;

CREATE TABLE Utilisateur (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(250),
    prenom VARCHAR (250),
    mdp VARCHAR(250),
    mail VARCHAR(250),
    administrateur BOOLEAN, PRIMARY KEY (ID)
);

CREATE TABLE Lunette (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(250),
    image VARCHAR(250),
    prix DECIMAL(10,2),
    couleur VARCHAR (250),
    marque VARCHAR(250), PRIMARY KEY (ID)
);

CREATE TABLE Panier (
    idPanier INT NOT NULL AUTO_INCREMENT,
    idUser INT,
    idProducts INT,
    quantite INT,
    PRIMARY KEY (IDPanier),
    FOREIGN KEY (IDUser) REFERENCES Utilisateur (ID),
    FOREIGN KEY (IDProducts) REFERENCES Lunette (ID)
);

CREATE TABLE HistoriquePanier (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR (250),
    action VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE demandes_sav (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomClient VARCHAR(255),
    numeroTelephone VARCHAR(20),
    descriptionProbleme TEXT
);

CREATE TABLE DossierSAV (
    idSAV INT NOT NULL AUTO_INCREMENT,
    Date VARCHAR(250),
    Vendeur VARCHAR(250),
    prix DECIMAL(10,2),
    marque VARCHAR(250), PRIMARY KEY (ID)
);
### Insertion de Données dans les Tables
