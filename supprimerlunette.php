<?php
session_start();
include('bdd.php');

$id = $_GET['id'];
//var_dump($id);
$stmt = $bdd->prepare("DELETE FROM  Panier WHERE idProducts =:id;");
$stmt->execute([
    "id"=>$id,
]
    
);
$stmt2 = $bdd->prepare("DELETE FROM  Lunette WHERE id =:id;");
$stmt2->execute([
    "id"=>$id,
]
    
);

header('location:admin.php');