<?php
session_start();
include('bdd.php');

$id = $_GET['id'];
$iduser = $_SESSION['id'];
$nom = $_SESSION['nom'];
$action ='ajout';
$nb = 1;
var_dump($nb);
$stmt = $bdd->prepare("INSERT INTO Panier (idUser,idProducts,quantite) VALUES (:idUser, :idProducts, :quantite);");
$stmt->execute([
    "idUser" => $iduser,
    "idProducts" => $id,
    "quantite" => $nb
]);

$stmt2 = $bdd->prepare("INSERT INTO HistoriquePanier (nom,action) VALUES (:nom, :action);");
$stmt2->execute([

    "nom" => $nom,
    "action" => $action,
]);

header('location:panier.php');
?>