DROP DATABASE IF EXISTS LunetteSITE;
CREATE DATABASE LunetteSITE;
USE LunetteSITE;

CREATE TABLE Utilisateur (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(250),
    prenom VARCHAR (250),
    mdp VARCHAR(250),
    mail VARCHAR(250),
    administrateur BOOLEAN, PRIMARY KEY (ID)
) ;
CREATE TABLE Lunette (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(250),
    image VARCHAR(250),
    prix DECIMAL(10,2),
    marque VARCHAR(250), PRIMARY KEY (ID)
) ;

CREATE TABLE Panier (
    idPanier INT NOT NULL AUTO_INCREMENT,
    idUser INT,
    idProducts INT,
    quantite INT,
    PRIMARY KEY (IDPanier),
    FOREIGN KEY (IDUser) REFERENCES Utilisateur (ID),
    FOREIGN KEY (IDProducts) REFERENCES Lunette (ID)
) ;
CREATE TABLE HistoriquePanier (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR (250),
    action VARCHAR(250),
    PRIMARY KEY (id)
) ;


INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Moscot","/images/MoscotLem.png",500,"Moscot");
INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Gucci","/images/shopping-3.png",300,"Gucci");
INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Louis Vuitton","/images/shopping-4.png",650,"Louis Vuitton");
INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Epos","/images/shopping.png",850,"Epos");
INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Caracura","/images/oui1.jpeg",850,"Caracura");
INSERT INTO Lunette (Nom,Image,Prix,Marque) VALUES ("Lunette Lazaaros","/images/Lazaaros.jpeg",2000,"Lazaaros");
INSERT INTO Panier  (idUser,idProducts,quantite) VALUES (1,1,1);
INSERT INTO Panier  (idUser,idProducts,quantite) VALUES (2,3,2);


