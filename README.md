# Lunettes SITE

Bienvenue sur Lunettes SITE, votre destination en ligne pour des lunettes élégantes et fonctionnelles.

## Table des matières

1. [Aperçu](#aperçu)
2. [Fonctionnalités](#fonctionnalités)
3. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [Structure du projet](#structure-du-projet)
6. [Contributions](#contributions)
7. [Licence](#licence)
8. [Contact](#contact)

## Aperçu

LunettesSITE est un site web de commerce électronique permettant aux utilisateurs de parcourir et d'acheter une variété de lunettes. Le site est conçu pour être intuitif et convivial, offrant une expérience de magasinage agréable.

## Fonctionnalités

- Parcourir les catégories de lunettes
- Recherche de produits
- Détails des produits
- Ajouter au panier et gestion du panier
- Passer une commande
- Authentification des utilisateurs
- Section admin pour gérer les produits et les commandes
- Gestion des demandes de service après-vente (SAV)

## Installation

### Prérequis

- [MySQL](https://www.mysql.com/)
- [PHP](https://www.php.net/)
- Un serveur web tel que [Apache](https://httpd.apache.org/) ou [Nginx](https://www.nginx.com/)

### Étapes

1. Clonez le dépôt :

    ```bash
    git clone https://github.com/votreutilisateur/lunettes-shop.git
    cd lunettes-shop
    ```

2. Configurez la base de données MySQL :

    - Connectez-vous à votre serveur MySQL et exécutez le script SQL fourni pour créer la base de données et les tables :

    ```sql
    DROP DATABASE IF EXISTS LunetteSITE;
    CREATE DATABASE LunetteSITE;
    USE LunetteSITE;

    CREATE TABLE Utilisateur (
        id INT NOT NULL AUTO_INCREMENT,
        nom VARCHAR(250),
        prenom VARCHAR(250),
        mdp VARCHAR(250),
        mail VARCHAR(250),
        administrateur BOOLEAN,
        PRIMARY KEY (id)
    );

    CREATE TABLE Lunette (
        id INT NOT NULL AUTO_INCREMENT,
        nom VARCHAR(250),
        image VARCHAR(250),
        prix DECIMAL(10,2),
        couleur VARCHAR(250),
        marque VARCHAR(250),
        PRIMARY KEY (id)
    );

    CREATE TABLE Panier (
        idPanier INT NOT NULL AUTO_INCREMENT,
        idUser INT,
        idProducts INT,
        quantite INT,
        PRIMARY KEY (idPanier),
        FOREIGN KEY (idUser) REFERENCES Utilisateur (id),
        FOREIGN KEY (idProducts) REFERENCES Lunette (id)
    );

    CREATE TABLE HistoriquePanier (
        id INT NOT NULL AUTO_INCREMENT,
        nom VARCHAR(250),
        action VARCHAR(250),
        PRIMARY KEY (id)
    );

    CREATE TABLE demandes_sav (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nomClient VARCHAR(255),
        numeroTelephone VARCHAR(20),
        descriptionProbleme TEXT
    );

    INSERT INTO Lunette (nom, image, prix, couleur, marque) VALUES 
    ("Lunette Moscot", "/images/MoscotLem.png", 500, "foncé", "Moscot"),
    ("Lunette Gucci", "/images/shopping-3.png", 300, "foncé", "Gucci"),
    ("Lunette Louis Vuitton", "/images/shopping-4.png", 650, "foncé", "Louis Vuitton"),
    ("Lunette Epos", "/images/shopping.png", 320, "foncé", "Epos"),
    ("Lunette Caracura", "/images/oui1.jpeg", 850, "clair", "Caracura"),
    ("Lunette Lazaaros", "/images/guccinoir.jpeg", 2000, "foncé", "Lazaaros"),
    ("Lunette Lazaaros", "/images/guccivice.jpeg", 120, "clair", "Vice City"),
    ("Lunette Salamancca", "/images/guccirose.jpeg", 230, "clair", "Gucci"),
    ("Lunette Gucci", "/images/jaitousaprouver.jpeg", 1000, "foncé", "Gucci"),
    ("Lunette Moncler", "/images/moncler.jpeg", 100, "foncé", "Moncler"),
    ("Lunette Prada", "/images/prada.jpeg", 200, "clair", "Prada");

    INSERT INTO Panier (idUser, idProducts, quantite) VALUES (1, 1, 1);
    INSERT INTO Panier (idUser, idProducts, quantite) VALUES (2, 3, 2);
    ```

3. Configurez votre serveur web pour servir les fichiers PHP.

4. Placez les fichiers de votre projet dans le répertoire du serveur web.

## Utilisation

### Frontend

- Ouvrez votre navigateur et allez à `http://localhost` (ou l'URL configurée pour votre serveur).
- Vous pouvez naviguer sur le site, rechercher des lunettes, ajouter des produits au panier, et effectuer des achats.

### Backend

- Connectez-vous en tant qu'administrateur pour accéder aux fonctionnalités de gestion des produits et des commandes.
- Gérez les demandes de service après-vente (SAV) depuis l'interface administrateur.

## Structure du projet

Voici un aperçu de la structure des répertoires du projet :

```plaintext
lunettes-shop/
├── images/             # Images des produits
├── css/                # Fichiers CSS
│   └── site.css
├── js/                 # Fichiers JavaScript
├── index.php           # Page d'accueil
├── inscription.php     # Page d'inscription
├── connexion.php       # Page de connexion
├── deconnexion.php     # Page de déconnexion
├── panier.php          # Page du panier
├── admin.php           # Page d'administration
├── base.php            # Script de traitement de l'inscription
├── ajoutpanier.php     # Script pour ajouter un produit au panier
├── supprimerlunette.php# Script pour supprimer une lunette
├── ajouterlunette.php  # Page pour ajouter une lunette
├── ajouterlunettebdd.php # Script de traitement pour ajouter une lunette à la BDD
├── bdd.php             # Connexion à la base de données
└── README.md           # Documentation du projet
```
## Contributions

Les contributions sont les bienvenues ! Si vous souhaitez contribuer, veuillez suivre ces étapes :

1. Fork le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/ma-nouvelle-fonctionnalité`)
3. Commitez vos modifications (`git commit -m 'Ajout de ma nouvelle fonctionnalité'`)
4. Pushez la branche (`git push origin feature/ma-nouvelle-fonctionnalité`)
5. Ouvrez une Pull Request

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

## Contact

Pour toute question, veuillez contacter :

- Nom : LAZAAR
- Email : samie17030@gmail.com
