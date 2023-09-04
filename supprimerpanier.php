<?php session_start();
include('bdd.php');

$id = $_GET['id'];
$iduser = $_SESSION['id'];
$nom = $_SESSION['nom'];
$action ='supression';
$stmt = $bdd->prepare("DELETE FROM Panier where idPanier=:idPanier");
$stmt->execute([
    "idPanier" => $id,
]);
$stmt2 = $bdd->prepare("INSERT INTO HistoriquePanier (nom,action) VALUES (:nom, :action);");
$stmt2->execute([

    "nom" => $nom,
    "action" => $action,
]);
header('location:panier.php');
?>