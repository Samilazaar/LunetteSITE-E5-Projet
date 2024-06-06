# LunetteSITE

## Description

LunetteSITE est une application web permettant aux utilisateurs de s'inscrire, se connecter et acheter des lunettes. Elle comporte plusieurs interfaces principales : une interface d'inscription, une interface de connexion, une interface de présentation des lunettes, et une interface d'administration.
## Structure des Fichiers

- `index.php` : Page d'accueil de l'application.
- `inscription.php` : Interface d'inscription des utilisateurs.
- `connexion.php` : Interface de connexion des utilisateurs.
- `admin.php` : Interface d'administration pour la gestion des lunettes.
- `ajouterlunette.php` : Page permettant d'ajouter une nouvelle lunette à la base de données.
- `supprimerlunette.php` : Page permettant de supprimer une lunette de la base de données.
- `panier.php` : Interface permettant de visualiser le panier d'achat.
- `ajoutpanier.php` : Page pour ajouter une lunette au panier d'un utilisateur.
- `bdd.php` : Fichier de configuration de la connexion à la base de données.
- `site.css` : Feuille de style CSS pour la mise en forme de l'application.

## Utilisation

- **Inscription et Connexion :** Les utilisateurs peuvent s'inscrire ou se connecter à l'application à l'aide des interfaces dédiées.
- **Présentation des Lunettes :** Les lunettes disponibles sont présentées sur la page d'accueil, avec la possibilité de les ajouter au panier.
- **Administration :** Les administrateurs peuvent ajouter de nouvelles lunettes ou en supprimer via l'interface d'administration.
- **Panier :** Les utilisateurs connectés peuvent visualiser leur panier d'achat sur la page dédiée.

### Prérequis

- Serveur Apache
- Serveur MySQL
- PHP

### Configuration de la Base de Données

1. Clonez ce repository sur votre machine locale :

```sh
git clone <url-du-repository>
cd LunetteSITE
```
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
```
### Insertion de Données dans les Tables
``` sql
INSERT INTO Lunette (nom, image, prix, couleur, marque) VALUES 
("Lunette Moscot", "/images/MoscotLem.png", 500, "foncé", "Moscot"),
("Lunette Gucci", "/images/shopping-3.png", 300, "foncé", "Gucci"),
("Lunette Louis Vuitton", "/images/shopping-4.png", 650, "foncé", "Louis Vuitton"),
("Lunette Epos", "/images/shopping.png", 320, "foncé", "Epos"),
("Lunette Persol", "/images/shopping-5.png", 350, "clair", "Persol");
```
### Configuration de l'application

Clonez ce repository sur votre machine locale.

```sh
git clone <url-du-repository>
cd <nom-du-repository>
```


DOC PAS TERMINÉ
