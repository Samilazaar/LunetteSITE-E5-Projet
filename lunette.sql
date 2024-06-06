DROP DATABASE LunetteSITE;
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
    couleur VARCHAR (250),
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

CREATE TABLE demandes_sav (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomClient VARCHAR(255),
    numeroTelephone VARCHAR(20),
    descriptionProbleme TEXT
);


INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Moscot","/images/MoscotLem.png",500,"foncé","Moscot");
INSERT INTO Lunette  (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Gucci","/images/shopping-3.png",300,"foncé","Gucci");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Louis Vuitton","/images/shopping-4.png",650,"foncé","Louis Vuitton");
INSERT INTO Lunette  (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Epos","/images/shopping.png",320,"foncé","Epos");
INSERT INTO Lunette  (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Caracura","/images/oui1.jpeg",850,"clair","Caracura");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Lazaaros","/images/guccinoir.jpeg",2000,"foncé","Lazaaros");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Lazaaros","/images/guccivice.jpeg",120,"clair","Vice City");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Salamancca","/images/guccirose.jpeg",230,"clair","Gucci");
INSERT INTO Lunette  (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Gucci","/images/jaitousaprouver.jpeg",1000,"foncé","Gucci");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Moncler","/images/moncler.jpeg",100,"foncé","Moncler");
INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES ("Lunette Prada","/images/prada.jpeg",200,"clair","Prada");
INSERT INTO Panier  (idUser,idProducts,quantite) VALUES (1,1,1);
INSERT INTO Panier  (idUser,idProducts,quantite) VALUES (2,3,2);



CREATE TABLE DossierSAV (
    idSAV INT NOT NULL AUTO_INCREMENT,
    Date VARCHAR(250),
    Vendeur VARCHAR(250),
    prix DECIMAL(10,2),
    marque VARCHAR(250), PRIMARY KEY (ID)
) ;


